package com.maltsev.journalMaltsev.controllers;

import com.maltsev.journalMaltsev.domain.entity.Student;
import com.maltsev.journalMaltsev.domain.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private StudentRepo studentRepo;
    @GetMapping("/")
    public String main(Model model){
        Iterable<Student> students= studentRepo.findAll();
        model.addAttribute("students",students);
        return "main";
    }

    @GetMapping("/student")
    @PreAuthorize("hasAuthority('STUDENT')")
    public String student(Model model) {
        Iterable<Student> students = studentRepo.findAll();
        model.addAttribute("students", students);
        return "main";
    }

    @PostMapping("/add")
    public String add(String fio, String groupp, Model model){
        Student student=new Student(fio,groupp);
        studentRepo.save(student);
        Iterable<Student> students= studentRepo.findAll();
        model.addAttribute("students",students);
        return "main";
    }
    @PostMapping("filter")
    public String filter(@RequestParam String filter, Model model) {
        Iterable<Student> students;
        if (filter != null && !filter.isEmpty()) {
            students = studentRepo.findByNamegroup(filter);
        } else {
            students = studentRepo.findAll();
        }
        model.addAttribute("students", students);
        return "main";
    }
}
