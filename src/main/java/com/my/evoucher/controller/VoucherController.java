package com.my.evoucher.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.evoucher.domain.Recipient;
import com.my.evoucher.domain.Voucher;
import com.my.evoucher.exception.RecipientNotFoundException;
import com.my.evoucher.exception.VoucherAlreadyUsedException;
import com.my.evoucher.exception.VoucherExpiredException;
import com.my.evoucher.exception.VoucherNotFoundException;
import com.my.evoucher.repository.RecipientRepository;
import com.my.evoucher.repository.VoucherRepository;
import com.sun.el.parser.ParseException;

@RestController()
@RequestMapping("voucher")
public class VoucherController {

	@Autowired
	private VoucherRepository voucherRepository;

	@Autowired
	private RecipientRepository recipientRepository;

	@GetMapping("/all")
	public List<Voucher> getAllVoucher() {
		return voucherRepository.findAll();
	}

	@GetMapping("/search/email/{email}")
	public List<String> findByRecipientEmail(@PathVariable String email) {

		Recipient recipient = recipientRepository.findByEmail(email);

		List<String> strList = new ArrayList<>();

		if (recipient != null) {
			List<Voucher> voucherList = voucherRepository.findByRecipient(recipient);

			if (!CollectionUtils.isEmpty(voucherList)) {

				voucherList = voucherList.stream()
						.filter(v -> {
									try {
										return validateVoucher(v);
									} catch (ParseException e) {
										e.printStackTrace();
										return false;
									}
						
						})
						.collect(Collectors.toList());

				for (Voucher v : voucherList) {
					StringBuilder sb = new StringBuilder();
					sb.append(v.getSpecialOffer().getName()).append(" : ").append(v.getCode());
					strList.add(sb.toString());
				}
			}

			return strList;
		} else {
			throw new RecipientNotFoundException();
		}
	}

	@PostMapping("/redeem/{email}/{code}")
	public double redeemVoucher(@PathVariable String email, @PathVariable String code) throws ParseException {

		Recipient recipient = recipientRepository.findByEmail(email);

		if (recipient != null) {
			Voucher v = voucherRepository.findByRecipientAndCode(recipient, code);
			
			boolean valid = v != null && validateVoucher(v);

			if (valid) {
				v.setDateOfUsage(new Date());
				v = voucherRepository.save(v);

				return v.getSpecialOffer().getPercentage();
			} else if (v == null) {
				throw new VoucherNotFoundException();
			} else if (v.getDateOfUsage() != null) {
				throw new VoucherAlreadyUsedException();
			} else {
				throw new VoucherExpiredException();
			}
		} else {
			throw new RecipientNotFoundException();
		}

	}

	private boolean validateVoucher(Voucher v) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM-yyyy");
		try {
			Date currDate = sdf.parse(sdf.format(new Date()));
			Date expiryDate = sdf.parse(sdf.format(v.getExpirationDate()));
			
			if(v.getDateOfUsage() == null  && (currDate.before(expiryDate) || currDate.equals(expiryDate))) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			throw new ParseException();
		}

	}

}
