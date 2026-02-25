package com.siv.api.entity.dbo.notificaciones;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import com.siv.api.entity.dbo.operaciones.Vuelo;

@Entity
@Table(name = "Suscripcion", schema = "dbo")
public class Suscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SuscripcionId")
    private Long suscripcionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VueloId", nullable = false)
    private Vuelo vuelo;

    @Column(name = "Email", length = 150)
    private String email;

    @Column(name = "Telefono", length = 30)
    private String telefono;

    @Column(name = "CanalEmail", nullable = false)
    private Boolean canalEmail;

    @Column(name = "CanalSMS", nullable = false)
    private Boolean canalSMS;

    @Column(name = "Preferencias", length = 300)
    private String preferencias;

    @Column(name = "Activa", nullable = false)
    private Boolean activa;

    @Column(name = "FechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;


    public Long getSuscripcionId() { return suscripcionId; }
    public void setSuscripcionId(Long suscripcionId) { this.suscripcionId = suscripcionId; }

    public Vuelo getVuelo() { return vuelo; }
    public void setVuelo(Vuelo vuelo) { this.vuelo = vuelo; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public Boolean getCanalEmail() { return canalEmail; }
    public void setCanalEmail(Boolean canalEmail) { this.canalEmail = canalEmail; }

    public Boolean getCanalSMS() { return canalSMS; }
    public void setCanalSMS(Boolean canalSMS) { this.canalSMS = canalSMS; }

    public String getPreferencias() { return preferencias; }
    public void setPreferencias(String preferencias) { this.preferencias = preferencias; }

    public Boolean getActiva() { return activa; }
    public void setActiva(Boolean activa) { this.activa = activa; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}