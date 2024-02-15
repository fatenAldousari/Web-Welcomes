package com.letcoded.SecureBankSystem.repository;

import com.letcoded.SecureBankSystem.entity.RoleEntity;
import com.letcoded.SecureBankSystem.util.enums.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    @Query(value = "SELECT * FROM role r where r.title = title", nativeQuery = true)
    Optional<RoleEntity> findRoleEntityByTitle(String title);
}


