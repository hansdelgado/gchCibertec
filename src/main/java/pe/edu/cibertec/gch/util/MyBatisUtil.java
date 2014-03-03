/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.util;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author portatil
 */
public class MyBatisUtil {

    protected static final SqlSessionFactory SQL_SESSION_FACTORY;

    static {
        try {
            Reader reader = Resources.getResourceAsReader(
                    "pe/edu/cibertec/data/SQLMapConfig.xml");

            SQL_SESSION_FACTORY =
                    new SqlSessionFactoryBuilder().build(reader);

        } catch (Exception e) {
            throw new RuntimeException("Error: " + e);
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return SQL_SESSION_FACTORY;
    }
}