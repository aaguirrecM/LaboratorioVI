package com.laboratorio.cursos.repository;

import com.laboratorio.cursos.model.Curso;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CursoRepository {

    private final List<Curso> cursos = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<Curso> findAll() {
        return cursos;
    }

    public Optional<Curso> findById(Long id) {
        return cursos.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    public Curso save(Curso curso) {
        if (curso.getId() == null) {
            curso.setId(idGenerator.getAndIncrement());
            cursos.add(curso);
        } else {
            deleteById(curso.getId());
            cursos.add(curso);
        }
        return curso;
    }

    public boolean deleteById(Long id) {
        return cursos.removeIf(c -> c.getId().equals(id));
    }

    public boolean existsById(Long id) {
        return cursos.stream().anyMatch(c -> c.getId().equals(id));
    }
}