package com.maltsev.journalMaltsev.domain.entity;

import com.maltsev.journalMaltsev.domain.Role;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    private boolean active;

    private String activationCode;


    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public boolean isAdmin() {
        return roles != null && roles.contains(Role.ADMIN);
    }

    public boolean isTeacher() {
        return roles != null && (roles.contains(Role.TEACHER) || roles.contains(Role.LECTOR));
    }

    public boolean isLector() {
        return roles != null && roles.contains(Role.LECTOR);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}