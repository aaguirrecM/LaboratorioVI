package com.laboratorio.cursos.service;

import com.laboratorio.cursos.model.Curso;
import com.laboratorio.cursos.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> obtenerTodos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> obtenerPorId(Long id) {
        return cursoRepository.findById(id);
    }

    public Curso guardar(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Optional<Curso> actualizar(Long id, Curso cursoDetalles) {
        return cursoRepository.findById(id).map(curso -> {
            curso.setNombre(cursoDetalles.getNombre());
            curso.setCodigo(cursoDetalles.getCodigo());
            curso.setCreditos(cursoDetalles.getCreditos());
            curso.setProfesor(cursoDetalles.getProfesor());
            return cursoRepository.save(curso);
        });
    }

    public boolean eliminar(Long id) {
        return cursoRepository.deleteById(id);
    }
}