package com.letcoded.SecureBankSystem.service.auth;

import com.letcoded.SecureBankSystem.entity.UserEntity;
import com.letcoded.SecureBankSystem.bo.customeUserDetails.CustomeUserDetails;
import com.letcoded.SecureBankSystem.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository guestRepository;

    public CustomUserDetailsService(UserRepository guestRepository) {

        this.guestRepository = guestRepository;
    }

    @Override
    public CustomeUserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try{
            return buildCustomUserDetailsOfUsername(s);
        }catch (NotFoundException e){
            throw new RuntimeException(e);
        }
    }

    private CustomeUserDetails buildCustomUserDetailsOfUsername(String username) throws NotFoundException {
        UserEntity user = guestRepository.findByUserName(username)
                .orElseThrow();
        if (user== null){
            throw new NotFoundException("User not found");
        }


        CustomeUserDetails userDetails = new CustomeUserDetails();
        userDetails.setId(user.getId());
        userDetails.setUserName(user.getUsername());
        userDetails.setPassword(user.getPassword());
        userDetails.setRole(user.getRole().getTitle().name());

        return userDetails;
    }
}