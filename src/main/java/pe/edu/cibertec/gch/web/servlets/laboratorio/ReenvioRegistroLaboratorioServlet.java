package pe.edu.cibertec.gch.web.servlets.laboratorio;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet para reenviar al registro de profesor
 */
@WebServlet(name = "ReenvioRegistroLaboratorio", urlPatterns = {"/irRegistroLaboratorio"})
public class ReenvioRegistroLaboratorioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/laboratorio/registro.jsp");
        requestDispatcher.forward(req, resp);
        // nuevo comentario
    }
}
