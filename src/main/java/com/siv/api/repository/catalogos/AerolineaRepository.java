package com.siv.api.repository.catalogos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siv.api.entity.dbo.catalogos.Aerolinea;

public interface AerolineaRepository extends JpaRepository<Aerolinea, Integer> {
}