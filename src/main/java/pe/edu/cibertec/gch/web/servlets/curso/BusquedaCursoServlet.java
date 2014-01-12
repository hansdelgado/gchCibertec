package pe.edu.cibertec.gch.web.servlets.curso;

import pe.edu.cibertec.gch.web.servlets.curso.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import pe.edu.cibertec.gch.logica.GestorCurso;
import pe.edu.cibertec.gch.modelo.Curso;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;
import pe.edu.cibertec.gch.web.servlets.GchServletUtils;

/**
 * Servlet para buscar profesores.
 */
@WebServlet(name = "BusquedaCursoServlet", urlPatterns = {"/buscarCurso"})
public class BusquedaCursoServlet extends HttpServlet {

    //private GestorCurso gestorCurso = new GestorCurso();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String textoCodigo = req.getParameter("codigo"),
                textoNombre = req.getParameter("nombre"),
                textoTipoBusqueda = req.getParameter("tipoBusqueda");;
        // segun el tipo de codigo obtenemos el tipo de busqueda
        TipoBusqueda tipoBusqueda = TipoBusqueda.obtenerPorCodigo(Integer.parseInt(textoTipoBusqueda));
        // trae los profesores en la fuente de datos
        //List<Curso> cursos = gestorCurso.listarSegunCurso(textoCodigo,textoNombre, tipoBusqueda);
        // almacena resultado en el request
        //req.setAttribute("cursos", cursos);
        // pinta los datos en el listado
        GchServletUtils.reenviarAModulo("curso", req, resp);
    }
}
