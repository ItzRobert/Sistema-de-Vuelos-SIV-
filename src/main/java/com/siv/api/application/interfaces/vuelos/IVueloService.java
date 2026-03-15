package com.siv.api.application.interfaces.vuelos;

import com.siv.api.application.dto.vuelos.CrearVueloRequest;
import com.siv.api.application.dto.vuelos.VueloDto;

import java.util.List;

public interface IVueloService {

    List<VueloDto> listarTodos();

    VueloDto obtenerPorId(Long id);

    VueloDto crear(CrearVueloRequest request);

}