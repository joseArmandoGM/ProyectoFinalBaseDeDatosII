/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sgecj.eventos.controller;

import com.sgecj.eventos.domain.Categoria;
import com.sgecj.eventos.service.CategoriaService;
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
public class CategoriaAbmController {

    private final CategoriaService categoriaService;

    public CategoriaAbmController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    /**
     * Manda a la pagina para insertar una nueva categoria
     * @param model
     * @return
     */
    @RequestMapping("/categorias/crear")
    public String mostrarFormAltaCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "formCategoria.html";
    }

    /**
     * Guarda una categoria en la base de datos
     * @param categoria
     * @return
     */
    @PostMapping("/categorias/guardar")
    public String guardar(Categoria categoria) {
        categoriaService.guardar(categoria);
        return "redirect:/categorias";
    }

    /**
     * Elimina una categoria de la base de datos
     * @param idCategoria
     * @return 
     */
    @RequestMapping("/categorias/eliminar")
    public String eliminarCategoriaPorId(@RequestParam("id") String idCategoria) {
        int id = Integer.parseInt(idCategoria);
        categoriaService.eliminarPorId(id);
        return "redirect:/categorias";
    }

    /**
     * Muestra la pagina de edicion de categorias
     * @param idCategoria
     * @param model
     * @return
     */
    @RequestMapping("/categorias/editar")
    public String mostrarEditarCategoria(@RequestParam("id") String idCategoria, Model model) {
        String mensajeError = "";

        try {
            // Intenta convertir el ID de la categoria a un entero
            int id = Integer.parseInt(idCategoria);

            // Busca la categoria por su ID
            Optional<Categoria> opcionalCategoria = categoriaService.buscarPorId(id);

            if (opcionalCategoria.isPresent()) {
                // Si la categoria se encuentra, la agrega al modelo para editarla
                Categoria categoria = opcionalCategoria.get();
                model.addAttribute("categoria", categoria);
                model.addAttribute("categorias", categoriaService.buscarTodos());
                return "formEditarCategoria.html";
            } else {
                // Si la actividad no se encuentra, muestra una página de error con el mensaje correspondiente
                mensajeError = "Actividad no encontrada";
                model.addAttribute("mensajeError", mensajeError);
                return "error";
            }
        } catch (NumberFormatException e) {
            // Si ocurre una excepción al convertir el ID a entero, muestra una página de error con el mensaje correspondiente
            mensajeError = "Id. de la categoria inválido";
            model.addAttribute("mensajeError", mensajeError);
            return "error";
        }
    }
}