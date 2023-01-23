package com.repaso.gatosapp;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jean Marchesini
 */
public class Inicio {

    public static void main(String[] args) throws IOException {

        int opcion_menu = -1;
        String[] botones = {
            "1. Ver Gatos",
            "2. Ver Favoritos",
            "3. Salir"
        };
        
        do{
            // Menú Principal
            String opcion = (String) JOptionPane.showInputDialog(null, "Gatitos App", "Menu Principal", JOptionPane.INFORMATION_MESSAGE,
                    null, botones, botones[0]);
            
            // Validamos que opción selecciona el usuario
            for(int i = 0; i < botones.length; i++){
                if(opcion.equals(botones[i])){
                    opcion_menu = i;
                }
            }
            
            switch (opcion_menu) {
                case 0:
                    GatosService.verGatos();
                    break;
                case 1:
                    GatosService.verFavoritos();
                    break;
                default:
                    break;
            }
        }while (opcion_menu != 1);

    }

}
