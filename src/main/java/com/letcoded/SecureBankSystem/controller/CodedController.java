package com.letcoded.SecureBankSystem.controller;

import com.letcoded.SecureBankSystem.bo.CreatContantRequest;
import com.letcoded.SecureBankSystem.bo.CreatFarewellRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CodedController {
    List<CreatContantRequest> allcontact = new ArrayList<>();


    @GetMapping("/sayhi")
    public String sayhi() {
        return "welcome";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    @PostMapping("/farewell")
    public String farewell(@RequestBody CreatFarewellRequest creatFarewellRequest) {

        return "goodbye, " + creatFarewellRequest.getName();
    }

    @PostMapping("/addContact")
    public String addContact(@RequestBody CreatContantRequest contant) {
        allcontact.add(contant);
        return "contang info:" + "name: " + contant.getName() + " email: " + contant.getEmail() + " number: " + contant.getPhone();
    }

    @GetMapping("/getContactDetails")
    public ResponseEntity<?> getContactDetails(@RequestParam String name) {
        for (int i = 0; i < allcontact.size(); i++) {
            System.out.println(allcontact.get(i).toString());
            if (allcontact.get(i).getName().equals(name)) {
                return ResponseEntity.ok(allcontact.get(i));
            }
        }
        return ResponseEntity.badRequest().body("Contact not found");
    }

}


//    public String getContactDetails(@RequestParam String name, CreatContantRequest details) {
//        if (name.equals(details.getName())) {
//            details.getName();
//            details.getName();
//            details.getNumber();
//        } else {
//            return "not found";
//        }
//        return name + "  number: " + details.getNumber() + "  email:  " + details.getEmail();
//    }
//}
