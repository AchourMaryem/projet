package com.example.projet_sem.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.JOINED)
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cin;
    private String nom;
    private String prenom;

    private String dateCin;

    private String dob;


}