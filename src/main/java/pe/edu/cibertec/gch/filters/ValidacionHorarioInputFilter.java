package pe.edu.cibertec.gch.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.validaciones.Validacion;
import pe.edu.cibertec.gch.validaciones.ValidacionFactory;

/**
 * Intercepta los requests a los servlets de mi aplicacion y asegura que los
 * parametros sean validos para ser consumidos por los servlets.
 */
@WebFilter(filterName = "ValidacionHorarioInputFilter", urlPatterns = {"/registrarHorario"})
public class ValidacionHorarioInputFilter implements Filter {

  private static final Logger LOG = Logger.getLogger(ValidacionHorarioInputFilter.class.getName());
    
  private void doBeforeProcessing(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
      System.out.println("validacionfiltrohorario-dobeforeprocessing");
        HttpServletRequest req = (HttpServletRequest) request;
        req.removeAttribute("errores");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println("creando una instancia de validacion factory()");
        ValidacionFactory factory = new ValidacionFactory();
        System.out.println("creando instancia de validacion() y obtener segun");
        Validacion validacion = factory.obtenerSegun(req);
        if(validacion != null) {
            System.out.println("validamos los datos con metodo validar de horario");
            validacion.validar(req);
            
           
           hacerReenvioA(validacion.getErrores(), chain, request, response, req, validacion.getPaginaReenvio());
        }
    }        

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)         
            throws IOException, ServletException {
        System.out.println("do filter horario");
        doBeforeProcessing(request, response, chain);
        chain.doFilter(request, response);
        //doAfterProcessing(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {
    }

    private static void hacerReenvioA(Map<String, String> errores, FilterChain chain, ServletRequest request, ServletResponse response, HttpServletRequest req, String paginaReenvio) throws IOException, ServletException {
        // determinacion del lugar a donde debe ir el request
        if (errores.isEmpty()) {
            chain.doFilter(request, response);
            
            System.out.println("sin errores (valinputfilt)");
            
        } else {
            System.out.println("errores detectados ");
            req.setAttribute("errores", errores);
            System.out.println("reenviamos a index.jsp y salimos del filtro sin registrar");
            //req.getRequestDispatcher(paginaReenvio).forward(request, response);
            
            request.getRequestDispatcher(paginaReenvio).forward(request, response);
            
            LOG.log(Level.SEVERE, "Errores en el registro" + errores.keySet().toString());
        }
    }
}
