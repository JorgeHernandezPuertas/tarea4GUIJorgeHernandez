/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author jorge
 */
public class PanelPrincipal extends JPanel implements ActionListener {

    // Atributos de la clase (privados)
    private PanelBotones botones;
    private JTextArea areaTexto;
    private int tipoOperacion;

    // Constructor
    public PanelPrincipal() {
        initComponents();
        tipoOperacion = -1; // No hay operaciones en la calculadora
    }

    // Se inicializan los componentes gráficos y se colocan en el panel
    private void initComponents() {
        // Creamos el panel de botones
        botones = new PanelBotones();
        // Creamos el área de texto
        areaTexto = new JTextArea(5, 30);
        areaTexto.setEditable(false);
        areaTexto.setBackground(Color.white);

        //Establecemos layout del panel principal
        this.setLayout(new BorderLayout());
        // Colocamos la botonera y el área texto
        this.add(areaTexto, BorderLayout.NORTH);
        this.add(botones, BorderLayout.SOUTH);

        // Hago que todos los botones sean actionlisteners
        for (JButton boton : this.botones.getgrupoBotones()) {
            boton.addActionListener(this);
        }

    }

    // Implemento la interfaz
    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtengo el objeto que desencadena el evento
        Object o = e.getSource();
        
        // Si es el botón de reseteo, reseteo
        if (o.equals(this.botones.grupoBotones[15])){
            areaTexto.setText("");
            
        // Si es el boton de operar, opero
        } else if (o.equals(this.botones.grupoBotones[14])){
            // Si es una expresion de calculo con dos operandos, opero
            if (this.areaTexto.getText().matches("[0-9]+[+-/*][0-9]+")){
                // Dependiendo de la operación opero
                if (this.areaTexto.getText().contains("+")){
                    String[] operandos = this.areaTexto.getText().split("\\+");
                    int operando1 = Integer.parseInt(operandos[0]);
                    int operando2 = Integer.parseInt(operandos[1]);
                    areaTexto.setText(String.valueOf(operando1 + operando2));
                } else if (this.areaTexto.getText().contains("-")){
                    String[] operandos = this.areaTexto.getText().split("-");
                    int operando1 = Integer.parseInt(operandos[0]);
                    int operando2 = Integer.parseInt(operandos[1]);
                    areaTexto.setText(String.valueOf(operando1 - operando2));
                } else if (this.areaTexto.getText().contains("*")){
                    String[] operandos = this.areaTexto.getText().split("\\*");
                    int operando1 = Integer.parseInt(operandos[0]);
                    int operando2 = Integer.parseInt(operandos[1]);
                    areaTexto.setText(String.valueOf(operando1 * operando2));
                } else {
                    String[] operandos = this.areaTexto.getText().split("/");
                    double operando1 = Double.parseDouble(operandos[0]);
                    double operando2 = Double.parseDouble(operandos[1]);
                    areaTexto.setText(String.valueOf(operando1 / operando2));
                }
            
            } // Si no es una expresion de calculo con dos operandos lo dejo igual
       
        // Si es otro botón lo escribo
        } else if (o instanceof JButton) {
            areaTexto.setText(this.areaTexto.getText() + ((JButton) o).getText());
        }
        
    }
}
