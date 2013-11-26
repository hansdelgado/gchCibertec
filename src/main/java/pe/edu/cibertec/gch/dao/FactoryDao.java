package pe.edu.cibertec.gch.dao;

import pe.edu.cibertec.gch.dao.cursos.CursoDao;
import pe.edu.cibertec.gch.dao.cursos.CursoDaoImpl;

public class FactoryDao {
    
    private static FactoryDao instance;
    
    private FactoryDao() {
    }
    
    public static FactoryDao getInstance() {
        if ( instance == null) {
            instance = new FactoryDao();
        }
        return instance;
    }
    
    public ProfesorDao getProfesorDao() {
        return new ProfesorDaoImplMemoria();
    }
    
    public CursoDao getCursoDao() {
        return new CursoDaoImpl();
    }
}
