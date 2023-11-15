package org.vedrunasevilla.redsocial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vedrunasevilla.redsocial.model.Email;
import org.vedrunasevilla.redsocial.model.User;
import org.vedrunasevilla.redsocial.repository.EmailRepositoryI;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailServiceI{
    @Autowired
    private EmailRepositoryI emailRepo;

    @Override
    public Email searchEmailByUser(User u) {
        return emailRepo.findByUser(u);
    }

    @Override
    public void insertEmail(Email e) {
        emailRepo.save(e);
    }

    @Override
    public void deleteEmail(Long id) {
        emailRepo.deleteById(id);
    }
}
