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
public class UnidadAcademica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UA_ID")
    private Integer id;
    @Column(name = "UA_NOMBRE")
    private String nombreUA;

    /**
     * @return the UA_ID
     */
    public Integer getUA_ID() {
        return id;
    }

    /**
     * @param UA_ID the UA_ID to set
     */
    public void setUA_ID(Integer UA_ID) {
        this.id = UA_ID;
    }

    /**
     * @return the UA_NOMBRE
     */
    public String getUA_NOMBRE() {
        return nombreUA;
    }

    /**
     * @param UA_NOMBRE the UA_NOMBRE to set
     */
    public void setUA_NOMBRE(String UA_NOMBRE) {
        this.nombreUA = UA_NOMBRE;
    }
}