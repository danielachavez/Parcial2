/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CentroDeMando;

/**
 *
 * @author Daniela Chavez
 */
public class CentroDeMando {
     public int vida=80;
     public int oro=450;
     public int energia=400;
     public int gema=250;
     public int acido=300;
     public int money=250;
     public int fichas=250;
     public int destreza_1=10000;
     public int destreza_2=5000;
     public int destreza_3=3000;
     int destreza_11=12100;
     int destreza_22=8450;
     int destreza_33=6750;

    public int getAcido() {
        return acido;
    }

    public void setAcido(int acido) {
        this.acido = acido;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getFichas() {
        return fichas;
    }

    public void setBronce(int fichas) {
        this.fichas= fichas;
    }

     
    public int getDestreza_1() {
        return destreza_1;
    }

    public void setDestreza_1(int destreza_1) {
        this.destreza_1 = destreza_1;
    }

    public int getDestreza_2() {
        return destreza_2;
    }

    public void setDestreza_2(int destreza_2) {
        this.destreza_2 = destreza_2;
    }

    public int getDestreza_3() {
        return destreza_3;
    }

    public void setDestreza_3(int destreza_3) {
        this.destreza_3 = destreza_3;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
     public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }
    
     public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }
     public int getGema() {
        return gema;
    }

    public void setGema(int gema) {
        this.gema = gema;
    }
    public void duplicar_vida(){
        setVida(getVida()*2);
    }
    
    public void level(double mando, double mando_2, double mando_3) {
        setDestreza_1((int)mando);
        setDestreza_2((int)mando_2);
        setDestreza_3((int)mando_3);
    }

    public void mejorarEdificacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}

