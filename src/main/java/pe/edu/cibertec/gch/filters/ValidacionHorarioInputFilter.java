/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.filters;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

    
/**
 *
 * @author JAVA-ADV-LM
 */
@WebFilter(filterName = "ValidacionHorarioInputFilter", urlPatterns = {"/*"})
public class ValidacionHorarioInputFilter implements Filter {
   
    private static final Logger LOG = Logger.getLogger(ValidacionProfesorInputFilter.class.getName());
    
  private void doBeforeProcessing(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        req.removeAttribute("errores");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println("estamos validand....o");
//        ValidacionFactory factory = new ValidacionFactory();
//        Validacion validacion = factory.obtenerSegun(req);
//        if(validacion != null) {
//           validacion.validar(req);
          // hacerReenvioA(validacion.getErrores(), chain, request, response, req, validacion.getPaginaReenvio());
        }

    @Override
    public void init(FilterConfig fc) throws ServletException {
   
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        doBeforeProcessing(sr, sr1, fc);
        fc.doFilter(sr, sr1);
    }

    @Override
    public void destroy() {

    }
        
}
