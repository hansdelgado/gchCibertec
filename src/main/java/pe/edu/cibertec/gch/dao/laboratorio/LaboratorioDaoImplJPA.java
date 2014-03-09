package pe.edu.cibertec.gch.dao.laboratorio;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pe.edu.cibertec.gch.modelo.Laboratorio;
import pe.edu.cibertec.gch.modelo.Profesor;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;
import pe.edu.cibertec.gch.modelo.mapper.LaboratorioMapper;
import pe.edu.cibertec.gch.util.JPAUtil;
import pe.edu.cibertec.gch.util.MyBatisUtil;

/**
 *
 * @author Java-ADV-LM
 */
public class LaboratorioDaoImplJPA 
                            implements LaboratorioDao {

     private EntityManagerFactory emf;

    public LaboratorioDaoImplJPA() {
        emf= JPAUtil.getEntityManagerFactory();
    }
              
    @Override
    public void eliminarPorCodigo(String codigo) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
            Laboratorio laboratorio = 
                    (Laboratorio) em.find(Laboratorio.class, codigo);
            em.remove(laboratorio);
        em.getTransaction().commit();

        em.close();         
    }

    @Override
    public Laboratorio consultarPorCodigo(String codigo) {
        EntityManager em = emf.createEntityManager();

        Laboratorio laboratorio = 
                    (Laboratorio) em.find(Laboratorio.class, codigo);

        em.close();
              
        return laboratorio;
       
    }

    @Override
    public List<Laboratorio> listarSegun(String nombre, String local, TipoBusqueda tipoBusqueda) {
        SqlSessionFactory ssf = 
                MyBatisUtil.getSqlSessionFactory();
        SqlSession session = ssf.openSession();
        
        EntityManager em=emf.createEntityManager();
        String query="SELECT l FROM Laboratorio l ";
        
        TypedQuery<Profesor> typedQuery=em.createQuery(query,Profesor.class);
        switch (tipoBusqueda) {
                case Completa:
                    break;
                case Parcial:
                    
                    if(nombre != null && !nombre.equals("")){
                        query=query + " AND l.nombre LIKE :labNombre";
                    }
                    if(local != null && !local.equals("")){
                        query = query + " AND l.local LIKE :labLocal";
                    }
                    typedQuery.setParameter("labNombre", nombre);
                    typedQuery.setParameter("labLocal", local);
                    break;
                default:
                    break;
            }

        System.out.println("query es: "+ typedQuery.toString());
        
        List<Profesor> profesores=typedQuery.getResultList();
        em.close();
        return profesores;
        
        
        
        
        
        
        
        // Utilizando mappers con interfaces
        LaboratorioMapper mapper = 
                session.getMapper(LaboratorioMapper.class);
        
        List<Laboratorio> laboratorios=null;
        
        switch (tipoBusqueda) {
            case Completa :
                laboratorios = mapper.obtenerLaboratorios();
                break;
            case Parcial :
                    Laboratorio lab=new Laboratorio();
                    if(nombre != null && !nombre.equals("")){
                        lab.setNombre(nombre);
                    }
                    if(local != null && !local.equals("")){
                        lab.setLocal(local);
                    }
                    laboratorios = mapper.obtenerLaboratoriosSegun(lab);
             break;
        }
        
        session.close();
        
        return laboratorios;
    }

    @Override
    public void registrar(Laboratorio laboratorio) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
            em.persist(laboratorio);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Laboratorio> listarTodos() {
        
         EntityManager em = emf.createEntityManager();

        Query emquery = em.createQuery(
                "SELECT l FROM Laboratorio l");
        List<Laboratorio> laboratorios = emquery.getResultList();

        em.close();
         
        return laboratorios;
    }

    @Override
    public void borrarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Laboratorio laboratorio) {
        
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
            em.merge(laboratorio);
        em.getTransaction().commit();

        em.close();
    }

   
}

