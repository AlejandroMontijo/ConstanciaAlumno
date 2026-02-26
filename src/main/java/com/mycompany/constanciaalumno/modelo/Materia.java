package com.mycompany.constanciaalumno.modelo;

/**
 * @author alejandro
 */
public class Materia {

    String clave;
    String nombre;
    int creditos;

    public Materia(String clave, String nombre, int creditos) {
        if (clave == null || clave.trim().isEmpty()) {
            throw new IllegalArgumentException("La clave de la materia no puede estar vacía.");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la materia no puede estar vacío.");
        }
        if (creditos < 0) {
            throw new IllegalArgumentException("Los créditos no pueden ser negativos.");
        }
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
