/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sgecj.eventos.service;

import com.sgecj.eventos.domain.Actividad;
import com.sgecj.eventos.repository.ActividadRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author huevo
 */
@Service
public class ActividadService {

    private final ActividadRepository actividadRepository;

    public ActividadService(ActividadRepository actividadRepository) {
        this.actividadRepository = actividadRepository;
    }

    /**
     * Retorna la lista con todas las actividades
     * @return 
     */
    public List<Actividad> buscarDestacados() {
        return actividadRepository.buscarTodos();
    }

    /**
     * Retorna la lista de actividades por su evento
     * @param eventoId
     * @return
     */
    public List<Actividad> buscarPorEvento(int eventoId) {
        return actividadRepository.buscarPorEvento(eventoId);
    }

    /**
     * Retorna la lista de actividades por su área tematica
     * @param areaTematicaId
     * @return
     */
    public List<Actividad> buscarPorAreaTematica(int areaTematicaId) {
        return actividadRepository.buscarPorAreaTematica(areaTematicaId);
    }

    /**
     * Retorna la lista de actividades por su categoría
     * @param categoriaId
     * @return
     */
    public List<Actividad> buscarPorCategoria(int categoriaId) {
        return actividadRepository.buscarPorCategoria(categoriaId);
    }

    /**
     * Realiza la consulta a la bd para buscar actividades por su nombre
     * @param consulta
     * @return
     */
    public List<Actividad> buscar(String consulta) {
        return actividadRepository.buscar(consulta);
    }

    /**
     * Guarda una actividad en la bd
     * @param actividad
     * @return
     */
    public Actividad guardar(Actividad actividad) {
        return actividadRepository.save(actividad);
    }

    /**
     * Permite buscar una actividad por su ID
     * @param id
     * @return
     */
    public Optional<Actividad> buscarPorId(int id) {
        return actividadRepository.findById(id);
    }

    /**
     * Elimina una actividad por su ID
     * @param id
     */
    public void eliminarPorId(int id) {
        actividadRepository.deleteById(id);
    }

    /**
     * Guarda los cambios de la actividad en la bd
     * @param actividad
     */
    public void guardarCambios(Actividad actividad) {
        actividadRepository.save(actividad);
    }
    
    /**
     * Realiza una subconsulta a la bd para buscar actividades por su categoria
     * @param consulta
     * @return
     */
    public List<Actividad> consultaCategoria(String consulta) {
        return actividadRepository.consultaCategoria(consulta);
    }
    
    /**
     * Realiza una subconsulta a la bd para buscar actividades por su area tematica
     * @param consulta
     * @return
     */
    public List<Actividad> consultaAreaTematica(String consulta) {
        return actividadRepository.consultaAreaTematica(consulta);
    }
    
    /**
     * Realiza una subconsulta a la bd para buscar actividades por su evento
     * @param consulta
     * @return
     */
    public List<Actividad> consultaEvento(String consulta) {
        return actividadRepository.consultaEvento(consulta);
    }
}
