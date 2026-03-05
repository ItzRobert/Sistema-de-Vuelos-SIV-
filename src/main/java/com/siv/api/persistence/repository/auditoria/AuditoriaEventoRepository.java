package com.siv.api.persistence.repository.auditoria;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siv.api.persistence.entity.AuditoriaEvento;

public interface AuditoriaEventoRepository extends JpaRepository<AuditoriaEvento, Long> { }