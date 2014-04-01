/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.cibertec.gch.action.laboratorio;

import com.opensymphony.xwork2.Action;
import pe.edu.cibertec.gch.logica.GestorLaboratorio;
import pe.edu.cibertec.gch.modelo.Laboratorio;

/**
 *
 * @author YESSY
 */
public class EdicionLaboratorioAction implements Action{
    private String codigo;
    private Laboratorio laboratorio;
    //private GestorLaboratorioImpl gestorLaboratorio= new GestorLaboratorioImpl();
    private GestorLaboratorio gestorLaboratorio;
    
    @Override
    public String execute() throws Exception {
        laboratorio = gestorLaboratorio.consultarSegun(codigo);
        if (null == laboratorio) {
            return INPUT;
        }
        return SUCCESS;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public GestorLaboratorio getGestorLaboratorio() {
        return gestorLaboratorio;
    }

    public void setGestorLaboratorio(GestorLaboratorio gestorLaboratorio) {
        this.gestorLaboratorio = gestorLaboratorio;
    }
    
}
