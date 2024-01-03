package com.example.projet_sem.Dao;

import com.example.projet_sem.Entity.B3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface B3Repository extends JpaRepository <B3,Long> {
    public Page <B3> findByCin(String cin,Pageable p) ;
public  Page<B3> findByNomAndPrenom(String mc, String mc1, Pageable p);
}
