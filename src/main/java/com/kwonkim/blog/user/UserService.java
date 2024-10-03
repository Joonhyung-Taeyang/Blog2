package com.kwonkim.blog.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private int join(User user) {
        userRepository.save(user);
        return 1;
    }

}
