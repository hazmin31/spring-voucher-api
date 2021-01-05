package com.my.evoucher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.my.evoucher.domain.SpecialOffer;

//@RepositoryRestResource(collectionResourceRel = "offer", path = "offer")
@Repository
public interface SpecialOfferRepository extends MongoRepository<SpecialOffer, String> {
	
	SpecialOffer findByName(String name);

}
