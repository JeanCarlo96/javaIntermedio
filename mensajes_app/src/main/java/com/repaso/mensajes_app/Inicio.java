package com.repaso.mensajes_app;

/**
 *
 * @author Jean Marchesini
 */
public class Inicio {
    
    public static void main(String[] args) {
        
        Conexion conexion = new Conexion();
        
        try{
            conexion.getConnection();
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
}
