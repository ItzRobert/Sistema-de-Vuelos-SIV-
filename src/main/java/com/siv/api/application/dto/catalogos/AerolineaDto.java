package com.siv.api.application.dto.catalogos;

public class AerolineaDto {
    private Integer id;
    private String codigoIata;
    private String nombre;
    private Boolean activa;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getCodigoIata() { return codigoIata; }
    public void setCodigoIata(String codigoIata) { this.codigoIata = codigoIata; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Boolean getActiva() { return activa; }
    public void setActiva(Boolean activa) { this.activa = activa; }
}
