package com.laboratorio.biblioteca.repository;

import com.laboratorio.biblioteca.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class LibroRepository {

    private final List<Libro> libros = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<Libro> findAll() {
        return libros;
    }

    public Optional<Libro> findById(Long id) {
        return libros.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst();
    }

    public Libro save(Libro libro) {
        if (libro.getId() == null) {
            libro.setId(idGenerator.getAndIncrement());
            libros.add(libro);
        } else {
            deleteById(libro.getId());
            libros.add(libro);
        }
        return libro;
    }

    public boolean deleteById(Long id) {
        return libros.removeIf(l -> l.getId().equals(id));
    }

    public boolean existsById(Long id) {
        return libros.stream().anyMatch(l -> l.getId().equals(id));
    }
}