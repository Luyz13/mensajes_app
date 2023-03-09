/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.levm.mensajes_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author levm13
 */
public class Conexion {
     private Conexion(){
        
    }
    
    
    //variable que almacena el estado de la conexion de la base de datos
    private static Connection connection;
    
    //variable para crear una sola instancia
    private static Conexion instancia;
    
    //variables de la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/mensajes_app";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public Connection doConnetion (){
        
        try {
            
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            
            System.out.println("CONEXION EXITOSA");
            
            return connection;
            
        } catch (SQLException e) {
             System.out.println("ERROR: " + e);
        }
        
        return connection;
        
    }
    
    
    public void closeConnetion () throws SQLException{
         
         try {
             connection.close();
             System.out.println("Desconexion");
             
         } catch (SQLException e) {
             System.out.println("Error: " + e);
             connection.close();
         } finally {
             connection.close();
         }
         
     }
    
    //patron singleton
    public static Conexion getInstance(){
        
        if(instancia == null){
            instancia = new Conexion ();
        }
        return instancia;
    }
}
   
