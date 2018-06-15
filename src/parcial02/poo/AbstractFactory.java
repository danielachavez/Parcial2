/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial02.poo;

import Gigantes.Gigante;
import Lanzarrocas.Raza;
import Verdugos.Verdugos;




/**
 *
 * @author HP PC
 */
public interface AbstractFactory {
    Raza getLanzarrocas(String type);
    Gigante getGigantes(String type);
    Verdugos getVerdugoz(String type);
    
    
    
}
