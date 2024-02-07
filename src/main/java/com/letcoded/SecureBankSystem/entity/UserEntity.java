package com.letcoded.SecureBankSystem.entity;

import com.letcoded.SecureBankSystem.util.enums.Status;

import javax.persistence.*;


@Entity
@Table(name = "bank_user")
public class UserEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name= "phone_number",nullable = false)
    private String phoneNumber;
    @Column (name = "email", nullable = false)
    private String email;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Enumerated(EnumType.STRING)
    private Status status;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
