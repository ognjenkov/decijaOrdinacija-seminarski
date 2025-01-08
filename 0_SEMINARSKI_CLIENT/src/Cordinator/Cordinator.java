/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cordinator;

import controllers.LoginController;
import forms.LoginForm;

/**
 *
 * @author ognje
 */
public class Cordinator {
    private static Cordinator instance;
    private LoginController loginController;
    private Cordinator() {
        
    }
    public static Cordinator getInstance() {
        if(instance == null) instance = new Cordinator();
        return instance;
    }

    public void otvoriLoginFormu() {
        loginController = new LoginController(new LoginForm());
        loginController.otvoriFormu();
    }
}
