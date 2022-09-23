package com.java.architect.user.repository;

import com.java.architect.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByUserId(Long userId);
}
