package pe.edu.cibertec.gch.web.servlets.horario;


import java.io.IOException;
//import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.logica.GestorHorario;
import pe.edu.cibertec.gch.modelo.EstadoActividad;
//import pe.edu.cibertec.gch.modelo.EstadoProfesor;
//import pe.edu.cibertec.gch.modelo.Genero;
import pe.edu.cibertec.gch.modelo.Horario; 


/**
 * Servlet para registrar un profesor.
 */
@WebServlet(name = "RegistroHorarioServlet", urlPatterns = {"/registrarHorario"})
public class RegistroHorarioServlet extends HttpServlet {

    private GestorHorario gestorHorario = new GestorHorario();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String codigo = req.getParameter("codigo"),
                descripcion = req.getParameter("descripcion"),
                estado = req.getParameter("estado");
                int momentoInicio = Integer.parseInt(req.getParameter("momentoInicio")),
                momentoFin= Integer.parseInt(req.getParameter("momentoFin"));
        System.out.println("ya recupere los datos del registro");
//        Profesor nuevoProfesor = new Profesor().conCodigo(codigo)
//                .conNombres(nombres)
//                .conApellidoPaterno(apellidoPaterno)
//                .conApellidoMaterno(apellidoMaterno)
//                .conDireccion(direccion)
//                .conReferencia(referencia)
//                .conSexo(Genero.obtenerSegun(sexo))
//                .conEstado(EstadoProfesor.Activo);
        
        Horario nuevoHorario=new Horario();
                    nuevoHorario.setCodigo(codigo);
                    nuevoHorario.setDescripcion(descripcion);
                    nuevoHorario.setMomentoInicio(momentoInicio);
                    nuevoHorario.setMomentoFin(momentoFin); 
                    
                        if(estado.equalsIgnoreCase("activo")){
                            nuevoHorario.setEstado(EstadoActividad.Activo);
                        }else{
                            nuevoHorario.setEstado(EstadoActividad.Inactivo);
                        }
                    
                    
                    System.out.println("agrrege los datos a la lista");
//        if (!fechaNacimiento.isEmpty()) {
//            int dia = Integer.parseInt(fechaNacimiento.substring(8)),
//                    mes = Integer.parseInt(fechaNacimiento.substring(5, 7)),
//                    ano = Integer.parseInt(fechaNacimiento.substring(0, 4));
//            final Calendar cal = Calendar.getInstance();
//            cal.setLenient(false);
//            cal.clear();
//            cal.set(ano, mes - 1, dia);
//            nuevoProfesor = nuevoProfesor.conFechaNacimiento(cal.getTime());
//        }
        gestorHorario.registrar(nuevoHorario);
        resp.sendRedirect("listarHorarios");
    }
}
