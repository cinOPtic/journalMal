package com.maltsev.journalMaltsev.domain.repository;

import com.maltsev.journalMaltsev.domain.entity.Secondname;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecondnameRepo extends JpaRepository<Secondname, Long> {
    Secondname findByName(String secondname);
}