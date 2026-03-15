package com.siv.api.persistence.repository.catalogos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.siv.api.persistence.entity.catalogos.AerolineaEntity;

public interface SpringDataAerolineaRepository extends JpaRepository<AerolineaEntity, Integer> {
}