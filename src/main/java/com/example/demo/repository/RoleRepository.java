package com.example.demo.repository;

import com.example.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findFirstByRoleName(String roleName);

    @Query("SELECT r FROM Role r WHERE r.roleName = :roleName")
    Optional<Role> findRoleByRoleNameQuery(
            @Param("roleName") String roleName);

}
