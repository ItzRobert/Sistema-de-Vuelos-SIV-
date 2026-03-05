package com.siv.api.persistence.repository.operaciones;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siv.api.persistence.entity.CambioOperativo;

public interface SpringDataCambioOperativoRepository extends JpaRepository<CambioOperativo, Long> {

   
    List<CambioOperativo> findByVuelo_VueloId(Long vueloId);

    
}
