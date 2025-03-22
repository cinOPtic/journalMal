package com.maltsev.journalMaltsev.domain.repository;

import com.maltsev.journalMaltsev.domain.entity.Firstname;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FirstnameRepo extends JpaRepository<Firstname, Long> {
    Firstname findByName(String firstname);
}