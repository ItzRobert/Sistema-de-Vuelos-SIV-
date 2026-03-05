package com.siv.api.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CausaOperativa", schema = "dbo")
public class CausaOperativa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CausaOperativaId")
    private Integer causaOperativaId;

    @Column(name = "Codigo", nullable = false, length = 40)
    private String codigo;

    @Column(name = "Descripcion", nullable = false, length = 200)
    private String descripcion;

    
    public Integer getCausaOperativaId() { return causaOperativaId; }
    public void setCausaOperativaId(Integer causaOperativaId) { this.causaOperativaId = causaOperativaId; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
