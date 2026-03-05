package com.siv.api.domain.model.notificaciones;

import java.time.LocalDateTime;

public class Suscripcion {

    private final Long id;
    private final Long vueloId;
    private final String email;     // nullable
    private final String telefono;  // nullable
    private final Boolean activa;
    private final LocalDateTime fechaCreacion;

    public Suscripcion(Long id, Long vueloId, String email, String telefono, Boolean activa, LocalDateTime fechaCreacion) {
        if (vueloId == null) throw new IllegalArgumentException("vueloId requerido");
        this.id = id;
        this.vueloId = vueloId;
        this.email = email;
        this.telefono = telefono;
        this.activa = activa;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getId() { return id; }
    public Long getVueloId() { return vueloId; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
    public Boolean getActiva() { return activa; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
}
