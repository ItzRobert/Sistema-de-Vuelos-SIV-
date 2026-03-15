package com.siv.api.persistence.entity.vuelos;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Aeropuerto", schema = "dbo")
public class AeropuertoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AeropuertoId")
    private Integer aeropuertoId;

    @Column(name = "CodigoIATA", nullable = false, length = 3)
    private String codigoIata;

    @Column(name = "Nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "Ciudad", length = 100)
    private String ciudad;

    @Column(name = "Pais", length = 100)
    private String pais;

    @Column(name = "Activo", nullable = false)
    private Boolean activo;

    @Column(name = "FechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    
    public Integer getAeropuertoId() { return aeropuertoId; }
    public void setAeropuertoId(Integer aeropuertoId) { this.aeropuertoId = aeropuertoId; }
    public String getCodigoIata() { return codigoIata; }
    public void setCodigoIata(String codigoIata) { this.codigoIata = codigoIata; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}