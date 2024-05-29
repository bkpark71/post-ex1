package org.example.post_ex1.service;

import lombok.RequiredArgsConstructor;
import org.example.post_ex1.entity.User;
import org.example.post_ex1.repository.UserMemoryRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMemoryRepository userRepository;

    public User getUserInfoByUserId(String userId){
        return userRepository.findByUserId(userId);
    }

    public User getUserInfoById(int id){
        return userRepository.findById(id);
    }
}
