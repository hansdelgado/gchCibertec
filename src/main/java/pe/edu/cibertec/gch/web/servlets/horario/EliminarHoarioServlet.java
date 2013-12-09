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
import pe.edu.cibertec.gch.web.servlets.GchServletUtils;

/**
 *
 * @author EINER
 */
@WebServlet(name = "EliminarHorarioServlet", urlPatterns = {"/eliminarHorario"})
public class EliminarHoarioServlet extends HttpServlet {
private GestorHorario gestorHorario = new GestorHorario();

@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String codigo = req.getParameter("codigo");
        gestorHorario.eliminar(gestorHorario.Recuperar(codigo));
        GchServletUtils.reenviarAModulo("horario", req, resp);
    }
}
