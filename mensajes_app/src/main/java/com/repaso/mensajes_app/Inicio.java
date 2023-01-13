package com.repaso.mensajes_app;

import java.util.Scanner;

/**
 *
 * @author Jean Marchesini
 */
public class Inicio {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("----------------------");
            System.out.println("Aplicación de Mensajes");
            System.out.println("1. Crear un mensaje");
            System.out.println("2. Listar un mensaje");
            System.out.println("3. Eliminar un mensaje");
            System.out.println("4. Editar un mensaje");
            System.out.println("5. Salir");
            
            // Leemos la opción del usuario
            opcion = sc.nextInt();
            
            switch(opcion){
                case 1:
                    MensajesService.crearMensaje();
                    break;
                case 2:
                    MensajesService.listarMensaje();
                    break;
                case 3:
                    MensajesService.borrarMensaje();
                    break;
                case 4:
                    MensajesService.editarMensaje();
                    break;
                default:
                    break;
            }
            
        } while (opcion != 5);


    }

}
