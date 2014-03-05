/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.web.servlets.laboratorio;


import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.mockito.Mockito.*;


/**
 *
 * @author Fernando
 */
public class ActualizaLaboratorioServletTest {
    
    private ActualizaLaboratorioServlet actualizaLaboratorioServlet;
    private HttpServletRequest req;
    private HttpServletResponse resp;
    
    public ActualizaLaboratorioServletTest() {
    }
    
    @Before
    public void setUp() {
        actualizaLaboratorioServlet = new ActualizaLaboratorioServlet();
        req = mock(HttpServletRequest.class);
        resp = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcherMock = mock(RequestDispatcher.class);
        when(req.getRequestDispatcher(anyString())).thenReturn(requestDispatcherMock);
    }    
    
    @Test @Ignore
    public void actualizacionDeLaboratorioValido() throws Exception {
        //ingreso de datos
       
        
        when(req.getParameter("codigo")).thenReturn("1005");
        when(req.getParameter("nombre")).thenReturn("Lab3");
        when(req.getParameter("descripcion")).thenReturn("Java");
        when(req.getParameter("local")).thenReturn("LOCAL1");
        when(req.getParameter("pabellon")).thenReturn("F");
        when(req.getParameter("salon")).thenReturn("c202");
        when(req.getParameter("capacidad")).thenReturn("2");
        when(req.getParameter("estado")).thenReturn("Implementado");
        when(req.getParameter("operacion")).thenReturn("Actualizar");
        
        if (req.getParameter("operacion").equalsIgnoreCase("Actualizar")) {
           actualizaLaboratorioServlet.doPost(req, resp);
           verify(resp).sendRedirect("listarLaboratorios");
           System.out.print("Actualizado Correctamente");
        } else {
           
           actualizaLaboratorioServlet.doPost(req, resp);
           verify(resp).sendRedirect("listarLaboratorios"); 
            
        }  
    }
    
   @Test @Ignore
   public void borrarLaboratorioValido() throws Exception {
       when(req.getParameter("codigo")).thenReturn("1001");
       when(req.getParameter("operacion")).thenReturn("");
       
       if (req.getParameter("operacion").equalsIgnoreCase("Actualizar")) {
           actualizaLaboratorioServlet.doPost(req, resp);
           verify(resp).sendRedirect("listarLaboratorios");
        } else {
           actualizaLaboratorioServlet.doPost(req, resp);
           verify(resp).sendRedirect("listarLaboratorios");
           System.out.print("Borrado Correctamente");
           
            
        }  
       
           
   }
     
    @After
    public void tearDown() {
    }
}
