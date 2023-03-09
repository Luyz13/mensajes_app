/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.levm.mensajes_app;

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
    public static void leerMensajes(){
        
    }
    public static void borrarMensaje(int idMensaje){
        
    }
    public static void modificarMensaje(){
        
    }
    
}
