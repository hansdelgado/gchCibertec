/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.web.servlets.horario;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LIBIO
 */
@WebServlet(name = "ReenvioRegistroHorarioServlet", urlPatterns = {"/irRegistroHorario"})
public class ReenvioRegistroHorarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/horario/registro.jsp");
        requestDispatcher.forward(req, resp);
        System.out.println("reenvioservlet-> reenviando a registro.jsp"+req.toString());
        // nuevo comentario
    }
  
  
}
