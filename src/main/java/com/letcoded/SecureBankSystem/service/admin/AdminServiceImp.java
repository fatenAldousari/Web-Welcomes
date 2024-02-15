package com.letcoded.SecureBankSystem.service.admin;

import com.letcoded.SecureBankSystem.entity.UserEntity;
import com.letcoded.SecureBankSystem.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class AdminServiceImp implements AdminService {
    private final UserRepository userRepository;
    public AdminServiceImp(UserRepository userRepository){
        this.userRepository = userRepository;
    }
   @Override
    public List<UserEntity>getAllUsers(){
        return userRepository.findAll();
   }
}
