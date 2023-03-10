/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.levm.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 *
 * @author levm13
 */
public class MensajesDAO {
    
    public static void crearMensaje(Mensaje mensaje){
      Conexion conexion = Conexion.getInstance();
      try(Connection objetoConexion = conexion.doConnetion()){
        
            PreparedStatement ps = null;
            try{
                String query = "INSERT INTO Mensajes "
                        + "(mensaje, autor_mensaje,fecha_mensaje) "
                        + "VALUES (?,?,?)";
                ps=objetoConexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutorMensaje());
                ps.setString(3, LocalDateTime.now().toString());

                ps.executeUpdate();
                System.out.println("El mensaje fue creado correctamente");
            }catch(SQLException e){
                System.out.println("Error:"+e);

            }  
      }catch(SQLException e){
                System.out.println("Error:"+e);

            } 
    }
    public static ResultSet leerMensajes(){
        Conexion conexion = Conexion.getInstance();
        Connection objetoConexion = conexion.doConnetion();
        PreparedStatement ps = null;
        try{
            String query = "SELECT * FROM Mensajes";
            ps=objetoConexion.prepareStatement(query);
            return ps.executeQuery();
            
        }catch(SQLException e){
          throw new RuntimeException(e);
        }
    }
    public static void borrarMensaje(int idMensaje){
        Conexion conexion = Conexion.getInstance();
        Connection objetoConexion = conexion.doConnetion();
        PreparedStatement ps = null;
        String query = "DELETE FROM Mensajes WHERE id_mensaje = ?";
        try{
            ps=objetoConexion.prepareStatement(query);
            ps.setInt(1, idMensaje);
            int msjUpdate=ps.executeUpdate();
            if(msjUpdate != 0){
                System.out.println("El mensaje fue eliminado");
            }
            else{
                System.out.println("El mensaje No fue encontrado");
            }
       }catch(SQLException e){
            System.out.println("El mensaje no pudo ser eliminado");
            throw new RuntimeException(e);
        }
            
        
    }
    public static void modificarMensaje(Mensaje mensaje){
        Conexion conexion = Conexion.getInstance();
        Connection objetoConexion = conexion.doConnetion();
        PreparedStatement ps = null;
        String query = "UPDATE Mensajes SET mensaje = ?, fecha_mensaje = ?  WHERE id_mensaje = ?";
        try{
            ps=objetoConexion.prepareStatement(query);
            ps.setString(1, mensaje.getMensaje());
            ps.setString(2, LocalDateTime.now().toString() );
            ps.setInt(3, mensaje.getIdMensaje());
            int msjUpdate=ps.executeUpdate();
            if(msjUpdate != 0){
                System.out.println("El mensaje fue actualizado");
            }
            else{
                System.out.println("El mensaje No fue encontrado");
            }
       }catch(SQLException e){
            System.out.println("El mensaje no pudo ser eliminado");
            throw new RuntimeException(e);
        }
            
    }
}
