package com.mycompany.constanciaalumno.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MateriaTest {

    @Test
    public void testMateriaCreacion() {
        Materia materia = new Materia("MAT101", "Cálculo Diferencial", 5);

        assertEquals("MAT101", materia.getClave(), "La clave debe coincidir");
        assertEquals("Cálculo Diferencial", materia.getNombre(), "El nombre debe coincidir");
        assertEquals(5, materia.getCreditos(), "Los créditos deben coincidir");
    }

    @Test
    public void testToString() {
        Materia materia = new Materia("MAT101", "Cálculo Diferencial", 5);
        String expected = "MAT101 - Cálculo Diferencial (5 créditos)";
        assertEquals(expected, materia.toString(), "El método toString debe tener el formato esperado");
    }

    @Test
    public void testValidacionesConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new Materia("", "Matemáticas", 5),
                "Debe fallar con clave vacía");
        assertThrows(IllegalArgumentException.class, () -> new Materia("001", null, 5), "Debe fallar con nombre nulo");
        assertThrows(IllegalArgumentException.class, () -> new Materia("001", "Física", -1),
                "Debe fallar con créditos negativos");
    }
}
