/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import interfaz.ventanas.GerenteMain;
import interfaz.ventanas.LoginFrame;

/**
 *
 * @author jairi
 */
public class Main {
    public static void main(String[] args) {
        
        //Aplicar la escala de toda la aplicacion
        System.setProperty("flatlaf.uiScale", "1.25");
        //Seleccionar el paquete de los estilos
        FlatLaf.registerCustomDefaultsSource("styles");
        //Iniciar faltlaf
        FlatLightLaf.setup();
        //Mostramos la ventana de login
        //new GerenteMain().setVisible(true);
        new LoginFrame().setVisible(true);
    }
}
