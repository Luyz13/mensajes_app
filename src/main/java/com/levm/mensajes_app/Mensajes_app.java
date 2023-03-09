/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.levm.mensajes_app;

import java.util.Scanner;

/**
 *
 * @author levm13
 */
public class Mensajes_app {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int opcion=0;
        do{
            System.out.println("\t-------------------------------");
            System.out.println("Aplicacion de mensajes");
            System.out.println("1. Crear mensaje");
            System.out.println("2. Eliminar mensaje");
            System.out.println("3. Leer mensajes");
            System.out.println("4. Modificar mensaje");
            System.out.println("5. Salir");
            
            opcion= sc.nextInt();
            switch(opcion){
                case 1:
                    MensajeService.crearMensaje();
                    break;
                case 2:
                    MensajeService.borrarMensaje(opcion);
                    break;
                case 3:
                    MensajeService.leerMensajes();
                    break;
                case 4:
                    MensajeService.modificarMensaje();
                    break;
               default:
                   break;
            }
            
        }while(opcion != 5);
        
    }
}
