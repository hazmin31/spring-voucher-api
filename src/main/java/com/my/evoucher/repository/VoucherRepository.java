package com.my.evoucher.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.my.evoucher.domain.Recipient;
import com.my.evoucher.domain.Voucher;

//@RepositoryRestResource(collectionResourceRel = "voucher", path = "voucher")
@Repository
public interface VoucherRepository  extends MongoRepository<Voucher, String>{

	Voucher findByCode(String code);
	
	List<Voucher> findByRecipient(Recipient recipient);
	
	Voucher findByRecipientAndCode(Recipient recipient, String Code);
	
}
