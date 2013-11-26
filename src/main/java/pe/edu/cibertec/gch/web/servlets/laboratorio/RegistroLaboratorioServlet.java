package pe.edu.cibertec.gch.web.servlets.laboratorio;

import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.logica.GestorLaboratorio;
import pe.edu.cibertec.gch.modelo.EstadoLaboratorio;
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
                nombres = req.getParameter("nombres"),
                apellidoPaterno = req.getParameter("apellidoPaterno"),
                apellidoMaterno = req.getParameter("apellidoMaterno"),
                direccion = req.getParameter("direccion"),
                referencia = req.getParameter("referencia"),
                fechaNacimiento = req.getParameter("fechaNacimiento"),
                sexo = req.getParameter("sexo"),
                estado = req.getParameter("estadoCivil"),
                email1 = req.getParameter("email1");
        int dia = Integer.parseInt(fechaNacimiento.substring(8)),
                mes = Integer.parseInt(fechaNacimiento.substring(5, 7)),
                ano = Integer.parseInt(fechaNacimiento.substring(0, 4));
        final Calendar cal = Calendar.getInstance();
        cal.setLenient(false);
        cal.clear();
        cal.set(ano, mes - 1, dia);
        Laboratorio nuevoLaboratorio = new Laboratorio()
                ;

        ///gestorProfesor.registrar(nuevoProfesor);
        resp.sendRedirect("listarProfesores");
    }
}
