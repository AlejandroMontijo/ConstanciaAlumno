package com.mycompany.constanciaalumno.vista;

import com.mycompany.constanciaalumno.modelo.Alumno;
import java.util.List;

/**
 * Interfaz fundamental del patrón Observer para las vistas.
 * Permite que componentes gráficos reaccionen a cambios en el modelo sin estar
 * acoplados a él concretamente.
 * 
 * @author alejandro
 */
public interface IAlumnoObserver {

    /**
     * Se invoca cuando el modelo indica que hay un cambio en la lista de alumnos
     * disponibles (filtro).
     * 
     * @param lista La nueva lista de alumnos a mostrar.
     */
    void actualizarListaAlumnos(List<Alumno> lista);

    /**
     * Se invoca cuando el modelo indica que se ha seleccionado o deseleccionado un
     * alumno en particular.
     * 
     * @param alumno El Alumno seleccionado u objeto null si la selección se limpió.
     */
    void actualizarDatosAlumno(Alumno alumno);

    /**
     * Se invoca cuando el modelo ordena mostrar un mensaje de sistema en la vista.
     * 
     * @param mensaje El texto a mostrar (ej. errores de búsqueda o confirmaciones).
     */
    void mostrarMensaje(String mensaje);
}
