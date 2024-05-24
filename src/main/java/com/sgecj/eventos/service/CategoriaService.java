/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sgecj.eventos.service;

import com.sgecj.eventos.domain.Categoria;
import com.sgecj.eventos.repository.CategoriaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author huevo
 */
@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    /**
     * Retorna la lista con todas las categorias
     * @return 
     */
    public List<Categoria> buscarTodos() {
        return categoriaRepository.findAll();
    }

    /**
     * Guarda la nueva categoria en la base de datos
     * @param categoria
     * @return 
     */
    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    /**
     * Elimina una categoria por su ID
     * @param id
     */
    public void eliminarPorId(int id) {
        categoriaRepository.deleteById(id);
    }

    /**
     * Busca una categoria por su ID
     * @param id
     * @return 
     */
    public Optional<Categoria> buscarPorId(int id) {
        return categoriaRepository.findById(id);
    }

    /**
     * Realiza la consulta a la bd para buscar categorias por su nombre
     * @param consulta
     * @return
     */
    public List<Categoria> buscar(String consulta) {
        return categoriaRepository.buscar(consulta);
    }
}