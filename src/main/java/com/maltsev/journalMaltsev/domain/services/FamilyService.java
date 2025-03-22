package com.maltsev.journalMaltsev.domain.services;

import com.maltsev.journalMaltsev.domain.entity.Family;
import com.maltsev.journalMaltsev.domain.repository.FamilyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyService {

    @Autowired
    private FamilyRepo familyRepository;

    /**
     * Сохраняет семейство, если оно еще не существует в базе данных.
     *
     * @param family Название семейства.
     * @return Сохраненное или существующее семейство.
     */
    public Family save(String family) {
        Family familyFromDB = familyRepository.findByName(family);

        if (familyFromDB == null) {
            familyFromDB = familyRepository.save(new Family(family));
        }

        return familyFromDB;
    }

    /**
     * Находит семейство по названию.
     *
     * @param family Название семейства.
     * @return Найденное семейство или null, если семейство не найдено.
     */
    public Family findByName(String family) {
        return familyRepository.findByName(family);
    }
}