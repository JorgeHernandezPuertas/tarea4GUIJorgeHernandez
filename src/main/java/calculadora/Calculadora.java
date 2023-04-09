/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

import javax.swing.JFrame;

/**
 *
 * @author jorge
 */
public class Calculadora {
    
    // Main de la calculadora
    public static void main(String[] args) {
        
        // Creo la ventana d ela calculadora
        JFrame ventana = new JFrame("Calculadora");
    	ventana.setBounds(250, 250, 0, 0);
        // Le añado el panel principal que he creado
    	ventana.add(new PanelPrincipal());
   	 
        // Le doy visibilidad, el boton de salida y hago un pack para que tenga el
        // tamaño justo
    	ventana.setVisible(true);
    	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	ventana.pack();
        
    }
    
}
