package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.User;
import org.example.repository.user.UserRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
    public boolean isPasswordValid(User user, String rawPassword) {
        return rawPassword.equals(user.getPassword());
    }
}
