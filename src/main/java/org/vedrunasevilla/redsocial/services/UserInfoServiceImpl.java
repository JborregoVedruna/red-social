package org.vedrunasevilla.redsocial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vedrunasevilla.redsocial.model.User;
import org.vedrunasevilla.redsocial.model.UserInfo;
import org.vedrunasevilla.redsocial.repository.UserInfoRepositoryI;

@Service
public class UserInfoServiceImpl implements UserInfoServiceI{
    @Autowired
    private UserInfoRepositoryI userInfoRepo;

    @Override
    public UserInfo searchUserInfoByUser(User user) {
        return userInfoRepo.findByUser(user);
    }

    @Override
    public void inserUserInfo(UserInfo userInfo) {
        userInfoRepo.save(userInfo);
    }

    @Override
    public void deteleUserInfo(Long id) {
        userInfoRepo.deleteById(id);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        userInfoRepo.save(userInfo);
    }
}
