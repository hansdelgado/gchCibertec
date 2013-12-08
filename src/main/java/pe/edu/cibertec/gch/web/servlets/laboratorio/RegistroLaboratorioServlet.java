package pe.edu.cibertec.gch.web.servlets.laboratorio;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.logica.GestorLaboratorio;
import pe.edu.cibertec.gch.modelo.EstadoLaboratorio;

import pe.edu.cibertec.gch.modelo.Laboratorio;

/**
 * Servlet para registrar un profesor.
 */
@WebServlet(name = "RegistroLaboratorioServlet", urlPatterns = {"/registrarLaboratorio"})
public class RegistroLaboratorioServlet extends HttpServlet {

    private GestorLaboratorio    gestorLaboratorio = new GestorLaboratorio();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String codigo = req.getParameter("codigo"),
                nombre = req.getParameter("nombre"),
                descripcion = req.getParameter("descripcion"),
                local = req.getParameter("local"),
                pabellon = req.getParameter("pabellon"),
                salon = req.getParameter("salon"),
                capacidad = req.getParameter("capacidad"),
                estado = req.getParameter("estado");
       
<<<<<<< HEAD
         Laboratorio nuevoLaboratorio = new Laboratorio();
         nuevoLaboratorio.setCodigo(codigo);
         nuevoLaboratorio.setNombre(nombre);
         nuevoLaboratorio.setDescripcion(descripcion);
         nuevoLaboratorio.setLocal(local);
         nuevoLaboratorio.setPabellon(pabellon);
         nuevoLaboratorio.setSalon(salon);
//         nuevoLaboratorio.setCapacidad(Integer.parseInt(capacidad));
//         nuevoLaboratorio.setEstado(estado);
=======
//         Laboratorio nuevoLaboratorio = new Laboratorio();
//         nuevoLaboratorio.setCodigo(codigo);
//         nuevoLaboratorio.setNombre(nombre);
//         nuevoLaboratorio.setDescripcion(descripcion);
//         nuevoLaboratorio.setLocal(local);
//         nuevoLaboratorio.setPabellon(pabellon);
//         nuevoLaboratorio.setSalon(salon);
//         nuevoLaboratorio.setCapacidad(Integer.parseInt(capacidad));
//         nuevoLaboratorio.setEstado(EstadoLaboratorio.obtenerSegun(estado));
                 
         Laboratorio nuevoLaboratorio = new Laboratorio().conCodigo(codigo)
                 .conNombre(nombre)
                 .conDescripcion(descripcion)
                 .conLocal(local)
                 .conPabellon(pabellon)
                 .conSalon(salon)
                 .conCapacidad(Integer.parseInt(capacidad))
                 .conEstado(EstadoLaboratorio.obtenerSegun(estado));
>>>>>>> f509052c851ec08c499561cb5c08955e2777fe74
                 
        gestorLaboratorio.registrar(nuevoLaboratorio);
        resp.sendRedirect("listarLaboratorios");
    }
}
