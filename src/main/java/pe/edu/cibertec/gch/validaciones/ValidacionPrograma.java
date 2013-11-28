package pe.edu.cibertec.gch.validaciones;

import java.util.Calendar;
import java.util.Map;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;


public class ValidacionPrograma extends Validacion {

    private static final Logger LOG = Logger.getLogger(ValidacionPrograma.class.getName());

    @Override
    public void validar(HttpServletRequest req) {

        if (req.getServletPath().startsWith("buscarPrograma", 1)) {
            // Si se intenta buscar profesores

            // recuperar input de listado de profesores
            String textoBusquedaProgramaTitulo = req.getParameter("titulo"),
                    textoBusquedaProgramaDescripcion = req.getParameter("descripcion"),
                    textoBusquedaProgramaTipoBusqueda = req.getParameter("tipoBusqueda");
            validarBusqueda(textoBusquedaProgramaTitulo, textoBusquedaProgramaDescripcion, textoBusquedaProgramaTipoBusqueda);

            setPaginaReenvio("view/programa/index.jsp");

        } else if (req.getServletPath().startsWith("registrarPrograma", 1)) {
            // Si se intenta registrar un profesor

            // recuperar input de listado de profesores
            String textoBusquedaProgramaTitulo = req.getParameter("titulo"),
                    textoBusquedaProgramaDescripcion = req.getParameter("descripcion"),
                    textoBusquedaProfesorTipoBusqueda = req.getParameter("tipoBusqueda");

            validarRegistro(textoBusquedaProgramaTitulo, errores, textoBusquedaProgramaDescripcion);

            setPaginaReenvio("view/programa/registro.jsp");
        }
    }

    private void validarBusqueda(String textoBusquedaProgramaTitulo, String textoBusquedaProgramaDescripcion, String textoBusquedaProfesorTipoBusqueda){
        // por cada parametro, validar
        if (textoBusquedaProgramaTitulo.length() > 20) {
            errores.put("titulo", "La longitud del programa no debe exceder los 20 caracteres");
        }
        if (textoBusquedaProgramaDescripcion.length() < 3) {
            errores.put("descripcion", "La longitud de la descripcion debe ser como minimo 3 caracteres");
        }
        if (!textoBusquedaProfesorTipoBusqueda.matches("1|2")) {
            errores.put("tipoBusqueda", "Se debe seleccionar un tipo de b&uacute;squeda v&aacute;lido");
        }
    }

            
    private void validarRegistro(String textoBusquedaProgramaTitulo, Map<String, String> errores, String textoBusquedaProgramaDescripcion){
        // por cada parametro, validar
        if (textoBusquedaProgramaTitulo.isEmpty() || !textoBusquedaProgramaTitulo.matches("\\w{5,8}")) {
            errores.put("titulo", "El titulo es obligatorio y debe tener cinco o seis caracteres");
        }
        if (textoBusquedaProgramaDescripcion.isEmpty() || textoBusquedaProgramaDescripcion.length() < 3) {
            errores.put("descripcion", "La descripcion es obligatoria y se permite mas de 3 caracteres");
        }

    }
}
