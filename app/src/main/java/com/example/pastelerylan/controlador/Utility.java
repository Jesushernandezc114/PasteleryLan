package com.example.pastelerylan.controlador;

public class Utility {
    public static final String TABLA_CLIENTES = "Clientes";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_NUMTELEFONICO= "numtelefonico";

    public static final String CREAR_TABLA_CLIENTES = "CREATE TABLE " +
            TABLA_CLIENTES + " (" +
            CAMPO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            CAMPO_NOMBRE + " TEXT, " +
            CAMPO_NUMTELEFONICO + " TEXT)";



    public static final String TABLA_VENTAS= "Ventas";
    public static final String CAMPO_ID_VENTAS = "id";
    public static final String CAMPO_ID_CLIENTE = "nombrecliente";
    public static final String CAMPO_DESCRIPCION= "descripcion";

    public static final String CREAR_TABLA_VENTAS = "CREATE TABLE " +
            TABLA_VENTAS + " (" +
            CAMPO_ID_VENTAS + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            CAMPO_ID_CLIENTE + " INTEGER, " +
            CAMPO_DESCRIPCION + " TEXT)";


    public static final String TABLA_USUARIO= "USUARIO";
    public static final String CAMPO_USUARIO = "user";
    public static final String CAMPO_PASSWORD = "password";
    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE " +
            TABLA_USUARIO + " (" + CAMPO_USUARIO + " TEXT, " +
            CAMPO_PASSWORD + " TEXT)";


}
