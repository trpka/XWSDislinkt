package com.example.JobOffersService.controller;

import com.example.JobOffersService.model.JobOffer;
import com.example.JobOffersService.service.JobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class JobOfferController
{
    @Autowired
    private JobOfferService jobOfferService;

    //Kreiranje Poslovne Ponude
    @RequestMapping(value="api/job/create",method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JobOffer> save(@RequestBody JobOffer jobOffer)
    {
        JobOffer created_job_offer=this.jobOfferService.save(jobOffer);
        return new ResponseEntity("Succesfully created a new job offer", HttpStatus.CREATED);
    }

    @RequestMapping(value = "api/jobs", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_ATOM_XML_VALUE})
    public ResponseEntity<List<JobOffer>> findAll()
    {
        List<JobOffer> job_offers = this.jobOfferService.findAll();
        return new ResponseEntity<>(job_offers, HttpStatus.OK);
    }

    //Pretraga Posla po Id-ju
    @RequestMapping(value="api/job/{id}",method = RequestMethod.GET,produces= {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<JobOffer> getJobOfferById(@PathVariable Long id){
        JobOffer job_offer=this.jobOfferService.getJobOfferById(id);
        return new ResponseEntity<>(job_offer,HttpStatus.OK);
    }

    //Pretraga Posla Po Opisu
    @RequestMapping(value="api/position/{position}",method = RequestMethod.GET,produces= {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<JobOffer> getJobByPosition(@PathVariable String position)
    {
        JobOffer job_offer=this.jobOfferService.getJobByPosition(position);
        return new ResponseEntity<>(job_offer,HttpStatus.OK);
    }

    //Brisanje Ponude po ID-ju
    @DeleteMapping("/api/job/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id)
    {
        JobOffer jobOffer = this.jobOfferService.getJobOfferById(id);
        this.jobOfferService.delete(jobOffer);
        return "Succesfully deleted user!";
    }



}