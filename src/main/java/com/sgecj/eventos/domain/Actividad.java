/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sgecj.eventos.domain;

import jakarta.persistence.Column;
import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author huevo
 */
@Entity
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACT_ID")
    private int id;
    @Column(name = "ACT_NOMBRE")
    private String nombre;
    @Column(name = "ACT_UBICACION")
    private String ubicacion;
    @Column(name = "ACT_CUPO_PERSONAS")
    private int cupoPersonas;
    @Column(name = "ACT_FECHA_INICIO")
    private LocalDate fechaInicio;
    @Column(name = "ACT_FECHA_FINAL")
    private LocalDate fechaFinal;
    @Column(name = "ACT_HORA_INICIO")
    private LocalTime horaInicio;
    @Column(name = "ACT_DURACION")
    private String duracion;
    @Column(name = "ACT_IMAGENURL")
    private String imagenURL;

    @ManyToOne
    @JoinColumn(name = "EVT_ID")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "AT_ID")
    private AreaTematica areaTematica;

    @ManyToOne
    @JoinColumn(name = "CAT_ID")
    private Categoria categoria;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the cupoPersonas
     */
    public int getCupoPersonas() {
        return cupoPersonas;
    }

    /**
     * @param cupoPersonas the cupoPersonas to set
     */
    public void setCupoPersonas(int cupoPersonas) {
        this.cupoPersonas = cupoPersonas;
    }

    /**
     * @return the fechaInicio
     */
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFinal
     */
    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    /**
     * @param fechaFinal the fechaFinal to set
     */
    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     * @return the horaInicio
     */
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @return the duracion
     */
    public String getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the imagenURL
     */
    public String getImagenURL() {
        return imagenURL;
    }

    /**
     * @param imagenURL the imagenURL to set
     */
    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }

    /**
     * @return the evento
     */
    public Evento getEvento() {
        return evento;
    }

    /**
     * @param evento the evento to set
     */
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    /**
     * @return the areaTematica
     */
    public AreaTematica getAreaTematica() {
        return areaTematica;
    }

    /**
     * @param areaTematica the areaTematica to set
     */
    public void setAreaTematica(AreaTematica areaTematica) {
        this.areaTematica = areaTematica;
    }

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
