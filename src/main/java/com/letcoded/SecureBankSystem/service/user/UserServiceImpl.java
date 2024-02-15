package com.letcoded.SecureBankSystem.service.user;

import com.letcoded.SecureBankSystem.bo.user.UpdateUserRequest;
import com.letcoded.SecureBankSystem.entity.UserEntity;
import com.letcoded.SecureBankSystem.bo.user.CreatUserRequest;
import com.letcoded.SecureBankSystem.repository.UserRepository;
import com.letcoded.SecureBankSystem.util.enums.Status;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public abstract class UserServiceImpl implements UserService {
    private final UserRepository userrepository;

    public UserServiceImpl(UserRepository userrepository) {

        this.userrepository = userrepository;
    }




    @Override
    public void saveUser(CreatUserRequest createUserRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(createUserRequest.getName());
        userEntity.setEmail(createUserRequest.getEmail());
        userEntity.setPhoneNumber(createUserRequest.getPhone());
        userEntity.setStatus(Status.valueOf(String.valueOf(createUserRequest.getStatus())));
        userrepository.save(userEntity);

    }



    @Override
    public void updateUserStatus(Long userID, UpdateUserRequest updateUserRequest) {
        UserEntity userEntity = userrepository.findById(userID)
                .orElseThrow();
        if (!updateUserRequest.getStatus().equals("ACTIVE") || !updateUserRequest.getStatus().equals("INACTIVE")) {
            throw new IllegalArgumentException("the status should be ACTIVE or INACTIVE");
        }
        userEntity.setStatus(Status.valueOf(updateUserRequest.getStatus()));
        userrepository.save(userEntity);
    }

    @Override
    public List<String> getALlUsersWithStrongPassword() {
        return null;
    }


    @Override
    public List<String> getAllUsersWithStrongPassword() {
        return userrepository.findAll()
        .stream()
        .filter(e -> e.getPassword().length() > 8)
                .map(UserEntity::getName)
       .collect(Collectors.toList());
  }
}
