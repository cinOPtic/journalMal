package com.maltsev.journalMaltsev.domain.services;

import com.maltsev.journalMaltsev.domain.entity.Role;
import com.maltsev.journalMaltsev.domain.entity.User;
import com.maltsev.journalMaltsev.domain.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        Set<Role> roles = new HashSet<>();
        roles.add(Role.STUDENT);
        user.setRoles(roles);
        return save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Поиск пользователя по имени
        User user = userRepository.findByUsername(username);

        // Если пользователь не найден, выбрасываем исключение
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        // Возвращаем пользователя как объект UserDetails
        return user;
    }

    public User save(User user) {
        // Поиск пользователя по имени
        User userFromDB = userRepository.findByUsername(user.getUsername());

        // Если пользователь не найден, сохраняем его
        if (userFromDB == null) {
            userFromDB = userRepository.save(user);
        }

        // Возвращаем сохраненного или существующего пользователя
        return userFromDB;
    }

}