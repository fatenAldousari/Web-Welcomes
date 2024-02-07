package com.letcoded.SecureBankSystem.service;

import com.letcoded.SecureBankSystem.entity.UserEntity;
import com.letcoded.SecureBankSystem.ob.user.CreatUserRequest;
import com.letcoded.SecureBankSystem.ob.user.UpdateUserRequest;
import com.letcoded.SecureBankSystem.repository.Userrepository;
import com.letcoded.SecureBankSystem.util.enums.Status;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final Userrepository userrepository;
    public UserServiceImpl(Userrepository userrepository){
        this.userrepository = userrepository;
    }

    @Override
    public void saveUser(CreatUserRequest creatUserRequest) {

        UserEntity userEntity = new UserEntity();
        userEntity.setName(creatUserRequest.getName());
        userEntity.setEmail(creatUserRequest.getEmail());
        userEntity.setPhoneNumber(creatUserRequest.getPhone());
        userEntity.setStatus(Status.valueOf(String.valueOf( creatUserRequest.getStatus()) ));
        userrepository.save(userEntity);

    }
    @Override
   public void updateUserRequest(UpdateUserRequest updateUserRequest){
        UserEntity userEntity= userrepository.findById(updateUserRequest.getUserId())
                .orElseThrow();
        if(!updateUserRequest.getStatus().equals("ACTIVE")||!updateUserRequest.getStatus().equals("INACTIVE")){
            throw new IllegalArgumentException("the status should be ACTIVE or INACTIVE");
        }
        userEntity.setStatus(Status.valueOf(updateUserRequest.getStatus()));
    userrepository.save(userEntity);
    }
}
