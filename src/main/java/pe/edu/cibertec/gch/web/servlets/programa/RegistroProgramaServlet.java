/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.web.servlets.programa;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.dao.ProgramaDao;
import pe.edu.cibertec.gch.modelo.Programa;

/**
 *
 * @author JAVA-ADV-LM
 */
@WebServlet(name = "RegistroProgramaServlet", urlPatterns = {"/registrarPrograma"})
public class RegistroProgramaServlet extends HttpServlet {

    //private GestorPrograma gestorPrograma = new GestorPrograma();
    private ProgramaDao programaDao = FactoryDao.getInstance().getProgramaDao();

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
        Programa nuevoPrograma = new Programa();
        nuevoPrograma.setCodigo(req.getParameter("codigo"));
        nuevoPrograma.setTitulo(req.getParameter("titulo").toUpperCase());
        nuevoPrograma.setDescripcion(req.getParameter("descripcion"));
        nuevoPrograma.setObjetivos(req.getParameter("objetivos"));
        nuevoPrograma.setRequisitos(req.getParameter("requisitos"));
        nuevoPrograma.setPrecio(Double.parseDouble(req.getParameter("precio")));

        /*
         gestorPrograma.registrar(nuevoPrograma);
         */

        //Registro los campos de programa
        programaDao.registrar(nuevoPrograma);
        //Muestro un mensaje de confirmacion del registro de programas
        req.setAttribute("mensaje", "Su nuevo programa '" + nuevoPrograma.getTitulo() + "' fué agregado con éxito");
        //instancio a mi objeto listadoprogservlet para enviar los resultados
        ListadoProgramaServlet listadoProgramaServlet = new ListadoProgramaServlet();
        listadoProgramaServlet.doGet(req, resp);

        /*
         resp.sendRedirect("listarProgramas");
         */
    }
}