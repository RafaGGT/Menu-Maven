package com.college.menu.vistas;

import java.util.*;
import com.college.menu.modelos.*;
import com.college.menu.servicios.*;

public class Menu extends MenuTemplate {

    AlumnoServicio alumnoServicio = new AlumnoServicio();
    ArchivoServicio archivoServicio = new ArchivoServicio();
    ArrayList<Alumno> alumno = new ArrayList<Alumno>();

    @Override
    public void crearAlumno() {
    	 System.out.println("--- Crear Alumno ---");
         //Llama una nueva instancia de la clase alumnos junto al constructor
         Alumno newAlumno = new Alumno();
         // Llama al metodo crearAlumno del servicio de alumnoServicio y pasa el nuevo objeto Alumno agregandolo al mapa
         alumnoServicio.crearAlumno(newAlumno); 
    }
    
    @Override
    public void listarAlumnos() {
    	// llama al método listarAlumnos() del objeto alumnoServicio, que devuelve un Map
        Map<String, Alumno> alumnos = alumnoServicio.listarAlumnos();
        
        // Verifica si hay alumnos
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        
        // Itera sobre cada alumno en el mapa
        System.out.println("--- Listar Alumnos ---");
        for (Alumno alu : alumnos.values()) {
            System.out.println("RUT: " + alu.getRut());
            System.out.println("Nombre: " + alu.getNombre());
            System.out.println("Apellido: " + alu.getApellido());
            System.out.println("Dirección: " + alu.getDireccion());
            
            // Mostrar materias y notas
            System.out.println("Materias:");
            for (Materia materia : alu.getMaterias()) {
                System.out.println(materia.getNombre()); // Nombre de la materia
                    System.out.println("Notas: " + materia.getNotas()); // Notas asociadas
            }
            System.out.println("--------------------------");
        }
    }

    //Permite agregar materias a un alumno ya registrado.
    @Override
    public void agregarMateria() {
    	if (alumnoServicio.listarAlumnos().isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
    	System.out.println("--- Agregar Materia ---");
        System.out.print("Ingresa el RUT del Alumno: ");
        String rutAlumno = leer.nextLine();  
        Alumno alumnoDetec = alumnoServicio.listarAlumnos().get(rutAlumno);
        if (alumnoDetec == null) {
            System.out.println("¡Alumno no encontrado!");
            return; // Salimos del método si el alumno no fue encontrado
        }

        // Mostrar materias disponibles
        for (int mat = 0; mat < MateriaEnum.values().length; mat++) {
            System.out.println((mat + 1) + ". " + MateriaEnum.values()[mat]);
        }
        System.out.println("Seleccione una materia:");
        // Capturar la selección de la materia
        int opMat = leer.nextInt();
        leer.nextLine(); // Limpiar el buffer del escáner
        
        // Crear una nueva instancia de Materia con la materia seleccionada
        Materia currentMate = new Materia(MateriaEnum.values()[opMat - 1]);
        
        // Llamar al método agregarMateria en AlumnoServicio
        alumnoServicio.agregarMateria(rutAlumno, currentMate);
        
        System.out.println("--- ¡Materia agregada! ---");
    }

    @Override
    public void agregarNotaPasoUno() {
        if (alumnoServicio.listarAlumnos().isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        System.out.println("--- Agregar Nota ---");
        System.out.print("Ingresa rut del Alumno: ");
        String rutAlumno = leer.nextLine();

        // Usar el servicio para obtener el alumno por RUT
        Alumno alumnoNota = alumnoServicio.listarAlumnos().get(rutAlumno);
        
        if (alumnoNota == null) {
            System.out.println("¡Alumno no encontrado!");
            return; // Salimos del método si el alumno no fue encontrado
        }
       
        // Obtiene la lista de materias asociadas a ese alumno
        List<Materia> materias = new ArrayList<>(alumnoNota.getMaterias()); // Convertir Set a List

        // Verificar si el alumno tiene materias  
        if (materias.isEmpty()) {
            System.out.println("El alumno no tiene materias asignadas.");
            return; 
        }

        // Mostrar las materias del alumno
        System.out.println("Alumno tiene las siguientes materias agregadas: ");
        for (int i = 0; i < materias.size(); i++) {
            System.out.println((i + 1) + ". " + materias.get(i).getNombre());
        }

        // Seleccionar materia
        System.out.print("Seleccionar materia: ");
        int opMat2 = Integer.parseInt(leer.nextLine()) - 1;

        // Verificar que la selección sea válida
        if (opMat2 < 0 || opMat2 >= materias.size()) {
            System.out.println("Selección de materia inválida.");
            return; // Salir del método si la selección es inválida
        }

        // Ingresar nota
        System.out.print("Ingresar nota (ejemplo: 7.0): "); 
        double nota = Double.parseDouble(leer.nextLine());
        
        // Agregar la nota a la materia seleccionada
        materias.get(opMat2).getNotas().add(nota);
        System.out.println("--- ¡Nota agregada a " + materias.get(opMat2).getNombre() + "! ---");
    }
    
    @Override
    public void terminarPrograma() {
        System.out.println("--- Terminando Programa ---");
        System.exit(0); // Termina la ejecución del programa
    }
    
    @Override
    public void exportarDatos() {
        System.out.print("Ingrese la ruta donde se guardará el archivo: ");
        String ruta = leer.nextLine();
        
        // Llama al método listarAlumnos de la clase AlumnoServicio que devuelve un mapa
        Map<String, Alumno> alumnosMap = alumnoServicio.listarAlumnos(); // Obtiene el mapa de alumnos

        // Llama directamente al método exportarDatos de archivoServicio pasando el mapa de alumnos y la ruta
        archivoServicio.exportarDatos(alumnosMap, ruta); // Exporta los datos a la ruta especificada
    }

}