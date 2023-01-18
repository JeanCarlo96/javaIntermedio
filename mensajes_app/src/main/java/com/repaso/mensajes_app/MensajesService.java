package com.repaso.mensajes_app;

import java.util.Scanner;

/**
 *
 * @author Jean Marchesini
 */
public class MensajesService {

    public static void crearMensaje() {
        Scanner sc = new Scanner(System.in);
        // Petición del nombre
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();
        // Petición del autor
        System.out.println("Escribe tu nombre");
        String nombre = sc.nextLine();

        // Creación de objeto Mensajes
        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);

        MensajesDAO.crearMensajeDB(registro);
    }

    public static void listarMensaje() {
        MensajesDAO.leerMensajesDB();
    }

    public static void borrarMensaje() {
        Scanner sc = new Scanner(System.in);
        // Solicitar el id del mensaje a borrar
        System.out.println("Indique el ID del mensaje a borrar");
        int id_mensaje = sc.nextInt();

        // Llamar al método deborrar
        MensajesDAO.borrarMensajeDB(id_mensaje);
    }

    public static void editarMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu nuevo mensaje");
        String mensaje = sc.nextLine();
        
        System.out.println("Indica el id del mensaje a editar");
        int id_mensaje = sc.nextInt();
        
        Mensajes actualizacion = new Mensajes(id_mensaje);
        actualizacion.setMensaje(mensaje);
        MensajesDAO.actualizarMensajeDB(actualizacion);
    }

}
