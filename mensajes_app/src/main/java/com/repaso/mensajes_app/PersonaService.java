package com.repaso.mensajes_app;

import java.util.Scanner;

/**
 *
 * @author Jean Marchesini
 */
public class PersonaService {
    
    public static void crearPersona() {
        Scanner sc = new Scanner(System.in);
        
        // Petición del nombre
        System.out.println("Escribe el nombre de la Persona");
        String nombre = sc.nextLine();
        
        // Petición de la edad
        System.out.println("Escribe su edad");
        int edad = sc.nextInt();
        
        // Limpieza del buffer
        sc.nextLine();
        
        // Petición del género
        System.out.println("Escribe el género");
        String genero = sc.nextLine();

        // Creación de objeto Persona
        Persona registro = new Persona(nombre, edad, genero);

        PersonaDAO.crearPersonaDB(registro);
    }
    
    public static void listarPersonas() {
        PersonaDAO.leerPersonasDB();
    }
    
    public static void borrarPersona() {
        Scanner sc = new Scanner(System.in);
        
        // Petición del nombre
        System.out.println("Escribe el código de la Persona a eliminar");
        int idPersona = sc.nextInt();
        
        PersonaDAO.borrarPersonaDB(idPersona);
    }
    
    public static void editarPersona() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el nombre de la Persona");
        String nombre = sc.nextLine();
        
        System.out.println("Escribe la edad de la Persona");
        int edad = sc.nextInt();
        
        // Limpiar buffer
        sc.nextLine();
        
        System.out.println("Escribe el género de la Persona");
        String genero = sc.nextLine();
        
        System.out.println("Indica el id de la Persona a editar");
        int idPersona = sc.nextInt();
        
        Persona actualizacion = new Persona(idPersona, nombre, edad, genero);
        PersonaDAO.actualizarPersonaDB(actualizacion);
    }
    
}
