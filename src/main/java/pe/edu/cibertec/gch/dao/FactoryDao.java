package pe.edu.cibertec.gch.dao;

import pe.edu.cibertec.gch.dao.cursos.CursoDao;
import pe.edu.cibertec.gch.dao.laboratorio.LaboratorioDao;
import pe.edu.cibertec.gch.dao.laboratorio.LaboratorioDaoImpl;

import pe.edu.cibertec.gch.dao.profesor.ProfesorDaoImplMemoria;
import pe.edu.cibertec.gch.dao.profesor.ProfesorDao;

public abstract class FactoryDao {
    
    private static FactoryDao instance;
    
    public static final int MEMORIA = 0;
    public static final int JDBC = 1;
    public static final int MYBATIS = 2;
    public static final int JPA=3;
    
    public static FactoryDao getFactory(int repositorio) {
        if ( instance == null) {
            switch(repositorio) {
                case MEMORIA:
                    instance = new FactoryDaoMemoria();
                    break;
                case MYBATIS:
                    instance = new FactoryDaoMyBatis();
                    break;                
                case JPA:
                    instance = new FactoryDaoJPA();
                    break;
            }
        }
        return instance;
    }
    
    public abstract ProfesorDao getProfesorDao();
    public abstract LaboratorioDao getLaboratorioDao();
    //public abstract HorarioDao getHorarioDao();
    //public abstract ProgramaDao getProgramaDao();
//    public abstract CursoDao getCursoDao();
    
}
