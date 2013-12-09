/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.web.servlets.horario;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.logica.GestorHorario;
import pe.edu.cibertec.gch.modelo.EstadoActividad;
import pe.edu.cibertec.gch.modelo.Horario;

/**
 *
 * @author EINER
 */
@WebServlet(name = "EditarHorarioServlet", urlPatterns = {"/editarHorario"})
public class EditarHorarioServlet extends HttpServlet {
private GestorHorario gestorHorario = new GestorHorario();
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String codigo = "3546";//req.getParameter("codigo");
        

        Horario horario = gestorHorario.Recuperar(codigo);
        req.setAttribute("horario", horario);
        req.getRequestDispatcher("modifica.jsp").forward(req, resp);
        
        //resp.sendRedirect("irEditarHorario");
    }
}
