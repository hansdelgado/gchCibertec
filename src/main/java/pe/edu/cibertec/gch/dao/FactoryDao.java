package pe.edu.cibertec.gch.dao;

import pe.edu.cibertec.gch.dao.horario.HorarioDao;
import pe.edu.cibertec.gch.dao.horario.HorarioDaoImplMemoria;

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
    
    //estamos agregando al factory el objeto a crear dao de horario
    public HorarioDao getHorarioDao() {
        return new HorarioDaoImplMemoria();
    }
}
