package com.mycompany.constanciaalumno.modelo;

import java.util.ArrayList;

/**
 * Clase que representa a un estudiante inscrito en el instituto.
 * Es la entidad principal de la capa de Modelo.
 * 
 * @author alejandro
 */
public class Alumno {

    String id;
    String nombre;
    String apellido;
    String carrera;
    int semestre;
    ArrayList<Materia> materias;

    /**
     * Construye una nueva instancia de Alumno con validaciones estrictas.
     * Inicializa internamente la lista de materias.
     * 
     * @param id       El identificador único del alumno.
     * @param nombre   El nombre o nombres del alumno.
     * @param apellido Los apellidos del alumno.
     * @param carrera  El programa académico al que pertenece.
     * @param semestre El nivel o semestre actual (>0).
     * @throws IllegalArgumentException si algún campo de texto está vacío o el
     *                                  semestre es inválido.
     */
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

    /**
     * Agrega una materia a la lista de materias inscritas por el alumno.
     * 
     * @param m El objeto Materia a agregar.
     */
    public void agregarMateria(Materia m) {
        materias.add(m);
    }

    /**
     * Obtiene el ID del alumno.
     * 
     * @return El identificador en formato de cadena.
     */
    public String getId() {
        return id;
    }

    /**
     * Obtiene el nombre del alumno.
     * 
     * @return El nombre del alumno.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el apellido del alumno.
     * 
     * @return El apellido del alumno.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Retorna el nombre completo concatenando nombre y apellido.
     * 
     * @return El nombre completo del alumno.
     */
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    /**
     * Obtiene la carrera universitaria en la que está inscrito el alumno.
     * 
     * @return El nombre de la carrera.
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * Obtiene el número de semestre actual del alumno.
     * 
     * @return El nivel de semestre (>0).
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * Obtiene la lista completa de las materias inscritas por el alumno.
     * 
     * @return Un ArrayList de objetos Materia.
     */
    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    /**
     * Calcula la cantidad total de materias inscritas.
     * 
     * @return El conteo de elementos en la lista de materias.
     */
    public int getCantidadMaterias() {
        return materias.size();
    }

    /**
     * Calcula la suma total de los créditos de todas las materias inscritas por el
     * alumno.
     * Si no hay materias, retorna 0.
     * 
     * @return La sumatoria entera de créditos cursados en el bloque.
     */
    public int getTotalCreditos() {
        int total = 0;
        for (Materia m : materias) {
            total += m.getCreditos();
        }
        return total;
    }

    /**
     * Representación textual predeterminada del Alumno para mostrarse en listas y
     * comboboxes.
     * 
     * @return Una cadena en el formato "ID - Nombre Apellido"
     */
    @Override
    public String toString() {
        return id + " - " + nombre + " " + apellido;
    }
}
