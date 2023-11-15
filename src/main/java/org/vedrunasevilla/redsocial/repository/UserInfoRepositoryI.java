package org.vedrunasevilla.redsocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vedrunasevilla.redsocial.model.User;
import org.vedrunasevilla.redsocial.model.UserInfo;

@Repository
public interface UserInfoRepositoryI extends JpaRepository<UserInfo, Long> {
    UserInfo findByUser(User user);
}
