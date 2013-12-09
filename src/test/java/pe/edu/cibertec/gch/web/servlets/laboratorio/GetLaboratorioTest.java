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
public class GetLaboratorioTest {
    
    private GetLaboratorio getLaboratorio;
    private HttpServletRequest req;
    private HttpServletResponse resp;
    
    public GetLaboratorioTest() {
    }
    
    @Before
    public void setUp() {
        getLaboratorio = new GetLaboratorio();
        req = mock(HttpServletRequest.class);
        resp = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcherMock = mock(RequestDispatcher.class);
        when(req.getRequestDispatcher(anyString())).thenReturn(requestDispatcherMock);
    }    
    
    @Test
    public void GetLaboratorioValido() throws Exception {
        //ingreso de datos
       
        when(req.getParameter("codigo")).thenReturn("1001");
  
        getLaboratorio.processRequest(req, resp);
        //verificacion
        verify(req).getRequestDispatcher("/view/laboratorio/actualiza.jsp");
    }
    @After
    public void tearDown() {
    }
}
