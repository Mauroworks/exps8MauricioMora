/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teatro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mauricio
 */
public class Teatro {

    /**
     * @param args the command line arguments
     */
    private static String[] arrGeneral= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
    private static String[] arrPalco= {"21","22","23","24","25","26","27","28","29","30","31","132","33","34","35","36","37","38","39","40"};
    private static String[] arrPlatea= {"41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60"};
    private static ArrayList<String> arrAsientos = new ArrayList<String>();
    private static ArrayList<Integer> arrTotal = new ArrayList<Integer>();
    private static ArrayList<String> arrUbicaciones = new ArrayList<String>();
    public static void main(String[] args) {
 
        // TODO code application logic here
       
        int opcion=0, tipoEntrada=0, ubicacion=0; 
        int precioPlatea=20000, precioPalco=30000, precioGeneral=15000;
        int cantEntradas=0, totalEntradas=0;
        int asiento = 0,id_venta=0,max_id=0;
        String asientosVenta = "",ubicacionVenta="";
        String[] asientosVandidos;
        Scanner scan = new Scanner(System.in);
        do
        {
            System.out.println("--------MENU----------");
            System.out.println("1.- Comprar Entradas");
            System.out.println("2.- Imprimir Boletas");
            System.out.println("3.- Modificar Venta");
            System.out.println("4.- Eliminar Venta");
            System.out.println("5.- Salir");
            do
            {
                System.out.println("Ingrese opción... ");
                opcion = scan.nextInt();
                if(opcion <1 || opcion >4)
                {
                    System.out.println("Opción incorrecta");
                }
            }while(opcion <1 || opcion >4);
            switch(opcion){
                case 1:
                    
                    do{
                        System.out.println("seleccione ubicación");
                        System.out.println("1 .- Platea");
                        System.out.println("2 .- Palco");
                        System.out.println("3 .- General");
                        ubicacion = scan.nextInt();
                        if(ubicacion<1 || ubicacion>3)
                        {
                            System.out.println("Ubicación incorrecta!!");
                        }
                    }while(ubicacion<1 || ubicacion>3);
                    System.out.println("Ingrese cantidad de entradas");
                    cantEntradas = scan.nextInt();
                    switch(ubicacion)
                    {
                        case 1:
                            mostrarPlatea();
                            for(int j=0;j<=cantEntradas-1;j++)
                            {
                                do{
                                System.out.println("Ingrese Asiento ");
                                asiento = scan.nextInt();
                                if(asiento<41 || asiento>60)
                                {
                                    System.out.println("Asiento Incorrecto");
                                }
                                if(arrPlatea[asiento-41].equals("V")){ System.out.println("Asiento vendido");}
                                }while(asiento<41 || asiento>60  || arrPlatea[asiento-41].equals("V"));
                                arrPlatea[asiento-41]="V";
                                asientosVenta = asientosVenta + String.valueOf(asiento) + ",";
                                
                            }
                            arrAsientos.add(asientosVenta);
                            arrUbicaciones.add("Platea");
                            totalEntradas = cantEntradas*precioPlatea;
                            arrTotal.add(totalEntradas);
                           
                            break;
                        case 2:
                            mostrarPalco();
                            for(int j=0;j<=cantEntradas-1;j++)
                            {
                                do{
                                System.out.println("Ingrese Asiento ");
                                asiento = scan.nextInt();
                                if(asiento<21 || asiento>40)
                                {
                                    System.out.println("Asiento Incorrecto");
                                }
                                if(arrPalco[asiento-21].equals("V")){System.out.println("Asiento vendido");}
                                }while(asiento<211 || asiento>40 || arrPalco[asiento-21].equals("V"));
                                arrPalco[asiento-21]="V";
                                asientosVenta = asientosVenta + String.valueOf(asiento) + ",";
                                
                            }
                            arrAsientos.add(asientosVenta);
                            arrUbicaciones.add("Palco");
                            totalEntradas = cantEntradas*precioPalco;
                            arrTotal.add(totalEntradas);
                            
                            break;
                        default:
                            mostrarGeneral();
                            for(int j=0;j<=cantEntradas-1;j++)
                            {
                                do{
                                System.out.println("Ingrese Asiento ");
                                asiento = scan.nextInt();
                                if(asiento<21 || asiento>40)
                                {
                                    System.out.println("Asiento Incorrecto");
                                }
                                if(arrPalco[asiento-21].equals("V")){System.out.println("Asiento vendido");}
                                }while(asiento<211 || asiento>40 || arrPalco[asiento-21].equals("V"));
                                arrPalco[asiento-21]="V";
                                asientosVenta = asientosVenta + String.valueOf(asiento) + ",";
                                
                            }
                            arrAsientos.add(asientosVenta);
                            arrUbicaciones.add("General");
                            totalEntradas = cantEntradas*precioGeneral;
                            arrTotal.add(totalEntradas);
                            break;
                        
                    }
                    System.out.println("Venta realizada. Solicite su boleta!!");
                    break;
                case 2:
                    max_id = arrTotal.size();
                    do{
                    System.out.println("Ingrese ID Venta");
                    id_venta = scan.nextInt();
                    if(id_venta<1 || id_venta>max_id)
                    {
                        System.out.println("Id Venta Incorrecto");
                    }
                    }while(id_venta<1 || id_venta>max_id);
                    totalEntradas = arrTotal.get(id_venta-1);
                    asientosVenta = arrAsientos.get(id_venta-1);
                    System.out.println("------BOLETA DE VENTA-------");
                    System.out.println("Asientos: " + asientosVenta);
                    System.out.println("Total boleta: " + totalEntradas);
                    System.out.println("GRACIAS POR SU COMPRA");
                    break;
                case 3:
                    max_id = arrTotal.size();
                    do{
                    System.out.println("Ingrese ID Venta");
                    id_venta = scan.nextInt();
                    if(id_venta<1 || id_venta>max_id)
                    {
                        System.out.println("Id Venta Incorrecto");
                    }
                    }while(id_venta<1 || id_venta>max_id);
                    do{
                        System.out.println("seleccione ubicación");
                        System.out.println("1 .- Platea");
                        System.out.println("2 .- Palco");
                        System.out.println("3 .- General");
                        ubicacion = scan.nextInt();
                        if(ubicacion<1 || ubicacion>3)
                        {
                            System.out.println("Ubicación incorrecta!!");
                        }
                    }while(ubicacion<1 || ubicacion>3);
                    System.out.println("Ingrese cantidad de entradas");
                    cantEntradas = scan.nextInt();
                    switch(ubicacion)
                    {
                        case 1:
                            mostrarPlatea();
                            for(int j=0;j<=cantEntradas-1;j++)
                            {
                                do{
                                System.out.println("Ingrese Asiento ");
                                asiento = scan.nextInt();
                                if(asiento<41 || asiento>60)
                                {
                                    System.out.println("Asiento Incorrecto");
                                }
                                if(arrPlatea[asiento-41].equals("V")){ System.out.println("Asiento vendido");}
                                }while(asiento<41 || asiento>60  || arrPlatea[asiento-41].equals("V"));
                                arrPlatea[asiento-41]="V";
                                asientosVenta = asientosVenta + String.valueOf(asiento) + ",";
                                
                            }
                            arrAsientos.set(id_venta-1,asientosVenta);
                            arrUbicaciones.set(id_venta-1,"Platea");
                            totalEntradas = cantEntradas*precioPlatea;
                            arrTotal.set(id_venta-1,totalEntradas);
                           
                            break;
                        case 2:
                            mostrarPalco();
                            for(int j=0;j<=cantEntradas-1;j++)
                            {
                                do{
                                System.out.println("Ingrese Asiento ");
                                asiento = scan.nextInt();
                                if(asiento<21 || asiento>40)
                                {
                                    System.out.println("Asiento Incorrecto");
                                }
                                if(arrPalco[asiento-21].equals("V")){System.out.println("Asiento vendido");}
                                }while(asiento<21 || asiento>40 || arrPalco[asiento-21].equals("V"));
                                arrPalco[asiento-21]="V";
                                asientosVenta = asientosVenta + String.valueOf(asiento) + ",";
                                
                            }
                            arrAsientos.set(id_venta-1,asientosVenta);
                            arrUbicaciones.set(id_venta-1,"Palco");
                            totalEntradas = cantEntradas*precioPalco;
                            arrTotal.set(id_venta-1,totalEntradas);
                            
                            break;
                        default:
                            mostrarGeneral();
                            for(int j=0;j<=cantEntradas-1;j++)
                            {
                                do{
                                System.out.println("Ingrese Asiento ");
                                asiento = scan.nextInt();
                                if(asiento<21 || asiento>40)
                                {
                                    System.out.println("Asiento Incorrecto");
                                }
                                if(arrPalco[asiento-21].equals("V")){System.out.println("Asiento vendido");}
                                }while(asiento<211 || asiento>40 || arrPalco[asiento-21].equals("V"));
                                arrPalco[asiento-21]="V";
                                asientosVenta = asientosVenta + String.valueOf(asiento) + ",";
                                
                            }
                            arrAsientos.set(id_venta-1,asientosVenta);
                            arrUbicaciones.set(id_venta-1,"General");
                            totalEntradas = cantEntradas*precioGeneral;
                            arrTotal.set(id_venta-1,totalEntradas);
                            break;
                        
                    }
                    System.out.println("Venta modificada. Solicite su boleta!!");
                    break;
                case 4:
                    max_id = arrTotal.size();
                    do{
                    System.out.println("Ingrese ID Venta");
                    id_venta = scan.nextInt();
                    if(id_venta<1 || id_venta>max_id)
                    {
                        System.out.println("Id Venta Incorrecto");
                    }
                    }while(id_venta<1 || id_venta>max_id);
                    
                    arrTotal.remove(id_venta-1);
                    arrAsientos.remove(id_venta-1);
                    ubicacionVenta = arrUbicaciones.get(id_venta-1);
                    switch(ubicacionVenta)
                    {
                        case "Platea":
                            asientosVandidos = asientosVenta.split(",");
                            for( int i = 0; i <= asientosVandidos.length - 1; i++)
                            {
                                if(!asientosVandidos[i].equals(""))
                                {
                                    arrPlatea[Integer.parseInt(asientosVandidos[i])-41] =  asientosVandidos[i];
                                }
                            }
                            break;
                        case "Palco":
                            asientosVandidos = asientosVenta.split(",");
                            for( int i = 0; i <= asientosVandidos.length - 1; i++)
                            {
                                if(!asientosVandidos[i].equals(""))
                                {
                                    arrPalco[Integer.parseInt(asientosVandidos[i])-21] =  asientosVandidos[i];
                                }
                            }
                            break;
                        default:
                            asientosVandidos = asientosVenta.split(",");
                            for( int i = 0; i <= asientosVandidos.length - 1; i++)
                            {
                                if(!asientosVandidos[i].equals(""))
                                {
                                    arrGeneral[Integer.parseInt(asientosVandidos[i])-1] =  asientosVandidos[i];
                                }
                            }
                            break;
                    
                    }
                    arrUbicaciones.remove(id_venta-1);
                    System.out.println("Venta eliminada");
                    break;
                
                default:
                    System.out.println("usted va a salir de la aplicación");
            }
            
            
            
            
        }while(opcion!=5);
        
    }
    
    public static void mostrarGeneral()
    {
        String newLine = System.getProperty("line.separator");
        for (int i = 0;i<=19;i++)
        {
            if(i+1==10 || i+1==20)
            {
                System.out.print(arrGeneral[i] + newLine);
            }
            else
            {
                System.out.print(arrGeneral[i] + "|");
            }
        
        }
    
    }
    
    public static void mostrarPalco()
    {
        String newLine = System.getProperty("line.separator");
        for (int i = 0;i<=19;i++)
        {
            if(i+1==10 || i+1==20)
            {
                System.out.print(arrPalco[i] + newLine);
            }
            else
            {
                System.out.print(arrPalco[i] + "|");
            }
        
        }
    
    }
    
    public static void mostrarPlatea()
    {
        String newLine = System.getProperty("line.separator");
        for (int i = 0;i<=19;i++)
        {
            if(i+1==10 || i+1==20)
            {
                System.out.print(arrPlatea[i] + newLine);
            }
            else
            {
                System.out.print(arrPlatea[i] + "|");
            }
        
        }
    
    }
    
    
}
