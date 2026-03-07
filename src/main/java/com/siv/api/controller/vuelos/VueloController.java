package com.siv.api.controller.vuelos;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siv.api.application.dto.vuelos.CrearVueloRequest;
import com.siv.api.application.dto.vuelos.VueloDto;
import com.siv.api.application.interfaces.vuelos.IVueloService;

@RestController
@RequestMapping("/vuelos")
public class VueloController {

    private final IVueloService vueloService;

    public VueloController(IVueloService vueloService) {
        this.vueloService = vueloService;
    }

    @GetMapping
    public List<VueloDto> listarTodos() {
        return vueloService.listarTodos();
    }

    @PostMapping
    public VueloDto crear(@RequestBody CrearVueloRequest request) {
        return vueloService.crear(request);
    }
}
