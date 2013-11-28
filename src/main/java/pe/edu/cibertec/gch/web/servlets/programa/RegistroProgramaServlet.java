/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.web.servlets.programa;

import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.logica.GestorProfesor;
import pe.edu.cibertec.gch.logica.GestorPrograma;
import pe.edu.cibertec.gch.modelo.EstadoProfesor;
import pe.edu.cibertec.gch.modelo.Genero;
import pe.edu.cibertec.gch.modelo.Programa;

/**
 *
 * @author JAVA-ADV-LM
 */
@WebServlet(name = "RegistroProgramaServlet", urlPatterns = {"/registrarPrograma"})
public class RegistroProgramaServlet extends HttpServlet {

    private GestorPrograma gestorPrograma = new GestorPrograma();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String codigo = req.getParameter("codigo"),
                titulo = req.getParameter("titulo"),
                descripcion = req.getParameter("descripcion"),
                objetivos = req.getParameter("objetivos"),
                requisitos = req.getParameter("requisitos"),
                precio = req.getParameter("precio");
                //duracion = req.getParameter("duracion");

        Programa nuevoPrograma = new Programa().conCodigo(codigo)
                .conTitulo(titulo)
                .conDescripcion(descripcion)
                .conObjetivos(objetivos)
                .conRequisitos(requisitos)
                .conPrecio(Double.parseDouble(precio));



        gestorPrograma.registrar(nuevoPrograma);
        resp.sendRedirect("listarProgramas");
    }
}
