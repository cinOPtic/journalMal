package com.maltsev.journalMaltsev.domain.services;

import com.maltsev.journalMaltsev.domain.entity.Firstname;
import com.maltsev.journalMaltsev.domain.repository.FirstnameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirstnameService {

    @Autowired
    private FirstnameRepo firstnameRepository;

    /**
     * Сохраняет имя, если оно еще не существует в базе данных.
     *
     * @param firstname Имя для сохранения.
     * @return Сохраненное или существующее имя.
     */
    public Firstname save(String firstname) {
        Firstname firstnameFromDB = firstnameRepository.findByName(firstname);

        if (firstnameFromDB == null) {
            firstnameFromDB = firstnameRepository.save(new Firstname(firstname));
        }

        return firstnameFromDB;
    }

    /**
     * Находит имя по названию.
     *
     * @param firstname Имя для поиска.
     * @return Найденное имя или null, если имя не найдено.
     */
    public Firstname findByName(String firstname) {
        return firstnameRepository.findByName(firstname);
    }
}