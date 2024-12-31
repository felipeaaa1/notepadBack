package com.felipe_alves.notepad.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipe_alves.notepad.model.Nota;
import com.felipe_alves.notepad.repository.NotaRepository;

@RestController
@RequestMapping("/notas")
@CrossOrigin(origins = "http://localhost:3000")
public class NotaController {

    @Autowired
    private NotaRepository repository;

    @GetMapping
    public List<Nota> getAllNotas() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nota> getNotaById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Nota createNota(@RequestBody Nota nota) {
        nota.setDataCriacao(LocalDateTime.now());
        nota.setUltimaAtualizacao(LocalDateTime.now());
        return repository.save(nota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nota> updateNota(@PathVariable("id") Long id, @RequestBody Nota notaDetails) {
        return repository.findById(id)
                .map(nota -> {
                    nota.setTitulo(notaDetails.getTitulo());
                    nota.setNota(notaDetails.getNota());
                    nota.setUltimaAtualizacao(LocalDateTime.now());
                    repository.save(nota);
                    return ResponseEntity.ok(nota);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNota(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(nota -> {
                    repository.delete(nota);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
