package com.laboratorio.hotel.model;

public class Reserva {
    private Long id;
    private String cliente;
    private Integer numeroHabitacion;
    private String fechaEntrada;
    private String fechaSalida;
    private String estado;

    public Reserva() {}

    public Reserva(Long id, String cliente, Integer numeroHabitacion, String fechaEntrada, String fechaSalida, String estado) {
        this.id = id;
        this.cliente = cliente;
        this.numeroHabitacion = numeroHabitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.estado = estado;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public Integer getNumeroHabitacion() { return numeroHabitacion; }
    public void setNumeroHabitacion(Integer numeroHabitacion) { this.numeroHabitacion = numeroHabitacion; }

    public String getFechaEntrada() { return fechaEntrada; }
    public void setFechaEntrada(String fechaEntrada) { this.fechaEntrada = fechaEntrada; }

    public String getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(String fechaSalida) { this.fechaSalida = fechaSalida; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}