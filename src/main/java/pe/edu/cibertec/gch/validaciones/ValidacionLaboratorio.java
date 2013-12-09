package pe.edu.cibertec.gch.validaciones;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

public class ValidacionLaboratorio extends Validacion {

    @Override
    public void validar(HttpServletRequest req) {

        if (req.getServletPath().startsWith("buscarLaboratorios", 1)) {
            // Si se intenta buscar profesores

            // recuperar input de listado de profesores
            String textoBusquedaLaboratorioNombre = req.getParameter("nombre"),
                    textoBusquedaLaboratorioLocal = req.getParameter("local");
            validarBusqueda(textoBusquedaLaboratorioNombre,textoBusquedaLaboratorioLocal);

            setPaginaReenvio("view/laboratorio/index.jsp");

        } else if (req.getServletPath().startsWith("registrarLaboratorio", 1)) {
            // Si se intenta registrar un laboratorio

            // recuperar input de listado de profesores
            String textoRegistroLaboratorioCodigo = req.getParameter("codigo"),
                    textoRegistroLaboratorioNombre = req.getParameter("nombre"),
                    textoRegistroLaboratorioDescripcion = req.getParameter("descripcion"),
                    textoRegistroLaboratorioLocal = req.getParameter("local"),
                    textoRegistroLaboratorioPabellon = req.getParameter("pabellon"),
                    textoRegistroLaboratorioSalon = req.getParameter("salon"),
                    textoRegistroLaboratorioCapacidad = req.getParameter("capacidad"),
                    textoRegistroLaboratorioEstado = req.getParameter("estado");
           
            validarRegistro(textoRegistroLaboratorioCodigo, textoRegistroLaboratorioNombre, 
                    textoRegistroLaboratorioDescripcion, textoRegistroLaboratorioLocal, textoRegistroLaboratorioPabellon, 
                    textoRegistroLaboratorioSalon, Integer.parseInt(textoRegistroLaboratorioCapacidad), textoRegistroLaboratorioEstado);

            setPaginaReenvio("view/laboratorio/registro.jsp");          
        }
    }

    private void validarBusqueda(String textoBusquedaLaboratorioNombre, String textoBusquedaLaboratorioLocal) {
        // por cada parametro, validar
        if (textoBusquedaLaboratorioNombre.length() > 10) {
            errores.put("nombre", "La longitud del nombre no debe exceder los 10 caracteres");
        }
        if (textoBusquedaLaboratorioLocal.length() > 10) {
            errores.put("local", "La longitud del local no debe exceder los 10 caracteres");
        }
    }

    private void validarRegistro(String textoRegistroLaboratorioCodigo, String textoRegistroLaboratorioNombre, 
            String textoRegistroLaboratorioDescripcion, String textoRegistroLaboratorioLocal, String textoRegistroLaboratorioPabellon, 
            String textoRegistroLaboratorioSalon, Integer textoRegistroLaboratorioCapacidad, String textoRegistroLaboratorioEstado) {
        // por cada parametro, validar
        if (textoRegistroLaboratorioCodigo.isEmpty() || !textoRegistroLaboratorioCodigo.matches("\\w{5,6}")) {
            errores.put("codigo", "El codigo es obligatorio y debe tener cinco o seis caracteres");
        }
        if (textoRegistroLaboratorioNombre.isEmpty() || textoRegistroLaboratorioNombre.length() > 10) {
            errores.put("nombres", "El nombre es obligatorios y se permite hasta 10 caracteres");
        }
        if (textoRegistroLaboratorioLocal.isEmpty() || textoRegistroLaboratorioLocal.length() > 10) {
            errores.put("local", "El local es obligatorio y se permite hasta 10 caracteres");
        }
   
    }
}
