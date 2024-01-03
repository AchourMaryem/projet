package com.example.projet_sem.service;

import com.example.projet_sem.Entity.B3;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IServiceB3 {

  Page<B3> findByCin(String cin, Pageable p);
  public Page<B3> getB3ByMc(String mc, String mc1, Pageable t);
  public List<B3> getAllB3();

  public void saveB3(B3 b3, MultipartFile mf) throws IOException;

  public B3 getB3(Long id);

public void updateB3(Long id, B3 updatedB3);
public void deleteB3(Long id);
byte[] generatePDF(Long id);


}
