package com.siv.api.persistence.repository.catalogos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.siv.api.domain.repository.AerolineaRepository;

@Repository
public class AerolineaRepositoryAdapter implements AerolineaRepository {

    private final SpringDataAerolineaRepository jpa;

    public AerolineaRepositoryAdapter(SpringDataAerolineaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public List<com.siv.api.domain.model.catalogos.Aerolinea> findAll() {
        return jpa.findAll().stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public Optional<com.siv.api.domain.model.catalogos.Aerolinea> findById(Integer id) {
        return jpa.findById(id).map(this::toDomain);
    }

    @Override
    public com.siv.api.domain.model.catalogos.Aerolinea save(
            com.siv.api.domain.model.catalogos.Aerolinea aerolinea
    ) {
        var saved = jpa.save(toEntity(aerolinea));
        return toDomain(saved);
    }

    // ---------- MAPPERS ----------
    private com.siv.api.domain.model.catalogos.Aerolinea toDomain(
            com.siv.api.persistence.entity.catalogos.AerolineaEntity e
    ) {
        return new com.siv.api.domain.model.catalogos.Aerolinea(
                e.getAerolineaId() == null ? null : e.getAerolineaId().longValue(),
                e.getCodigoIATA(),
                e.getNombre(),
                e.getActiva() != null && e.getActiva()
        );
    }

    private com.siv.api.persistence.entity.catalogos.AerolineaEntity toEntity(
            com.siv.api.domain.model.catalogos.Aerolinea d
    ) {
        var e = new com.siv.api.persistence.entity.catalogos.AerolineaEntity();
        if (d.getId() != null) {
            e.setAerolineaId(d.getId().intValue()); // Long -> Integer
        }
        e.setCodigoIATA(d.getCodigoIata());

        e.setNombre(d.getNombre());
      
        e.setActiva(d.isActiva());
       
        return e;
    }
}
