package com.example.projet_sem.service;

import com.example.projet_sem.Dao.B3Repository;
import com.example.projet_sem.Entity.B3;
import com.example.projet_sem.Entity.Document;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceB3 implements IServiceB3 {
    B3Repository b3repository;
    @Override
    public List<B3> getAllB3(){
        return b3repository.findAll();

    }

}
