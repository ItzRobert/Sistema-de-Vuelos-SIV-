package com.siv.api.domain.model.operaciones;

public class TipoCambio {
    private final Integer id;
    private final String codigo;
    private final String nombre;

    public TipoCambio(Integer id, String codigo, String nombre) {
        if (codigo == null || codigo.isBlank()) throw new IllegalArgumentException("El código no puede estar vacío");
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("El nombre no puede estar vacío");
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Integer getId() { return id; }
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
}
