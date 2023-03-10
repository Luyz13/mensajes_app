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
        Connection objetoConexion = conexion.doConnetion();
        
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
        
    }
    public static void modificarMensaje(Mensaje mensaje){
        
    }
}
