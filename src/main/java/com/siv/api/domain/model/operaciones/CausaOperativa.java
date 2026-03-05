package com.siv.api.domain.model.operaciones;

public class CausaOperativa {
    private final Integer id;
    private final String codigo;
    private final String descripcion;

    public CausaOperativa(Integer id, String codigo, String descripcion) {
        if (codigo == null || codigo.isBlank()) throw new IllegalArgumentException("El código no puede estar vacío");
        if (descripcion == null || descripcion.isBlank()) throw new IllegalArgumentException("La descripción no puede estar vacía");
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public Integer getId() { return id; }
    public String getCodigo() { return codigo; }
    public String getDescripcion() { return descripcion; }
}