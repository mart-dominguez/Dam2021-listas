package com.mdgz.dam.dam2021_listas.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Serie {
    private Integer id;
    private String nombre;
    private Integer calificacion;
    private Integer visualizaciones;
    private Genero genero;
    private Boolean enMiLista;

    public Serie(){}

    public Serie(Consumer<Serie> c){
        c.accept(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Integer getVisualizaciones() {
        return visualizaciones;
    }

    public void setVisualizaciones(Integer visualizaciones) {
        this.visualizaciones = visualizaciones;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Boolean getEnMiLista() {
        return enMiLista;
    }

    public void setEnMiLista(Boolean enMiLista) {
        this.enMiLista = enMiLista;
    }

    @Override
    public String toString() {
        return nombre.substring(0,3)+" ";
    }

    public static List<Serie> ejemplos(){
        Genero gComedia = new Genero( g -> {
            g.setId(2);
            g.setDescripcion("Comedia");
        } );
        Genero gSusp = new Genero( g -> {
            g.setId(2);
            g.setDescripcion("SUSPENSO");
        } );

        ArrayList<Serie> as = new ArrayList<>();
        as.add( new Serie(
                s -> {
                    s.setId(1);
                    s.setGenero(gComedia);
                    s.setNombre("GoT");
                    s.setCalificacion(85);
                    s.setVisualizaciones(900);
                    s.setEnMiLista(false);
                }
        ));
        as.add( new Serie(
                s -> {
                    s.setId(4);
                    s.setGenero(gSusp);
                    s.setNombre("Breaking Bad");
                    s.setCalificacion(90);
                    s.setVisualizaciones(920);
                    s.setEnMiLista(false);
                }
        ));
        as.add( new Serie(
                s -> {
                    s.setId(3);
                    s.setGenero(gComedia);
                    s.setNombre("ABC");
                    s.setCalificacion(29);
                    s.setVisualizaciones(900);
                    s.setEnMiLista(false);
                }
        ));
        as.add( new Serie(
                s -> {
                    s.setId(4);
                    s.setGenero(gComedia);
                    s.setNombre("YTR HGGHH");
                    s.setCalificacion(49);
                    s.setVisualizaciones(900);
                    s.setEnMiLista(false);
                }
        ));

        as.add( new Serie(
                s -> {
                    s.setId(5);
                    s.setGenero(gSusp);
                    s.setNombre("Peaky Blinders");
                    s.setCalificacion(92);
                    s.setVisualizaciones(920);
                    s.setEnMiLista(true);
                }
        ));

        as.add( new Serie(
                s -> {
                    s.setId(6);
                    s.setGenero(gSusp);
                    s.setNombre("Loki");
                    s.setCalificacion(60);
                    s.setVisualizaciones(920);
                    s.setEnMiLista(true);
                }
        ));

        as.add( new Serie(
                s -> {
                    s.setId(7);
                    s.setGenero(gSusp);
                    s.setNombre("Loki 999");
                    s.setCalificacion(58);
                    s.setVisualizaciones(1920);
                    s.setEnMiLista(false);
                }
        ));

        as.add( new Serie(
                s -> {
                    s.setId(8);
                    s.setGenero(gSusp);
                    s.setNombre("AAA 88888");
                    s.setCalificacion(54);
                    s.setVisualizaciones(1920);
                    s.setEnMiLista(true);
                }
        ));

        as.add( new Serie(
                s -> {
                    s.setId(9);
                    s.setGenero(gSusp);
                    s.setNombre("AAA 99999");
                    s.setCalificacion(98);
                    s.setVisualizaciones(1920);
                    s.setEnMiLista(false);
                }
        ));

        as.add( new Serie(
                s -> {
                    s.setId(10);
                    s.setGenero(gSusp);
                    s.setNombre("BBB  140000");
                    s.setCalificacion(58);
                    s.setVisualizaciones(1920);
                    s.setEnMiLista(false);
                }
        ));

        as.add( new Serie(
                s -> {
                    s.setId(11);
                    s.setGenero(gSusp);
                    s.setNombre("BBB  GFDSGF");
                    s.setCalificacion(58);
                    s.setVisualizaciones(1920);
                    s.setEnMiLista(false);
                }
        ));

        as.add( new Serie(
                s -> {
                    s.setId(12);
                    s.setGenero(gComedia);
                    s.setNombre("BBB  #DFF");
                    s.setCalificacion(58);
                    s.setVisualizaciones(1920);
                    s.setEnMiLista(false);
                }
        ));

        as.add( new Serie(
                s -> {
                    s.setId(13);
                    s.setGenero(gSusp);
                    s.setNombre("BBB  ggfdfg");
                    s.setCalificacion(58);
                    s.setVisualizaciones(1920);
                    s.setEnMiLista(false);
                }
        ));

        as.add( new Serie(
                s -> {
                    s.setId(14);
                    s.setGenero(gComedia);
                    s.setNombre("BBB  345435");
                    s.setCalificacion(58);
                    s.setVisualizaciones(1920);
                    s.setEnMiLista(true);
                }
        ));
        return as;
    }
}
