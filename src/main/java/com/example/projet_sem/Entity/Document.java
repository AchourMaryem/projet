package com.example.projet_sem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

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

    private String cin;
    private String nom;
    private String prenom;

    private String dateCin;

    private String dob;
    @JsonIgnore
    @OneToOne(mappedBy = "document", cascade = CascadeType.ALL)
    private Qrcode qrcode;


}