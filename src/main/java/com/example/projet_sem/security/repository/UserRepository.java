package com.example.projet_sem.security.repository;

import com.example.projet_sem.security.entities.AppRole;
import com.example.projet_sem.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, String> {

    public AppUser findAppUserByUsername(String userName);
    public AppUser save(AppUser appUser);
}
