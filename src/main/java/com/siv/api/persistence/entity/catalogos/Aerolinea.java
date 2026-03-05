package com.siv.api.persistence.entity.catalogos;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Aerolinea", schema = "dbo")
public class Aerolinea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="AerolineaId")
	private Integer aerolineaId;

  
    @Column(name = "CodigoIATA", nullable = false, length = 2)
    private String codigoIATA;

    @Column(name = "Nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "Activa", nullable = false)
    private Boolean activa;

    @Column(name = "FechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;


    public Integer getAerolineaId() { return aerolineaId; }
    public void setAerolineaId(Integer aerolineaId) { this.aerolineaId = aerolineaId; }

    public String getCodigoIATA() { return codigoIATA; }
    public void setCodigoIATA(String codigoIATA) { this.codigoIATA = codigoIATA; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Boolean getActiva() { return activa; }
    public void setActiva(Boolean activa) { this.activa = activa; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}

