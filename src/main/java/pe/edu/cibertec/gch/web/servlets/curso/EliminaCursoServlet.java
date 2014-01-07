/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.web.servlets.curso;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.logica.GestorCurso;
import pe.edu.cibertec.gch.modelo.Curso;
import pe.edu.cibertec.gch.modelo.EstadoActividad;
//import pe.edu.cibertec.gch.modelo.EstadoProfesor;

/**
 *
 * @author JAVA-ADV-LM
 */

//@WebServlet(name = "EliminaCursoServlet", urlPatterns = {"/eliminarCurso"})
//public class EliminaCursoServlet extends HttpServlet {
//    
//    private GestorCurso gestorCurso = new GestorCurso();
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        final String codigo = req.getParameter("codigo"),
//                nombre = req.getParameter("nombre"),
//                descripcion = req.getParameter("descripcion"),
//                objetivos = req.getParameter("objetivos"),
//                requisitos = req.getParameter("requisitos"),
//                duracion = req.getParameter("duracion"),
//                estado = req.getParameter("estado");
//        Curso nuevoCurso = new Curso()
//                .conCodigo(codigo)
//                .conNombre(nombre)
//                .conDescripcion(descripcion)
//                .conObjetivos(objetivos)
//                .conRequisitos(requisitos)
//                .conDuracion(duracion)
//                .conEstado(EstadoActividad.Valido);
//        //final String codigo = req.getParameter("codigo");
//        //gestorCurso.registrar(nuevoCurso);
//        
//        gestorCurso.eliminarPorCodigo(codigo);
//        resp.sendRedirect("listarCursos");
//        
//    }
//}


@WebServlet(name = "EliminaCursoServlet", urlPatterns = {"/eliminarCurso"})
public class EliminaCursoServlet extends HttpServlet {
    
    private GestorCurso gestorCurso = new GestorCurso();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String codigo = req.getParameter("codigo");
        gestorCurso.eliminarPorCodigo(codigo);
        resp.sendRedirect("listarCursos");
    }
}
