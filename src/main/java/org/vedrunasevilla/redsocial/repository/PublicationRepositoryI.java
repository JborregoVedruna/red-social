package org.vedrunasevilla.redsocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vedrunasevilla.redsocial.model.Publication;
import org.vedrunasevilla.redsocial.model.User;

import java.util.List;

@Repository
public interface PublicationRepositoryI extends JpaRepository<Publication, Long> {

    List<Publication> findByAuthor(final User user);
}
