package com.example.projet_sem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class BirthCertificate extends Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String Sexe;
    private String Nom_pere;
    private String Nom_mere;
    private String Lieu;
    private String Nationnalite;
    private String Etat;
    private String Observation;
    @ManyToOne
    @JoinColumn(name = "id_docs", nullable = false)
    private Document document;


}
