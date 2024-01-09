package com.example.projet_sem.security.service;
import com.example.projet_sem.security.entities.AppUser;

public interface IAccountService {

    public void addRole(String role);
    public void addUser(String username, String password, String mail);
    public void addroletoUser(String username, String role);
    public AppUser loadUserByUsername(String username);
}
