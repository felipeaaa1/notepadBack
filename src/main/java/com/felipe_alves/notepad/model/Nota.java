package com.felipe_alves.notepad.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "notas")
@Data
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String nota;

    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Column(name = "ultima_atualizacao")
    private LocalDateTime ultimaAtualizacao = LocalDateTime.now();
}
