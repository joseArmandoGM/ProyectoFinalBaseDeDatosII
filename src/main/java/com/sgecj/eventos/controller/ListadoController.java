/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sgecj.eventos.controller;

import com.sgecj.eventos.domain.Actividad;
import com.sgecj.eventos.domain.Categoria;
import com.sgecj.eventos.service.ActividadService;
import com.sgecj.eventos.service.AreaTematicaService;
import com.sgecj.eventos.service.CategoriaService;
import com.sgecj.eventos.service.EventoService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author huevo
 */
@Controller
public class ListadoController {

    private final ActividadService actividadService;
    private final CategoriaService categoriaService;
    private final EventoService eventoService;
    private final AreaTematicaService areaTematicaService;

    public ListadoController(ActividadService actividadService,
            CategoriaService categoriaService, EventoService eventoService,
            AreaTematicaService areaTematicaService) {
        this.actividadService = actividadService;
        this.categoriaService = categoriaService;
        this.eventoService = eventoService;
        this.areaTematicaService = areaTematicaService;
    }

    /**
     * Muestra la pagina con todas las actividades
     * @param model
     * @return
     */
    @RequestMapping("/listado")
    public String listarActividades(Model model) {
        List<Actividad> actividades = actividadService.buscarDestacados();
        model.addAttribute("actividades", actividades);
        return "listado.html";
    }

    /**
     * Retorna una lista de actividades segun el evento
     * @param eventoId
     * @param model
     * @return
     */
    @RequestMapping("/actividadesPorEvento")
    public String listarActividadesPorEvento(int eventoId, Model model) {
        List<Actividad> actividades = actividadService.buscarPorEvento(eventoId);
        model.addAttribute("actividades", actividades);
        return "listado.html";
    }

    /**
     * Retorna una lista de actividades segun el area tematica
     * @param areaTematicaId
     * @param model
     * @return
     */
    @RequestMapping("/actividadesPorAreaTematica")
    public String listarActividadesPorAreaTematica(int areaTematicaId, Model model) {
        List<Actividad> actividades = actividadService.buscarPorAreaTematica(areaTematicaId);
        model.addAttribute("actividades", actividades);
        return "listado.html";
    }

    /**
     * Retorna una lista de actividades segun la categoria
     * @param categoriaId
     * @param model
     * @return
     */
    @RequestMapping("/actividadesPorCategoria")
    public String listarActividadesPorCategoria(int categoriaId, Model model) {
        List<Actividad> actividades = actividadService.buscarPorCategoria(categoriaId);
        model.addAttribute("actividades", actividades);
        return "listado.html";
    }

    /**
     * Permite realizar búsquedas de actividades por el nombre
     * @param consulta
     * @param model
     * @return
     */
    @RequestMapping("/buscar")
    public String buscar(@RequestParam("q") String consulta, Model model) {
        List<Actividad> actividades = actividadService.buscar(consulta);
        model.addAttribute("actividades", actividades);
        return "listado.html";
    }

    /**
     * Permite realizar búsquedas de categorias por su nombre
     * @param consulta
     * @param model
     * @return
     */
    @RequestMapping("/buscarCategoria")
    public String buscarCategoria(@RequestParam("q") String consulta, Model model) {
        List<Categoria> categorias = categoriaService.buscar(consulta);
        model.addAttribute("categorias", categorias);
        return "listadoCategorias.html";
    }

    /**
     * Muestra como se estan procesando las actividades en la página
     * @return 
     */
    @GetMapping("/actividades")
    @ResponseBody
    public ResponseEntity<List<Actividad>> getActividades() {
        List<Actividad> todos = actividadService.buscarDestacados();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    /**
     * Maneja la solicitud para buscar una actividad por su ID.
     * @param idActividad El ID de la actividad a buscar.
     * @param model El modelo para agregar atributos para la vista.
     * @return La vista que mostrará los detalles de la actividad o una página de
     * error.
     */
    @RequestMapping("/buscarActividadPorId")
    public String buscarActividadPorId(@RequestParam("actividadId") String idActividad, Model model) {
        String mensajeError = "";

        try {
            // Intenta convertir el ID de la actividad a un entero
            int id = Integer.parseInt(idActividad);

            // Busca la actividad por su ID
            Optional<Actividad> opcionalActividad = actividadService.buscarPorId(id);

            if (opcionalActividad.isPresent()) {
                // Si la actividad se encuentra, lo agrega al modelo y muestra la vista de actividades
                Actividad actividad = opcionalActividad.get();
                model.addAttribute("actividad", actividad);
                return "actividad.html";
            } else {
                // Si la actividad no se encuentra, muestra una página de error con el mensaje correspondiente
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
     * Retorna una lista de categorias
     * @param model
     * @return
     */
    @RequestMapping("/categorias")
    public String listarCategorias(Model model) {
        List<Categoria> categorias = categoriaService.buscarTodos();
        model.addAttribute("categorias", categorias);
        return "listadoCategorias.html";
    }
    
    /**
     * Muestra la pagina de inicio de la aplicación
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model) {
        return "index.html";
    }
    
    /**
     * Muestra la pagina de consultas y subconsultas
     * @param model
     * @return
     */
    @RequestMapping("/consultas")
    public String consultas(Model model) {
        model.addAttribute("eventos", eventoService.buscarTodos());
        model.addAttribute("categorias", categoriaService.buscarTodos());
        model.addAttribute("areasTematicas", areaTematicaService.buscarTodos());
        return "consultas.html";
    }
    
    /**
     * Permite realizar búsquedas de actividades por la categoria
     * @param consulta
     * @param model
     * @return
     */
    @RequestMapping("/consultaCategoria")
    public String consultaC(@RequestParam("q") String consulta, Model model) {
        List<Actividad> actividades = actividadService.consultaCategoria(consulta);
        model.addAttribute("actividades", actividades);
        return "consultas.html";
    }
    
    /**
     * Permite realizar búsquedas de actividades por el area tematica
     * @param consulta
     * @param model
     * @return
     */
    @RequestMapping("/consultaAreaTematica")
    public String consultaAT(@RequestParam("q") String consulta, Model model) {
        List<Actividad> actividades = actividadService.consultaAreaTematica(consulta);
        model.addAttribute("actividades", actividades);
        return "consultas.html";
    }
    
    /**
     * Permite realizar búsquedas de actividades por el area tematica
     * @param consulta
     * @param model
     * @return
     */
    @RequestMapping("/consultaEvento")
    public String consultaEvento(@RequestParam("q") String consulta, Model model) {
        List<Actividad> actividades = actividadService.consultaEvento(consulta);
        model.addAttribute("actividades", actividades);
        return "consultas.html";
    }
}