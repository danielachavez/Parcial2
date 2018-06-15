/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial02.poo;

import CentroDeMando.CentroDeMando;
import Lanzarrocas.Raza;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Daniela Chavez
 */
public class Parcial02Poo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int cont=0;
        CentroDeMando CentroMando_1=new CentroDeMando();
        CentroDeMando CentroMando_2=new CentroDeMando();
        ArrayList<Raza> generador_oro=new ArrayList<Raza>();
        ArrayList<Raza> generador_vida=new ArrayList<Raza>();
        ArrayList<Raza> generador_gema=new ArrayList<Raza>();
        ArrayList<Raza> preparar=new ArrayList<Raza>();
        ArrayList<Raza> trans1=new ArrayList<Raza>();
        ArrayList<Raza> trans2=new ArrayList<Raza>();
        ArrayList<Raza> ataque=new ArrayList<Raza>();
        ArrayList<Raza> preparados=new ArrayList<Raza>();
        ArrayList<Raza> defendiendo=new ArrayList<Raza>();
        Raza[] origen=new Raza[1];
        ArrayList<Raza> generador_oro2=new ArrayList<Raza>();
        ArrayList<Raza> generador_vida2=new ArrayList<Raza>();
        ArrayList<Raza> generador_gema2=new ArrayList<Raza>();
        ArrayList<Raza> preparar2=new ArrayList<Raza>();
        ArrayList<Raza> trans12=new ArrayList<Raza>();
        ArrayList<Raza> trans22=new ArrayList<Raza>();
        ArrayList<Raza> ataque2=new ArrayList<Raza>();
        ArrayList<Raza> preparados2=new ArrayList<Raza>();
        ArrayList<Raza> defendiendo2=new ArrayList<Raza>();
        Raza[] origen2=new Raza[1];
        Scanner auxi = new Scanner(System.in);
        int raza_1;
        int raza_2 = 0;
       
        System.out.println("");
        System.out.println("Le Mostraremos las caracteristicas de cada raza");
        System.out.println("La raza de Lanzarrocas tiene la habilidad  de que el ataque de sus tropas es el doble");
        System.out.println("La raza de Gigantes tiene la habilidad  que la vida de sus estructuras es el doble");
        System.out.println("La raza de Verdugos tiene la habilidad  de generar más recursos por turno");
        System.out.println("*****************************************************************************************************");
        System.out.println("Seleccione una raza: ");
        System.out.println("1.Verdugos");
        System.out.println("2.Lanzarrocas");
        System.out.println("3.Gigantes"); 
        
        raza_1=auxi.nextInt();
        
        
        while(raza_1!=1 && raza_1!=2 && raza_1!=3) {
            System.out.println("Por favor ingrese una raza valida para el jugador 1");
            raza_1=auxi.nextInt();
        }
        Jugador jugador_1=new Jugador( 1 , raza_1, CentroMando_1,generador_oro,generador_vida,generador_gema,preparar,trans1,trans2,preparados,ataque,defendiendo,origen);
       
        System.out.println("Ingrese la raza escogida: ");
        System.out.println("1.Verdugos");
        System.out.println("2.Lanzarrocas");
        System.out.println("1.Gigantes");                  
        raza_1=auxi.nextInt();
         while(raza_1!=1 && raza_1!=2 && raza_1!=3) {
            System.out.println("Por favor ingrese una raza valida para el jugador 2");
            raza_1=auxi.nextInt();
        }
        int contador=1, fase=1;
        Jugador jugador_2= new Jugador(2, raza_2, CentroMando_2,generador_oro2,generador_vida2,generador_gema2,preparar2,trans12,trans22,preparados2,ataque2,defendiendo2,origen2);
        Menu menu_1 = new Menu(contador, jugador_1, jugador_2);
        Menu menu_2 = new Menu(contador, jugador_2, jugador_1);
        String lanzarrocas="Lanzarrocas";
        String gigantes="Gigantes";
        String verdugos="Verdugos";
        
        System.out.println("La raza del jugador "+ jugador_1.getNum()+ " es "+ jugador_1.getRaza());
        System.out.println("La raza del jugador "+ jugador_2.getNum()+ " es "+ jugador_2.getRaza());
        while(cont!=-1){
            if(cont%2==0){  
              
                menu_1.Automatico();
                
                menu_1.M_Jugador();
                cont=jugador_1.fase(cont);
            }
            else{ 
               
                menu_2.Automatico();
                
                menu_2.M_Jugador();
                cont=jugador_2.fase(cont);
            }
        }
    }
    
}

 
 