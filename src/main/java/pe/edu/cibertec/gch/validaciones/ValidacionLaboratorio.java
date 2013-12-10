package pe.edu.cibertec.gch.validaciones;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import pe.edu.cibertec.gch.modelo.EstadoLaboratorio;
import pe.edu.cibertec.gch.modelo.Laboratorio;

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
        }else if (req.getServletPath().startsWith("actualizarLaboratorio", 1)) {
            // Si se intenta registrar un laboratorio

            // recuperar input de listado de profesores
            String  textoActualizaLaboratorioCodigo = req.getParameter("codigo"),
                    textoActualizaLaboratorioNombre = req.getParameter("nombre"),
                    textoActualizaLaboratorioDescripcion = req.getParameter("descripcion"),
                    textoActualizaLaboratorioLocal = req.getParameter("local"),
                    textoActualizaLaboratorioPabellon = req.getParameter("pabellon"),
                    textoActualizaLaboratorioSalon = req.getParameter("salon"),
                    textoActualizaLaboratorioCapacidad = req.getParameter("capacidad"),
                    textoActualizaLaboratorioEstado = req.getParameter("estado");
           
            validarActualiza(textoActualizaLaboratorioNombre, textoActualizaLaboratorioDescripcion,
                    textoActualizaLaboratorioLocal, textoActualizaLaboratorioPabellon, textoActualizaLaboratorioSalon,
                    Integer.parseInt(textoActualizaLaboratorioCapacidad), textoActualizaLaboratorioEstado);
            
            Laboratorio laboratorio = new Laboratorio().conNombre(textoActualizaLaboratorioNombre)
                    .conCapacidad(Integer.parseInt(textoActualizaLaboratorioCapacidad))
                    .conCodigo(textoActualizaLaboratorioCodigo)
                    .conDescripcion(textoActualizaLaboratorioDescripcion)
                    .conLocal(textoActualizaLaboratorioLocal)
                    .conPabellon(textoActualizaLaboratorioPabellon)
                    .conSalon(textoActualizaLaboratorioSalon)
                    .conEstado(EstadoLaboratorio.obtenerSegun(textoActualizaLaboratorioEstado));
            req.setAttribute("laboratorio", laboratorio);
            
            setPaginaReenvio("view/laboratorio/actualiza.jsp");          
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
        if (textoRegistroLaboratorioDescripcion.isEmpty() || textoRegistroLaboratorioDescripcion.length() > 10) {
            errores.put("descripcion", "El Descripcion es obligatorio y se permite hasta 10 caracteres");
        }
        if (textoRegistroLaboratorioPabellon.isEmpty() || textoRegistroLaboratorioPabellon.length() > 10) {
            errores.put("pabellon", "El Pabellon es obligatorios y se permite hasta 10 caracteres");
        }
        if (textoRegistroLaboratorioSalon.isEmpty() || !textoRegistroLaboratorioSalon.matches("\\w{3,4}")) {
            errores.put("salon", "El salon es obligatorio y debe ser numeros de 3 o 4 digitos");
        }
        if (textoRegistroLaboratorioCapacidad<10) {
            errores.put("capacidad", "El Capacidad es obligatorio y debe ser mayor a 10");
        }
   
    }
    private void validarActualiza( String textoActualizaLaboratorioNombre, 
            String textoActualizaLaboratorioDescripcion, String textoActualizaLaboratorioLocal, String textoActualizaLaboratorioPabellon, 
            String textoActualizaLaboratorioSalon, Integer textoActualizaLaboratorioCapacidad, String textoActualizaLaboratorioEstado) {
        // por cada parametro, validar
        if (textoActualizaLaboratorioNombre.isEmpty() || textoActualizaLaboratorioNombre.length() > 10) {
            errores.put("nombres", "El nombre es obligatorios y se permite hasta 10 caracteres");
        }
        if (textoActualizaLaboratorioLocal.isEmpty() || textoActualizaLaboratorioLocal.length() > 10) {
            errores.put("local", "El local es obligatorio y se permite hasta 10 caracteres");
        }
        if (textoActualizaLaboratorioDescripcion.isEmpty() || textoActualizaLaboratorioDescripcion.length() > 10) {
            errores.put("descripcion", "El Descripcion es obligatorio y se permite hasta 10 caracteres");
        }
        if (textoActualizaLaboratorioPabellon.isEmpty() || textoActualizaLaboratorioPabellon.length() > 10) {
            errores.put("pabellon", "El Pabellon es obligatorios y se permite hasta 10 caracteres");
        }
        if (textoActualizaLaboratorioSalon.isEmpty() || !textoActualizaLaboratorioSalon.matches("\\w{3,4}")) {
            errores.put("salon", "El salon es obligatorio y debe ser numeros de 3 o 4 digitos");
        }
        if (textoActualizaLaboratorioCapacidad<10) {
            errores.put("capacidad", "La capacidad es obligatorio y debe ser mayor a 10");
        }
   
    }
}
