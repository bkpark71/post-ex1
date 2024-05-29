package org.example.post_ex1.service;

import lombok.RequiredArgsConstructor;
import org.example.post_ex1.entity.User;
import org.example.post_ex1.repository.UserMemoryRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserMemoryRepository userRepository;

    public boolean login(String userId, String password) {
        User findUser = userRepository.findByUserId(userId);
        if(findUser == null) {
            return false;
        } else {
            if(findUser.getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }
        }
    }
}
