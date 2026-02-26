package com.mycompany.constanciaalumno.modelo;

/**
 * Clase que representa a una materia o asignatura del plan de estudios.
 * Elemento de la capa de Modelo.
 * 
 * @author alejandro
 */
public class Materia {

    String clave;
    String nombre;
    int creditos;

    /**
     * Construye un nuevo objeto Materia con validación de datos.
     * 
     * @param clave    La clave o código de la materia (ej. ISW-401).
     * @param nombre   El nombre completo de la materia.
     * @param creditos El valor en créditos de la materia.
     * @throws IllegalArgumentException si la clave o el nombre están vacíos, o si
     *                                  los créditos son negativos.
     */
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

    /**
     * Obtiene la clave de la materia.
     * 
     * @return La clave de la materia.
     */
    public String getClave() {
        return clave;
    }

    /**
     * Obtiene el nombre de la materia.
     * 
     * @return El nombre de la materia.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el número de créditos que otorga la materia.
     * 
     * @return Los créditos de la materia.
     */
    public int getCreditos() {
        return creditos;
    }

    @Override
    public String toString() {
        return clave + " - " + nombre + " (" + creditos + " créditos)";
    }
}
