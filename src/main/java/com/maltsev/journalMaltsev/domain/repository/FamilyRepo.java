package com.maltsev.journalMaltsev.domain.repository;

import com.maltsev.journalMaltsev.domain.entity.Family;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepo extends JpaRepository<Family, Long> {
    Family findByName(String name);
}