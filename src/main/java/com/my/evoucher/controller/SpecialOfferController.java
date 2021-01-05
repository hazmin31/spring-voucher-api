package com.my.evoucher.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.evoucher.RandomCodeGenerator;
import com.my.evoucher.domain.Recipient;
import com.my.evoucher.domain.SpecialOffer;
import com.my.evoucher.domain.Voucher;
import com.my.evoucher.repository.RecipientRepository;
import com.my.evoucher.repository.SpecialOfferRepository;
import com.my.evoucher.repository.VoucherRepository;

@RestController()
@RequestMapping("offer")
public class SpecialOfferController {

	@Autowired
	SpecialOfferRepository specialOfferRepository;

	@Autowired
	RecipientRepository recipientRepository;

	@Autowired
	VoucherRepository voucherRepository;

	@GetMapping("/all")
	public List<SpecialOffer> getAllSpecialOffer() {
		return specialOfferRepository.findAll();
	}

	@GetMapping("/search/{name}")
	public SpecialOffer findByName(@PathVariable String name) {
		return specialOfferRepository.findByName(name);
	}

	@PostMapping("/{name}/{percentage}/{expiryDate}")
	public SpecialOffer insertSpecialOffer(@PathVariable String name, @PathVariable double percentage,
			@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date expiryDate) {

		SpecialOffer so = specialOfferRepository.save(new SpecialOffer(name, percentage));

		List<Recipient> recipientList = recipientRepository.findAll();

		for (Recipient each : recipientList) {

			String newCode = "";

			boolean proceed = false;

			while (!proceed) {

				newCode = RandomCodeGenerator.getRandomCode();
				Voucher v = voucherRepository.findByCode(newCode);

				if (v == null) {
					proceed = true;
				}
			}

			Voucher voucher = new Voucher(newCode, each, so, expiryDate, null);

			voucherRepository.save(voucher);
		}

		return so;
	}

}
