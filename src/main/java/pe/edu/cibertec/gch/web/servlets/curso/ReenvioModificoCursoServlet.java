package pe.edu.cibertec.gch.web.servlets.curso;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.logica.GestorCurso;
import pe.edu.cibertec.gch.modelo.Curso;
import pe.edu.cibertec.gch.web.servlets.GchServletUtils;

/**
 * Servlet para reenviar al registro de profesor
 */
@WebServlet(name = "ReenvioModificoCurso", urlPatterns = {"/irModificaCurso"})
public class ReenvioModificoCursoServlet extends HttpServlet {
    private GestorCurso gestorCurso = new GestorCurso();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                
        final String codigo = req.getParameter("codigo");
        Curso curso = gestorCurso.consultarPorCodigo(codigo);
        req.setAttribute("nombre", curso.getNombre());
        req.getRequestDispatcher("view/curso/modifica.jsp").forward(req, resp);
    }
}
