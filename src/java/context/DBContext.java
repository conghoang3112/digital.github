/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package context;

import static com.sun.faces.facelets.util.Path.context;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author CongHoangDevelop
 */

public class DBContext {
    InitialContext initial;
    Context connection;
    String dbname, serverName, portNumber, image, username, password;

    public DBContext() {
        try {
            initial = new InitialContext();
            Object obj = initial.lookup("java:comp/env");
            connection = (Context) obj;
            serverName = connection.lookup("serverName").toString();
            dbname = connection.lookup("dbName").toString();
            portNumber = connection.lookup("portNumber").toString();
            image = connection.lookup("image").toString();
            username = connection.lookup("username").toString();
            password = connection.lookup("password").toString();
        } catch (Exception e) {
        }
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbname;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, username, password);
    }
    public void closeConnection(ResultSet rs, PreparedStatement ps, Connection con) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
    public String getImage(){
        return image;
    }

}
