package com.maltsev.journalMaltsev.domain.services;

import com.maltsev.journalMaltsev.domain.entity.Secondname;
import com.maltsev.journalMaltsev.domain.repository.SecondnameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecondnameService {

    @Autowired
    private SecondnameRepo secondnameRepository;

    /**
     * Сохраняет фамилию, если она еще не существует в базе данных.
     *
     * @param secondname Фамилия для сохранения.
     * @return Сохраненная или существующая фамилия.
     */
    public Secondname save(String secondname) {
        Secondname secondnameFromDB = secondnameRepository.findByName(secondname);

        if (secondnameFromDB == null) {
            secondnameFromDB = secondnameRepository.save(new Secondname(secondname));
        }

        return secondnameFromDB;
    }

    /**
     * Находит фамилию по названию.
     *
     * @param secondname Фамилия для поиска.
     * @return Найденная фамилия или null, если фамилия не найдена.
     */
    public Secondname findByName(String secondname) {
        return secondnameRepository.findByName(secondname);
    }
}