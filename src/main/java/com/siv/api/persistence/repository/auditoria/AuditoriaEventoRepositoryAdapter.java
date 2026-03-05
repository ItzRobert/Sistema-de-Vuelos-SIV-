package com.siv.api.persistence.repository.auditoria;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.siv.api.domain.repository.AuditoriaEventoRepository;

@Repository
public class AuditoriaEventoRepositoryAdapter implements AuditoriaEventoRepository {

    private final SpringDataAuditoriaEventoRepository jpa;

    public AuditoriaEventoRepositoryAdapter(SpringDataAuditoriaEventoRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public List<com.siv.api.domain.model.auditoria.AuditoriaEvento> findAll() {
        return jpa.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public Optional<com.siv.api.domain.model.auditoria.AuditoriaEvento> findById(Long id) {
        return jpa.findById(id).map(this::toDomain);
    }

    @Override
    public com.siv.api.domain.model.auditoria.AuditoriaEvento save(
            com.siv.api.domain.model.auditoria.AuditoriaEvento evento
    ) {
        var saved = jpa.save(toEntity(evento));
        return toDomain(saved);
    }

    

    private com.siv.api.domain.model.auditoria.AuditoriaEvento toDomain(
            com.siv.api.persistence.entity.AuditoriaEvento e
    ) {
        Integer usuarioId = (e.getUsuarioOperativo() == null || e.getUsuarioOperativo().getUsuarioOperativoId() == null)
                ? null
                : e.getUsuarioOperativo().getUsuarioOperativoId();

        return new com.siv.api.domain.model.auditoria.AuditoriaEvento(
                e.getAuditoriaEventoId(),
                e.getTipoEvento(),
                e.getEntidad(),
                e.getEntidadId(),
                e.getDetalle(),
                e.getActor(),
                usuarioId,
                e.getFechaHora()
        );
    }

    private com.siv.api.persistence.entity.AuditoriaEvento toEntity(
            com.siv.api.domain.model.auditoria.AuditoriaEvento d
    ) {
        var e = new com.siv.api.persistence.entity.AuditoriaEvento();

        e.setAuditoriaEventoId(d.getId());
        e.setTipoEvento(d.getTipoEvento());
        e.setEntidad(d.getEntidad());
        e.setEntidadId(d.getEntidadId());
        e.setDetalle(d.getDetalle());
        e.setActor(d.getActor());
        e.setFechaHora(d.getFechaHora());

       
        var u = new com.siv.api.persistence.entity.UsuarioOperativo();
        u.setUsuarioOperativoId(d.getUsuarioOperativoId());
        e.setUsuarioOperativo(u);

        return e;
    }
}
