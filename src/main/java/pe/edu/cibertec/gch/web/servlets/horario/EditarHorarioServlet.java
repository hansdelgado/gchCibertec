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
import pe.edu.cibertec.gch.logica.GestorHorario;
import pe.edu.cibertec.gch.modelo.EstadoActividad;
import pe.edu.cibertec.gch.modelo.Horario;

/**
 *
 * @author LIBIO
 */
@WebServlet(name = "EditarHorarioServlet", urlPatterns = {"/editarHorario"})
public class EditarHorarioServlet extends HttpServlet {
private GestorHorario gestorHorario = new GestorHorario();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    
        final String codigo = req.getParameter("codigo"),
                descripcion = req.getParameter("descripcion"),
                estado = req.getParameter("estado");
                int momentoInicio = Integer.parseInt(req.getParameter("momentoInicio")),
                momentoFin= Integer.parseInt(req.getParameter("momentoFin"));
        System.out.println("ya recupere los datos del editar");
        
        
        Horario nuevoHorario=new Horario();
                    nuevoHorario.setCodigo(codigo);
                    nuevoHorario.setDescripcion(descripcion);
                    nuevoHorario.setMomentoInicio(momentoInicio);
                    nuevoHorario.setMomentoFin(momentoFin); 
                    
                        if(estado.equalsIgnoreCase("activo")){
                            nuevoHorario.setEstado(EstadoActividad.Activo);
                        }else{
                            nuevoHorario.setEstado(EstadoActividad.Inactivo);
                        }
                        System.out.println("actualizaremos");
                        gestorHorario.actualizar(nuevoHorario);
                        System.out.println("ya hemos actualizado el horario");
                        resp.sendRedirect("listarHorarios");
    }
  
  
}
