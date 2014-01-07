package pe.edu.cibertec.gch.validaciones;

import java.util.Calendar;
import java.util.Map;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

public class ValidacionCurso extends Validacion {

    private static final Logger LOG = Logger.getLogger(ValidacionCurso.class.getName());

    @Override
    public void validar(HttpServletRequest req) {

        if (req.getServletPath().startsWith("buscarCurso", 1)) {
            // Si se intenta buscar profesores

            // recuperar input de listado de profesores
            String textoBusquedaCursoCodigo = req.getParameter("codigo"),
                    textoBusquedaCursoNombre = req.getParameter("nombre");
            validarBusqueda(textoBusquedaCursoCodigo, textoBusquedaCursoNombre);

            setPaginaReenvio("view/curso/index.jsp");

        } else if (req.getServletPath().startsWith("irRegistrarCurso", 1)) {
            // Si se intenta registrar un profesor

            // recuperar input de listado de profesores
            String textoRegistroCursoCodigo = req.getParameter("codigo"),
                    textoRegistroCursoNombre = req.getParameter("nombre"),
                    textoRegistroCursoDescripcion = req.getParameter("descripcion"),
                    textoRegistroCursoObjetivos = req.getParameter("objetivos"),
                    textoRegistroCursoRequisitos = req.getParameter("requisitos"),
                    textoRegistroCursoDuracion = req.getParameter("duracion"),
                    textoRegistroCursoEstado = req.getParameter("estado");
            validarRegistro(textoRegistroCursoCodigo, errores, textoRegistroCursoNombre, textoRegistroCursoDescripcion, textoRegistroCursoObjetivos, textoRegistroCursoRequisitos, textoRegistroCursoDuracion, textoRegistroCursoEstado );

            setPaginaReenvio("view/curso/registro.jsp");
        }
    }

    private void validarBusqueda(String textoBusquedaCursoCodigo, String textoBusquedaCursoNombre) {
        // por cada parametro, validar
        if (textoBusquedaCursoCodigo.length() > 50) {
            errores.put("nombres", "La longitud del nombre no debe exceder los 100 caracteres");
        }
        if (textoBusquedaCursoNombre.length() > 50) {
            errores.put("apellidoPaterno", "La longitud del apellido paterno no debe exceder los 50 caracteres");
        }
    }

    private void validarRegistro(
            String textoRegistroCursoCodigo, Map<String, String> errores,
            String  textoRegistroCursoNombre,
            String  textoRegistroCursoDescripcion,
            String  textoRegistroCursoObjetivos,
            String  textoRegistroCursoRequisitos,
            String  textoRegistroCursoDuracion,
            String  textoRegistroCursoEstado ) {
    
        // por cada parametro, validar
        if (textoRegistroCursoCodigo.isEmpty() || !textoRegistroCursoCodigo.matches("\\w{5,8}")) {
            errores.put("codigo", "El codigo es obligatorio y debe tener cinco o seis caracteres");
        }
        if (textoRegistroCursoNombre.isEmpty() || textoRegistroCursoNombre.length() > 50) {
            errores.put("nombres", "Los nombres son obligatorios y se permite hasta 50 caracteres");
        }
        if (textoRegistroCursoDescripcion.isEmpty() || textoRegistroCursoDescripcion.length() > 50) {
            errores.put("apellidoPaterno", "El apellido paterno es obligatorio y se permite hasta 50 caracteres");
        }
        if (!textoRegistroCursoObjetivos.isEmpty() && textoRegistroCursoObjetivos.length() > 50) {
            errores.put("apellidoMaterno", "El apellido materno puede tener hasta 50 caracteres");
        }
        if (!textoRegistroCursoRequisitos.isEmpty() && textoRegistroCursoRequisitos.length() > 400) {
            errores.put("direccion", "La direcci&oacute;n puede tener hasta 400 caracteres");
        }
        if (!textoRegistroCursoDuracion.isEmpty() && textoRegistroCursoDuracion.length() > 400) {
            errores.put("referencia", "La referencia puede tener hasta 400 caracteres");
        }
        if (!textoRegistroCursoEstado.isEmpty() && textoRegistroCursoEstado.length() > 400) {
            errores.put("referencia", "La referencia puede tener hasta 400 caracteres");
        }
//        if (null != textoRegistroCursoEstado && !textoRegistroCursoEstado.isEmpty() && !textoRegistroProfesorSexo.matches("m|f")) {
//            errores.put("sexo", "El g&eacute;nero indicado no es v&aacute;lido");
//        }
    }
}
