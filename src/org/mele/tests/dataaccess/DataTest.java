package org.mele.tests.dataaccess;

import org.junit.Test;

import java.sql.*;
import java.util.Properties;

import static junit.framework.Assert.fail;

/**
 * Created by mariodimitrov on 12/26/14.
 */
public class DataTest {
    private Statement createConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        String url = "jdbc:postgresql://horton.elephantsql.com:5432/qqfldvsh";
        Properties props = new Properties();
        props.setProperty("user", "qqfldvsh");
        props.setProperty("password", "Aeslz5A1KGir1aNVSBEEDxxScjYAPGom");
        // props.setProperty("ssl","true");
        try {
            Connection conn = DriverManager.getConnection(url, props);
            Statement st = conn.createStatement();
            return st;
                 /* ResultSet rs = st.executeQuery("SELECT * FROM people");
            while (rs.next()) {
                System.out.print("Column 1 returned ");
                System.out.println(rs.getString(2));
                System.out.print("Column 2 returned ");
                System.out.println(rs.getString(3));
            }
            rs.close();
            */

        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Test
    public void testCreateVariableTable() {
        fail("Not implemented");
    }

    @Test
    public void testDropVariableTable() {
        fail("Not implemented");
    }

    @Test
    public void test() {
        Statement st = createConnection();
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM userfiles");
            while (rs.next()) {
                System.out.print("Column 1 returned ");
                System.out.println(rs.getString(2));
                System.out.print("Column 2 returned ");
                System.out.println(rs.getString(3));
                System.out.print("Column 3 returned ");
                System.out.println(rs.getString(4));
                System.out.print("Column 4 returned ");
                System.out.println(rs.getString(5));
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
