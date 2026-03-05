package com.siv.api.domain.model.vuelos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Vuelo {

    private final Long id;
    private final String numero;
    private final Long aerolineaId;
    private final Long origenAeropuertoId;
    private final Long destinoAeropuertoId;
    private final LocalDate fecha;
    private final LocalTime horaSalida;
    private final LocalTime horaLlegada;

    public Vuelo(Long id,
                 String numero,
                 Long aerolineaId,
                 Long origenAeropuertoId,
                 Long destinoAeropuertoId,
                 LocalDate fecha,
                 LocalTime horaSalida,
                 LocalTime horaLlegada) {

        if (numero == null || numero.isBlank()) {
            throw new IllegalArgumentException("El número de vuelo no puede estar vacío");
        }

        if (horaSalida != null && horaLlegada != null &&
            horaLlegada.isBefore(horaSalida)) {
            throw new IllegalArgumentException("La hora de llegada no puede ser antes que la salida");
        }

        this.id = id;
        this.numero = numero;
        this.aerolineaId = aerolineaId;
        this.origenAeropuertoId = origenAeropuertoId;
        this.destinoAeropuertoId = destinoAeropuertoId;
        this.fecha = fecha;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public Long getAerolineaId() {
        return aerolineaId;
    }

    public Long getOrigenAeropuertoId() {
        return origenAeropuertoId;
    }

    public Long getDestinoAeropuertoId() {
        return destinoAeropuertoId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public LocalTime getHoraLlegada() {
        return horaLlegada;
    }


    public boolean esVueloMismoDia() {
        return fecha != null;
    }
}