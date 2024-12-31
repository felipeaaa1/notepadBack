package com.felipe_alves.notepad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipe_alves.notepad.model.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {
}
