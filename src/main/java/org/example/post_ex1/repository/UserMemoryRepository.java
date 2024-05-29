package org.example.post_ex1.repository;

import org.example.post_ex1.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserMemoryRepository {
    private Map<Integer, User> users = new HashMap<>();
    private int seq = 0;

    public UserMemoryRepository(){
        users.put(++seq, new User(seq, "user", "user", "홍길동"));
        users.put(++seq, new User(seq, "admin", "admin", "admin-name"));
    }

    public User findById(int id) {
        return users.get(id);
    }

    public List<User> findAll(){
        return new ArrayList<>(users.values());
    }

    public User findByUserId(String userId) {
        List<User> all = findAll();
        User retUser = null;
        for (User user : all) {
            if (user.getUserId().equals(userId)) {
                retUser = user;
            }
        }
        return retUser;
    }

    public User save(User user) {
        seq++;
        user.setId(seq);
        users.put(seq, user);
        return user;
    }
}
