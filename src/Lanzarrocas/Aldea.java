/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lanzarrocas;

import Gigantes.Gigante;
import Lanzarrocas.Raza;
import Lanzarrocas.Especialista;
import RecursosLanzarrocas.G_Energia;
import RecursosLanzarrocas.G_Gema;
import RecursosLanzarrocas.G_Oro;
import VehiculoGigantes.Camion;
import VehiculoLanzarrocas.Cuadrimoto;
import Verdugos.Verdugos;
import parcial02.poo.AbstractFactory;
import parcial02.poo.Escuadrones;

/**
 *
 * @author Daniela Chavez
 */
public class Aldea implements AbstractFactory {

    @Override
    public Raza getLanzarrocas(String type) {
          switch (type) {
            case "Escuadrones":
                return new Escuadrones();
            case "Avatar":
                return new Especialista();
            case "Cuadrimoto":
                return new Cuadrimoto();
            case "Caminion":
                return new Camion();
            case "Entrenar":
                return new EntrenarLanzarrocas();
            case "Generador de Energia":
                return new G_Energia();
            case "Generador de Gema":
                return new G_Gema();
            case "Generador de Oro":
                return new G_Oro();
            /*case "Verdugos":
                return new Verdugos();
            case "Escuadrone":
                return new Escuadrons();
            case "EntrenarVedugoz":
                return new EntrenadorVerdugoz();
            case "Avioneta":
                return new Avioneta();
            case "motocicleta":
                return new Motocicleta();
            case "Generador de Fichas":
                return new G_Fichas();
            case "Generador de Amatista":
                return new G_Amatista();
            case "Generador de Acido":
                return new G_Acido();
            case "Cuadrimoto":
                return new Cuadrimoto();
            case "Camion":
                return new Camion();
            case "Generador de Monedas":
                return new G_Monedas();
            case "Generador de Hechizo":
                return new G_Hechizo();
            case "Generador de Zafiro":
                return new G_Zafiro();
            case "Gigante":
                return new Gigante();
            case "Escuadrones":
                return new Escuadrones();
            case "Entrenar":
                return new E_Gigante();
           
                */
        }
        return null;
    }

    @Override
    public Gigante getGigantes(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Verdugos getVerdugoz(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
     
}

