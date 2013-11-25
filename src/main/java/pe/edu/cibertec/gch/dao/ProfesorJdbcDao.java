package pe.edu.cibertec.gch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.cibertec.gch.modelo.Profesor;
import pe.edu.cibertec.utiles.ConexionDB;

/**
 * DAO empleando JDBC TODO podemos hacer uso del abstract factory
 */
public class ProfesorJdbcDao implements ProfesorDao {

    @Override
    public List<Profesor> listarTodos() {
        List<Profesor> listaProfesores = new ArrayList<Profesor>();
        String QUERY_SELECT = "SELECT * FROM profesor";
        try  {
            Connection conexion = ConexionDB.crearConexion();
                Statement stmt = conexion.createStatement();
                ResultSet resultSet = stmt.executeQuery(QUERY_SELECT);
            while (resultSet.next()) {
                Profesor profesor = new Profesor()
                        .conCodigo(resultSet.getString("codigo"))
                        .conNombres(resultSet.getString("nombres"))
                        .conApellidoPaterno(resultSet.getString("apellidoPaterno"))
                        .conApellidoMaterno(resultSet.getString("apellidoMaterno"));
                listaProfesores.add(profesor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProfesores;
    }
    
    @Override
    public List<Profesor> listarSegun(String nombre, String apellidoPaterno, String apellidoMaterno) {
        List<Profesor> listaProfesores = new ArrayList<Profesor>();
        try {
        Connection conexion = ConexionDB.crearConexion();
        String QUERY_SELECT = "SELECT * FROM profesor where nombres like '%" + nombre +"%'";
        Statement stmt = conexion.createStatement();
        ResultSet resultSet = stmt.executeQuery(QUERY_SELECT);
        while (resultSet.next()) {
                Profesor profesor = new Profesor()
                        .conCodigo(resultSet.getString("codigo"))
                        .conNombres(resultSet.getString("nombres"))
                        .conApellidoPaterno(resultSet.getString("apellidoPaterno"))
                        .conApellidoMaterno(resultSet.getString("apellidoMaterno"));
                listaProfesores.add(profesor);
            }
        } catch (Exception ex) {
            
        }
        return listaProfesores;
    }

    @Override
    public void eliminarPorCodigo(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Profesor consultarPorCodigo(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registrar(Profesor obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Profesor profesor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
