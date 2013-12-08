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
import org.junit.Test;
import static org.mockito.Mockito.*;


/**
 *
 * @author Fernando
 */
public class RegistroLaboratorioServletTest {
    
    private RegistroLaboratorioServlet registroLaboratorioServlet;
    private HttpServletRequest req;
    private HttpServletResponse resp;
    
    public RegistroLaboratorioServletTest() {
    }
    
    @Before
    public void setUp() {
        registroLaboratorioServlet = new RegistroLaboratorioServlet();
        req = mock(HttpServletRequest.class);
        resp = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcherMock = mock(RequestDispatcher.class);
        when(req.getRequestDispatcher(anyString())).thenReturn(requestDispatcherMock);
    }    
    
    @Test
    public void registroDeLaboratorioValido() throws Exception {
        //ingreso de datos
        when(req.getParameter("codigo")).thenReturn("1005");
        when(req.getParameter("nombre")).thenReturn("Lab3");
        when(req.getParameter("descripcion")).thenReturn("Java");
        when(req.getParameter("local")).thenReturn("LOCAL1");
        registroLaboratorioServlet.doPost(req, resp);
        //verificacion
        verify(resp).sendRedirect("listarLaboratorios");
    }
    
    @Test
    public void registroDeLaboratorioInvalidoPorCodigo() throws Exception {
        when(req.getParameter("codigo")).thenReturn(null);
        when(req.getParameter("nombre")).thenReturn("Lab9");
        when(req.getParameter("descripcion")).thenReturn("Java");
        when(req.getParameter("local")).thenReturn("LOCAL1");
        registroLaboratorioServlet.doPost(req, resp);
        verify(req).setAttribute("mensaje", "Hay errores en los datos enviados");
      
        
    }
     
    @After
    public void tearDown() {
    }
}
