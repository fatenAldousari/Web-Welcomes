package com.letcoded.SecureBankSystem.service.user;

import com.letcoded.SecureBankSystem.bo.user.CreatUserRequest;
import com.letcoded.SecureBankSystem.bo.user.UpdateUserRequest;

import java.util.List;

public interface UserService {
    void saveUser(CreatUserRequest createUserRequest);
    void updateUserStatus(Long userId, UpdateUserRequest updateUserStatusRequest);
    List<String> getALlUsersWithStrongPassword();

    List<String> getAllUsersWithStrongPassword();

    void updateUserRequest(UpdateUserRequest updateUserRequest);
}
