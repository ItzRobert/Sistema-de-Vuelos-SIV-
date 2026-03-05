package com.siv.api.persistence.repository.operaciones;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siv.api.persistence.entity.CausaOperativa;

public interface SpringDataCausaOperativaRepository extends JpaRepository<CausaOperativa, Integer> {
}