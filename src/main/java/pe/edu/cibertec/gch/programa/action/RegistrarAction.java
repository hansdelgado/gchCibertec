package pe.edu.cibertec.gch.programa.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import pe.edu.cibertec.gch.modelo.Programa;
import pe.edu.cibertec.gch.logica.GestorPrograma;
import pe.edu.cibertec.gch.modelo.Moneda;

public class RegistrarAction extends ActionSupport {

    private GestorPrograma gestorPrograma = new GestorPrograma();
    private List<Programa> programas;
    private Programa programa;
    private String mensaje;
    private Moneda[] monedas = Moneda.values();

    @Override
    public String execute() throws Exception {

        gestorPrograma.registrar(programa);
        setMensaje(getText("gch.programa.exito.registrar"));
        return SUCCESS;
    }

    @Override
    public void validate() {
        Programa p = gestorPrograma.consultarPorCodigo(programa.getCodigo());
        if (p != null) { // si ya existe
            addFieldError("programa.codigo", getText("gch.programa.error.codigo.duplicado"));
        }
    }

    public String inicializar() {
        return SUCCESS;
    }

    // Metodos de acceso de los JavaBeans.
    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public List<Programa> getProgramas() {
        return programas;
    }

    public void setProgramas(List<Programa> programas) {
        this.programas = programas;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Moneda[] getMonedas() {
        return monedas;
    }

    public void setMonedas(Moneda[] monedas) {
        this.monedas = monedas;
    }
}
