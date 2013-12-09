/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.logica;

public class GestorFactory {

    public static GestorProfesor getGestorLaboratorio() {
        return new GestorProfesor();
    }
}
