package com.valtech.training.first.repos;

import java.util.List;
import com.valtech.training.first.entites.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorRepo extends JpaRepository<Author, Long>{

	List<Author> findAll();

}
