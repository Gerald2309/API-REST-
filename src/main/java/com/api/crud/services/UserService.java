package com.api.crud.services;

import com.api.crud.models.UserModel;
import com.api.crud.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    public ArrayList<UserModel> getUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    public Optional<UserModel> getById(Long id) {
        return userRepository.findById(id);

    }

    public Optional<UserModel> update(Long id, UserModel user) {
        return userRepository.findById(id).map(u -> {
            u.setFirstName(user.getFirstName());
            u.setLastName(user.getLastName());
            u.setEmail(user.getEmail());
            return userRepository.save(u);
        });
    }

    public Boolean deleteUser(Long id){
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
