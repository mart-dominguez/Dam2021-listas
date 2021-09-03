package com.mdgz.dam.dam2021_listas.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Genero {
    private Integer id;
    private String descripcion;

    public Genero(){}

    public Genero(Consumer<Genero> c){
        c.accept(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }

    public static List<Genero> ejemplos(){
        /** crear un arreglo de 2 generos */
        ArrayList<Genero> ag = new ArrayList<>();
        Genero gComedia = new Genero( g -> {
            g.setId(2);
            g.setDescripcion("Comedia");
        } );
        ag.add(gComedia);
        Genero gSusp = new Genero( g -> {
            g.setId(2);
            g.setDescripcion("SUSPENSO");
        } );
        ag.add(gSusp);
        return ag;
    }
}
