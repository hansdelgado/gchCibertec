package pe.edu.cibertec.gch.web.servlets.laboratorio;

import java.io.IOException;
import javax.servlet.RequestDispatcher;

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
       
        if (sonDatosValidos(codigo, nombre, descripcion, local, pabellon, salon, capacidad, estado)) {
            Laboratorio nuevoLaboratorio = new Laboratorio().conCodigo(codigo)
                 .conNombre(nombre)
                 .conDescripcion(descripcion)
                 .conLocal(local)
                 .conPabellon(pabellon)
                 .conSalon(salon)
                 .conCapacidad(Integer.parseInt(capacidad))
                 .conEstado(EstadoLaboratorio.obtenerSegun(estado));
                 
        gestorLaboratorio.registrar(nuevoLaboratorio);
        resp.sendRedirect("listarLaboratorios");
        } else {
            // si hay algunos campos invalidos, se retorna
            req.setAttribute("mensaje", "Hay errores en los datos enviados");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/laboratorio/registro.jsp");
            requestDispatcher.forward(req, resp);
        }
               
    }
    
     private boolean sonDatosValidos(String codigo, String nombre, String descripcion, String local, String pabellon, String salon, String capacidad, String estado) {
        boolean esValido = true;
        // TODO solo se valida que no sean vacios, sin embargo la logica de 
        // validacion deberia incluir otros aspectos
        if (codigo == null || codigo.isEmpty()) {
            esValido = false;
        } else if (nombre == null || nombre.isEmpty()) {
            esValido = false;
        } else if (descripcion == null || descripcion.isEmpty()) {
            esValido = false;
        } else if (local == null || local.isEmpty()) {
            esValido = false;
        } else if (pabellon == null || pabellon.isEmpty()) {
            esValido = false;
        } else if (salon == null || salon.isEmpty()) {
            esValido = false;
        }else if (capacidad == null || capacidad.isEmpty()) {
            esValido = false;
        }else if (estado == null || estado.isEmpty()) {
            esValido = false;
        }
        
        return esValido;
    }

}

