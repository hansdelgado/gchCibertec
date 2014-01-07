package pe.edu.cibertec.gch.dao;

import pe.edu.cibertec.gch.dao.laboratorio.LaboratorioDao;
import pe.edu.cibertec.gch.dao.laboratorio.LaboratorioDaoImpl;

import pe.edu.cibertec.gch.dao.profesor.ProfesorDaoImplMemoria;
import pe.edu.cibertec.gch.dao.profesor.ProfesorDao;

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
    
    
    
    
     public LaboratorioDao getLaboratorioDao() {
        return new LaboratorioDaoImpl();
    }
    
}
