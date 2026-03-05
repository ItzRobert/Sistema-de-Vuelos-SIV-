package com.siv.api.controller.catalogos;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siv.api.application.service.vuelos.ListarAeropuertosService;
import com.siv.api.domain.model.vuelos.Aeropuerto;

@RestController
@RequestMapping("/catalogos/aeropuertos")
public class AeropuertoController {

    private final ListarAeropuertosService service;

    public AeropuertoController(ListarAeropuertosService service) {
        this.service = service;
    }

    @GetMapping
    public List<Aeropuerto> listar() {
        return service.ejecutar();
    }
}
