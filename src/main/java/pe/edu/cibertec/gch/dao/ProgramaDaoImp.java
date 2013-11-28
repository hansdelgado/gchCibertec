/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.dao;

import java.util.ArrayList;
import java.util.List;
import pe.edu.cibertec.gch.modelo.Programa;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;


 
public class ProgramaDaoImp implements ProgramaDao{
private static ArrayList<Programa> programas = new ArrayList<Programa>();

    static {
             Programa p = new Programa();
            p.setCodigo("01");
            p.setDescripcion("descripcion");
            p.setTitulo("nombre");  
            p.setObjetivos("obj");
            
//            Programa p2 = new Programa();
//             p2.setCodigo("02");
//            p2.setDescripcion("descripcion1");
//            p2.setTitulo("nombre1");  
//            p2.setObjetivos("obj1");
//            
//            programas.add(p2);  
            programas.add(p);  
    }

    @Override
    public List<Programa> listarTodos() {

          return programas;
    }

    @Override
    public void registrar(Programa obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void borrarTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Programa> listarSegun(String titulo, String descripcion, String objetivo, TipoBusqueda tipoBusqueda) {
        
       
        return null;
        
        
    }

  
    
}
