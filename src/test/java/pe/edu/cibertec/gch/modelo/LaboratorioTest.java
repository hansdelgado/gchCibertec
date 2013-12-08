/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.cibertec.gch.modelo;

import java.util.Date;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Fernando
 */
public class LaboratorioTest {
    
    private Laboratorio laboratorio;
     @Before
    public void setUp() {
        laboratorio = new Laboratorio() {
            {
                setCodigo("1010");
                setNombre("Lab10");
                setDescripcion("Java Advanced");
                setLocal("LOCAL1");
               
            }
        };
    }

    @Test
    public void cuandoTieneDatosValidos() {
        boolean conDatosObligatorios = laboratorio.tieneDatosObligatorios();
        assertTrue(conDatosObligatorios);
    }
    
    @Test
    public void cuandoTieneCodigoNulo() {
        laboratorio.setCodigo(null);
        boolean conDatosObligatorios = laboratorio.tieneDatosObligatorios();
        assertFalse(conDatosObligatorios);
    }
}
