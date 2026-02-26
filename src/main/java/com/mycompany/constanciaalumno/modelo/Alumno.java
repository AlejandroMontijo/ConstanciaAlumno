package com.mycompany.constanciaalumno.modelo;

import java.util.ArrayList;

/**
 * @author alejandro
 */
public class Alumno {

    String id;
    String nombre;
    String apellido;
    String carrera;
    int semestre;
    ArrayList<Materia> materias;

    public Alumno(String id, String nombre, String apellido, String carrera, int semestre) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del alumno no puede estar vacío.");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del alumno no puede estar vacío.");
        }
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido del alumno no puede estar vacío.");
        }
        if (carrera == null || carrera.trim().isEmpty()) {
            throw new IllegalArgumentException("La carrera del alumno no puede estar vacía.");
        }
        if (semestre <= 0) {
            throw new IllegalArgumentException("El semestre debe ser mayor a cero.");
        }
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
        this.semestre = semestre;
        this.materias = new ArrayList<>();
    }

    public void agregarMateria(Materia m) {
        materias.add(m);
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public String getCarrera() {
        return carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public int getCantidadMaterias() {
        return materias.size();
    }

    public int getTotalCreditos() {
        int total = 0;
        for (Materia m : materias) {
            total += m.getCreditos();
        }
        return total;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " " + apellido;
    }
}
