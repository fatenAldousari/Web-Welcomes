package com.letcoded.SecureBankSystem.util.excption;

 public class UserNotFoundExcption extends RuntimeException{

    public UserNotFoundExcption(String str){
        super(str);
    }
}