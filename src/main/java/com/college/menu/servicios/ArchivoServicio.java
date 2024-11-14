package com.college.menu.servicios;

import com.college.menu.modelos.Alumno;
import com.college.menu.modelos.Materia;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class ArchivoServicio {

    private List<Alumno> alumnosACargar; // Lista para almacenar alumnos mientras se procesa el archivo
    private PromedioServicioImp promediosServicioImp; // Instancia de la clase PromedioServicioImp

    // Constructor
    public ArchivoServicio() {
        this.alumnosACargar = new ArrayList<>(); // Inicializar la lista de alumnos
        this.promediosServicioImp = new PromedioServicioImp(); // Inicializar el servicio de promedios
    }

    // Método para exportar los datos de los alumnos a un archivo
    public void exportarDatos(Map<String, Alumno> alumnos, String ruta) {
        String archivoPath = ruta + "/promedios.txt"; // Definir la ruta del archivo

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoPath))) {
            for (Alumno alumno : alumnos.values()) { // Iterar sobre los alumnos del mapa
                alumnosACargar.add(alumno); // Añadir los alumnos a la lista mientras se itera
                
                // Escribir la información del alumno
                StringBuilder materiasInfo = new StringBuilder();
                materiasInfo.append("Alumno: ").append(alumno.getRut()).append(" - ")
                            .append(alumno.getNombre()).append(" ").append(alumno.getApellido()).append(" [");

                // Agregar las materias del alumno
                for (Materia materia : alumno.getMaterias()) {
                    materiasInfo.append("materia [nombre=").append(materia.getNombre())
                                .append(", notas=").append(materia.getNotas()).append("], ");
                }

                // Eliminar la última coma y cerrar el corchete
                if (materiasInfo.length() > 0) {
                    materiasInfo.setLength(materiasInfo.length() - 2);
                }
                materiasInfo.append("]\n");

                // Escribir la información del alumno y sus materias
                writer.write(materiasInfo.toString());

                // Calcular y escribir el promedio de cada materia
                for (Materia materia : alumno.getMaterias()) {
                    double promedio = promediosServicioImp.calcularPromedio(materia.getNotas());
                    writer.write("Materia: " + materia.getNombre() + " - Promedio: " + promedio + "\n");
                }
            }
            System.out.println("Datos exportados correctamente en: " + archivoPath);
        } catch (IOException e) {
            System.out.println("Error al exportar datos: " + e.getMessage());
        }
    }
}
