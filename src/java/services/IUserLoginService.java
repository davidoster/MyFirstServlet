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

interface IUserLoginService {
    boolean validateLogin(UserLogin ul);
    boolean dbValidateLogin(UserLogin ul);
    static void koukou() { 
        System.out.println("sdfsdfdsf");
    }
}
