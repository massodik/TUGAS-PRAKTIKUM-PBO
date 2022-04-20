package com.muhaimin.springbootresetpasswordapplication.repository;

import com.muhaimin.springbootresetpasswordapplication.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}