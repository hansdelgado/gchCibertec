/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.util;

/**
 *
 * @author hans delgado
 */

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.util.StringUtils;
import org.springframework.web.util.HtmlUtils;
import pe.edu.cibertec.gch.annotation.Unescape;
/**
 * Class that helps unescape model strings that are sent to the Database with strange characters.
 * @author hans delgado (hans.delgado)
 *
 */
public class UnescapeUtil {

  private static final String SET_PREFIX = "set";
  private static final String GET_PREFIX = "get";

  /**
   * Recorrer todos los attributos 
   * @throws Exception 
   */
  public static void unescapeInstance(Object obj) {
    try {
      List<Field> fields = new ArrayList<Field>();
      for (Field field : getAllFields(fields, obj.getClass())) {
        // We should only unescape Strings.
        if (field.isAnnotationPresent(Unescape.class) && (String.class.isAssignableFrom(field.getType()))) {
          Method getter = obj.getClass().getMethod(GET_PREFIX + StringUtils.capitalize(field.getName()));
          Method setter = obj.getClass().getMethod(SET_PREFIX + StringUtils.capitalize(field.getName()), String.class);
          if (getter != null && setter != null) {
            setter.invoke(obj, HtmlUtils.htmlUnescape((String) getter.invoke(obj) ));
            System.out.println("Se invoca al metodo setter para el field :" + field.toString());
          }
        }
      }
      
    } catch (Exception e) {
      // Do nothing.
    }
  }
  
  /***
   * Gets all the fields including the super class ones
   * @param fields
   * @param type
   * @return all fields for an object.
   */
  public static List<Field> getAllFields(List<Field> fields, Class<?> type) {
    fields.addAll(Arrays.asList(type.getDeclaredFields()));

    if (type.getSuperclass() != null) {
        fields = getAllFields(fields, type.getSuperclass());
    }
    return fields;
  }
}
