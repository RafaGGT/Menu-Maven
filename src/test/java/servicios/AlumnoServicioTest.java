package servicios;

import com.college.menu.modelos.Alumno;
import com.college.menu.modelos.Materia;
import com.college.menu.modelos.MateriaEnum;
import com.college.menu.servicios.AlumnoServicio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AlumnoServicioTest {

    private AlumnoServicio alumnoServicioImp;
    private Alumno mapu;
    private Materia matematicas;
    private Materia lenguaje;

    @BeforeEach
    public void setup() {
        // Inicializamos la instancia real
        alumnoServicioImp = new AlumnoServicio();

        // Creamos los objetos de prueba
        mapu = new Alumno("20.111.857-3", "Rafael", "G.", "Casita 1");
        matematicas = new Materia(MateriaEnum.MATEMATICAS);
        lenguaje = new Materia(MateriaEnum.LENGUAJE);
    }

    @Test
    public void crearAlumnoTest() {
        assertTrue(alumnoServicioImp.listarAlumnos().isEmpty());

        alumnoServicioImp.crearAlumno(mapu);
        Map<String, Alumno> alumnos = alumnoServicioImp.listarAlumnos();
        assertEquals(1, alumnos.size()); // Tamaño
        assertEquals(mapu, alumnos.get("20.111.857-3")); // Rut
    }

    @Test
    public void agregarMateriaTest() {
    // llama para agregar el objeto mapu al sistema y despues la materia en base al rut
        alumnoServicioImp.crearAlumno(mapu);
        alumnoServicioImp.agregarMateria(mapu.getRut(), matematicas);
        
     // Recuperar la lista de materias
        List<Materia> materias = alumnoServicioImp.materiasPorAlumnos(mapu.getRut());
     // Verificadores:
        assertEquals(1, materias.size()); // Tamaño
        assertEquals(matematicas, materias.get(0)); // Primera posicion 
    }

    @Test
    public void materiasPorAlumnosTest() {
    	// Crea una simulacion del objeto 
        AlumnoServicio alumnoServicioMock = Mockito.mock(AlumnoServicio.class);
        // define el comportamiento esperado de un método del mock, osea que devuelva una lista de las materia en este caso
        when(alumnoServicioMock.materiasPorAlumnos("20.111.857-3")).thenReturn(List.of(matematicas, lenguaje));

        List<Materia> materias = alumnoServicioMock.materiasPorAlumnos("20.111.857-3");
        // Verificadores:
        assertEquals(2, materias.size()); // Tamaño 2
        assertEquals(matematicas, materias.get(0)); // Que sea el primero
        assertEquals(lenguaje, materias.get(1)); // Que sea el segundo
        verify(alumnoServicioMock).materiasPorAlumnos("20.111.857-3");
    }

    @Test
    public void listarAlumnosTest() {
    	//Verifica que el mapa este vacio
        assertTrue(alumnoServicioImp.listarAlumnos().isEmpty());

        Alumno alumno2 = new Alumno("30.222.968-4", "Gustavo", "T.", "Casita 2");
        // Se agregan 2 alumnos a crearAlumno
        alumnoServicioImp.crearAlumno(mapu);
        alumnoServicioImp.crearAlumno(alumno2);

        Map<String, Alumno> alumnos = alumnoServicioImp.listarAlumnos();
        assertEquals(2, alumnos.size()); //Verifica tamaño
        // Verificador de ruts
        assertEquals(mapu, alumnos.get("20.111.857-3"));
        assertEquals(alumno2, alumnos.get("30.222.968-4"));
    }
}
