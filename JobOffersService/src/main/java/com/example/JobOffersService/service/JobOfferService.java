package com.example.JobOffersService.service;

import com.example.JobOffersService.model.JobOffer;
import com.example.JobOffersService.repository.JobOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobOfferService
{
    @Autowired
    private JobOfferRepository jobOfferRepository;

  public JobOffer save(JobOffer jobOffer)
  {
      List<JobOffer> list_of_all = jobOfferRepository.findAll();

      Long id = (long)0;
      for(JobOffer jo: list_of_all)
      {
          id = jo.getId();
      }
      id = id + 1;
      jobOffer.setId(id);
      this.jobOfferRepository.save(jobOffer);

      return this.jobOfferRepository.save(jobOffer);
  }

  public List<JobOffer> findAll()
  {
      return  this.jobOfferRepository.findAll();
  }

  public JobOffer getJobOfferById(Long id)
  {
      return this.jobOfferRepository.getJobById(id);
  }

  public JobOffer getJobByDescription(String description)
  {
      return this.jobOfferRepository.getJobByDescription(description);
  }


  public JobOffer getJobByPosition(String position)
  {
      return this.jobOfferRepository.getJobByPosition(position);
  }



}
