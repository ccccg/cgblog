package com.cgblog.blog.repository;

import com.cgblog.blog.domain.User;

public interface RegistUserRepository extends UserRepository<User,String>{

    @Override
    User save(User user);
}
