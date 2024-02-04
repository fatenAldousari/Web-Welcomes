package com.letcoded.SecureBankSystem.controller;

import com.letcoded.SecureBankSystem.ob.CreatFarewellRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController("/api/v1")
public class CodedController {
    @GetMapping("/sayhi")
    public String sayhi() {
        return "welcome";
    }
    @GetMapping("/greet")
    public String greet(@RequestParam String name){
        return "Hello, " +name +"!";
    }
    @PostMapping("/farewell")
        public String farewell(@RequestBody CreatFarewellRequest creatFarewellRequest){

        return "goodbye, "+ creatFarewellRequest.getName();
        }
}
