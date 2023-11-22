package com.example.pastelerylan.modelo;

public class Cliente {
    private Integer id;
    private String nombre;
    private String numtelefonico;

    public Cliente() {
    }

    public Cliente(Integer id, String nombre, String numtelefonico) {
        this.id = id;
        this.nombre = nombre;
        this.numtelefonico = numtelefonico;
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

    public String getNumtelefonico() {
        return numtelefonico;
    }

    public void setNumtelefonico(String numtelefonico) {
        this.numtelefonico = numtelefonico;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", numtelefonico='" + numtelefonico + '\'' +
                '}';
    }
}
