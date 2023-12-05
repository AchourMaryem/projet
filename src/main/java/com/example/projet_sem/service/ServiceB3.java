package com.example.projet_sem.service;

import com.example.projet_sem.Dao.B3Repository;
import com.example.projet_sem.Entity.B3;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceB3 implements IServiceB3 {

    private final B3Repository b3repository;

    @Override
    public List<B3> getAllB3() {
        return b3repository.findAll();
    }

    @Override
    public void saveB3(B3 b3) {
        b3repository.save(b3);
    }

    @Override
    public B3 getB3(Long id) {
        return b3repository.findById(id).orElse(null);
    }
}
