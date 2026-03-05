package com.siv.api.persistence.repository.operaciones;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siv.api.persistence.entity.TipoCambio;

public interface SpringDataTipoCambioRepository extends JpaRepository<TipoCambio, Integer> {
}
