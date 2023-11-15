package org.vedrunasevilla.redsocial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vedrunasevilla.redsocial.model.Publication;
import org.vedrunasevilla.redsocial.model.User;
import org.vedrunasevilla.redsocial.repository.PublicationRepositoryI;

import java.util.List;

@Service
public class PublicationServiceImpl implements PublicationServiceI{
    @Autowired
    private PublicationRepositoryI publicationRepo;

    @Override
    public List<Publication> searchAllPublications() {
        return publicationRepo.findAll();
    }

    @Override
    public List<Publication> searchPublicationsByAuthor(User user) {
        return publicationRepo.findByAuthor(user);
    }

    @Override
    public Publication searchPublicationById(Long id) {
        return publicationRepo.findById(id).orElseThrow();
    }

    @Override
    public void insertPublication(Publication publication) {
        publicationRepo.save(publication);
    }

    @Override
    public void deletePublication(Long id) {
        publicationRepo.deleteById(id);
    }
}
