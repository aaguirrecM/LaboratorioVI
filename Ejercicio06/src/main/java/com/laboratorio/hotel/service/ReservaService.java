package com.laboratorio.hotel.service;

import com.laboratorio.hotel.model.Reserva;
import com.laboratorio.hotel.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<Reserva> obtenerTodas() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> obtenerPorId(Long id) {
        return reservaRepository.findById(id);
    }

    public Reserva guardar(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Optional<Reserva> actualizar(Long id, Reserva reservaDetalles) {
        return reservaRepository.findById(id).map(reserva -> {
            reserva.setCliente(reservaDetalles.getCliente());
            reserva.setNumeroHabitacion(reservaDetalles.getNumeroHabitacion());
            reserva.setFechaEntrada(reservaDetalles.getFechaEntrada());
            reserva.setFechaSalida(reservaDetalles.getFechaSalida());
            reserva.setEstado(reservaDetalles.getEstado());
            return reservaRepository.save(reserva);
        });
    }

    public boolean eliminar(Long id) {
        return reservaRepository.deleteById(id);
    }
}