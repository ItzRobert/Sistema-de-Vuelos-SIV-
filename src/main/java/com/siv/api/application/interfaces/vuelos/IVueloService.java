package com.siv.api.application.interfaces.vuelos;

import java.util.List;

import com.siv.api.application.dto.vuelos.CrearVueloRequest;
import com.siv.api.application.dto.vuelos.VueloDto;

public interface IVueloService {

    List<VueloDto> listarTodos();

    VueloDto obtenerPorId(Long id);

    VueloDto crear(CrearVueloRequest request);

    VueloDto actualizar(Long id, CrearVueloRequest request);

    void eliminar(Long id);
}