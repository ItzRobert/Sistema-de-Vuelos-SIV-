package com.siv.api.entity.dbo.notificaciones;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import com.siv.api.entity.dbo.operaciones.CambioOperativo;

@Entity
@Table(name = "Notificacion", schema = "dbo")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NotificacionId")
    private Long notificacionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SuscripcionId", nullable = false)
    private Suscripcion suscripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CambioOperativoId") // nullable
    private CambioOperativo cambioOperativo;

    @Column(name = "Canal", nullable = false, length = 10)
    private String canal;

    @Column(name = "EstadoEnvio", nullable = false, length = 20)
    private String estadoEnvio;

    @Column(name = "Mensaje", length = 500)
    private String mensaje;

    @Column(name = "FechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "FechaEnvio")
    private LocalDateTime fechaEnvio;

    // getters/setters
    public Long getNotificacionId() { return notificacionId; }
    public void setNotificacionId(Long notificacionId) { this.notificacionId = notificacionId; }

    public Suscripcion getSuscripcion() { return suscripcion; }
    public void setSuscripcion(Suscripcion suscripcion) { this.suscripcion = suscripcion; }

    public CambioOperativo getCambioOperativo() { return cambioOperativo; }
    public void setCambioOperativo(CambioOperativo cambioOperativo) { this.cambioOperativo = cambioOperativo; }

    public String getCanal() { return canal; }
    public void setCanal(String canal) { this.canal = canal; }

    public String getEstadoEnvio() { return estadoEnvio; }
    public void setEstadoEnvio(String estadoEnvio) { this.estadoEnvio = estadoEnvio; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public LocalDateTime getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(LocalDateTime fechaEnvio) { this.fechaEnvio = fechaEnvio; }
}
