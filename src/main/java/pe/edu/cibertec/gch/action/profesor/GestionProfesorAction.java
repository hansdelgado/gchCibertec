package pe.edu.cibertec.gch.action.profesor;

import com.opensymphony.xwork2.Action;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.cibertec.gch.exception.DatosInvalidosException;
import pe.edu.cibertec.gch.modelo.EstadoProfesor;
import pe.edu.cibertec.gch.modelo.Genero;
import pe.edu.cibertec.gch.modelo.Profesor;

public class GestionProfesorAction extends ProfesorBaseAction {

    public String registrar() {
        int dia = Integer.parseInt(fechaNacimiento.substring(8)),
                mes = Integer.parseInt(fechaNacimiento.substring(5, 7)),
                ano = Integer.parseInt(fechaNacimiento.substring(0, 4));
        Calendar cal = Calendar.getInstance();
        cal.setLenient(false);
        cal.clear();
        cal.set(ano, mes - 1, dia);
        Profesor profesor = new Profesor().conCodigo(codigo)
                .conNombres(nombres)
                .conApellidoPaterno(apellidoPaterno)
                .conApellidoMaterno(apellidoMaterno)
                .conDireccion(direccion)
                .conReferencia(referencia)
                .conFechaNacimiento(cal.getTime())
                .conSexo(Genero.obtenerSegun(sexo))
                .conEstado(EstadoProfesor.Activo);

        gestor.registrar(profesor);
        return Action.SUCCESS;
    }

    public String actualizar() {
        int dia = Integer.parseInt(fechaNacimiento.substring(8)),
                mes = Integer.parseInt(fechaNacimiento.substring(5, 7)),
                ano = Integer.parseInt(fechaNacimiento.substring(0, 4));
        Calendar cal = Calendar.getInstance();
        cal.setLenient(false);
        cal.clear();
        cal.set(ano, mes - 1, dia);
        Profesor profesor = new Profesor().conCodigo(codigo)
                .conNombres(nombres)
                .conApellidoPaterno(apellidoPaterno)
                .conApellidoMaterno(apellidoMaterno)
                .conDireccion(direccion)
                .conReferencia(referencia)
                .conFechaNacimiento(cal.getTime())
                .conSexo(Genero.obtenerSegun(sexo))
                .conEstado(EstadoProfesor.obtenerSegun(estado));

        gestor.actualizar(profesor);
        return Action.SUCCESS;
    }

    public String eliminar() {
        try {
            gestor.eliminarSegun(codigo);
            return Action.SUCCESS;
        } catch (DatosInvalidosException ex) {
            Logger.getLogger(GestionProfesorAction.class.getName()).log(Level.SEVERE, null, ex);
            return Action.ERROR;
        }
    }
}
