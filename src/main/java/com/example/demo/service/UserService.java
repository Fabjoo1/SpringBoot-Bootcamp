package com.example.demo.service;

import com.example.demo.enteties.SPID;
import com.example.demo.enteties.Status;
import com.example.demo.enteties.User;

@org.springframework.stereotype.Service
    public class UserService {

        public User createUser(User user) {
            return new User(
                    user.getId(),
                    user.getName(),
                    user.getUsername()
            );
        }

        public void editUser(User user, long id, String name, String username) {
            user.setId(id);
            user.setName(name);
            user.setUsername(username);
        }

}