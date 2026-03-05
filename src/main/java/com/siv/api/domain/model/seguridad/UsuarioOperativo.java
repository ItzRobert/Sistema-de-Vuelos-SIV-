package com.siv.api.domain.model.seguridad;

import java.time.LocalDateTime;

public class UsuarioOperativo {

    private final Integer id;
    private final String username;
    private final String nombre;
    private final Boolean activo;
    private final LocalDateTime fechaCreacion;

    public UsuarioOperativo(Integer id, String username, String nombre, Boolean activo, LocalDateTime fechaCreacion) {
        if (username == null || username.isBlank()) throw new IllegalArgumentException("username requerido");
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("nombre requerido");
        this.id = id;
        this.username = username;
        this.nombre = nombre;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getId() { return id; }
    public String getUsername() { return username; }
    public String getNombre() { return nombre; }
    public Boolean getActivo() { return activo; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
}
