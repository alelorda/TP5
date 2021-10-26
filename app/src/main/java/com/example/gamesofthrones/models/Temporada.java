package com.example.gamesofthrones.models;

public class Temporada {
    private int id;
    private String nombre;
    private String anio;
    private String cantEpisodios;
    private String libro;
    private float rating;
    private String foto;

    public Temporada(int id, String nombre, String cantEpisodios, String anio, String libro, float rating, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.cantEpisodios = cantEpisodios;
        this.anio = anio;
        this.libro = libro;
        this.foto = foto;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }


    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public String getCantEpisodios() {
        return cantEpisodios;
    }

    public void setCantEpisodios(String cantEpisodios) {
        this.cantEpisodios = cantEpisodios;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
