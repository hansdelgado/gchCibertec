package pe.edu.cibertec.gch.dao;

import pe.edu.cibertec.gch.dao.cursos.CursoDao;
import pe.edu.cibertec.gch.dao.laboratorio.LaboratorioDao;
import pe.edu.cibertec.gch.dao.profesor.ProfesorDao;
import pe.edu.cibertec.gch.dao.profesor.ProfesorDaoImplMemoria;

/**
 *
 * @author Java-ADV-LM
 */
public class FactoryDaoMemoria extends FactoryDao {

    @Override
    public ProfesorDao getProfesorDao() {
        return new ProfesorDaoImplMemoria();
    }

//    @Override
//    public CursoDao getCursoDao() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public LaboratorioDao getLaboratorioDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
