package pe.edu.cibertec.gch.web.servlets.programa;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.logica.GestorPrograma;
import pe.edu.cibertec.gch.modelo.EstadoActividad;
import pe.edu.cibertec.gch.modelo.Moneda;
import pe.edu.cibertec.gch.modelo.Programa;

/**
 * Servlet para modificar un nuevo programa.
 */
@WebServlet(name = "ActualizaProgramaServlet", urlPatterns = {"/actualizarPrograma"})
public class ActualizaProgramaServlet extends HttpServlet {

    //private ProgramaDao programaDao = FactoryDao.getInstance().getProgramaDao();
    private GestorPrograma gestorPrograma = new GestorPrograma();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String moneda = req.getParameter("moneda");

        Programa update = new Programa();
        update.setCodigo(req.getParameter("codigo"));
        update.setTitulo(req.getParameter("titulo").toUpperCase());
        update.setDescripcion(req.getParameter("descripcion"));
        update.setObjetivos(req.getParameter("objetivos"));
        update.setRequisitos(req.getParameter("requisitos"));
        update.setMoneda(moneda.equals("NS") ? Moneda.NuevosSoles : Moneda.DolaresUS);
        update.setPrecio(Double.parseDouble(req.getParameter("precio")));
        update.setEstado(EstadoActividad.Valido);
        update.setFechaInicial(fechaToDate(req.getParameter("fecha")));
        update.setDuracion(Integer.parseInt(req.getParameter("duracion")));

        gestorPrograma.modificarPorCodigo(update);
        req.setAttribute("mensaje", "Su programa fué modificado con éxito");
        ListadoProgramaServlet listadoProgramaServlet = new ListadoProgramaServlet();
        listadoProgramaServlet.doGet(req, resp);
    }

    private Date fechaToDate(String fecha) {

        int dia = Integer.parseInt(fecha.substring(8)),
                mes = Integer.parseInt(fecha.substring(5, 7)),
                ano = Integer.parseInt(fecha.substring(0, 4));
        final Calendar cal = Calendar.getInstance();
        cal.setLenient(false);
        cal.clear();
        cal.set(ano, mes - 1, dia);

        return cal.getTime();
    }
}
