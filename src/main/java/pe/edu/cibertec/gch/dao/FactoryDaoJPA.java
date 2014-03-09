package pe.edu.cibertec.gch.dao;

import pe.edu.cibertec.gch.dao.laboratorio.LaboratorioDao;
import pe.edu.cibertec.gch.dao.laboratorio.LaboratorioDaoImplJPA;
import pe.edu.cibertec.gch.dao.profesor.ProfesorDao;

/**
 *
 * @author Java-ADV-LM
 */
public class FactoryDaoJPA extends FactoryDao {

    @Override
    public ProfesorDao getProfesorDao() {
        return null;
    }

//    @Override
//    public CursoDao getCursoDao() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    @Override
    public LaboratorioDao getLaboratorioDao() {
        return new LaboratorioDaoImplJPA();
    }
}
