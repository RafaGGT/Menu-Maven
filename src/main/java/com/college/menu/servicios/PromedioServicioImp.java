package com.college.menu.servicios;

import java.util.List;

public class PromedioServicioImp {
    public double calcularPromedio(List<Double> notas) {
        if (notas.isEmpty()) return 0.0;
        
        double suma = 0.0;
        for (double nota : notas) {
            suma += nota;
        }
        
        // Calcular el promedio
        double promedioSinRedondear = suma / notas.size();
        
        // Redondear a 1 decimal
        double promedioRedondeado = Math.round(promedioSinRedondear * 10.0) / 10.0;
        
        return promedioRedondeado;
    }
}
