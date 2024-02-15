package com.letcoded.SecureBankSystem.service.admin;

import com.letcoded.SecureBankSystem.entity.UserEntity;

import java.util.List;

public interface AdminService {
    List<UserEntity>getAllUsers();
}
