package com.example.projet_sem.security.repository;

import com.example.projet_sem.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<AppRole, String> {
}
