package pe.edu.cibertec.gch.web.servlets.laboratorio;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.logica.GestorLaboratorioImpl;
import pe.edu.cibertec.gch.modelo.EstadoLaboratorio;

import pe.edu.cibertec.gch.modelo.Laboratorio;

/**
 * Servlet para registrar un profesor.
 */
@WebServlet(name = "ActualizaLaboratorioServlet", urlPatterns = {"/actualizarLaboratorio"})
public class ActualizaLaboratorioServlet extends HttpServlet {

    private GestorLaboratorioImpl    gestorLaboratorio = new GestorLaboratorioImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String codigo = req.getParameter("codigo"),
                nombre = req.getParameter("nombre"),
                descripcion = req.getParameter("descripcion"),
                local = req.getParameter("local"),
                pabellon = req.getParameter("pabellon"),
                salon = req.getParameter("salon"),
                capacidad = req.getParameter("capacidad"),
                estado = req.getParameter("estado"),
                operacion =req.getParameter("operacion");
        
        if (operacion.equalsIgnoreCase("Actualizar")) {
//            gestorLaboratorio.actualizar(codigo, nombre, descripcion, local,pabellon,salon,Integer.parseInt(capacidad),EstadoLaboratorio.obtenerSegun(estado));
            resp.sendRedirect("listarLaboratorios");   
        } else {
//            gestorLaboratorio.eliminarPorCodigo(codigo);
            resp.sendRedirect("listarLaboratorios");   
            
        }  
    }
}
