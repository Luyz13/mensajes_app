/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.levm.mensajes_app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author levm13
 */
public class Mensajes_app {

    public static void main(String[] args) throws SQLException {
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
                    System.out.println("Ingrese el ID del mensaje que desea eliminar");
                    int _idMensaje = sc.nextInt();
                    MensajeService.borrarMensaje(_idMensaje);
                    break;
                case 3:
                    List<Mensaje> msjList=MensajeService.leerMensajes();
                    for(Mensaje m: msjList){
                        System.out.println("ID:" +m.getIdMensaje());
                        System.out.println("Mensaje:" +m.getMensaje());
                        System.out.println("Autor:"+m.getAutorMensaje());
                    }
                    break;
                case 4:
                    Mensaje msjUpdate= new Mensaje();
                    System.out.println("Ingresa el id del Mensaje que quieres actualizar");
                    int idMensaje=sc.nextInt();
                    msjUpdate.setIdMensaje(idMensaje);
                    System.out.println("Ingresa el nuevo mensaje");
                    String newMsj=sc.nextLine();
                    msjUpdate.setMensaje(newMsj);
                    MensajeService.modificarMensaje(msjUpdate);
                    break;
               default:
                   break;
            }
            
        }while(opcion != 5);
        
    }
}
