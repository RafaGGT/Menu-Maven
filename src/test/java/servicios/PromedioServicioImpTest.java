package servicios;

import com.college.menu.servicios.PromedioServicioImp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

public class PromedioServicioImpTest {

    @Test
    public void Test() {
    	// Se crea una instancia de la clase PromedioServicioImp
        PromedioServicioImp servicio = new PromedioServicioImp();
        // Aquí se llama al método calcularPromedio de la clase PromedioServicioImp
        double promedio = servicio.calcularPromedio(Arrays.asList(5.5, 6.5, 7.5));
        assertEquals(6.5, promedio, 0.01);  // Verifica que el promedio sea 6.5
    }

    @Test
    public void TestOne() {
        PromedioServicioImp servicio = new PromedioServicioImp();
        double promedio = servicio.calcularPromedio(Arrays.asList(7.0));
        assertEquals(7.0, promedio, 0.01);  // Verifica el promedio con una sola nota
    }

    @Test
    public void TestFail() {
        PromedioServicioImp servicio = new PromedioServicioImp();
        double promedio = servicio.calcularPromedio(Arrays.asList(1.0, 3.0, 7.0));
        assertEquals(7.0, promedio, 0.01);  // Esta prueba está destinada a fallar
    }
}

