/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.web.servlets.programa;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.logica.GestorPrograma;
import pe.edu.cibertec.gch.modelo.Programa;
import pe.edu.cibertec.gch.web.servlets.GchServletUtils;

/**
 *
 * @author JAVA-ADV-LM
 */
@WebServlet(name = "ListadoProgramasServlet", urlPatterns = {"/listarProgramas"})
public class ListadoProgramaServlet extends HttpServlet {
    
    
    private GestorPrograma gestorPrograma = new GestorPrograma();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // trae los profesores en la fuente de datos
        List<Programa> programas = gestorPrograma.listarTodos();
        // almacena resultado en el request
        req.setAttribute("programas", programas);
        // pinta los datos en el listado
        GchServletUtils.reenviarAModulo("programa", req, resp);
    }
}
