package pe.edu.cibertec.gch.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.cibertec.gch.modelo.EstadoActividad;
import pe.edu.cibertec.gch.modelo.Moneda;
import pe.edu.cibertec.gch.modelo.Programa;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

public class ProgramaDaoImp implements ProgramaDao {
    
    private static ArrayList<Programa> programas = new ArrayList<Programa>();
    
    static {
        SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        
        Programa p = new Programa();
        p.setCodigo("01");
        p.setTitulo("Tecnico informatico");
        p.setDescripcion("Orientado al Sector de Telecomunicaciones");
        p.setObjetivos("Conocimiento de TI");
        p.setRequisitos("Ninguno");
        p.setMoneda(Moneda.DolaresUS);
        p.setPrecio(700);
        p.setEstado(EstadoActividad.Valido);
        p.setDuracion(150);
        try {
            p.setFechaInicial(fecha.parse("2013-06-11"));
        } catch (ParseException ex) {
            Logger.getLogger(ProgramaDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        programas.add(p);
    }
    
    @Override
    public List<Programa> listarTodos() {
        
        return programas;
    }
    
    @Override
    public void registrar(Programa programa) {
        programas.add(programa);
    }
    
    public void borrarTodos() {
    }
    
    @Override
    public List<Programa> listarSegun(String titulo, String descripcion, String objetivo, TipoBusqueda tipoBusqueda) {
        return null;
    }
    
    @Override
    public void eliminarPorCodigo(String codigo) {
        //programas.remove(new Programa(codigo));
        Programa remover = null;
        for(Programa programa : programas) {
            if (programa.getCodigo().equals(codigo))
                remover = programa;
        }
        programas.remove(remover);
    }
    
    @Override
    public Programa consultarPorCodigo(final String codigo) {
        Programa programa = new Programa();
        programa.setCodigo(codigo);
        return programas.get(programas.indexOf(programa));
    }
    
    @Override
    public void modificarPorCodigo(Programa pro) {
        programas.set(programas.indexOf(pro), pro);
    }
}
