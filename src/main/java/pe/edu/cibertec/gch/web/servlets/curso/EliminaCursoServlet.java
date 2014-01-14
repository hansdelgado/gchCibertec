/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.web.servlets.curso;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.exception.DatosInvalidosException;
import pe.edu.cibertec.gch.logica.GestorCurso;
//import pe.edu.cibertec.gch.modelo.EstadoProfesor;

/**
 *
 * @author JAVA-ADV-LM
 */
@WebServlet(name = "EliminaCursoServlet", urlPatterns = {"/eliminarCurso"})
public class EliminaCursoServlet extends HttpServlet {
    
    private GestorCurso gestorCurso = new GestorCurso();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            final String codigo = req.getParameter("codigo");
            //gestorCurso.eliminarPorCodigo(codigo);
            gestorCurso.eliminarPorCodigo(codigo);
            resp.sendRedirect("listarCursos");
        } catch (DatosInvalidosException ex) {
            Logger.getLogger(EliminaCursoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
