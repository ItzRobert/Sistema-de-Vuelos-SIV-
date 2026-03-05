package com.siv.api.application.dto.vuelos;

import java.time.LocalDate;
import java.time.LocalTime;

public class CrearVueloRequest {
    public String numero;
    public Long aerolineaId;
    public Long origenAeropuertoId;
    public Long destinoAeropuertoId;
    public LocalDate fecha;
    public LocalTime horaSalida;
    public LocalTime horaLlegada;
}
