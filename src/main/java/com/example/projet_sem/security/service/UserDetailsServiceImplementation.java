package com.example.projet_sem.security.service;
import com.example.projet_sem.security.entities.AppUser;
import com.example.projet_sem.security.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class UserDetailsServiceImplementation implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    IAccountService accountService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //AppUser appUser=accountService.loadUserByUsername(username);
        AppUser appUser = userRepository.findAppUserByUsername(username);
        if(appUser==null) throw new UsernameNotFoundException("user not found");

        //9lebna e role b authority grantedauthority : interface simplegrantedauthority
        List<GrantedAuthority> authorities=new ArrayList<>();
        appUser.getRoles().forEach(e->authorities.add(new SimpleGrantedAuthority(e.getRole())));
        return new User(appUser.getUsername(), appUser.getPassword(), authorities);
    }
}


//konnet nekhdem fil mémoire wala kol chay fil base les roles w jointures