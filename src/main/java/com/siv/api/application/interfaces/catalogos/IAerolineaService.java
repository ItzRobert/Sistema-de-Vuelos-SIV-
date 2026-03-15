package com.siv.api.application.interfaces.catalogos;

import com.siv.api.application.dto.catalogos.AerolineaDto;
import java.util.List;

public interface IAerolineaService {
    List<AerolineaDto> listarTodas();
    AerolineaDto obtenerPorId(Long id);
}
