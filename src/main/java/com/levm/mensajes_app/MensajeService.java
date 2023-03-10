/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.levm.mensajes_app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author levm13
 */
public class MensajeService {
    
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa tu mensaje");
        String msj= sc.nextLine();
        System.out.println("El autor:");
        String autor= sc.nextLine();
        
        Mensaje mensaje = new Mensaje(msj,autor);
        MensajesDAO.crearMensaje(mensaje);
        
    };
    public static List<Mensaje> leerMensajes() throws SQLException{
        List<Mensaje> ml = new ArrayList<Mensaje>();
        ResultSet rsMensajes=MensajesDAO.leerMensajes();
        while(rsMensajes.next()){
            Mensaje newMensaje= new Mensaje(
                    rsMensajes.getInt("id_mensaje"),
                    rsMensajes.getString("mensaje"),
                    rsMensajes.getString("autor_mensaje")
            );
            ml.add(newMensaje); 
        }
        return ml;
    }
    public static void borrarMensaje(int idMensaje){
        MensajesDAO.borrarMensaje(idMensaje);
    }
    public static void modificarMensaje(Mensaje mensaje){
        MensajesDAO.modificarMensaje(mensaje);
    }
    
}
