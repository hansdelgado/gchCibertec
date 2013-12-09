package pe.edu.cibertec.gch.web.servlets.horario;

import pe.edu.cibertec.gch.web.servlets.horario.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.logica.GestorHorario;
//import pe.edu.cibertec.gch.logica.GestorProfesor;
import pe.edu.cibertec.gch.modelo.Horario;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;
import pe.edu.cibertec.gch.web.servlets.GchServletUtils;

/**
 * Servlet para buscar profesores.
 */
@WebServlet(name = "BusquedaHorarioServlet", urlPatterns = {"/buscarHorarios"})
public class BusquedaHorarioServlet extends HttpServlet {

    private GestorHorario gestorHorario = new GestorHorario();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String textoCodigo = req.getParameter("codigo"),
                textoDescripcion = req.getParameter("descripcion"),
                textoEstado = req.getParameter("estado"),
                textoTipoBusqueda = req.getParameter("tipoBusqueda");
        // segun el tipo de codigo obtenemos el tipo de busqueda
        TipoBusqueda tipoBusqueda = TipoBusqueda.obtenerPorCodigo(Integer.parseInt(textoTipoBusqueda));
        // trae los profesores en la fuente de datos
        List<Horario> horarios = gestorHorario.listarSegun(textoCodigo,textoDescripcion,textoEstado, tipoBusqueda);
        // almacena resultado en el request
        req.setAttribute("horarios", horarios);
        // pinta los datos en el listado
        GchServletUtils.reenviarAModulo("horario", req, resp);
    }
}
