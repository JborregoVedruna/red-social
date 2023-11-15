package org.vedrunasevilla.redsocial.services;

import org.vedrunasevilla.redsocial.model.User;

import java.util.Optional;

public interface UserServiceI {
    Optional<User> searchUserById(final Long id);
    User searchUserByUsername(String username);
    User insertUser(final User user);
    void deleteUser(User user);
    User updateUser(final User user);
}
