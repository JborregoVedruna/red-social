package org.vedrunasevilla.redsocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vedrunasevilla.redsocial.model.User;

@Repository
public interface UserRepositoryI extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}
