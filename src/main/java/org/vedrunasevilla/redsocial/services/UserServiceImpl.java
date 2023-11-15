package org.vedrunasevilla.redsocial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vedrunasevilla.redsocial.model.User;
import org.vedrunasevilla.redsocial.repository.UserRepositoryI;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceI{
    @Autowired
    private UserRepositoryI userRepo;

    @Override
    public Optional<User> searchUserById(Long id) {
        return userRepo.findById(id);
    };

    @Override
    public User searchUserByUsername(String username) {
        return userRepo.findUserByUsername(username);
    }

    @Override
    public User insertUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepo.delete(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepo.save(user);
    }
}
