package com.maltsev.journalMaltsev.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "firstname")
public class Firstname {

    @Id
    @Column(name = "firstname_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    public Firstname() {
    }

    public Firstname(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}