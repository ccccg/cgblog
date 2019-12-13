package com.cgblog.blog.repository;

import com.cgblog.blog.domain.User;

import java.util.Optional;

public interface LoginUserRepository extends UserRepository<User,String>{

    @Override
    Optional<User> findUserByIdAndPassword(String id, String password);


}
