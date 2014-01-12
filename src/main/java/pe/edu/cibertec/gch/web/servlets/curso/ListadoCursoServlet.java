/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.web.servlets.curso;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import pe.edu.cibertec.gch.logica.GestorCurso;
import pe.edu.cibertec.gch.modelo.Curso;
import pe.edu.cibertec.gch.web.servlets.GchServletUtils;

/**
 *
 * @author JAVA-ADV-LM
 */
@WebServlet(name = "ListadoCursoServlet", urlPatterns = {"/listarCursos"})
public class ListadoCursoServlet extends HttpServlet {
    //private GestorCurso gestorCurso = new GestorCurso();
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // trae los profesores en la fuente de datos
        //List<Curso> cursos = gestorCurso.listarTodos();
        // almacena resultado en el request
        //req.setAttribute("cursos", cursos);
        // pinta los datos en el listado
        
        GchServletUtils.reenviarAModulo("curso", req, resp);
    }
    
}
