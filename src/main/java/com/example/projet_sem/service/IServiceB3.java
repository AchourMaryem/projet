package com.example.projet_sem.service;

import com.example.projet_sem.Entity.B3;

import java.util.List;

public interface IServiceB3 {
  public List<B3> getAllB3();
public void saveB3(B3 b3);
public B3 getB3(Long id);

void updateB3(Long id, B3 updatedB3);
void deleteB3(Long id);
byte[] generatePDF(Long id);

  List<B3> getB3BYCIN(Long cin);
}
