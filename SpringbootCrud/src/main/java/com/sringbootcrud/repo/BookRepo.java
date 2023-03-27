package com.sringbootcrud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sringbootcrud.model.Book;
@Repository
public interface BookRepo extends JpaRepository<Book, Integer>
{

}
