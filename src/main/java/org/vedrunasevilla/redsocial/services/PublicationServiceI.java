package org.vedrunasevilla.redsocial.services;

import org.vedrunasevilla.redsocial.model.Publication;
import org.vedrunasevilla.redsocial.model.User;

import java.util.List;

public interface PublicationServiceI {
    List<Publication> searchAllPublications();
    List<Publication> searchPublicationsByAuthor(final User user);
    Publication searchPublicationById(Long id);
    void insertPublication(Publication publication);
    void deletePublication(Long id);
}
