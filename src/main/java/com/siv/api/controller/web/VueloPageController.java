package com.siv.api.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.siv.api.application.dto.vuelos.CrearVueloRequest;
import com.siv.api.application.interfaces.catalogos.IAerolineaService;
import com.siv.api.application.interfaces.catalogos.IAeropuertoService;
import com.siv.api.application.interfaces.vuelos.IVueloService;

@Controller
@RequestMapping("/web/vuelos")
public class VueloPageController {

    private final IVueloService vueloService;
    private final IAerolineaService aerolineaService;
    private final IAeropuertoService aeropuertoService;

    public VueloPageController(
            IVueloService vueloService,
            IAerolineaService aerolineaService,
            IAeropuertoService aeropuertoService) {
        this.vueloService = vueloService;
        this.aerolineaService = aerolineaService;
        this.aeropuertoService = aeropuertoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("vuelos", vueloService.listarTodos());
        return "vuelos/index";
    }

    @GetMapping("/crear")
    public String mostrarFormulario(Model model) {
        model.addAttribute("vuelo", new CrearVueloRequest());
        model.addAttribute("aerolineas", aerolineaService.listarTodas());
        model.addAttribute("aeropuertos", aeropuertoService.listarTodos());
        return "vuelos/crear";
    }

    @PostMapping("/crear")
    public String crear(@ModelAttribute("vuelo") CrearVueloRequest request,
                        RedirectAttributes redirectAttributes,
                        Model model) {
        try {
            vueloService.crear(request);
            redirectAttributes.addFlashAttribute("success", "Vuelo creado correctamente.");
            return "redirect:/web/vuelos";
        } catch (Exception e) {
            String mensaje = e.getMessage();

            if (mensaje != null && mensaje.contains("UQ_Vuelo")) {
                model.addAttribute("error",
                        "Ya existe un vuelo registrado con esa combinación de aerolínea, número, fecha, origen y destino.");
            } else {
                model.addAttribute("error", "No se pudo guardar el vuelo: " + mensaje);
            }

            model.addAttribute("vuelo", request);
            model.addAttribute("aerolineas", aerolineaService.listarTodas());
            model.addAttribute("aeropuertos", aeropuertoService.listarTodos());
            return "vuelos/crear";
        }
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        var vuelo = vueloService.obtenerPorId(id);

        CrearVueloRequest request = new CrearVueloRequest();
        request.setNumeroVuelo(vuelo.getNumero());
        request.setAerolineaId(vuelo.getAerolineaId().intValue());
        request.setOrigenAeropuertoId(vuelo.getOrigenAeropuertoId().intValue());
        request.setDestinoAeropuertoId(vuelo.getDestinoAeropuertoId().intValue());
        request.setFechaVuelo(vuelo.getFecha().toString());
        request.setHoraProgramadaSalida(vuelo.getHoraSalida().toString());
        request.setHoraProgramadaLlegada(vuelo.getHoraLlegada().toString());

        model.addAttribute("vuelo", request);
        model.addAttribute("id", id);
        model.addAttribute("aerolineas", aerolineaService.listarTodas());
        model.addAttribute("aeropuertos", aeropuertoService.listarTodos());

        return "vuelos/editar";
    }

    @PostMapping("/editar/{id}")
    public String actualizar(@PathVariable Long id,
                             @ModelAttribute("vuelo") CrearVueloRequest request,
                             RedirectAttributes redirectAttributes,
                             Model model) {
        try {
            vueloService.actualizar(id, request);
            redirectAttributes.addFlashAttribute("success", "Vuelo actualizado correctamente.");
            return "redirect:/web/vuelos";
        } catch (Exception e) {
            String mensaje = e.getMessage();

            if (mensaje != null && mensaje.contains("UQ_Vuelo")) {
                model.addAttribute("error",
                        "Ya existe un vuelo registrado con esa combinación de aerolínea, número, fecha, origen y destino.");
            } else {
                model.addAttribute("error", "No se pudo actualizar el vuelo: " + mensaje);
            }

            model.addAttribute("vuelo", request);
            model.addAttribute("id", id);
            model.addAttribute("aerolineas", aerolineaService.listarTodas());
            model.addAttribute("aeropuertos", aeropuertoService.listarTodos());
            return "vuelos/editar";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            vueloService.eliminar(id);
            redirectAttributes.addFlashAttribute("success", "Vuelo eliminado correctamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "No se pudo eliminar el vuelo.");
        }
        return "redirect:/web/vuelos";
    }
}