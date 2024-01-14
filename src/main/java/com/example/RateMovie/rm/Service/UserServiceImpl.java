package com.example.RateMovie.rm.Service;

import com.example.RateMovie.rm.Entity.UserEntity;
import com.example.RateMovie.rm.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    private boolean isAdmin;

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    private boolean isLogged;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public boolean getLoginUser(UserEntity user) {
        for (int i = 1; i <= getAllUser().size(); i++) {
            if(getOneUserById(Long.valueOf(i)).getUsername().equals(user.getUsername())){
                if(getOneUserById(Long.valueOf(i)).getPassword().equals(user.getPassword())){
                    if(getOneUserById(Long.valueOf(i)).getRoles().equals("ADMIN")){
                        setAdmin(true);
                    }
                    setLogged(true);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getOneUserById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public boolean Logged() {
        return isLogged();
    }

    @Override
    public void Logout() {
        setLogged(false);
        setAdmin(false);
    }

    @Override
    public boolean Admin() {
        return isAdmin();
    }

}
