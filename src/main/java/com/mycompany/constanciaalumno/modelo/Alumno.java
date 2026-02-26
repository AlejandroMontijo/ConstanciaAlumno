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
