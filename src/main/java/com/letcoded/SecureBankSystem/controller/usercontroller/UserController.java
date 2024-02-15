package com.letcoded.SecureBankSystem.controller.usercontroller;

import com.letcoded.SecureBankSystem.bo.user.CreatUserRequest;
import com.letcoded.SecureBankSystem.bo.user.UpdateUserRequest;
import com.letcoded.SecureBankSystem.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/creat-user")
    public ResponseEntity<String> creatUser(@RequestBody CreatUserRequest creatUserRequest){
        try{
            userService.saveUser(creatUserRequest);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        userService.saveUser(creatUserRequest);
        return ResponseEntity.ok("User Created successfully");
    }
    @PutMapping("/update_user_status")
    public ResponseEntity<String> updateUser(@RequestParam Long userId, @RequestBody UpdateUserRequest updateUserRequest){
        try{
            userService.updateUserRequest(updateUserRequest);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("user updated secessfully");
    }
}
