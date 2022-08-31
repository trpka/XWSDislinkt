package com.example.agentApplication.Repository;

import com.example.agentApplication.model.JobOffer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobOfferRepository extends MongoRepository<JobOffer, Long>
{
    JobOffer getJobById(Long id);

    JobOffer getJobByDescription(String description);

    JobOffer getJobByPosition(String position);
}
