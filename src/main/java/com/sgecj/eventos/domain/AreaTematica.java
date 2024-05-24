/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sgecj.eventos.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author huevo
 */
@Entity
public class AreaTematica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AT_ID")
    private Integer id;
    @Column(name = "AT_NOMBRE")
    private String nombreAreaTematica;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nombreAreaTematica
     */
    public String getNombreAreaTematica() {
        return nombreAreaTematica;
    }

    /**
     * @param nombreAreaTematica the nombreAreaTematica to set
     */
    public void setNombreAreaTematica(String nombreAreaTematica) {
        this.nombreAreaTematica = nombreAreaTematica;
    }
}
