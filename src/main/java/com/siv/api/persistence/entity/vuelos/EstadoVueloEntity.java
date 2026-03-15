package com.siv.api.persistence.entity.vuelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EstadoVuelo", schema = "dbo")
public class EstadoVueloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EstadoVueloId")
    private Integer estadoVueloId;

    @Column(name = "Codigo", nullable = false, length = 30)
    private String codigo;

    @Column(name = "Nombre", nullable = false, length = 60)
    private String nombre;

    @Column(name = "EsFinal", nullable = false)
    private Boolean esFinal;

   
    public Integer getEstadoVueloId() { return estadoVueloId; }
    public void setEstadoVueloId(Integer estadoVueloId) { this.estadoVueloId = estadoVueloId; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Boolean getEsFinal() { return esFinal; }
    public void setEsFinal(Boolean esFinal) { this.esFinal = esFinal; }
}