# EXAMEN 1 — Constancia de Alumno Inscrito

## 1. Descripción del Caso de Uso

### CU-01: Generar Constancia de Alumno Inscrito

| Campo | Descripción |
|-------|-------------|
| **Nombre** | Generar Constancia de Alumno Inscrito |
| **Actor Principal** | Personal Administrativo |
| **Descripción** | El usuario busca un alumno por su ID de forma incremental, selecciona al alumno deseado, verifica sus datos de inscripción y genera una constancia oficial. |
| **Precondiciones** | El sistema tiene alumnos registrados con sus materias inscritas. |
| **Postcondiciones** | Se genera y muestra la constancia de inscripción del alumno seleccionado. |

### Flujo Básico

1. El usuario abre la aplicación "Constancia de Alumno Inscrito".
2. El usuario comienza a escribir el ID del alumno en el campo de texto de la zona izquierda.
3. A medida que escribe, el sistema filtra y muestra en la lista de la zona derecha los alumnos cuyo ID contiene el texto escrito.
4. El usuario selecciona un alumno de la lista.
5. El sistema muestra los datos de confirmación debajo de la lista: nombre completo, ID, carrera, semestre, cantidad de materias, créditos y lista de materias inscritas.
6. El usuario hace clic en "Generar Constancia".
7. El sistema genera y muestra la constancia formal en la misma zona, con encabezado institucional, fecha, datos del alumno, materias y folio.

### Flujos Alternos

- **3a.** Si no existe ningún alumno cuyo ID contenga el texto escrito, se muestra un mensaje "No se encontraron alumnos".
- **4a.** Si el usuario modifica el ID, la lista se actualiza automáticamente y se limpian los datos previos.

---

## 2. Storyboard del Caso de Uso

### Pantalla 1: Estado Inicial
```
┌──────────────────────────────────────────────────────────┐
│              Constancia de Alumno Inscrito                │
├──────────────┬───────────────────────────────────────────┤
│ Buscar       │  Resultados                               │
│ Alumno       │  ┌─────────────────────────────────────┐  │
│              │  │ Alumnos encontrados                 │  │
│ ID del       │  │                                     │  │
│ Alumno:      │  │  (lista vacía)                      │  │
│ ┌──────────┐ │  │                                     │  │
│ │          │ │  └─────────────────────────────────────┘  │
│ └──────────┘ │  ┌─────────────────────────────────────┐  │
│              │  │ Información del Alumno              │  │
│              │  │                                     │  │
│              │  │                                     │  │
│              │  │                                     │  │
│              │  └─────────────────────────────────────┘  │
│              │                    [Generar Constancia]    │
└──────────────┴───────────────────────────────────────────┘
```

### Pantalla 2: Búsqueda Incremental
El usuario escribe "000123" y aparecen 2 alumnos que hacen match:
```
┌──────────────────────────────────────────────────────────┐
│              Constancia de Alumno Inscrito                │
├──────────────┬───────────────────────────────────────────┤
│ Buscar       │  Resultados                               │
│ Alumno       │  ┌─────────────────────────────────────┐  │
│              │  │ Alumnos encontrados                 │  │
│ ID del       │  │ 000123456 - Carlos García López     │  │
│ Alumno:      │  │ 000123789 - María Hernández Ruiz    │  │
│ ┌──────────┐ │  │                                     │  │
│ │ 000123   │ │  └─────────────────────────────────────┘  │
│ └──────────┘ │  ┌─────────────────────────────────────┐  │
│              │  │ Información del Alumno              │  │
│              │  │                                     │  │
│              │  │                                     │  │
│              │  │                                     │  │
│              │  └─────────────────────────────────────┘  │
│              │                    [Generar Constancia]    │
└──────────────┴───────────────────────────────────────────┘
```

### Pantalla 3: Alumno Seleccionado — Datos de Confirmación
```
┌──────────────────────────────────────────────────────────┐
│              Constancia de Alumno Inscrito                │
├──────────────┬───────────────────────────────────────────┤
│ Buscar       │  Resultados                               │
│ Alumno       │  ┌─────────────────────────────────────┐  │
│              │  │ Alumnos encontrados                 │  │
│ ID del       │  │ ▶ 000123456 - Carlos García López   │  │
│ Alumno:      │  │   000123789 - María Hernández Ruiz  │  │
│ ┌──────────┐ │  └─────────────────────────────────────┘  │
│ │ 000123   │ │  ┌─────────────────────────────────────┐  │
│ └──────────┘ │  │ Datos de Confirmación               │  │
│              │  │                                     │  │
│              │  │ ID:       000123456                  │  │
│              │  │ Nombre:   Carlos García López        │  │
│              │  │ Carrera:  Ing. en Software           │  │
│              │  │ Semestre: 5                          │  │
│              │  │ Materias: 5                          │  │
│              │  │ Créditos: 36                         │  │
│              │  │                                     │  │
│              │  │ MATERIAS INSCRITAS:                  │  │
│              │  │ • ISW-401 - Programación III         │  │
│              │  │ • ISW-402 - Base de Datos II         │  │
│              │  │ • ISW-403 - Redes de Computadoras    │  │
│              │  │ • ISW-404 - Ingeniería de Software   │  │
│              │  │ • MAT-301 - Probabilidad y Estad.    │  │
│              │  └─────────────────────────────────────┘  │
│              │                    [Generar Constancia]    │
└──────────────┴───────────────────────────────────────────┘
```

### Pantalla 4: Constancia Generada
```
┌──────────────────────────────────────────────────────────┐
│              Constancia de Alumno Inscrito                │
├──────────────┬───────────────────────────────────────────┤
│ Buscar       │  ┌─────────────────────────────────────┐  │
│ Alumno       │  │ Constancia Generada                 │  │
│              │  │                                     │  │
│ ID del       │  │ ╔══════════════════════════════════╗ │  │
│ Alumno:      │  │ ║ INSTITUTO TECNOLÓGICO DE SONORA  ║ │  │
│ ┌──────────┐ │  │ ║ DIRECCIÓN ACADÉMICA              ║ │  │
│ │ 000123   │ │  │ ╚══════════════════════════════════╝ │  │
│ └──────────┘ │  │                                     │  │
│              │  │ CONSTANCIA DE ALUMNO INSCRITO        │  │
│              │  │                                     │  │
│              │  │ Ciudad Obregón, Sonora, a 25 de     │  │
│              │  │ febrero de 2026                      │  │
│              │  │                                     │  │
│              │  │ A QUIEN CORRESPONDA:                 │  │
│              │  │                                     │  │
│              │  │ ...se hace constar que el alumno:    │  │
│              │  │ CARLOS GARCÍA LÓPEZ                  │  │
│              │  │ ID: 000123456                        │  │
│              │  │ Carrera: Ing. en Software, Sem. 5    │  │
│              │  │ 5 materias, 36 créditos              │  │
│              │  │                                     │  │
│              │  │ Folio: CONST-2026-XXXXXX             │  │
│              │  └─────────────────────────────────────┘  │
│              │                    [Generar Constancia]    │
└──────────────┴───────────────────────────────────────────┘
```

---

## 3. Liga al código en GitHub

> **https://github.com/AlejandroMontijo/ConstanciaAlumno**

---

## 4. Liga al video de ejecución y explicación del código

> **[AGREGAR AQUÍ LA URL DEL VIDEO]**
