package com.siv.api.application.dto.vuelos;

import java.time.LocalDate;
import java.time.LocalTime;

public class VueloDto {

    private Long id;
    private String numero;
    private Long aerolineaId;
    private Long origenAeropuertoId;
    private Long destinoAeropuertoId;
    private LocalDate fecha;
    private LocalTime horaSalida;
    private LocalTime horaLlegada;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Long getAerolineaId() {
        return aerolineaId;
    }

    public void setAerolineaId(Long aerolineaId) {
        this.aerolineaId = aerolineaId;
    }

    public Long getOrigenAeropuertoId() {
        return origenAeropuertoId;
    }

    public void setOrigenAeropuertoId(Long origenAeropuertoId) {
        this.origenAeropuertoId = origenAeropuertoId;
    }

    public Long getDestinoAeropuertoId() {
        return destinoAeropuertoId;
    }

    public void setDestinoAeropuertoId(Long destinoAeropuertoId) {
        this.destinoAeropuertoId = destinoAeropuertoId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public LocalTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
}