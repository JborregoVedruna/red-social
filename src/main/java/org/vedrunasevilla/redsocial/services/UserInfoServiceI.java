package org.vedrunasevilla.redsocial.services;

import org.vedrunasevilla.redsocial.model.User;
import org.vedrunasevilla.redsocial.model.UserInfo;

public interface UserInfoServiceI {
    UserInfo searchUserInfoByUser(User user);
    void inserUserInfo(final UserInfo userInfo);
    void deteleUserInfo(Long id);
    void updateUserInfo(final UserInfo userInfo);
}
