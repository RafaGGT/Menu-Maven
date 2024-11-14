package com.college.menu.modelos;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private MateriaEnum nombre; // Almacena el nombre de la materia
    private List<Double> notas; // Contiene las notas asociadas a la materia

    // Constructor
    public Materia(MateriaEnum nombre) {
        this.nombre = nombre;
        this.notas = new ArrayList<>(); // Inicializa la lista de notas
    }

    // Getters y Setters
    public MateriaEnum getNombre() {
        return nombre;
    }

    public void setNombre(MateriaEnum nombre) {
        this.nombre = nombre;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }
}

