package com.siv.api.application.interfaces.catalogos;

import com.siv.api.application.dto.catalogos.AeropuertoDto;
import java.util.List;

public interface IAeropuertoService {
    List<AeropuertoDto> listarTodos();
    AeropuertoDto obtenerPorId(Long id);
}