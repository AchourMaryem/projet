package com.example.projet_sem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WeddingCertificate extends Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String NomCouple;
    private String PrenomCouple;
    private String Sexe;
    private String Nom_pere;
    private String Nom_mere;
    private String Lieu;


}
