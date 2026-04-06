
package com.siv.api.domain.model.operaciones;

import java.time.LocalDateTime;

public class CambioOperativo {

    private final Long id;
    private final Long vueloId;
    private final Integer tipoCambioId;
    private final Integer causaOperativaId;     
    private final Integer usuarioOperativoId;   
    private final String valorAnterior;         
    private final String valorNuevo;            
    private final String observacion;           
    private final LocalDateTime fechaHoraCambio;
    private final String fuente;

    public CambioOperativo(Long id,
                           Long vueloId,
                           Integer tipoCambioId,
                           Integer causaOperativaId,
                           Integer usuarioOperativoId,
                           String valorAnterior,
                           String valorNuevo,
                           String observacion,
                           LocalDateTime fechaHoraCambio,
                           String fuente) {

        if (vueloId == null) throw new IllegalArgumentException("vueloId es requerido");
        if (tipoCambioId == null) throw new IllegalArgumentException("tipoCambioId es requerido");
        if (fechaHoraCambio == null) throw new IllegalArgumentException("fechaHoraCambio es requerida");
        if (fuente == null || fuente.isBlank()) throw new IllegalArgumentException("fuente es requerida");

        this.id = id;
        this.vueloId = vueloId;
        this.tipoCambioId = tipoCambioId;
        this.causaOperativaId = causaOperativaId;
        this.usuarioOperativoId = usuarioOperativoId;
        this.valorAnterior = valorAnterior;
        this.valorNuevo = valorNuevo;
        this.observacion = observacion;
        this.fechaHoraCambio = fechaHoraCambio;
        this.fuente = fuente;
    }

    public Long getId() { return id; }
    public Long getVueloId() { return vueloId; }
    public Integer getTipoCambioId() { return tipoCambioId; }
    public Integer getCausaOperativaId() { return causaOperativaId; }
    public Integer getUsuarioOperativoId() { return usuarioOperativoId; }
    public String getValorAnterior() { return valorAnterior; }
    public String getValorNuevo() { return valorNuevo; }
    public String getObservacion() { return observacion; }
    public LocalDateTime getFechaHoraCambio() { return fechaHoraCambio; }
    public String getFuente() { return fuente; }
}
