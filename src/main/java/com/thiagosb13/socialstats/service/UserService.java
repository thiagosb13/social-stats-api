package com.thiagosb13.socialstats.service;

import com.thiagosb13.socialstats.domain.User;
import com.thiagosb13.socialstats.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    public User save(String name) {
        var user = new User();
        user.setName(name);
        return userRepository.save(user);
    }
}
