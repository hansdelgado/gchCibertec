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
 *
 * @author JAVA-ADV-LM
 */
@WebServlet(name = "RegistroProgramaServlet", urlPatterns = {"/registrarPrograma"})
public class RegistroProgramaServlet extends HttpServlet {

    private GestorPrograma gestorPrograma = new GestorPrograma();
    //private ProgramaDao programaDao = FactoryDao.getInstance().getProgramaDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*     
         final String codigo = req.getParameter("codigo"),
         titulo = req.getParameter("titulo"),
         descripcion = req.getParameter("descripcion"),
         objetivos = req.getParameter("objetivos"),
         requisitos = req.getParameter("requisitos"),
         precio = req.getParameter("precio"),
         moneda = req.getParameter("moneda");

         Programa nuevoPrograma = new Programa().conCodigo(codigo)
         .conTitulo(titulo)
         .conDescripcion(descripcion)
         .conObjetivos(objetivos)
         .conRequisitos(requisitos)
         .conPrecio(Double.parseDouble(precio));
         */
        final String moneda = req.getParameter("moneda");

        Programa nuevoPrograma = new Programa();

        nuevoPrograma.setCodigo(req.getParameter("codigo"));
        nuevoPrograma.setTitulo(req.getParameter("titulo").toUpperCase());
        nuevoPrograma.setDescripcion(req.getParameter("descripcion"));
        nuevoPrograma.setObjetivos(req.getParameter("objetivos"));
        nuevoPrograma.setRequisitos(req.getParameter("requisitos"));
        nuevoPrograma.setMoneda(moneda.equals("NS") ? Moneda.NuevosSoles : Moneda.DolaresUS);
        nuevoPrograma.setPrecio(Double.parseDouble(req.getParameter("precio")));
        nuevoPrograma.setEstado(EstadoActividad.Valido);
        nuevoPrograma.setFechaInicial(fechaToDate(req.getParameter("fecha")));
        nuevoPrograma.setDuracion(Integer.parseInt(req.getParameter("duracion")));

        /*
         gestorPrograma.registrar(nuevoPrograma);
         */

        //Registro los campos de programa
        gestorPrograma.registrar(nuevoPrograma);
        //Muestro un mensaje de confirmacion del registro de programas
        req.setAttribute("mensaje", "Su nuevo programa '" + nuevoPrograma.getTitulo() + "' fué agregado con éxito");
        //instancio a mi objeto listadoprogservlet para enviar los resultados
        ListadoProgramaServlet listadoProgramaServlet = new ListadoProgramaServlet();
        listadoProgramaServlet.doGet(req, resp);

        /*
         resp.sendRedirect("listarProgramas");
         */
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
