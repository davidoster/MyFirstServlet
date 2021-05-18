/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.Crud;
import models.DBConnectionOptions;
import models.UserLogin;

/**
 *
 * @author George.Pasparakis
 */
public class UserLoginService implements IUserLoginService {

    @Override
    public boolean validateLogin(UserLogin ul) {
        return(dbValidateLogin(ul));
    }

    @Override
    public boolean dbValidateLogin(UserLogin ul) {
        Crud crud = new Crud();
        String sql = "SELECT username, password FROM users WHERE username = ? AND password = ?";
        String host      = "localhost";
        String hostPort  = "3306";
        String username  = "root";
        String password  = "root";
        String database  = "users";
        String dbOption = "useSSL=false&serverTimezone=Europe/Athens";
        DBConnectionOptions dbOptions = new DBConnectionOptions(host, hostPort, username, password, database, dbOption);
        if(crud.dbExecute(dbOptions, sql, ul) != null) {
            return true;
        }
        return(false);
    }

    
}
