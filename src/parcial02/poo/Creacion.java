/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial02.poo;

import Lanzarrocas.Aldea;

/**
 *
 * @author Daniela Chavez
 */
class Creacion {

public static AbstractFactory getFactory(String type){
        switch (type){
            case "Lanzarrocas":
                return new Aldea();
            
            
            
        }
        return null;
    }
}
