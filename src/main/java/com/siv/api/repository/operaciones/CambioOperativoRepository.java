package com.siv.api.repository.operaciones;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.siv.api.entity.dbo.operaciones.CambioOperativo;

public interface CambioOperativoRepository extends JpaRepository<CambioOperativo, Long> {

   
    List<CambioOperativo> findByVuelo_VueloId(Long vueloId);
}
