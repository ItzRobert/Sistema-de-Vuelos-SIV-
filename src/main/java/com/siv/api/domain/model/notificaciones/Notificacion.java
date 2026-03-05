package com.siv.api.domain.model.notificaciones;

import java.time.LocalDateTime;

public class Notificacion {

    private final Long id;
    private final Long suscripcionId;
    private final String canal;
    private final String mensaje;
    private final LocalDateTime fechaHora;

    public Notificacion(Long id, Long suscripcionId, String canal, String mensaje, LocalDateTime fechaHora) {
        if (suscripcionId == null) throw new IllegalArgumentException("suscripcionId requerido");
        if (canal == null || canal.isBlank()) throw new IllegalArgumentException("canal requerido");
        if (mensaje == null || mensaje.isBlank()) throw new IllegalArgumentException("mensaje requerido");
        if (fechaHora == null) throw new IllegalArgumentException("fechaHora requerida");
        this.id = id;
        this.suscripcionId = suscripcionId;
        this.canal = canal;
        this.mensaje = mensaje;
        this.fechaHora = fechaHora;
    }

    public Long getId() { return id; }
    public Long getSuscripcionId() { return suscripcionId; }
    public String getCanal() { return canal; }
    public String getMensaje() { return mensaje; }
    public LocalDateTime getFechaHora() { return fechaHora; }
}
