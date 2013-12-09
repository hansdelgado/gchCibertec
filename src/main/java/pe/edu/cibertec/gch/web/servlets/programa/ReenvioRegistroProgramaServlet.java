package pe.edu.cibertec.gch.web.servlets.programa;

import pe.edu.cibertec.gch.web.servlets.profesor.*;
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
@WebServlet(name = "ReenvioRegistroPrograma", urlPatterns = {"/irRegistroPrograma"})
public class ReenvioRegistroProgramaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/programa/registro.jsp");
        requestDispatcher.forward(req, resp);

    }
}
