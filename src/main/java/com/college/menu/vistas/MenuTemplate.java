package com.college.menu.vistas;

import java.util.Scanner;

public abstract class MenuTemplate {
    // Iniciación del scanner y declaración de variables 
    Scanner leer = new Scanner(System.in);
    String op;
    
    // Métodos que serán abstractos 
    public abstract void exportarDatos();
    public abstract void crearAlumno();
    public abstract void agregarMateria();
    public abstract void agregarNotaPasoUno();
    public abstract void listarAlumnos();
    public abstract void terminarPrograma();

    // Método iniciarMenu final
    public final void iniciarMenu() {
        do {
            System.out.println("---- Menú Principal ----");
            System.out.println("1. Crear Alumno");
            System.out.println("2. Listar Alumnos");
            System.out.println("3. Agregar Materia");
            System.out.println("4. Agregar Nota");
            System.out.println("5. Terminar Programa");
            System.out.println("6. Exportar Datos");
            System.out.println("Seleccione una opción: ");
            op = leer.nextLine();

            switch (op) {
                case "1": 
                    crearAlumno(); 
                    break;
                case "2": 
                    listarAlumnos(); 
                    break;
                case "3": 
                    agregarMateria(); 
                    break;
                case "4": 
                    agregarNotaPasoUno(); 
                    break;
                case "5": 
                    terminarPrograma(); 
                    break;
                case "6": 
                    exportarDatos(); 
                    break;
                default: 
                    System.out.println("Opción inválida, por favor ingresa un número del 1 al 6."); 
                    break;
            }
        } while (op != "5");  
        leer.close();
    }
}
