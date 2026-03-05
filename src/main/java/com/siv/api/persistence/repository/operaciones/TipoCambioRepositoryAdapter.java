package com.siv.api.persistence.repository.operaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.siv.api.domain.repository.TipoCambioRepository;

@Repository
public class TipoCambioRepositoryAdapter implements TipoCambioRepository {

    private final SpringDataTipoCambioRepository jpa;

    public TipoCambioRepositoryAdapter(SpringDataTipoCambioRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public List<com.siv.api.domain.model.operaciones.TipoCambio> findAll() {
        return jpa.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public Optional<com.siv.api.domain.model.operaciones.TipoCambio> findById(Integer id) {
        return jpa.findById(id).map(this::toDomain);
    }

    @Override
    public com.siv.api.domain.model.operaciones.TipoCambio save(com.siv.api.domain.model.operaciones.TipoCambio d) {
        var saved = jpa.save(toEntity(d));
        return toDomain(saved);
    }

    private com.siv.api.domain.model.operaciones.TipoCambio toDomain(com.siv.api.persistence.entity.TipoCambio e) {
        return new com.siv.api.domain.model.operaciones.TipoCambio(
                e.getTipoCambioId(),
                e.getCodigo(),
                e.getNombre()
        );
    }

    private com.siv.api.persistence.entity.TipoCambio toEntity(com.siv.api.domain.model.operaciones.TipoCambio d) {
        var e = new com.siv.api.persistence.entity.TipoCambio();
        e.setTipoCambioId(d.getId());
        e.setCodigo(d.getCodigo());
        e.setNombre(d.getNombre());
        return e;
    }
}
