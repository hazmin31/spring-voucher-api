package com.my.evoucher;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;

import com.my.evoucher.repository.RecipientRepository;
import com.my.evoucher.repository.SpecialOfferRepository;
import com.my.evoucher.repository.VoucherRepository;

@SpringBootApplication
public class SpringVoucherPoolApplication implements CommandLineRunner {

	@Autowired
	private RecipientRepository recipientRepository;

	@Autowired
	SpecialOfferRepository offerRepository;
	
	@Autowired
	VoucherRepository voucherRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringVoucherPoolApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

//		recipientRepository.deleteAll();
//		offerRepository.deleteAll();
//		voucherRepository.deleteAll();
		
	}

	
	@PostConstruct
	public void initIndexes() {
		mongoTemplate.indexOps("recipient").ensureIndex(new Index("email", Direction.ASC).unique());
	}
}
