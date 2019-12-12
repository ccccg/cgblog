package com.cgblog.blog.service;

import com.cgblog.blog.domain.User;
import com.cgblog.blog.repository.LoginUserRepository;
import com.cgblog.blog.repository.RegistUserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    RegistUserRepository registUserRepository;

    @Autowired
    LoginUserRepository loginUserRepository;
    public void save(User user){
        registUserRepository.save(user);
    }

    public User login(String id, String password){
        Optional<User> op = loginUserRepository.findUserByIdAndPassword(id,password);
        if(op.isPresent()){
            return op.get();
        }
        return null;
    }

}
