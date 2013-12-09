package pe.edu.cibertec.gch.validaciones;

import java.util.Map;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

public class ValidacionHorario extends Validacion {

    private static final Logger LOG = Logger.getLogger(ValidacionHorario.class.getName());

    @Override
    public void validar(HttpServletRequest req) {

        if (req.getServletPath().startsWith("buscarHorarios", 1)) {
            // Si se intenta buscar horarios

            // recuperar input de listado de profesores
            String textoBusquedaHorarioDescripcion = req.getParameter("descripcion"),
                    textoBusquedaHorarioMomentoInicio = req.getParameter("momentoInicio"),
                    textoBusquedaHorarioMomentoFin = req.getParameter("momentoFin"),
                    textoBusquedaHorarioEstado = req.getParameter("estado"),
                    textoBusquedaHorarioTipoBusqueda = req.getParameter("tipoBusqueda");
            validarBusqueda(textoBusquedaHorarioDescripcion, textoBusquedaHorarioMomentoInicio,textoBusquedaHorarioMomentoFin,textoBusquedaHorarioEstado, textoBusquedaHorarioTipoBusqueda);

            setPaginaReenvio("view/horario/index.jsp");

        } else if (req.getServletPath().startsWith("registrarHorario", 1)) {
             //Si se intenta registrar un horario

             //recuperar input de listado de profesores
            String textoRegistroHorarioCodigo = req.getParameter("codigo"),
                    textoRegistroHorarioDescripcion = req.getParameter("descripcion"),
                    textoRegistroHorarioMomentoInicio = req.getParameter("momentoInicio"),
                    textoRegistroHorarioMomentoFin = req.getParameter("momentoFin"),
                    textoRegistroHorarioEstado = req.getParameter("estado");
                    System.out.println("ya recupramos los datos y enpezamos a validar(validacion horario)");
            validarRegistro(textoRegistroHorarioCodigo, errores, textoRegistroHorarioDescripcion, textoRegistroHorarioMomentoInicio
                    , textoRegistroHorarioMomentoFin, textoRegistroHorarioEstado);
            System.out.println("ya valide los datos ");
            
            setPaginaReenvio("view/horario/index.jsp");
        }
    
    }
    private void validarBusqueda(String textoBusquedaHorarioDescripcion, String textoBusquedaHorarioMomentoInicio, 
            String textoBusquedaHorarioMomentoFin, String textoBusquedaHorarioEstado ,String textoBusquedaHorarioTipoBusqueda) {
        // por cada parametro, validar
        System.out.println("estoy en validacion horario- busqueda");
        if (textoBusquedaHorarioDescripcion.length() > 75) {
            errores.put("nombres", "La descripcion del horario del curso no debe exceder los 75 caracteres");
        }
        if (textoBusquedaHorarioMomentoInicio.length() > 4) {
            errores.put("apellidoPaterno", "La longitud de la hora de Inicio(Ej.1700) no debe exceder los 4 caracteres");
        }
        if (textoBusquedaHorarioMomentoFin.length() > 4) {
            errores.put("apellidoMaterno", "La longitud del apellido materno no debe exceder los 4 caracteres");
        }
        if (textoBusquedaHorarioEstado.length() > 10) {
            errores.put("apellidoMaterno", "La longitud del campo estado no debe exceder los 10 caracteres");
        }
        if (!textoBusquedaHorarioTipoBusqueda.matches("1|2")) {
            errores.put("tipoBusqueda", "Se debe seleccionar un tipo de b&uacute;squeda v&aacute;lido");
        }
    }

    private void validarRegistro(String textoRegistroHorarioCodigo, Map<String, String> errores, String textoRegistroHorarioDescripcion, 
            String textoRegistroHorarioMomentoInicio, String textoRegistroHorarioMomentoFin, 
            String textoRegistroHorarioEstado) {
        // por cada parametro, validar
        System.out.println("validando datos para registrar horario");
        if (textoRegistroHorarioCodigo.isEmpty() || !textoRegistroHorarioCodigo.matches("\\w{5,6}")) {
            errores.put("codigo", "El codigo es obligatorio y debe tener cinco o seis caracteres");
        }
        if (textoRegistroHorarioDescripcion.isEmpty() || textoRegistroHorarioDescripcion.length() > 50) {
            errores.put("descripcion", "la descripcion es obligatoria y se permite hasta 50 caracteres");
        }
        if (textoRegistroHorarioMomentoInicio.isEmpty() || textoRegistroHorarioMomentoInicio.length() > 4 ||
                (Integer.parseInt( textoRegistroHorarioMomentoInicio)>2400)) {
            System.out.println("si etro aki el momento inicio es erroneo");
            errores.put("momentoInicio", "El campo momento Inicio debe ser numerico ya que indica hora (ej 1400  para indicar las 14:00 horas)");
        }
        
        if (textoRegistroHorarioMomentoFin.isEmpty() || textoRegistroHorarioMomentoFin.length() > 4 ||
                (Integer.parseInt( textoRegistroHorarioMomentoFin)>2400)) {
            errores.put("momentoFin", "El campo momento Fin debe ser numerico ya que indica hora (ej 1400  para indicar las 14:00 horas)");
        }
    }
}
    

