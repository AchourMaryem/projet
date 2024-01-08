package com.example.projet_sem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "Cin is required")
    private String cin;

    @NotEmpty(message = "Name is required")
    private String nom;

    @NotEmpty(message = "first name is required")
    private String prenom;

    @NotEmpty(message = "Cin date is required")
    private String dateCin;

    @NotEmpty(message = "date of birth is required")
    private String dob;
    @JsonIgnore
    @OneToOne(mappedBy = "document", cascade = CascadeType.ALL)
    private Qrcode qrcode;


}