package com.letcoded.SecureBankSystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "banck_accout")
public class BankAccountEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private Double balance;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }


}
