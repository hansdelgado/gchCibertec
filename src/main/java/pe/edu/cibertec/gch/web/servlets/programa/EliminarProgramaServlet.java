package pe.edu.cibertec.gch.web.servlets.programa;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.logica.GestorPrograma;
import pe.edu.cibertec.gch.web.servlets.GchServletUtils;

/**
 *
 * @author MICHAEL
 */
@WebServlet(name = "EliminarProgramaServlet", urlPatterns = {"/irEliminarPrograma"})
public class EliminarProgramaServlet extends HttpServlet {

    //private ProgramaDao programaDao = FactoryDao.getInstance().getProgramaDao();
    private GestorPrograma gestorPrograma = new GestorPrograma();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {

        String codigo = req.getParameter("codigo");
        gestorPrograma.eliminarPorCodigo(codigo);
        
        req.setAttribute("mensaje", "Su programa fué eliminado con éxito");
        //ListadoProgramaServlet listadoProgramaServlet = new ListadoProgramaServlet();
        //listadoProgramaServlet.doGet(req, response);
        req.setAttribute("programas", gestorPrograma.listarTodos());
        GchServletUtils.reenviarAModulo("programa", req, response);
    }
}
