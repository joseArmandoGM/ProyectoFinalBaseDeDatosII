/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sgecj.eventos.repository;

import com.sgecj.eventos.domain.Actividad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author huevo
 */
public interface ActividadRepository extends JpaRepository<Actividad, Integer> {

    /**
     * Retorna la lista de actividades por nombre
     * @return
     */
    @Query("Select a from Actividad a order by a.nombre")
    List<Actividad> buscarTodos();

    /**
     * Retorna la lista de actividades segun el evento al que pertenece
     * @param eventoId
     * @return
     */
    @Query("from Actividad a where a.evento.id = ?1 order by a.nombre")
    List<Actividad> buscarPorEvento(int eventoId);

    /**
     * Retorna la lista de actividades segun el area tematica a la que pertenece
     * @param areaTematicaId
     * @return
     */
    @Query("from Actividad a where a.areaTematica.id = ?1 order by a.nombre")
    List<Actividad> buscarPorAreaTematica(int areaTematicaId);

    /**
     * Retorna la lista de actividades segun la categoria a la que pertenece
     * @param categoriaId
     * @return
     */
    @Query("from Actividad a where a.categoria.id = ?1 order by a.nombre")
    List<Actividad> buscarPorCategoria(int categoriaId);

    /**
     * Busca las actividades por el String de busqueda
     * @param consulta
     * @return
     */
    @Query("from Actividad a where a.nombre like %?1%")
    List<Actividad> buscar(String consulta);
    
    /**
     * Retorna la lista de actividades ordenadas por su categoria
     * segun la categoria seleccionada
     * @param consulta
     * @return 
     */
    @Query("SELECT a FROM Actividad a WHERE a.categoria.id = (SELECT c.id FROM Categoria c WHERE c.nombreCategoria LIKE %?1%)")
    List<Actividad> consultaCategoria(String consulta);
    
    /**
     * Retorna la lista de actividades ordenadas por su area tematica
     * segun el area tematica seleccionada
     * @param consulta
     * @return 
     */
    @Query("SELECT a FROM Actividad a WHERE a.areaTematica.id = (SELECT at.id FROM AreaTematica at WHERE at.nombreAreaTematica LIKE %?1%)")
    List<Actividad> consultaAreaTematica(String consulta);
    
    /**
     * Retorna la lista de actividades ordenadas por su evento
     * segun el area tematica seleccionada
     * @param consulta
     * @return 
     */
    @Query("SELECT a FROM Actividad a WHERE a.evento.id = (SELECT e.id FROM Evento e WHERE e.nombreEvento LIKE %?1%)")
    List<Actividad> consultaEvento(String consulta);
}
