package com.siv.api.persistence.repository.operaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.siv.api.domain.repository.CambioOperativoRepository;

@Repository
public class CambioOperativoRepositoryAdapter implements CambioOperativoRepository {

    private final SpringDataCambioOperativoRepository jpa;

    public CambioOperativoRepositoryAdapter(SpringDataCambioOperativoRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public List<com.siv.api.domain.model.operaciones.CambioOperativo> findAll() {
        return jpa.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public Optional<com.siv.api.domain.model.operaciones.CambioOperativo> findById(Long id) {
        return jpa.findById(id).map(this::toDomain);
    }

    @Override
    public com.siv.api.domain.model.operaciones.CambioOperativo save(
            com.siv.api.domain.model.operaciones.CambioOperativo cambio
    ) {
        var saved = jpa.save(toEntity(cambio));
        return toDomain(saved);
    }

    @Override
    public List<com.siv.api.domain.model.operaciones.CambioOperativo> findByVueloId(Long vueloId) {
       
        return jpa.findByVuelo_VueloId(vueloId).stream().map(this::toDomain).toList();


    }

    

    private com.siv.api.domain.model.operaciones.CambioOperativo toDomain(
            com.siv.api.persistence.entity.CambioOperativo e
    ) {
        Long vueloId = (e.getVuelo() == null || e.getVuelo().getVueloId() == null)
                ? null
                : e.getVuelo().getVueloId();

        Integer tipoCambioId = (e.getTipoCambio() == null || e.getTipoCambio().getTipoCambioId() == null)
                ? null
                : e.getTipoCambio().getTipoCambioId();

        Integer causaOperativaId = (e.getCausaOperativa() == null || e.getCausaOperativa().getCausaOperativaId() == null)
                ? null
                : e.getCausaOperativa().getCausaOperativaId();

        Integer usuarioOperativoId = (e.getUsuarioOperativo() == null || e.getUsuarioOperativo().getUsuarioOperativoId() == null)
                ? null
                : e.getUsuarioOperativo().getUsuarioOperativoId();

        return new com.siv.api.domain.model.operaciones.CambioOperativo(
                e.getCambioOperativoId(),
                vueloId,
                tipoCambioId,
                causaOperativaId,
                usuarioOperativoId,
                e.getValorAnterior(),
                e.getValorNuevo(),
                e.getObservacion(),
                e.getFechaHoraCambio(),
                e.getFuente()
        );
    }

    private com.siv.api.persistence.entity.CambioOperativo toEntity(
            com.siv.api.domain.model.operaciones.CambioOperativo d
    ) {
        var e = new com.siv.api.persistence.entity.CambioOperativo();

        e.setCambioOperativoId(d.getId());

        
        var vuelo = new com.siv.api.persistence.entity.vuelos.VueloEntity();
        vuelo.setVueloId(d.getVueloId());
        e.setVuelo(vuelo);

       
        var tipo = new com.siv.api.persistence.entity.TipoCambio();
        tipo.setTipoCambioId(d.getTipoCambioId());
        e.setTipoCambio(tipo);

        
        if (d.getCausaOperativaId() != null) {
            var causa = new com.siv.api.persistence.entity.CausaOperativa();
            causa.setCausaOperativaId(d.getCausaOperativaId());
            e.setCausaOperativa(causa);
        } else {
            e.setCausaOperativa(null);
        }

        
        if (d.getUsuarioOperativoId() != null) {
            var u = new com.siv.api.persistence.entity.UsuarioOperativo();
            u.setUsuarioOperativoId(d.getUsuarioOperativoId());
            e.setUsuarioOperativo(u);
        } else {
            e.setUsuarioOperativo(null);
        }

        e.setValorAnterior(d.getValorAnterior());
        e.setValorNuevo(d.getValorNuevo());
        e.setObservacion(d.getObservacion());
        e.setFechaHoraCambio(d.getFechaHoraCambio());
        e.setFuente(d.getFuente());

        return e;
    }
}