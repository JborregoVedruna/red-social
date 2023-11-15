package org.vedrunasevilla.redsocial.services;

import org.vedrunasevilla.redsocial.model.Email;
import org.vedrunasevilla.redsocial.model.User;

import java.util.List;

public interface EmailServiceI {
    Email searchEmailByUser(User u);
    void insertEmail(final Email e);
    void deleteEmail(Long id);

}
