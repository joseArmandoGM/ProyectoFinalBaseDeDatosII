/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sgecj.eventos.service;

import com.sgecj.eventos.domain.Evento;
import com.sgecj.eventos.repository.EventoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author huevo
 */
@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    /**
     * Retorna una lista con todos los eventos
     * @return 
     */
    public List<Evento> buscarTodos() {
        return eventoRepository.findAll();
    }
}