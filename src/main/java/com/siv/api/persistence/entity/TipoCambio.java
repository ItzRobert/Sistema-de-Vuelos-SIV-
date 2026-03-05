package com.siv.api.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TipoCambio", schema = "dbo")
public class TipoCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TipoCambioId")
    private Integer tipoCambioId;

    @Column(name = "Codigo", nullable = false, length = 40)
    private String codigo;

    @Column(name = "Nombre", nullable = false, length = 80)
    private String nombre;

   
    public Integer getTipoCambioId() { return tipoCambioId; }
    public void setTipoCambioId(Integer tipoCambioId) { this.tipoCambioId = tipoCambioId; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
