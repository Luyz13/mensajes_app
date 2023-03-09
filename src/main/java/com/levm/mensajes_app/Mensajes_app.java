/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.levm.mensajes_app;

import java.sql.Connection;

/**
 *
 * @author levm13
 */
public class Mensajes_app {

    public static void main(String[] args) {
        Conexion con = new Conexion();
        try(Connection cnx = con.getConnection())
        {
            
        }
        catch(Exception e){
            System.out.println(e);
            
        }
    }
}
