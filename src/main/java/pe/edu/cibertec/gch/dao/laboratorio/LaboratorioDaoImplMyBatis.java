package pe.edu.cibertec.gch.dao.laboratorio;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pe.edu.cibertec.gch.modelo.Laboratorio;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;
import pe.edu.cibertec.gch.modelo.mapper.LaboratorioMapper;
import pe.edu.cibertec.gch.util.MyBatisUtil;

/**
 *
 * @author Java-ADV-LM
 */
public class LaboratorioDaoImplMyBatis 
                            implements LaboratorioDao {

    
    
    @Override
    public void eliminarPorCodigo(String codigo) {
        SqlSessionFactory ssf = 
                MyBatisUtil.getSqlSessionFactory();
        SqlSession session = ssf.openSession();
        LaboratorioMapper mapper = 
                session.getMapper(LaboratorioMapper.class);
        mapper.eliminar(codigo);
        session.commit();

        session.close();
    }

    @Override
    public Laboratorio consultarPorCodigo(String codigo) {
        SqlSessionFactory ssf = 
                MyBatisUtil.getSqlSessionFactory();
       SqlSession session = ssf.openSession();
        LaboratorioMapper mapper = 
                session.getMapper(LaboratorioMapper.class);
        Laboratorio laboratorio=mapper.obtenerLaboratorioXCodigo(codigo);
        session.commit();

        session.close();
        
        return laboratorio;
       
    }

    @Override
    public List<Laboratorio> listarSegun(String nombre, String local, TipoBusqueda tipoBusqueda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registrar(Laboratorio laboratorio) {
       SqlSessionFactory ssf = 
                MyBatisUtil.getSqlSessionFactory();
        SqlSession session = ssf.openSession();
        LaboratorioMapper mapper = 
                session.getMapper(LaboratorioMapper.class);
        mapper.insertar(laboratorio);
        session.commit();

        session.close();
    }

    @Override
    public List<Laboratorio> listarTodos() {
        SqlSessionFactory ssf = 
                MyBatisUtil.getSqlSessionFactory();
        SqlSession session = ssf.openSession();
        
        // Utilizando mappers con interfaces
        LaboratorioMapper mapper = 
                session.getMapper(LaboratorioMapper.class);
        List<Laboratorio> laboratorios = mapper.obtenerLaboratorios();
        session.close();
        
        return laboratorios;
    }

    @Override
    public void borrarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Laboratorio laboratorio) {
        SqlSessionFactory ssf = 
                MyBatisUtil.getSqlSessionFactory();
        SqlSession session = ssf.openSession();
        LaboratorioMapper mapper = 
                session.getMapper(LaboratorioMapper.class);
        mapper.modificar(laboratorio);
        session.commit();

        session.close();
    }

   
}
