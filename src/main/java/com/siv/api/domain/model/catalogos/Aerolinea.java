package com.siv.api.domain.model.catalogos;

public class Aerolinea {

    private final Long id;
    private final String codigoIata;
    private final String nombre;
    private final boolean activa;

    public Aerolinea(Long id, String codigoIata, String nombre, boolean activa) {
        this.id = id;
        this.codigoIata = codigoIata;
        this.nombre = nombre;
        this.activa = activa;
    }

    public Long getId() {
        return id;
    }

    public String getCodigoIata() {
        return codigoIata;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isActiva() {
        return activa;
    }}


  
