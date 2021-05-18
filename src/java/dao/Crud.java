/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.DBConnectionOptions;
import models.UserLogin;

/**
 *
 * @author George.Pasparakis
 */
public class Crud implements ICrud {

    @Override
    public Connection getConnection(DBConnectionOptions dbOptions) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PreparedStatement createPreStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet execute(PreparedStatement preStatement) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeConnection(PreparedStatement preStatement, Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet dbExecute(DBConnectionOptions dbOptions, String sql, UserLogin ul) {
        Connection conn;
        String url = "jdbc:mysql://" + dbOptions.getHost() + ":" 
                                     + dbOptions.getHostPort() + "/" 
                                     + dbOptions.getDatabase() + "?"
                                     + dbOptions.getDbOptions(); // useSSL=false&serverTimezone=Europe/Athens
        
        try {
            conn = DriverManager.getConnection(url, dbOptions.getUsername(), dbOptions.getPassword());
            String preStatement = sql; // "SELECT username, password FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(preStatement);
            ps.setString(1, ul.getUsername());
            ps.setString(2, ul.getPassword());
//            ps.setString(1, "admin");
//            ps.setString(2, "admin");
            boolean bReturnValue = ps.execute() && ps.getResultSet().next();
            if(bReturnValue) {
                return(ps.getResultSet());
            }
        } catch(SQLException e) {
            System.out.println("Oooops");
        }
        return(null);
    }
    
}
