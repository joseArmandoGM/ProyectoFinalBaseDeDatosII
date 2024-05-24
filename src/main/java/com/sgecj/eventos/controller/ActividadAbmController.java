/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sgecj.eventos.controller;

import com.sgecj.eventos.domain.Actividad;
import com.sgecj.eventos.service.ActividadService;
import com.sgecj.eventos.service.AreaTematicaService;
import com.sgecj.eventos.service.CategoriaService;
import com.sgecj.eventos.service.EventoService;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author huevo
 */
@Controller
public class ActividadAbmController {

    private final ActividadService actividadService;
    private final EventoService eventoService;
    private final CategoriaService categoriaService;
    private final AreaTematicaService areaTematicaService;

    public ActividadAbmController(ActividadService actividadService,
            EventoService eventoService,
            CategoriaService categoriaService,
            AreaTematicaService areaTematicaService) {
        this.actividadService = actividadService;
        this.eventoService = eventoService;
        this.categoriaService = categoriaService;
        this.areaTematicaService = areaTematicaService;
    }

    /**
     * Manda a la pagina para insertar una nueva actividad
     * @param model
     * @return
     */
    @RequestMapping("/actividades/crear")
    public String mostrarFormAlta(Model model) {
        model.addAttribute("eventos", eventoService.buscarTodos());
        model.addAttribute("categorias", categoriaService.buscarTodos());
        model.addAttribute("areasTematicas", areaTematicaService.buscarTodos());
        model.addAttribute("actividad", new Actividad());
        return "formActividad.html";
    }

    /**
     * Guarda una actividad en la base de datos
     * @param actividad
     * @return
     */
    @PostMapping("/actividades/guardar")
    public String guardar(Actividad actividad) {
        actividadService.guardar(actividad);
        return "redirect:/listado";
    }

    /**
     * Elimina una actividad de la base de datos
     * @param idActividad
     * @return
     */
    @RequestMapping("/actividades/eliminar")
    public String eliminarActividadPorId(@RequestParam("id") String idActividad) {
        int idA = Integer.parseInt(idActividad);
        actividadService.eliminarPorId(idA);
        return "redirect:/listado";
    }

    /**
     * Muestra la pagina de edicion de actividades
     * @param idActividad
     * @param model
     * @return
     */
    @RequestMapping("/actividades/editar")
    public String mostrarEditarActividad(@RequestParam("id") String idActividad, Model model) {
        String mensajeError = "";

        try {
            // Intenta convertir el ID del videojuego a un entero
            int id = Integer.parseInt(idActividad);

            // Busca el videojuego por su ID
            Optional<Actividad> opcionalActividad = actividadService.buscarPorId(id);

            if (opcionalActividad.isPresent()) {
                // Si el videojuego se encuentra, lo agrega al modelo y muestra la vista del videojuego
                Actividad actividad = opcionalActividad.get();
                model.addAttribute("actividad", actividad);
                // Aquí puedes hacer cualquier procesamiento adicional necesario antes de mostrar la página
                model.addAttribute("eventos", eventoService.buscarTodos());
                model.addAttribute("categorias", categoriaService.buscarTodos());
                model.addAttribute("areasTematicas", areaTematicaService.buscarTodos());
                return "formEditarActividad.html";
            } else {
                // Si el videojuego no se encuentra, muestra una página de error con el mensaje correspondiente
                mensajeError = "Actividad no encontrada";
                model.addAttribute("mensajeError", mensajeError);
                return "error";
            }
        } catch (NumberFormatException e) {
            // Si ocurre una excepción al convertir el ID a entero, muestra una página de error con el mensaje correspondiente
            mensajeError = "Id. de la actividad inválido";
            model.addAttribute("mensajeError", mensajeError);
            return "error";
        }
    }

    /**
     * Guarda los cambios de una actividad en la base de datos
     * @param actividad
     * @return
     */
    @PostMapping("/actividades/guardarCambios")
    public String guardarCambios(Actividad actividad) {
        actividadService.guardarCambios(actividad);
        return "redirect:/listado";
    }
}
