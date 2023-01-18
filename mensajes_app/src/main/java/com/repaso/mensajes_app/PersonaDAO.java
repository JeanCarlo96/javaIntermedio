package com.repaso.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jean Marchesini
 */
public class PersonaDAO {
    
    private static final String INSERT_PERSONA = "INSERT INTO persona (nombre, edad, genero) VALUES (?, ?, ?)";
    private static final String SELECT_PERSONA = "SELECT id_persona, nombre, edad, genero FROM persona";
    private static final String DELETE_PERSONA = "DELETE FROM persona WHERE id_persona = ?";
    private static final String UPDATE_PERSONA = "UPDATE persona SET nombre = ?, edad = ?, genero = ? WHERE id_persona = ?";
    
     public static void crearPersonaDB(Persona persona) {
        Conexion db_connect = new Conexion();

        try {
            Connection conexion = db_connect.getConnection();
            PreparedStatement ps = null;
            
            ps = conexion.prepareStatement(INSERT_PERSONA);
            ps.setString(1, persona.getNombre());
            ps.setInt(2, persona.getEdad());
            ps.setString(3, persona.getGenero());
            
            ps.executeUpdate();
            
            System.out.println("Se ha insertado una persona correctamente");
            
        } catch (SQLException e) {
            System.out.println("No se pudo insertar la Persona: " + e);
        }
    }
     
     public static void leerPersonasDB() {
        Conexion db_connect = new Conexion();

        try {
            Connection conexion = db_connect.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = conexion.prepareStatement(SELECT_PERSONA);
            rs = ps.executeQuery();
            
            while(rs.next()){
                System.out.println("Id Persona: " + rs.getInt("id_persona"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Edad: " + rs.getString("edad"));
                System.out.println("Genero: " + rs.getString("genero"));
                System.out.println("");
            }
            
        } catch (SQLException e) {
            System.out.println("No se pudieron recuperar las personas");
            System.out.println(e);
        }
    }
     
     public static void borrarPersonaDB(int idPersona) {
        Conexion db_connect = new Conexion();
        
         try {
            Connection conexion = db_connect.getConnection();
            PreparedStatement ps = null;
            
            ps = conexion.prepareStatement(DELETE_PERSONA);
            ps.setInt(1, idPersona);
            
            ps.executeUpdate();
            
            System.out.println("La persona ha sido borrado");
        } catch (SQLException e) {
            System.out.println("No se pudo borrar la persona");
            System.out.println(e);
        }
    }
     
    public static void actualizarPersonaDB(Persona persona) {
        Conexion db_connect = new Conexion();
        
         try {
            Connection conexion = db_connect.getConnection();
            PreparedStatement ps = null;
            
            ps = conexion.prepareStatement(UPDATE_PERSONA);
            
            ps.setString(1, persona.getNombre());
            ps.setInt(2, persona.getEdad());
            ps.setString(3, persona.getGenero());
            ps.setInt(4, persona.getIdPersona());
            
            ps.executeUpdate();
            
            System.out.println("La Persona se ha actualizado correctamente");
        } catch (SQLException e) {
            System.out.println("No se pudo actualizar a la Persona");
            System.out.println(e);
        }
    }
    
}
