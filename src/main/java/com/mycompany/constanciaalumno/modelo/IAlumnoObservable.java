package com.mycompany.constanciaalumno.modelo;

import com.mycompany.constanciaalumno.vista.IAlumnoObserver;
import java.util.List;

/**
 * Interfaz que define las operaciones de un Sujeto (Observable)
 * dentro del patrón Observer.
 * En el modelo Pull, expone métodos para que los Observadores extraigan el
 * estado.
 * 
 * @author alejandro
 */
public interface IAlumnoObservable {
    void agregarObservador(IAlumnoObserver o);

    void removerObservador(IAlumnoObserver o);

    void notificarObservadores();

    // Métodos para el modelo Pull (Polimorfismo para la Vista)
    List<Alumno> getAlumnosFiltrados();

    Alumno getAlumnoSeleccionado();

    String getMensajeBusqueda();
}
