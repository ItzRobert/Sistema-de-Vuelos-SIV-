package com.siv.api.persistence.repository.operaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.siv.api.domain.repository.CausaOperativaRepository;

@Repository
public class CausaOperativaRepositoryAdapter implements CausaOperativaRepository {

    private final SpringDataCausaOperativaRepository jpa;

    public CausaOperativaRepositoryAdapter(SpringDataCausaOperativaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public List<com.siv.api.domain.model.operaciones.CausaOperativa> findAll() {
        return jpa.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public Optional<com.siv.api.domain.model.operaciones.CausaOperativa> findById(Integer id) {
        return jpa.findById(id).map(this::toDomain);
    }

    @Override
    public com.siv.api.domain.model.operaciones.CausaOperativa save(com.siv.api.domain.model.operaciones.CausaOperativa d) {
        var saved = jpa.save(toEntity(d));
        return toDomain(saved);
    }

    private com.siv.api.domain.model.operaciones.CausaOperativa toDomain(com.siv.api.persistence.entity.CausaOperativa e) {
        return new com.siv.api.domain.model.operaciones.CausaOperativa(
                e.getCausaOperativaId(),
                e.getCodigo(),
                e.getDescripcion()
        );
    }

    private com.siv.api.persistence.entity.CausaOperativa toEntity(com.siv.api.domain.model.operaciones.CausaOperativa d) {
        var e = new com.siv.api.persistence.entity.CausaOperativa();
        e.setCausaOperativaId(d.getId());
        e.setCodigo(d.getCodigo());
        e.setDescripcion(d.getDescripcion());
        return e;
    }
}
