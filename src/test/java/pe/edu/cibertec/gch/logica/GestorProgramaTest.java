package pe.edu.cibertec.gch.logica;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import pe.edu.cibertec.gch.modelo.Programa;

public class GestorProgramaTest {

    GestorPrograma gestorPrograma;

    public GestorProgramaTest() {
    }

    @Before
    public void setUp() {

        gestorPrograma = new GestorPrograma();
    }

    @After
    public void tearDown() {
        //se ejecuta cada vez que termina una prueba unitaria
    }

    @Test
    public void consultarProgramaPorCodigo() {
        // carga de datos
        Programa p1 = new Programa("01");
        gestorPrograma.registrar(p1);
        // ejecucion y verificacion
        assertEquals(p1, gestorPrograma.consultarPorCodigo("01"));
    }

//    @Test
//    public void registrarPrograma() {
//        // carga de datos
//
//        Programa p1 = new Programa("01");
//        // ejecutar
//        gestorPrograma.registrar(p1);
//        // verificar
//        assertEquals(1, gestorPrograma.listarTodos().size());
//    }
//    @Test
//    public void eliminarProgramaPorCodigo() {
//        //gestorPrograma.borrarTodos();
//        Programa p1 = new Programa("01");
//        p1.setEstado(EstadoActividad.Valido);
//        gestorPrograma.registrar(p1);
//
//        gestorPrograma.eliminarPorCodigo("01");
//
//        assertEquals(EstadoActividad.Obsoleto, gestorPrograma.listarTodos().get(0).getEstado());
//    }
}
