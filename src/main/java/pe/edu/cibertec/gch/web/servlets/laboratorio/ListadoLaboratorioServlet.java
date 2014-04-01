package pe.edu.cibertec.gch.web.servlets.laboratorio;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.logica.GestorLaboratorioImpl;
import pe.edu.cibertec.gch.modelo.Laboratorio;
import pe.edu.cibertec.gch.web.servlets.GchServletUtils;

/**
 * Servlet para listar profesores.
 */
@WebServlet(name = "ListadoLaboratorioServlet", urlPatterns = {"/listarLaboratorios"})
public class ListadoLaboratorioServlet extends HttpServlet {

    private GestorLaboratorioImpl gestorLaboratorios = new GestorLaboratorioImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // trae los profesores en la fuente de datos
        List<Laboratorio> laboratorios = gestorLaboratorios.listarTodos();
        // almacena resultado en el request
        req.setAttribute("laboratorios", laboratorios);
        // pinta los datos en el listado
        GchServletUtils.reenviarAModulo("laboratorio", req, resp);
    }
}
