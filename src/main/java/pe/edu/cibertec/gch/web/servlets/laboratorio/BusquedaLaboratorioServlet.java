package pe.edu.cibertec.gch.web.servlets.laboratorio;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.logica.GestorLaboratorio;
import pe.edu.cibertec.gch.modelo.Laboratorio;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;
import pe.edu.cibertec.gch.web.servlets.GchServletUtils;


/**
 * Servlet para buscar profesores.
 */
@WebServlet(name = "BusquedaLaboratorioServlet", urlPatterns = {"/buscarLaboratorios"})
public class BusquedaLaboratorioServlet extends HttpServlet {

    
    
    
    private GestorLaboratorio gestorLaboratorio = new GestorLaboratorio();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String textoNombre = req.getParameter("nombre"),
                textoLocal = req.getParameter("local"),
                textoTipoBusqueda = req.getParameter("tipoBusqueda");
        // segun el tipo de codigo obtenemos el tipo de busqueda
        TipoBusqueda tipoBusqueda = TipoBusqueda.obtenerPorCodigo(Integer.parseInt(textoTipoBusqueda));
        // trae los profesores en la fuente de datos
        List<Laboratorio> laboratorios = gestorLaboratorio.listarSegun(textoNombre,
                textoLocal,tipoBusqueda);
        // almacena resultado en el request
        req.setAttribute("laboratorios", laboratorios);
        // pinta los datos en el listado
        GchServletUtils.reenviarAModulo("laboratorio", req, resp);
    }
}
