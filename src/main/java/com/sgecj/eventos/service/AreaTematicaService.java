/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sgecj.eventos.service;

import com.sgecj.eventos.domain.AreaTematica;
import com.sgecj.eventos.repository.AreaTematicaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author huevo
 */
@Service
public class AreaTematicaService {

    private final AreaTematicaRepository areaTematicaRepository;

    public AreaTematicaService(AreaTematicaRepository areaTematicaRepository) {
        this.areaTematicaRepository = areaTematicaRepository;
    }

    /**
     * Retorna la lista con todas las areas tematicas
     * @return 
     */
    public List<AreaTematica> buscarTodos() {
        return areaTematicaRepository.findAll();
    }
}