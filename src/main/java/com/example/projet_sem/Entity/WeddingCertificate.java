package com.example.projet_sem.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @NotEmpty(message = "Ajout nom du couple")

    private String nomcouple;
    @NotEmpty(message = "Ajout prenom couple")

    private String prenomcouple;

    @NotNull(message = "Ajout votre sexe")
    private String Sexe;

    @NotEmpty(message = "Ajout nom pere")

    private String nompere;
    @NotEmpty(message = "Ajout nom mere")

    private String nommere;


    @NotEmpty(message = "Ajout votre lieu")
    private String Lieu;


}
