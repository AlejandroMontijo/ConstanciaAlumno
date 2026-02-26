package com.mycompany.constanciaalumno.modelo;

import com.mycompany.constanciaalumno.vista.IAlumnoObserver;

/**
 * Interfaz que define las operaciones de un Sujeto Observable en el patrón
 * Observer.
 * Permite que otros objetos (como la Vista) se suscriban para ser notificados
 * de cambios en los datos.
 * Aplica el principio de Segregación de Interfaces (ISP).
 * 
 * @author alejandro
 */
public interface IAlumnoObservable {

    /**
     * Suscribe un observador para que reciba notificaciones de cambios.
     * 
     * @param o El observador que implementa IAlumnoObserver.
     */
    void agregarObservador(IAlumnoObserver o);

    /**
     * Da de baja un observador existente.
     * 
     * @param o El observador a remover.
     */
    void removerObservador(IAlumnoObserver o);

    /**
     * Notifica a todos los observadores suscritos que ha ocurrido un cambio en el
     * modelo,
     * para que puedan actualizarse.
     */
    void notificarObservadores();
}
