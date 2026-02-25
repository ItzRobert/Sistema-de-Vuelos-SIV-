package com.siv.api.entity.dbo.operaciones;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import com.siv.api.entity.dbo.catalogos.TipoCambio;
import com.siv.api.entity.dbo.catalogos.CausaOperativa;
import com.siv.api.entity.dbo.seguridad.UsuarioOperativo;

@Entity
@Table(name = "CambioOperativo", schema = "dbo")
public class CambioOperativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CambioOperativoId")
    private Long cambioOperativoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VueloId", nullable = false)
    private Vuelo vuelo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TipoCambioId", nullable = false)
    private TipoCambio tipoCambio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CausaOperativaId") // nullable
    private CausaOperativa causaOperativa;

    @Column(name = "ValorAnterior", length = 200)
    private String valorAnterior;

    @Column(name = "ValorNuevo", length = 200)
    private String valorNuevo;

    @Column(name = "Observacion", length = 300)
    private String observacion;

    @Column(name = "FechaHoraCambio", nullable = false)
    private LocalDateTime fechaHoraCambio;

    @Column(name = "Fuente", nullable = false, length = 30)
    private String fuente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UsuarioOperativoId", nullable = false)
    private UsuarioOperativo usuarioOperativo;

    // getters/setters
    public Long getCambioOperativoId() { return cambioOperativoId; }
    public void setCambioOperativoId(Long cambioOperativoId) { this.cambioOperativoId = cambioOperativoId; }

    public Vuelo getVuelo() { return vuelo; }
    public void setVuelo(Vuelo vuelo) { this.vuelo = vuelo; }

    public TipoCambio getTipoCambio() { return tipoCambio; }
    public void setTipoCambio(TipoCambio tipoCambio) { this.tipoCambio = tipoCambio; }

    public CausaOperativa getCausaOperativa() { return causaOperativa; }
    public void setCausaOperativa(CausaOperativa causaOperativa) { this.causaOperativa = causaOperativa; }

    public String getValorAnterior() { return valorAnterior; }
    public void setValorAnterior(String valorAnterior) { this.valorAnterior = valorAnterior; }

    public String getValorNuevo() { return valorNuevo; }
    public void setValorNuevo(String valorNuevo) { this.valorNuevo = valorNuevo; }

    public String getObservacion() { return observacion; }
    public void setObservacion(String observacion) { this.observacion = observacion; }

    public LocalDateTime getFechaHoraCambio() { return fechaHoraCambio; }
    public void setFechaHoraCambio(LocalDateTime fechaHoraCambio) { this.fechaHoraCambio = fechaHoraCambio; }

    public String getFuente() { return fuente; }
    public void setFuente(String fuente) { this.fuente = fuente; }

    public UsuarioOperativo getUsuarioOperativo() { return usuarioOperativo; }
    public void setUsuarioOperativo(UsuarioOperativo usuarioOperativo) { this.usuarioOperativo = usuarioOperativo; }
}