package com.siv.api.repository.auditoria;

import org.springframework.data.jpa.repository.JpaRepository;
import com.siv.api.entity.dbo.auditoria.AuditoriaEvento;

public interface AuditoriaEventoRepository extends JpaRepository<AuditoriaEvento, Long> { }