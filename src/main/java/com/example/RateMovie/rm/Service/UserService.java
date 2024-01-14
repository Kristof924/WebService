package com.example.RateMovie.rm.Service;

import com.example.RateMovie.rm.Entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService {

    public void saveUser(UserEntity user);

    public boolean getLoginUser(UserEntity user);

    List<UserEntity> getAllUser();

    UserEntity getOneUserById(Long id);

    public boolean Logged();
    public void Logout();

    public boolean Admin();
}
