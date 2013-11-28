/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.logica;

import java.util.ArrayList;
import java.util.List;
import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.dao.ProgramaDao;
import pe.edu.cibertec.gch.modelo.Profesor;
import pe.edu.cibertec.gch.modelo.Programa;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;
import sun.security.jca.GetInstance;

/**
 *
 * @author JAVA-ADV-LM
 */
public class GestorPrograma   implements GestorBase<Programa>{

    
    private static ArrayList<Programa> programas = new ArrayList<Programa>();
     ProgramaDao dao = FactoryDao.getInstance().getProgramaDao();
    @Override
    public List<Programa> listarTodos() {
//        Programa p = new Programa();
//        p.setCodigo("01");
//        p.setDescripcion("descripcipn");
//        p.setTitulo("titulo");
//                
//            programas.add(p);
//          return programas;
   
  //ProgramaDao programaDao= FactoryDao.getInstance().getProgramaDao();
       return dao.listarTodos();
       
    }
    
   
        public List<Programa> listarSegun(String titulo, String descripcion,TipoBusqueda tipoBusqueda) {
       List<Programa> encontrados= new ArrayList<Programa>();
            
            switch(tipoBusqueda){
                case Completa:
                    encontrados=listarTodos();
            break;
                case Parcial:
                    for (Programa prog : listarTodos()){
                      if((!titulo.isEmpty()
                              && prog.getTitulo().contains(titulo))
                              || (!descripcion.isEmpty() 
                              && prog.getDescripcion().contains(descripcion)))
                      {
                          encontrados.add(prog);
                      }
                      
                    }
                    break;
            }
            return encontrados;
            
                   // ; //dao.listarSegun(titulo, descripcion, objetivo,tipoBusqueda);
    }


    @Override
    public void eliminarPorCodigo(String codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Programa consultarPorCodigo(String codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void registrar(Programa entidad) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
