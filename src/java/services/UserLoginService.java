/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

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
        
        
        return(false);
    }

    
}
