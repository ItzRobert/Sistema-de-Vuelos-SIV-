package com.siv.api.domain.model.vuelos;

import java.time.LocalDateTime;

public class Aeropuerto {

    private final Long id;
    private final String codigoIATA;
    private final String nombre;
    private final String ciudad;
    private final String pais;
    private final boolean activo;
    private final LocalDateTime fechaCreacion;

    public Aeropuerto(Long id,
                      String codigoIATA,
                      String nombre,
                      String ciudad,
                      String pais,
                      boolean activo,
                      LocalDateTime fechaCreacion) {

        if (codigoIATA == null || codigoIATA.isBlank() || codigoIATA.length() != 3) {
            throw new IllegalArgumentException("El código IATA del aeropuerto debe tener 3 caracteres");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del aeropuerto no puede estar vacío");
        }

        this.id = id;
        this.codigoIATA = codigoIATA;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getId() { return id; }
    public String getCodigoIATA() { return codigoIATA; }
    public String getNombre() { return nombre; }
    public String getCiudad() { return ciudad; }
    public String getPais() { return pais; }
    public boolean isActivo() { return activo; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
}
