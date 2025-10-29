package org.josh.climber.service;

import org.josh.climber.model.UserModel;
import org.josh.climber.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<UserModel> getAllUsers(){
        return userRepo.findAll();
    }

    public UserModel createUser(UserModel user){
        return userRepo.save(user);
    }


}