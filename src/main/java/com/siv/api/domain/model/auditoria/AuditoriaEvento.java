package com.siv.api.domain.model.auditoria;

import java.time.LocalDateTime;

public class AuditoriaEvento {

    private final Long id;
    private final String tipoEvento;
    private final String entidad;
    private final Long entidadId;              
    private final String detalle;             
    private final String actor;
    private final Integer usuarioOperativoId;  
    private final LocalDateTime fechaHora;

    public AuditoriaEvento(Long id,
                           String tipoEvento,
                           String entidad,
                           Long entidadId,
                           String detalle,
                           String actor,
                           Integer usuarioOperativoId,
                           LocalDateTime fechaHora) {

        if (tipoEvento == null || tipoEvento.isBlank()) throw new IllegalArgumentException("tipoEvento requerido");
        if (entidad == null || entidad.isBlank()) throw new IllegalArgumentException("entidad requerida");
        if (actor == null || actor.isBlank()) throw new IllegalArgumentException("actor requerido");
        if (usuarioOperativoId == null) throw new IllegalArgumentException("usuarioOperativoId requerido");
        if (fechaHora == null) throw new IllegalArgumentException("fechaHora requerida");

        this.id = id;
        this.tipoEvento = tipoEvento;
        this.entidad = entidad;
        this.entidadId = entidadId;
        this.detalle = detalle;
        this.actor = actor;
        this.usuarioOperativoId = usuarioOperativoId;
        this.fechaHora = fechaHora;
    }

    public Long getId() { return id; }
    public String getTipoEvento() { return tipoEvento; }
    public String getEntidad() { return entidad; }
    public Long getEntidadId() { return entidadId; }
    public String getDetalle() { return detalle; }
    public String getActor() { return actor; }
    public Integer getUsuarioOperativoId() { return usuarioOperativoId; }
    public LocalDateTime getFechaHora() { return fechaHora; }
}
