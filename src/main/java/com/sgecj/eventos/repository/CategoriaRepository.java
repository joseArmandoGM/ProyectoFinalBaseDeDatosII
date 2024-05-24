/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sgecj.eventos.repository;

import com.sgecj.eventos.domain.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author huevo
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    /**
     * Busca las categorias por su nombre
     * @param consulta
     * @return
     */
    @Query("from Categoria c where c.nombreCategoria like %?1%")
    List<Categoria> buscar(String consulta);
}