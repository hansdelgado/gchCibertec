package pe.edu.cibertec.gch.web.servlets.curso;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet para reenviar el eliminar curso
 */
@WebServlet(name = "ReenvioEliminaCurso", urlPatterns = {"/irEliminarCurso"})
public class ReenvioEliminaCursoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("view/curso/eliminar.jsp").forward(req, resp);
    }
}
