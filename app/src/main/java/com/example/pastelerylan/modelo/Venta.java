package com.example.pastelerylan.modelo;

public class Venta {
    private Integer id;
    private Integer idcliente;
    private String Descripcion;

    public Venta() {
    }

    public Venta(Integer id, Integer idcliente, String descripcion) {
        this.id = id;
        this.idcliente = idcliente;
        Descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id=" + id +
                ", idcliente=" + idcliente +
                ", Descripcion='" + Descripcion + '\'' +
                '}';
    }
}
