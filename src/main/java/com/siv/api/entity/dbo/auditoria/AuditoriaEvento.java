package com.siv.api.entity.dbo.auditoria;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import com.siv.api.entity.dbo.seguridad.UsuarioOperativo;

@Entity
@Table(name = "AuditoriaEvento", schema = "dbo")
public class AuditoriaEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AuditoriaEventoId")
    private Long auditoriaEventoId;

    @Column(name = "TipoEvento", nullable = false, length = 50)
    private String tipoEvento;

    @Column(name = "Entidad", nullable = false, length = 30)
    private String entidad;

    @Column(name = "EntidadId")
    private Long entidadId;

    @Column(name = "Detalle", length = 600)
    private String detalle;

    @Column(name = "Actor", nullable = false, length = 30)
    private String actor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UsuarioOperativoId", nullable = false)
    private UsuarioOperativo usuarioOperativo;

    @Column(name = "FechaHora", nullable = false)
    private LocalDateTime fechaHora;

    // getters/setters
    public Long getAuditoriaEventoId() { return auditoriaEventoId; }
    public void setAuditoriaEventoId(Long auditoriaEventoId) { this.auditoriaEventoId = auditoriaEventoId; }

    public String getTipoEvento() { return tipoEvento; }
    public void setTipoEvento(String tipoEvento) { this.tipoEvento = tipoEvento; }

    public String getEntidad() { return entidad; }
    public void setEntidad(String entidad) { this.entidad = entidad; }

    public Long getEntidadId() { return entidadId; }
    public void setEntidadId(Long entidadId) { this.entidadId = entidadId; }

    public String getDetalle() { return detalle; }
    public void setDetalle(String detalle) { this.detalle = detalle; }

    public String getActor() { return actor; }
    public void setActor(String actor) { this.actor = actor; }

    public UsuarioOperativo getUsuarioOperativo() { return usuarioOperativo; }
    public void setUsuarioOperativo(UsuarioOperativo usuarioOperativo) { this.usuarioOperativo = usuarioOperativo; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
}