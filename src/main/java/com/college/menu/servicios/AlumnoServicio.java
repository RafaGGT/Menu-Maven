package com.college.menu.servicios;

import com.college.menu.modelos.Alumno;
import com.college.menu.modelos.Materia;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlumnoServicio {
    private Map<String, Alumno> listaAlumnos;

    public AlumnoServicio() {
        listaAlumnos = new HashMap<>(); // Inicializa el mapa
    }

    // Método para crear un nuevo alumno
    public void crearAlumno(Alumno alumno) {
    	if (!listaAlumnos.containsKey(alumno.getRut())) {
            listaAlumnos.put(alumno.getRut(), alumno); // Agrega el alumno al mapa usando el RUT como clave
            System.out.println("--- ¡Alumno agregado! ---");
        } else {
            System.out.println("El alumno con RUT " + alumno.getRut() + " ya está registrado.");
        }
    }

    // Método para listar alumnos
    public Map<String, Alumno> listarAlumnos() {
        return listaAlumnos;
    }

    // Método para agregar materia
    public void agregarMateria(String rutAlumno, Materia currentMate) {
        Alumno alumno = listaAlumnos.get(rutAlumno); // Busca al alumno en el mapa
        if (alumno != null) {
            alumno.getMaterias().add(currentMate); // Agrega la materia
        } else {
            System.out.println("Alumno con RUT " + rutAlumno + " no encontrado.");
        }
    }

    // Método para obtener materias por alumno
    public List<Materia> materiasPorAlumnos(String rutAlumno) {
        Alumno alumno = listaAlumnos.get(rutAlumno); // Busca al alumno por su RUT
        if (alumno != null) {
            return new ArrayList<>(alumno.getMaterias()); // Devuelve las materias como una lista
        }
        return new ArrayList<>(); // Retorna una lista vacía si no se encuentra el alumno
    }
}
