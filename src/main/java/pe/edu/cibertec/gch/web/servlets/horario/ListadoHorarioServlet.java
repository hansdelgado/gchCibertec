/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.web.servlets.horario;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.logica.GestorHorario;
import pe.edu.cibertec.gch.modelo.Horario;
import pe.edu.cibertec.gch.web.servlets.GchServletUtils;

/**
 *
 * @author LIBIO
 */
@WebServlet(name = "ListadoHorarioServlet", urlPatterns = {"/listarHorarios"})
public class ListadoHorarioServlet extends HttpServlet {

    private GestorHorario gestorHorario = new GestorHorario();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // trae los horarioes en la fuente de datos
        List<Horario> horarios = gestorHorario.listarTodos();
        // almacena resultado en el request
        req.setAttribute("horarios", horarios);
        // pinta los datos en el listado
        System.out.println("listado horario servlet -> reenviarmodulo");
        GchServletUtils.reenviarAModulo("horario", req, resp);
    }
}
