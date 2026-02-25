package com.siv.api.repository.operaciones;

import org.springframework.data.jpa.repository.JpaRepository;
import com.siv.api.entity.dbo.operaciones.Vuelo;

public interface VueloRepository extends JpaRepository<Vuelo, Long> { }