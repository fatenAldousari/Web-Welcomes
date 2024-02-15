package com.letcoded.SecureBankSystem;

import com.letcoded.SecureBankSystem.entity.UserEntity;
import com.letcoded.SecureBankSystem.repository.UserRepository;
import com.letcoded.SecureBankSystem.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static com.fasterxml.jackson.databind.cfg.CoercionInputShape.Array;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class SecureBankSystemApplicationTests {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void whenUserPasswordIsLargerThan8Digit_thenSuccess() {
//        List<UserEntity>mockUsersPassword= Array.asList
//                new
//        )
        UserEntity userEntity = new UserEntity();
        userEntity.setName("faten");
        userEntity.setPassword("12345678");

        UserEntity userEntity2 = new UserEntity();
        userEntity2.setName("faten1");
        userEntity2.setPassword("12345612");

        UserEntity userEntity3 = new UserEntity();
        userEntity3.setName("faten2");
        userEntity3.setPassword("888");

        List<UserEntity>mocksUserEntity= Arrays.asList(userEntity,userEntity2,userEntity3);
        Mockito.when(userRepository.findAll()).thenReturn(mocksUserEntity);

        List<String> userWithStrongPasswords = userService.getAllUsersWithStrongPassword();

        List<String>expectedUsersWithStrongPassword= Arrays.asList("faten","faten1");
        assertEquals(expectedUsersWithStrongPassword,userWithStrongPasswords);

    }

}
