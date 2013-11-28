package pe.edu.cibertec.gch.web.servlets.laboratorio;

import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.logica.GestorLaboratorio;
import pe.edu.cibertec.gch.modelo.Genero;
import pe.edu.cibertec.gch.modelo.Laboratorio;

/**
 * Servlet para registrar un profesor.
 */
@WebServlet(name = "RegistroLaboratorioServlet", urlPatterns = {"/registrarLaboratorio"})
public class RegistroLaboratorioServlet extends HttpServlet {

    private GestorLaboratorio    gestorLaboratorio = new GestorLaboratorio();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String codigo = req.getParameter("codigo"),
                nombre = req.getParameter("nombre"),
                descripcion = req.getParameter("descripcion"),
                local = req.getParameter("local"),
                pabellon = req.getParameter("pabellon"),
                salon = req.getParameter("salon"),
                capacidad = req.getParameter("capacidad"),
                estado = req.getParameter("estado");
       
         Laboratorio nuevoLaboratorio = new Laboratorio();
         nuevoLaboratorio.setCodigo(codigo);
         nuevoLaboratorio.setNombre(nombre);
         nuevoLaboratorio.setDescripcion(descripcion);
         nuevoLaboratorio.setLocal(local);
         nuevoLaboratorio.setPabellon(pabellon);
         nuevoLaboratorio.setSalon(salon);
         nuevoLaboratorio.setCapacidad(Integer.parseInt(capacidad));
//         nuevoLaboratorio.setEstado(estado);
                 
        
        gestorLaboratorio.registrar(nuevoLaboratorio);
        resp.sendRedirect("listarLaboratorios");
    }
}
