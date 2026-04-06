package com.siv.api.controller.vuelos;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<VueloDto>> listarTodos() {
        return ResponseEntity.ok(vueloService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VueloDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(vueloService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<VueloDto> crear(@RequestBody CrearVueloRequest request) {
        VueloDto creado = vueloService.crear(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VueloDto> actualizar(@PathVariable Long id,
                                               @RequestBody CrearVueloRequest request) {
        return ResponseEntity.ok(vueloService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        vueloService.eliminar(id);
        return ResponseEntity.ok("Vuelo eliminado correctamente.");
    }
}
