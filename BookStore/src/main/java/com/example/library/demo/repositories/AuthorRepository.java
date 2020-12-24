package com.example.library.demo.repositories;

import com.example.library.demo.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}


// we can create our own repository

// create an interface

/*
   public interface CrudRepo<T, Long> {
        Map<Long, T> map = new HashMap<>();

   }
 */