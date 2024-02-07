package com.letcoded.SecureBankSystem.service;

import com.letcoded.SecureBankSystem.entity.UserEntity;
import com.letcoded.SecureBankSystem.ob.user.CreatUserRequest;
import com.letcoded.SecureBankSystem.ob.user.UpdateUserRequest;

public interface UserService {
    void saveUser(CreatUserRequest creatUserRequest);
    void updateUserRequest(UpdateUserRequest updateUserRequest);
    }

