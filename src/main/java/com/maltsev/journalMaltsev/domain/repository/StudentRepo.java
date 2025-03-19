package com.maltsev.journalMaltsev.domain.repository;

import com.maltsev.journalMaltsev.domain.entity.Student;
import org.springframework.data.repository.CrudRepository;


public interface StudentRepo extends CrudRepository<Student, Long> {
}
