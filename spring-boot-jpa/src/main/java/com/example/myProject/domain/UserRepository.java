package com.example.myProject.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
//    User findByUsername(String username);
    User findUserByUsernameIsLike(String search);
    User findUserByUsernameIsLikeOrNickNameIsLike(String search);
}
