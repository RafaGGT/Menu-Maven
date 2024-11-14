package com.college.menu.modelos;
import java.util.*;

public class Alumno{
	private String rut, nombre, apellido, direccion;
	private Set<Materia> materias;
	private Scanner leer = new Scanner(System.in);
	
	// Constructor
	public Alumno() {
	    setRut();
	    setNombre();
	    setApellido();
	    setDireccion();
	    materias = new HashSet<>(); // Inicializa la lista de materias
	}
	// Constructor para test
	public Alumno(String rut, String nombre, String apellido, String direccion) {
		this.rut = rut;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		materias = new HashSet<>(); 
	}

	public String getRut() {
		return rut;
	}
	public void setRut() {
	    System.out.print("Ingrese Rut: ");
	    rut = leer.nextLine();
	    while (rut.isEmpty() ) {  
	        System.out.print("El RUT vacio o no es valido. Ingrese nuevamente: ");
	        rut = leer.nextLine();
	    }
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre() {
		System.out.println("Ingrese Nombre: ");
		nombre = leer.nextLine();
		while (nombre.isEmpty()) {
	        System.out.print("El Nombre no puede estar vacío. Ingrese nuevamente: ");
	        nombre = leer.nextLine();
	    }
	}
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido() {
		System.out.println("Ingrese Apellido: ");
		apellido = leer.nextLine();
		while (apellido.isEmpty()) {
	        System.out.print("El Apellido no puede estar vacío. Ingrese nuevamente: ");
	        apellido = leer.nextLine();
	    }
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion() {
		System.out.println("Ingrese Direccion: ");
		direccion = leer.nextLine();
		while (direccion.isEmpty()) {
	        System.out.print("La direccion no puede estar vacíao. Ingrese nuevamente: ");
	        direccion = leer.nextLine();
	    }
	}
	
	public Set<Materia> getMaterias() {
		return materias;
	}
	
	public void setMaterias(Set<Materia> materias) {
	    this.materias = materias;
	} 
}