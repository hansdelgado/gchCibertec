/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.web.servlets.horario;

import java.io.IOException;
import java.io.PrintWriter;
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
 * @author EINER
 */
@WebServlet(name = "EditarHorario", urlPatterns = {"/editarHorarios"})
public class EditarHorario extends HttpServlet {
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // trae los horarioes en la fuente de datos
        //List<Horario> horarios = gestorHorario.listarTodos();
        // almacena resultado en el request
        //recuperando el codigo
        System.out.println(req.getAttribute("codigo"));
    
        String codigo="3546";//req.getAttribute("codigo").toString();
        Horario horario=gestorHorario.Recuperar(codigo);
        System.out.println(horario.getCodigo());
        System.out.println(horario.getDescripcion());
        req.setAttribute("horarios", horario);
        // pinta los datos en el listado
        req.getRequestDispatcher("view/horario/modifica.jsp").forward(req, resp);
        //resp.sendRedirect("view/horario/modifica.jsp");
        //GchServletUtils.reenviarAModificar("horario", req, resp);
    }
   
}
