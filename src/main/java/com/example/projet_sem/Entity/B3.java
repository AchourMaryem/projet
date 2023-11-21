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
public class B3 extends Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String Nom_Pere;
    private String Remarque;

    @ManyToOne
    @JoinColumn(name = "id_docs", nullable = false)
    private Document document;
}
