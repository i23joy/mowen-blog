package com.blog.mowen.model.repository;

import com.blog.mowen.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, String> {

    UserEntity findByUsername(String username);

    void deleteByUid(String uid);

}
