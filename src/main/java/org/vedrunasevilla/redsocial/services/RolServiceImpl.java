package org.vedrunasevilla.redsocial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vedrunasevilla.redsocial.model.Rol;
import org.vedrunasevilla.redsocial.repository.RolRepositoryI;

import java.util.List;

@Service
public class RolServiceImpl implements RolServiceI{
    @Autowired
    private RolRepositoryI rolRepo;

    @Override
    public List<Rol> searchAllRoles() {
        return rolRepo.findAll();
    }
}
