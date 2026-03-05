package com.siv.api.controller.vuelos;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siv.api.application.dto.vuelos.CrearVueloRequest;
import com.siv.api.application.service.vuelos.CrearVueloService;
import com.siv.api.application.service.vuelos.ListarVuelosService;
import com.siv.api.domain.model.vuelos.Vuelo;

@RestController
@RequestMapping("/vuelos")
public class VueloController {

    
    private final ListarVuelosService listar;
    private final CrearVueloService crear;

    
    public VueloController(ListarVuelosService listar, CrearVueloService crear) {
        this.listar = listar;
        this.crear = crear;
    }

    
    @GetMapping
    public List<Vuelo> listar() {
        return listar.ejecutar();
    }

    
    @PostMapping
    public Vuelo crear(@RequestBody CrearVueloRequest request) {
        return crear.ejecutar(request);
    }
}
