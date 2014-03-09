/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.cibertec.gch.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Java-ADV-LM
 */
public class JPAUtil {
    private static EntityManagerFactory emf;
    
    private JPAUtil(){}
    
    public static EntityManagerFactory getEntityManagerFactory(){
        if(emf==null){
            emf=Persistence.createEntityManagerFactory("PU_GCH");
        }
        return emf;
    }
}
