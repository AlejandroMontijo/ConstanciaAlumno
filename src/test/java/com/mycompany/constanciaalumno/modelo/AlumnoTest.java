package com.mycompany.constanciaalumno.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlumnoTest {

    @Test
    public void testGetNombreCompleto() {
        Alumno alumno = new Alumno("123", "Juan", "Perez", "ISW", 5);
        assertEquals("Juan Perez", alumno.getNombreCompleto(),
                "El nombre completo debe ser la concatenación de nombre y apellido");
    }

    @Test
    public void testAgregarMateria() {
        Alumno alumno = new Alumno("123", "Juan", "Perez", "ISW", 5);
        Materia materia = new Materia("001", "Matemáticas", 4);

        assertEquals(0, alumno.getCantidadMaterias(), "El alumno debe iniciar sin materias");

        alumno.agregarMateria(materia);
        assertEquals(1, alumno.getCantidadMaterias(), "El alumno debe tener 1 materia después de agregarla");
        assertEquals(materia, alumno.getMaterias().get(0), "La materia agregada debe estar en la lista");
    }

    @Test
    public void testGetTotalCreditos() {
        Alumno alumno = new Alumno("123", "Juan", "Perez", "ISW", 5);
        Materia m1 = new Materia("001", "Física", 5);
        Materia m2 = new Materia("002", "Química", 4);

        alumno.agregarMateria(m1);
        alumno.agregarMateria(m2);

        assertEquals(9, alumno.getTotalCreditos(),
                "El total de créditos debe ser la suma de los créditos de las materias (5+4)");
    }

    @Test
    public void testValidacionesConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new Alumno("", "Juan", "Perez", "ISW", 5),
                "Debe fallar con ID vacío");
        assertThrows(IllegalArgumentException.class, () -> new Alumno("123", null, "Perez", "ISW", 5),
                "Debe fallar con nombre nulo");
        assertThrows(IllegalArgumentException.class, () -> new Alumno("123", "Juan", "   ", "ISW", 5),
                "Debe fallar con apellido en blanco");
        assertThrows(IllegalArgumentException.class, () -> new Alumno("123", "Juan", "Perez", "", 5),
                "Debe fallar con carrera vacía");
        assertThrows(IllegalArgumentException.class, () -> new Alumno("123", "Juan", "Perez", "ISW", 0),
                "Debe fallar con semestre cero o negativo");
    }
}
