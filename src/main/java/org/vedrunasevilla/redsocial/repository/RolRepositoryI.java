package org.vedrunasevilla.redsocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vedrunasevilla.redsocial.model.Rol;

@Repository
public interface RolRepositoryI extends JpaRepository<Rol, Long> {
}
