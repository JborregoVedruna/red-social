package org.vedrunasevilla.redsocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vedrunasevilla.redsocial.model.Email;
import org.vedrunasevilla.redsocial.model.User;

@Repository
public interface EmailRepositoryI extends JpaRepository<Email, Long> {
    Email findByUser (final User user);
}
