package com.siv.api.domain.model.vuelos;

public class EstadoVuelo {
    private final Integer id;
    private final String nombre;

    public EstadoVuelo(Integer id, String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del estado no puede estar vacío");
        }
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() { return id; }
    public String getNombre() { return nombre; }
}
