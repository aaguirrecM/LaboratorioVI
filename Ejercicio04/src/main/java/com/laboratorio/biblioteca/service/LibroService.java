package com.laboratorio.biblioteca.service;

import com.laboratorio.biblioteca.model.Libro;
import com.laboratorio.biblioteca.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> obtenerTodos() {
        return libroRepository.findAll();
    }

    public Optional<Libro> obtenerPorId(Long id) {
        return libroRepository.findById(id);
    }

    public Libro guardar(Libro libro) {
        return libroRepository.save(libro);
    }

    public Optional<Libro> actualizar(Long id, Libro libroDetalles) {
        return libroRepository.findById(id).map(libro -> {
            libro.setTitulo(libroDetalles.getTitulo());
            libro.setAutor(libroDetalles.getAutor());
            libro.setIsbn(libroDetalles.getIsbn());
            libro.setAnioPublicacion(libroDetalles.getAnioPublicacion());
            libro.setEstado(libroDetalles.getEstado());
            return libroRepository.save(libro);
        });
    }

    public boolean eliminar(Long id) {
        return libroRepository.deleteById(id);
    }
}