/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import models.DBConnectionOptions;
import models.UserLogin;

/**
 *
 * @author George.Pasparakis
 */
public interface ICrud {
    Connection getConnection(DBConnectionOptions dbOptions);
    PreparedStatement createPreStatement(String sql);
    ResultSet execute(PreparedStatement preStatement);
    void closeConnection(PreparedStatement preStatement, Connection conn);
    
    
    ResultSet dbExecute(DBConnectionOptions dbOptions, String sql, UserLogin ul);
    
    
}
