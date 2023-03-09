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
    public Connection getConnection(){
        Connection con= null;
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app","root","");
            if(con != null)
            {
                System.out.println("Conexion exitosa");
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return con;
    }
    
}
