package com.yaritzapech.miscontactos.pojo;


public class Contacto {

    private int id;
    private String nombre;
    private String telefono;
    private int foto;
    private int like;

    public Contacto(int foto, String nombre, int likes) {
        this.foto = foto;
        this.nombre = nombre;
        this.like = likes;
    }

    public Contacto() {

    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
