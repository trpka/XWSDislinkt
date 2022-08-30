package com.example.JobOffersService.repository;

import com.example.JobOffersService.model.JobOffer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobOfferRepository extends MongoRepository<JobOffer, Long>
{
    JobOffer getJobById(Long id);

    JobOffer getJobByDescription(String description);

    JobOffer getJobByPosition(String position);
}
