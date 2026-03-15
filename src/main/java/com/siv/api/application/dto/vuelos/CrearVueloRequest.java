package com.siv.api.application.dto.vuelos;

public class CrearVueloRequest {

    private Integer aerolineaId;
    private String numeroVuelo;
    private Integer origenAeropuertoId;
    private Integer destinoAeropuertoId;
    private String fechaVuelo;
    private String horaProgramadaSalida;
    private String horaProgramadaLlegada;
    private Integer estadoVueloId;
    private String fuente;

    public Integer getAerolineaId() {
        return aerolineaId;
    }

    public void setAerolineaId(Integer aerolineaId) {
        this.aerolineaId = aerolineaId;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public Integer getOrigenAeropuertoId() {
        return origenAeropuertoId;
    }

    public void setOrigenAeropuertoId(Integer origenAeropuertoId) {
        this.origenAeropuertoId = origenAeropuertoId;
    }

    public Integer getDestinoAeropuertoId() {
        return destinoAeropuertoId;
    }

    public void setDestinoAeropuertoId(Integer destinoAeropuertoId) {
        this.destinoAeropuertoId = destinoAeropuertoId;
    }

    public String getFechaVuelo() {
        return fechaVuelo;
    }

    public void setFechaVuelo(String fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public String getHoraProgramadaSalida() {
        return horaProgramadaSalida;
    }

    public void setHoraProgramadaSalida(String horaProgramadaSalida) {
        this.horaProgramadaSalida = horaProgramadaSalida;
    }

    public String getHoraProgramadaLlegada() {
        return horaProgramadaLlegada;
    }

    public void setHoraProgramadaLlegada(String horaProgramadaLlegada) {
        this.horaProgramadaLlegada = horaProgramadaLlegada;
    }

    public Integer getEstadoVueloId() {
        return estadoVueloId;
    }

    public void setEstadoVueloId(Integer estadoVueloId) {
        this.estadoVueloId = estadoVueloId;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }
}