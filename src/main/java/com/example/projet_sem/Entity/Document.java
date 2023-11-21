package com.example.projet_sem.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

@Inheritance(strategy = InheritanceType.JOINED)
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)



    private Long id;
    private Long idDocs;
    private Long cin;
    private String nom;
    private String prenom;
    private Date dateCin;
    private String dob;
    private String type;


    @OneToMany(mappedBy = "document",cascade = CascadeType.ALL)
    private List<B3> b3List;
   @OneToMany(mappedBy = "document",cascade = CascadeType.ALL)
    private List<WeddingCertificate> weddingCertificates;
    @OneToMany(mappedBy = "document",cascade = CascadeType.ALL)
    private List<BirthCertificate> BirthCertificates;



}
