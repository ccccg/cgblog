package com.cgblog.blog.repository;

import com.cgblog.blog.domain.User;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface UserRepository<User,String> extends Repository<User,String> {

    User save(User user);

    Optional<User> findUserByName(String name);

    Optional<User> findUserByIdAndPassword(String id,String password);
}
