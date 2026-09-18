package com.laboratorio.hotel.repository;

import com.laboratorio.hotel.model.Reserva;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ReservaRepository {

    private final List<Reserva> reservas = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<Reserva> findAll() {
        return reservas;
    }

    public Optional<Reserva> findById(Long id) {
        return reservas.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst();
    }

    public Reserva save(Reserva reserva) {
        if (reserva.getId() == null) {
            reserva.setId(idGenerator.getAndIncrement());
            reservas.add(reserva);
        } else {
            deleteById(reserva.getId());
            reservas.add(reserva);
        }
        return reserva;
    }

    public boolean deleteById(Long id) {
        return reservas.removeIf(r -> r.getId().equals(id));
    }

    public boolean existsById(Long id) {
        return reservas.stream().anyMatch(r -> r.getId().equals(id));
    }
}