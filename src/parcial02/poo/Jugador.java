/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial02.poo;

import CentroDeMando.CentroDeMando;
import Lanzarrocas.Raza;
import java.util.ArrayList;

/**
 *
 * @author Daniela Chavez
 */
public class Jugador {

     /*public ArrayList<Integer> gen_oro;
    public ArrayList<Integer> gen_elixir;
    public ArrayList<Integer> gen_gema;
    public ArrayList<Integer> transporte1;
    public ArrayList<Integer> transporte2;
    */
    //public ArrayList<GeneradorOro> geno;
    public int num;
    public int raza;
    public CentroDeMando C_mando;
    public  ArrayList<Raza> Eco1;
    public  ArrayList<Raza> Eco2;
    public  ArrayList<Raza> Eco3;
    public  ArrayList<Raza> entrenar;
    public  ArrayList<Raza> vehiculo_1;
    public  ArrayList<Raza> vehiculo_2;
    public  ArrayList<Raza> Preparados;
    public  ArrayList<Raza> atacar;
    public  ArrayList<Raza> defendiendo;
    public Raza[] Origen;
 
    public Jugador(){
    }

    public Jugador(int num, int raza, CentroDeMando C_mando, ArrayList<Raza> Eco1, ArrayList<Raza> Eco2, ArrayList<Raza> Eco3, ArrayList<Raza> entrenar, ArrayList<Raza> vehiculo_1, ArrayList<Raza> vehiculo_2, ArrayList<Raza> Preparados, ArrayList<Raza> atacar, ArrayList<Raza> defendiendo, Raza[] Origen) {
        this.num = num;
        this.raza = raza;
        this.C_mando = C_mando;
        this.Eco1 = Eco1;
        this.Eco2 = Eco2;
        this.Eco3 = Eco3;
        this.entrenar = entrenar;
        this.vehiculo_1 = vehiculo_1;
        this.vehiculo_2 = vehiculo_2;
        this.Preparados = Preparados;
        this.atacar = atacar;
        this.defendiendo = defendiendo;
        this.Origen = Origen;
    }

    public int getRaza() {
        return raza;
    }

    public void setRaza(int raza) {
        this.raza = raza;
    }


    public Raza[] getOrigen() {
        return Origen;
    }

    public void setOrigen(Raza[] Origen) {
        this.Origen = Origen;
    }

    

    public ArrayList<Raza> getDefendiendo() {
        return defendiendo;
    }

    public void setDefendiendo(ArrayList<Raza> defendiendo) {
        this.defendiendo = defendiendo;
    }
    
    public ArrayList<Raza> getAtacar() {
        return atacar;
    }

    public void setAtacar(ArrayList<Raza> atacar) {
        this.atacar = atacar;
    }

    
    public ArrayList<Raza> getEco1() {
        return Eco1;
    }

    public void setRecurso_1(ArrayList<Raza> Eco1) {
        this.Eco1 = Eco1;
    }

    public ArrayList<Raza> getEco2() {
        return Eco2;
    }

    public void setRecurso_2(ArrayList<Raza> recurso_2) {
        this.Eco2 = Eco2;
    }

    public ArrayList<Raza> getEco3() {
        return Eco3;
    }

    public void setRecurso_3(ArrayList<Raza> Eco3) {
        this.Eco3 = Eco3;
    }

    public ArrayList<Raza> getEntrenar() {
        return entrenar;
    }

    public void setEntrenador(ArrayList<Raza> entrenar) {
        this.entrenar = entrenar;
    }

    public ArrayList<Raza> getVehiculo_1() {
        return vehiculo_1;
    }

    public void setVehiculo1(ArrayList<Raza> vehiculo_1) {
        this.vehiculo_1 = vehiculo_1;
    }

    public ArrayList<Raza> getVehiculo_2() {
        return vehiculo_2;
    }

    public void setVehiculo_2(ArrayList<Raza> vehiculo_2) {
        this.vehiculo_2 = vehiculo_2;
    }

    public CentroDeMando getC_mando() {
        return C_mando;
    }

    public void setC_mando(CentroDeMando C_mando) {
        this.C_mando = C_mando;
    }

    
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public ArrayList<Raza> getPreparados() {
        return Preparados;
    }

    public void setPreparados(ArrayList<Raza> Preparados) {
        this.Preparados = Preparados;
    }
    
    
    public int fase(int cont){
        if(cont%2==0){
            System.out.println("Es turno del jugador "+ ((cont%2)+2));
        }
        else{
            System.out.println("Es turno del jugador "+ ((cont%2)));
        }
        
        cont=cont+1;
        return cont;
    }

  
    
    
}
