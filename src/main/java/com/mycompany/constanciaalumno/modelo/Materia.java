package com.mycompany.constanciaalumno.modelo;

/**
 * @author alejandro
 */
public class Materia {

    String clave;
    String nombre;
    int creditos;

    public Materia(String clave, String nombre, int creditos) {
        this.clave = clave;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    @Override
    public String toString() {
        return clave + " - " + nombre + " (" + creditos + " créditos)";
    }
}
