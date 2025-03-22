package com.maltsev.journalMaltsev.domain.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    STUDENT, TEACHER, ADMIN, LECTOR;

    @Override
    public String getAuthority() {
        return name();
    }
}