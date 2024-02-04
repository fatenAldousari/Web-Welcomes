package com.letcoded.SecureBankSystem.controller;

import com.letcoded.SecureBankSystem.ob.Contant;
import com.letcoded.SecureBankSystem.ob.CreatFarewellRequest;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController("/api/v1")
public class CodedController {
    List<Contant> allcontact = new ArrayList<>();


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
        @PostMapping("/addContact")
    public String addContact(@RequestBody Contant contant){
        allcontact.add(contant);
        return "contang info:" + "name: "+ contant.getName()+" email: "+ contant.getEmail()+ " number: "+contant.getNumber();
        }
        @GetMapping("/getContactDetails")
            public String getContactDetails(@RequestParam  String name,Contant details){
        if (name.equals(details.getName())){
            details.getName();
            details.getName();
            details.getNumber();
        }else {
            return "not found";
        }
        return name +"  number: "+ details.getNumber()+ "  email:  "+ details.getEmail() ;
        }
}
