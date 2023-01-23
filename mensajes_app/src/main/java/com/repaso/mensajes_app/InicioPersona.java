package com.repaso.mensajes_app;

import java.util.Scanner;

/**
 *
 * @author Jean Marchesini
 */
public class InicioPersona {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("----------------------");
            System.out.println("Aplicación de Personas");
            System.out.println("1. Crear una Persona");
            System.out.println("2. Listar Personas");
            System.out.println("3. Eliminar Persona");
            System.out.println("4. Editar una Persona");
            System.out.println("5. Salir");
            
            // Leemos la opción del usuario
            opcion = sc.nextInt();
            
            switch(opcion){
                case 1:
                    PersonaService.crearPersona();
                    break;
                case 2:
                    PersonaService.listarPersonas();
                    break;
                case 3:
                    PersonaService.borrarPersona();
                    break;
                case 4:
                    PersonaService.editarPersona();2
                    break;
                default:
                    break;
            }
            
        } while (opcion != 5);


    }

}
