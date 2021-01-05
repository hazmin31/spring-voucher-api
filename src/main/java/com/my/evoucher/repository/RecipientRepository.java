package com.my.evoucher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.my.evoucher.domain.Recipient;

//@RepositoryRestResource(collectionResourceRel = "recipient", path = "recipient")
@Repository
public interface RecipientRepository extends MongoRepository<Recipient, String>{
	
	Recipient findByEmail(String email);

}
