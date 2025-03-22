package com.maltsev.journalMaltsev.domain.repository;

import com.maltsev.journalMaltsev.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findByFamily_IdAndFirstname_IdAndSecondname_Id(
            Long familyId, Long firstnameId, Long secondnameId);
}