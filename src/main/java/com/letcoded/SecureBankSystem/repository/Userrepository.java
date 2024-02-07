package com.letcoded.SecureBankSystem.repository;

import com.letcoded.SecureBankSystem.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepository extends JpaRepository<UserEntity,Long> {

}
