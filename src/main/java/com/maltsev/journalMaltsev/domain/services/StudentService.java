package com.maltsev.journalMaltsev.domain.services;

import com.maltsev.journalMaltsev.domain.entity.*;
import com.maltsev.journalMaltsev.domain.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepository;

    @Autowired
    private FamilyService familyService;

    /**
     * Сохраняет студента, если он еще не существует в базе данных.
     *
     * @param family      Семейство студента.
     * @param firstname   Имя студента.
     * @param secondname  Фамилия студента.
     * @param studentuser Пользователь, связанный со студентом.
     * @return Сохраненный или существующий студент.
     */
    public Student save(Family family, Firstname firstname, Secondname secondname, User studentuser) {
        // Поиск студента по идентификаторам связанных сущностей
        Student studentFromDB = studentRepository.findByFamily_IdAndFirstname_IdAndSecondname_Id(
                family.getId(), firstname.getId(), secondname.getId()
        );

        // Если студент не найден, создаем и сохраняем нового
        if (studentFromDB == null) {
            Student student = new Student(family, firstname, secondname, studentuser);
            studentFromDB = studentRepository.save(student);
        }

        return studentFromDB;
    }
}