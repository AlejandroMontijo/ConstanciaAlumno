package com.mycompany.constanciaalumno.modelo;

import java.util.ArrayList;

/**
 * @author alejandro
 */
public class DatosAlumnos {

    // datos de prueba hardcodeados
    public static ArrayList<Alumno> obtenerAlumnos() {
        ArrayList<Alumno> lista = new ArrayList<>();

        // alumno 1
        Alumno a1 = new Alumno("000123456", "Carlos", "García López", "Ingeniería en Software", 5);
        a1.agregarMateria(new Materia("ISW-401", "Programación III", 8));
        a1.agregarMateria(new Materia("ISW-402", "Base de Datos II", 8));
        a1.agregarMateria(new Materia("ISW-403", "Redes de Computadoras", 6));
        a1.agregarMateria(new Materia("ISW-404", "Ingeniería de Software", 8));
        a1.agregarMateria(new Materia("MAT-301", "Probabilidad y Estadística", 6));
        lista.add(a1);

        // alumno 2
        Alumno a2 = new Alumno("000123789", "María", "Hernández Ruiz", "Ingeniería en Software", 3);
        a2.agregarMateria(new Materia("ISW-201", "Programación II", 8));
        a2.agregarMateria(new Materia("ISW-202", "Estructura de Datos", 8));
        a2.agregarMateria(new Materia("ISW-203", "Matemáticas Discretas", 6));
        a2.agregarMateria(new Materia("FIS-201", "Física II", 6));
        lista.add(a2);

        // alumno 3
        Alumno a3 = new Alumno("000456123", "Juan", "Martínez Soto", "Ingeniería Civil", 7);
        a3.agregarMateria(new Materia("CIV-501", "Estructuras II", 8));
        a3.agregarMateria(new Materia("CIV-502", "Hidráulica", 6));
        a3.agregarMateria(new Materia("CIV-503", "Geotecnia", 6));
        a3.agregarMateria(new Materia("CIV-504", "Diseño de Pavimentos", 8));
        a3.agregarMateria(new Materia("CIV-505", "Topografía II", 6));
        a3.agregarMateria(new Materia("ADM-401", "Administración de Proyectos", 6));
        lista.add(a3);

        // alumno 4
        Alumno a4 = new Alumno("000456789", "Ana", "López Mendoza", "Ingeniería Industrial", 4);
        a4.agregarMateria(new Materia("IIN-301", "Investigación de Operaciones", 8));
        a4.agregarMateria(new Materia("IIN-302", "Control de Calidad", 6));
        a4.agregarMateria(new Materia("IIN-303", "Ergonomía", 6));
        a4.agregarMateria(new Materia("MAT-302", "Cálculo III", 8));
        a4.agregarMateria(new Materia("IIN-304", "Procesos de Manufactura", 6));
        lista.add(a4);

        // alumno 5
        Alumno a5 = new Alumno("000789123", "Pedro", "Ramírez Castro", "Ingeniería en Software", 8);
        a5.agregarMateria(new Materia("ISW-601", "Proyecto de Software I", 10));
        a5.agregarMateria(new Materia("ISW-602", "Seguridad Informática", 6));
        a5.agregarMateria(new Materia("ISW-603", "Inteligencia Artificial", 8));
        lista.add(a5);

        // alumno 6
        Alumno a6 = new Alumno("000789456", "Laura", "Sánchez Vega", "Ingeniería Civil", 2);
        a6.agregarMateria(new Materia("CIV-101", "Dibujo Técnico", 6));
        a6.agregarMateria(new Materia("CIV-102", "Mecánica de Materiales", 8));
        a6.agregarMateria(new Materia("MAT-101", "Cálculo I", 8));
        a6.agregarMateria(new Materia("FIS-101", "Física I", 6));
        a6.agregarMateria(new Materia("QUI-101", "Química General", 6));
        lista.add(a6);

        // alumno 7
        Alumno a7 = new Alumno("000321654", "Roberto", "Díaz Flores", "Ingeniería Industrial", 6);
        a7.agregarMateria(new Materia("IIN-401", "Logística", 6));
        a7.agregarMateria(new Materia("IIN-402", "Simulación de Procesos", 8));
        a7.agregarMateria(new Materia("IIN-403", "Gestión de la Cadena de Suministro", 8));
        a7.agregarMateria(new Materia("IIN-404", "Planeación de la Producción", 6));
        lista.add(a7);

        // alumno 8
        Alumno a8 = new Alumno("000654321", "Sofía", "Torres Navarro", "Ingeniería en Software", 1);
        a8.agregarMateria(new Materia("ISW-101", "Programación I", 8));
        a8.agregarMateria(new Materia("MAT-100", "Precálculo", 6));
        a8.agregarMateria(new Materia("COM-100", "Comunicación Oral y Escrita", 4));
        a8.agregarMateria(new Materia("ING-100", "Inglés I", 4));
        a8.agregarMateria(new Materia("FIS-100", "Introducción a la Física", 6));
        a8.agregarMateria(new Materia("ISW-100", "Introducción a la Ingeniería", 4));
        lista.add(a8);

        return lista;
    }
}
