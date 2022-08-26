package com.example.JobOffersService.repository;

import com.example.JobOffersService.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface BookRepository extends MongoRepository<Book, Integer> {
}
