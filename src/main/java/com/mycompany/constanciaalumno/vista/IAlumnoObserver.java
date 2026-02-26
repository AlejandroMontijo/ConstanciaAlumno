package com.mycompany.constanciaalumno.vista;

import com.mycompany.constanciaalumno.modelo.IAlumnoObservable;

/**
 * Interfaz fundamental del patrón Observer para la Vista.
 * Adhiere al modelo Pull: la vista recibe el observable (polimorfismo)
 * en lugar de los objetos concretos directamente.
 * 
 * @author alejandro
 */
public interface IAlumnoObserver {

    /**
     * El Sujeto (Observable) invoca este método cuando su estado interno cambia.
     * 
     * @param observable La instancia que notifica el cambio (se accede por su
     *                   interfaz).
     */
    void actualizar(IAlumnoObservable observable);

}
