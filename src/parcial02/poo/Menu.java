/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial02.poo;

import Lanzarrocas.Raza;
import java.util.Scanner;

/**
 *
 * @author Daniela Chavez
 */
public class Menu {
    public int contador;
    public Jugador jugador;
    public Jugador prox;
    public static Menu menu;
    
     public Menu() {
    }

    public Menu(int contador, Jugador jugador, Jugador prox) {
        this.contador = contador;
        this.jugador = jugador;
        this.prox = prox;
    }

    public Jugador getProx() {
        return prox;
    }

    public void setProx(Jugador prox) {
        this.prox = prox;
    }
    
    
    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
     
    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    public static Menu getInstance(){
        if(menu==null){
            menu = new Menu();
        }
        return menu;
    }
    public void Automatico(){
        int ataque1=10, ataque2=15;
        AbstractFactory factory;
        factory = Creacion.getFactory("Lanzarrocas");
        Raza oro_1 = factory.getLanzarrocas("Generador de Oro");
        Raza energia_1 = factory.getLanzarrocas("Generador de Energia");
        Raza gema_1 = factory.getLanzarrocas("Generador de Gema");
        Raza escuadron = factory.getLanzarrocas("Escuadrones");
        for (int i = 0; i < getJugador().getEco2().size(); i++) {
                        energia_1=getJugador().getEco2().get(i);
                        if(getJugador().getRaza()==1){
                            energia_1.generar_doble();
                        }
                        else{
                        energia_1.generar();
                        }
                    }
        for (int i = 0; i < getJugador().getEco2().size(); i++) {
            energia_1 = getJugador().getEco2().get(i);
            int num = energia_1.recolectar();
                        int num1 = getJugador().getC_mando().getEnergia();
                        int sum2 = num + num1; 
                        getJugador().getC_mando().setEnergia(sum2);
                        

                    }
                   for (int i = 0; i < getJugador().getEco1().size(); i++) {
                        oro_1=getJugador().getEco1().get(i);
                        if(getJugador().getRaza()==1){
                            oro_1.generar_doble();
                        }
                        else{
                        oro_1.generar();
                        }
               
                    }
                    
                    for (int i = 0; i < getJugador().getEco3().size(); i++) {
                        gema_1=getJugador().getEco3().get(i);
                        if(getJugador().getRaza()==1){
                            gema_1.generar_doble();
                        }
                        else{
                        gema_1.generar();
                        }
                       
                    }
                    for (int i = 0; i < getJugador().getAtacar().size(); i++) {
                        escuadron = getJugador().getAtacar().get(i);
                        if (escuadron.lista() == 1) {
                            int ubi = escuadron.ubicacion();
                            getProx().getEco1().get(ubi).modificar_vida(5);
                            if (getProx().getEco1().get(ubi).vida() < 1) {
                                System.out.println("El Generador a sido destruido " + ubi);
                                getProx().getEco1().remove(ubi);
                                System.out.println("El escuadron esta disponible para un nuevo ataque");
                                getJugador().getPreparados().add(escuadron);
                                getJugador().getAtacar().remove(i);

                            } else {
                                System.out.println("No se ha destruido el generador de oro numero " + ubi);
                            }
                        }
                        else if(escuadron.lista()==2){
                            int ubi=escuadron.ubicacion();
                            getProx().getEco2().get(ubi).modificar_vida(5);
                            if (getProx().getEco2().get(ubi).vida() < 1) {
                                System.out.println("Se ha destruido el generador " + ubi);
                                getProx().getEco2().remove(ubi);
                                System.out.println("El escuadron esta disponible para un nuevo ataque");
                                getJugador().getPreparados().add(escuadron);
                                getJugador().getAtacar().remove(i);

                            } else {
                                System.out.println("No se ha destruido el generador de energia numero " + ubi);
                            }
                        }
                        else if(escuadron.lista()==3){
                            int ubi=escuadron.ubicacion();
                            getProx().getEco3().get(ubi).modificar_vida(5);
                            if (getProx().getEco3().get(ubi).vida() < 1) {
                                System.out.println("Se ha destruido el generador " + ubi);
                                getProx().getEco3().remove(ubi);
                                System.out.println("El escuadron esta disponible para un nuevo ataque");
                                getJugador().getPreparados().add(escuadron);
                                getJugador().getAtacar().remove(i);

                            } else {
                                System.out.println("No se ha destruido el generador de gemas número " + ubi);
                            }
                        }
                        else if(escuadron.lista()==4){
                            int ubi=escuadron.ubicacion();
                            getProx().getEntrenar().get(ubi).modificar_vida(5);
                            if (getProx().getEntrenar().get(ubi).vida() < 1) {
                                System.out.println("Se ha destruido el edificio de entrenamiento " + ubi);
                                getProx().getEntrenar().remove(ubi);
                                System.out.println("El escuadron esta disponible para un nuevo ataque");
                                getJugador().getPreparados().add(escuadron);
                                getJugador().getAtacar().remove(i);

                            } else {
                                System.out.println("No se ha destruido el edificio de entrenamiento numero " + ubi);
                            }
                        }
                        else if(escuadron.lista()==5){
                            int ubi=escuadron.ubicacion();
                            getProx().getVehiculo_1().get(ubi).modificar_vida(5);
                            if (getProx().getVehiculo_1().get(ubi).vida() < 1) {
                                System.out.println("Se Se ha destruido el  edificio de vehiculos tipo 1 numero " + ubi);
                                getProx().getVehiculo_1().remove(ubi);
                                System.out.println("El escuadron esta disponible para un nuevo ataque");
                                getJugador().getPreparados().add(escuadron);
                                getJugador().getAtacar().remove(i);

                            } else {
                                System.out.println("No se ha destruido el edificio de vehiculo tipo 1 numero " + ubi);
                            }
                        }
                        else if(escuadron.lista()==6){
                            int ubi=escuadron.ubicacion();
                            getProx().getVehiculo_2().get(ubi).modificar_vida(5);
                            if (getProx().getVehiculo_2().get(ubi).vida() < 1) {
                                System.out.println("Se ha destruido el  edificio de vehiculos tipo 2 numero " + ubi);
                                getProx().getVehiculo_2().remove(ubi);
                                System.out.println("El escuadron esta disponible para un nuevo ataque");
                                getJugador().getPreparados().add(escuadron);
                                getJugador().getAtacar().remove(i);

                            } else {
                                System.out.println("No se ha destruido el edificio de vehiculo tipo 2 numero " + ubi);
                            }
                        }
                        else if(escuadron.lista()==7){
                            
                        }
                    }
        
    }
    public void M_Lanzarroca(){
        System.out.println("El Oro disponible es "+getJugador().getC_mando().getOro());
            System.out.println("La energia disponible es "+getJugador().getC_mando().getEnergia());
            System.out.println("Las Gemas a su disposicion es "+getJugador().getC_mando().getGema());
            System.out.println("\n********JUGADOR********/n");
            System.out.println("1. Recoger Oro");
            System.out.println("2. Recoger Gemas");
            System.out.println("3. Atacar al oponente");
            System.out.println("4. Defender ataque del oponente");
            System.out.println("5. Crear generador de Oro (210 gema & 60 elixir)");
            System.out.println("6. Crear generador de energia (210 oro & 60 gema"); 
            System.out.println("7. Crear generador de gemas (210 elixir & 60 oro"); 
            System.out.println("8. Crear edificacion para entrenar especialistas y escuadrones (210 gema & 60 elixir)");
            System.out.println("9. Crear edificación para vehiculos tipo 1 (210 oro & 60 gema)");
            System.out.println("10. Crear edificación para vehiculos tipo 2 (210 elixir & 60 oro)");
            System.out.println("11. Mejorar centro de Mando");
            System.out.println("12. Entrenar tropas");
            System.out.println("13. Fin del turno");
            System.out.println("14. Rendirse");
    }
    public void M_Gigante(){
        System.out.println("Las Moneda a su disposicion es "+getJugador().getC_mando().getOro());
            System.out.println("El Hechizo a su disposicion es "+getJugador().getC_mando().getEnergia());
            System.out.println("Los Zafiros a su disposicion es "+getJugador().getC_mando().getGema());
            System.out.println("\n********JUGADOR********");
            System.out.println("1. Recoger Monedas");
            System.out.println("2. Recoger Zafiros");
            System.out.println("3. Atacar al oponente");
            System.out.println("4. Defender ataque del oponente");
            System.out.println("5. Crear generador de Monedas (210 rubi & 60 posion)");
            System.out.println("6. Crear generador de Hechizos (210 plata & 60 rubi)"); 
            System.out.println("7. Crear generador de Zafiros (210 posion & 60 plata)"); 
            System.out.println("8. Crear edificacion para entrenar especialistas y escuadrones (210 rubi & 60 posion )");
            System.out.println("9. Crear edificación para vehiculos tipo 1 (210 plata & 60 rubi)");
            System.out.println("10. Crear edificación para vehiculos tipo 2 (210 posion & 60 plata)");
            System.out.println("11. Mejorar centro de Mando");
            System.out.println("12. Entrenar tropas");
            System.out.println("13. Fin del turno");
            System.out.println("14. Rendirse");
    }
    public void M_Verdugo(){
        System.out.println("La Fichas a su disposicion es "+getJugador().getC_mando().getOro());
            System.out.println("El Acido a su disposicion es "+getJugador().getC_mando().getEnergia());
            System.out.println("Las Amatista a su disposicion es "+getJugador().getC_mando().getGema());
            System.out.println("\n********JUGADOR********/n");
            System.out.println("1. Recoger Fichas");
            System.out.println("2. Recoger Amatista");
            System.out.println("3. Atacar al rival");
            System.out.println("4. Defender ataque del oponente");
            System.out.println("5. Crear generador de Fichas (210 diamante & 60 lava)");
            System.out.println("6. Crear generador de Acido  (210 bronce & 60 diamante)"); 
            System.out.println("7. Crear generador de Amatista (210 lava & 60 bronce)"); 
            System.out.println("8. Crear edificacion para entrenar especialistas y escuadrones (210 diamante & 60 lava)");
            System.out.println("9. Crear edificación para vehiculos tipo 1 (210 bronce & 60 diamante)");
            System.out.println("10. Crear edificación para vehiculos tipo 2 (210 lava & 60 bronce)");
            System.out.println("11. Mejorar centro de Mando");
            System.out.println("12. Entrenar tropas");
            System.out.println("13. Fin del turno");
            System.out.println("14. Rendirse");
    }
    
    public void M_Jugador(){
        int opc=0,ataque_1=10,ataque_2=15;
        do{
            if(1==(getJugador().getRaza())){
                    M_Lanzarroca();
                }
                
                if(2==(getJugador().getRaza())){
                    M_Verdugo();
                }
                if(3==(getJugador().getRaza())){
                   M_Gigante();
                }
         int precio1=150, precio2=50;
           
            AbstractFactory factory;
            factory = Creacion.getFactory("Lanzarrocas");
            Raza oro_1 = factory.getLanzarrocas("Generador de Oro");
            Raza energia_1 = factory.getLanzarrocas("Generador de Energia");
            Raza gema_1 = factory.getLanzarrocas("Generador de Gema");
            Raza escuadron = factory.getLanzarrocas("Escuadrones");

            Scanner auxi = new Scanner(System.in);

            try{
                System.out.println("\nEscoge una opción: ");
                opc = auxi.nextInt();
            }
            catch(Exception e){
                System.err.println("\nNo ingresó un numero valido\n");
            }
            
            switch(opc){    
                case 1:
               
                        getJugador().getC_mando().setOro( getJugador().getC_mando().getOro()-100);
                        getJugador().getC_mando().setEnergia( getJugador().getC_mando().getEnergia()-100);
                        for (int i = 0; i <getJugador().getEco1().size(); i++) {
                        oro_1 = getJugador().getEco1().get(i);
                        int num = oro_1.recolectar();                    
                        int num1 = getJugador().getC_mando().getOro();
                        int sum = num + num1;
                        getJugador().getC_mando().setOro(sum);
                    }
                    System.out.println("Se almaceno");
                   
                    break;
                case 2:
                    
                    for (int i = 0; i < getJugador().getEco3().size(); i++) {
                        gema_1 = getJugador().getEco3().get(i);
                        int num = gema_1.recolectar();
                        int num1 = getJugador().getC_mando().getGema();
                        int sum = num + num1;
                        getJugador().getC_mando().setGema(sum);
                    }
                    System.out.println("Se almaceno ");
                    break;
                case 3:
                    if (getJugador().getVehiculo_2().size() > 0 || getJugador().getVehiculo_1().size() > 0) {

                        if (getJugador().getPreparados().size() > 0 || getJugador().getOrigen()[0] != null) {
                            System.out.println("¿Que le desea atacar al oponente?");
                            System.out.println("1. Generador de Oro");
                            System.out.println("2. Generador de Energia");
                            System.out.println("3. Generador de Gemas");
                            System.out.println("4. Edificación de entrenamiento");
                            System.out.println("5. Edificacion de vehiculos tipo 1");
                            System.out.println("6. Edificación vehiculos tipo 2");
                            System.out.println("7. Centro de mando");
                            Scanner auxin = new Scanner(System.in);
                            Scanner auxiv = new Scanner(System.in);
                            int x, y;
                            x = auxin.nextInt();
                            int exist = 15;
                            int cont = 0;
                            int dist = 1000;
                            int cifra_1=1;
                            int cifra_2=2;
                            System.out.println("¿En qué tipo de vehiculo desea mandar a sus tropas?");
                            System.out.println("1. Vehiculo de tipo 1");
                            System.out.println("2. Vehiculo de tipo 2");
                            y = auxiv.nextInt();
                            while (y != cifra_1 && y != cifra_2) {
                                System.out.println("¿En qué tipo de vehiculo desea mandar a sus tropas?");
                                System.out.println("1. Vehiculo de tipo 1");
                                System.out.println("2. Vehiculo de tipo 2");
                                y = auxiv.nextInt();
                            }
                            
                             
                            factory = Creacion.getFactory("Lanzarrocas");
                            Raza orig = factory.getLanzarrocas("Generador");
                            
                            switch (x) {
                                case 1:
                                    if (getProx().getEco1().size() > 0) {
                                        int cantidad = getProx().getEco1().size();
                                        Scanner auxin2 = new Scanner(System.in);
                                        System.out.println("¿Cuál de los " + cantidad + " generadores de oro desea atacar?");
                                        int ubi = auxin2.nextInt();
                                        ubi = ubi - 1;
                                        int x_2;
                                        System.out.println("¿Con qué desea atacar?");
                                        System.out.println("1. Con el escuadron");
                                        System.out.println("2. Con el especialista");
                                        x_2 = auxin.nextInt();
                                        if (x_2 == 1) {
                                            if (getJugador().getEntrenar().size() > 0) {
                                                if (y == 1) {
                                                    if (getJugador().getVehiculo_1().size() > 0) {
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo_2().size() > 0) {
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    }
                                                }

                                                int adm = getJugador().getEntrenar().size();
                                                adm = adm - 1;
                                                factory = Creacion.getFactory("Lanzarrocas");
                                                Raza escuadron_1 = factory.getLanzarrocas("Escuadrones");
                                                escuadron_1 = getJugador().getPreparados().get(adm);
                                                escuadron_1.modificar_lista(1);
                                                escuadron_1.modificar_ubicacion(ubi);
                                                getJugador().getAtacar().add(escuadron_1);
                                                getJugador().getPreparados().remove(adm);
                                                getProx().getEco1().get(ubi).modificar_vida(5);
                                                if (getProx().getEco1().get(ubi).vida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else { 
                                                System.out.println("No tiene escuadrones disponibles");
                                            }
                                        } else if (x_2 == 2) {
                                            if (getJugador().getOrigen()[0] != null) {
                                                if (y == 1) {
                                                    if (getJugador().getVehiculo_1().size() > 0) {
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo_2().size() > 0) {
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    }
                                                }

                                                factory = Creacion.getFactory("Lanzarroca");
                                                Raza escuadron_2 = factory.getLanzarrocas("Especialista");
                                                escuadron_2.modificar_lista(1);
                                                escuadron_2.modificar_ubicacion(ubi);
                                                getJugador().getAtacar().add(escuadron_2);
                                                getProx().getEco1().get(ubi).modificar_vida(ataque_2);
                                                if (getProx().getEco1().get(ubi).vida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else {
                                                System.out.println("No tiene especialitas disponibles");
                                            }

                                        }

                                    } else {
                                        System.out.println("El rival no posee generadores de Oro");
                                    }
                                    break;

                                case 2:
                                    if (getProx().getEco2().size() > 0) {
                                        int cantidad = getProx().getEco2().size();
                                        Scanner auxin2 = new Scanner(System.in);
                                        System.out.println("¿Cuál de los " + cantidad + " generadores de vida desea atacar?");
                                        int ubi = auxin2.nextInt();
                                        ubi = ubi - 1;
                                        int x_2;
                                        System.out.println("¿Con qué desea atacar?");
                                        System.out.println("1. Con el escuadron");
                                        System.out.println("2. Con el especialista");
                                        x_2 = auxin.nextInt();
                                        if (x_2 == 1) {
                                            if (getJugador().getEntrenar().size() > 0) {
                                                if (y == 1) {
                                                    if (getJugador().getVehiculo_1().size() > 0) {
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo_2().size() > 0) {
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    }
                                                }

                                                int adm = getJugador().getEntrenar().size();
                                                adm = adm - 1;
                                                factory = Creacion.getFactory("Lanzarrocas");
                                                Raza escuadron_1 = factory.getLanzarrocas("Escuadrones");
                                                escuadron_1 = getJugador().getEntrenar().get(adm);
                                                escuadron_1.modificar_lista(2);
                                                escuadron_1.modificar_ubicacion(ubi);
                                                getJugador().getAtacar().add(escuadron_1);
                                                getJugador().getPreparados().remove(adm);
                                                getProx().getEco2().get(ubi).modificar_vida(5);
                                                if (getProx().getEco2().get(ubi).vida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else {
                                                System.out.println("No tiene escuadrones disponibles");
                                            }
                                        } else if (x_2 == 2) {
                                            if (getJugador().getOrigen()[0] != null) {
                                                if (y == 1) {
                                                    if (getJugador().getVehiculo_1().size() > 0) {
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo_2().size() > 0) {
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    }
                                                }

                                                getProx().getEco2().get(ubi).modificar_vida(20);
                                                if (getProx().getEco2().get(ubi).vida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else {
                                                System.out.println("No tiene especialistas disponibles");
                                            }

                                        }

                                    } else {
                                        System.out.println("El rival no posee generadores de Energia");
                                    }
                                    break;
                                case 3:
                                    if (getProx().getEco3().size() > 0) {
                                        int cantidad = getProx().getEco3().size();
                                        Scanner auxin2 = new Scanner(System.in);
                                        System.out.println("¿Cuál de los " + cantidad + " generadores de gema desea atacar?");
                                        int ubi = auxin2.nextInt();
                                        ubi = ubi - 1;
                                        int x_2;
                                        System.out.println("¿Con qué desea atacar?");
                                        System.out.println("1. Con el escuadron");
                                        System.out.println("2. Con el especialista");
                                        x_2 = auxin.nextInt();
                                        if (x_2 == 1) {
                                            if (getJugador().getEntrenar().size() > 0) {
                                                if (y == 1) {
                                                    if (getJugador().getVehiculo_1().size() > 0) {
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo_2().size() > 0) {
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    }
                                                }

                                                int adm = getJugador().getPreparados().size();
                                                adm = adm - 1;
                                                factory = Creacion.getFactory("Lanzarrocas");
                                                Raza escuadrones_1 = factory.getLanzarrocas("Escuadrones");
                                                escuadrones_1 = getJugador().getPreparados().get(adm);
                                                escuadrones_1.modificar_lista(3);
                                                escuadrones_1.modificar_ubicacion(ubi);
                                                getJugador().getAtacar().add(escuadrones_1);
                                                getJugador().getPreparados().remove(adm);
                                                getProx().getEco3().get(ubi).modificar_vida(ataque_1);
                                                if (getProx().getEco3().get(ubi).vida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else {
                                                System.out.println("No tiene escuadrones disponibles");
                                            }
                                        } else if (x_2 == 2) {
                                            if (getJugador().getOrigen()[0] != null) {
                                                if (y == 1) {
                                                    if (getJugador().getVehiculo_1().size() > 0) {
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo_2().size() > 0) {
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    }
                                                }

                                                getProx().getEco3().get(ubi).modificar_vida(20);
                                                if (getProx().getEco3().get(ubi).vida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else {
                                                System.out.println("No tiene especialitas disponibles");
                                            }

                                        }

                                    } else {
                                        System.out.println("El rival no posee generadores de Gema");
                                    }
                                    break;

                                case 4:
                                    if (getProx().getEntrenar().size() > 0) {
                                        int cantidad = getProx().getEntrenar().size();
                                        Scanner auxin2 = new Scanner(System.in);
                                        System.out.println("¿Cuál de los " + cantidad + " edificios de entrenamiento desea atacar?");
                                        int ubi = auxin2.nextInt();
                                        ubi = ubi - 1;
                                        int x_2;
                                        System.out.println("¿Con qué desea atacar?");
                                        System.out.println("1. Con el escuadron");
                                        System.out.println("2. Con el especialista");
                                        x_2 = auxin.nextInt();
                                        if (x_2 == 1) {
                                            if (getJugador().getPreparados().size() > 0) {
                                                if (y == 1) {
                                                    if (getJugador().getVehiculo_1().size() > 0) {
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo_2().size() > 0) {
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    }
                                                }

                                                int adm = getJugador().getPreparados().size();
                                                adm = adm - 1;
                                                factory = Creacion.getFactory("Lanzarrocas");
                                                Raza escuadron_1 = factory.getLanzarrocas("Escuadrones");
                                                escuadron_1 = getJugador().getPreparados().get(adm);
                                                escuadron_1.modificar_lista(4);
                                                escuadron_1.modificar_ubicacion(ubi);
                                                getJugador().getAtacar().add(escuadron_1);
                                                getJugador().getPreparados().remove(adm);
                                                getProx().getEntrenar().get(ubi).modificar_vida(ataque_1);
                                                if (getProx().getEntrenar().get(ubi).vida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else {
                                                System.out.println("No tiene escuadrones disponibles");
                                            }
                                        } else if (x_2 == 2) {
                                            if (getJugador().getOrigen()[0] != null) {
                                                if (y == 1) {
                                                    if (getJugador().getVehiculo_1().size() > 0) {
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo_2().size() > 0) {
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    }
                                                }

                                                getProx().getEntrenar().get(ubi).modificar_vida(20);
                                                if (getProx().getEntrenar().get(ubi).vida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else {
                                                System.out.println("No tiene especialistas disponibles");
                                            }

                                        }

                                    } else {
                                        System.out.println("El rival no posee edificaciones de entrenamiento");
                                    }
                                    break;
                                case 5:
                                    if (getProx().getVehiculo_1().size() > 0) {
                                        int cantidad = getProx().getVehiculo_1().size();
                                        Scanner auxin2 = new Scanner(System.in);
                                        System.out.println("¿Cuál de los " + cantidad + " vehiculos tipo 1 desea atacar?");
                                        int ubi = auxin2.nextInt();
                                        ubi = ubi - 1;
                                        int x_2;
                                        System.out.println("¿Con qué desea atacar?");
                                        System.out.println("1. Con el escuadron");
                                        System.out.println("2. Con el especialista");
                                        x_2 = auxin.nextInt();
                                        if (x_2 == 1) {
                                            if (getJugador().getPreparados().size() > 0) {
                                                if (y == 1) {
                                                    if (getJugador().getVehiculo_1().size() > 0) {
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo_2().size() > 0) {
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    }
                                                }

                                                int adm = getJugador().getPreparados().size();
                                                adm = adm - 1;
                                                factory = Creacion.getFactory("Lanzarrocas");
                                                Raza escuadrones_1 = factory.getLanzarrocas("Escuadrones");
                                                escuadrones_1 = getJugador().getPreparados().get(adm);
                                                escuadrones_1.modificar_lista(5);
                                                escuadrones_1.modificar_ubicacion(ubi);
                                                getJugador().getAtacar().add(escuadrones_1);
                                                getJugador().getPreparados().remove(adm);
                                                getProx().getVehiculo_1().get(ubi).modificar_vida(ataque_1);
                                                if (getProx().getVehiculo_1().get(ubi).vida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else {
                                                System.out.println("No tiene escuadrones disponibles");
                                            }
                                        } else if (x_2 == 2) {
                                            if (getJugador().getOrigen()[0] != null) {
                                                if (y == 1) {
                                                    if (getJugador().getVehiculo_1().size() > 0) {
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo_2().size() > 0) {
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    }
                                                }

                                                getProx().getVehiculo_1().get(ubi).modificar_vida(20);
                                                if (getProx().getVehiculo_1().get(ubi).vida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else {
                                                System.out.println("No tiene especialistas disponibles");
                                            }

                                        }

                                    } else {
                                        System.out.println("El rival no posee vehiculos de tipo 1");
                                    }
                                    break;
                                case 6:
                                    if (getProx().getVehiculo_2().size() > 0) {
                                        int cantidad = getProx().getVehiculo_2().size();
                                        Scanner auxin2 = new Scanner(System.in);
                                        System.out.println("¿Cuál de los " + cantidad + " vehiculos tipo 2 desea atacar?");
                                        int ubi = auxin2.nextInt();
                                        ubi = ubi - 1;
                                        int x_2;
                                        System.out.println("¿Con qué desea atacar?");
                                        System.out.println("1. Con el escuadron");
                                        System.out.println("2. Con el especialista");
                                        x_2 = auxin.nextInt();
                                        if (x_2 == 1) {
                                            if (getJugador().getPreparados().size() > 0) {
                                                if (y == 1) {
                                                    if (getJugador().getVehiculo_1().size() > 0) {
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo_2().size() > 0) {
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    }
                                                }

                                                int adm = getJugador().getPreparados().size();
                                                adm = adm - 1;
                                                factory = Creacion.getFactory("Lanzarrocas");
                                                Raza escuadrones_1 = factory.getLanzarrocas("Escuadrones");
                                                escuadrones_1 = getJugador().getPreparados().get(adm);
                                                escuadrones_1.modificar_lista(6);
                                                escuadrones_1.modificar_ubicacion(ubi);
                                                getJugador().getAtacar().add(escuadrones_1);
                                                getJugador().getPreparados().remove(adm);
                                                getProx().getVehiculo_2().get(ubi).modificar_vida(ataque_1);
                                                if (getProx().getVehiculo_2().get(ubi).vida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else {
                                                System.out.println("No tiene escuadrones disponibles");
                                            }
                                        } else if (x_2 == 2) {
                                            if (getJugador().getOrigen()[0] != null) {
                                                if (y == 1) {
                                                    if (getJugador().getVehiculo_1().size() > 0) {
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo_2().size() > 0) {
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    }
                                                }

                                                factory =  Creacion.getFactory("Lanzarrocas");
                                                Raza esa = factory.getLanzarrocas("Especialista");
                                                esa.modificar_lista(6);
                                                getJugador().getAtacar().add(esa);
                                                //getJugador().getPreparados().remove(adm);
                                                getProx().getVehiculo_2().get(ubi).modificar_vida(ataque_2);
                                                if (getProx().getVehiculo_2().get(ubi).vida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else {
                                                System.out.println("No tiene especialistas disponibles");
                                            }

                                        }

                                    } else {
                                        System.out.println("El rival no posee vehiculos de tipo 2");
                                    }
                                    break;
                                case 7:
                                    //Terminar este if
                                    if (getProx().getEntrenar().size() == 0) {

                                        int x_2;
                                        System.out.println("¿Con qué desea atacar?");
                                        System.out.println("1. Con el escuadron");
                                        System.out.println("2. Con el especialista");
                                        x_2 = auxin.nextInt();
                                        if (x_2 == 1) {
                                            //Este también
                                            if (getJugador().getPreparados().size() > 0) {
                                                if (y == 1) {
                                                    if (getJugador().getVehiculo_1().size() > 0) {
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo_2().size() > 0) {
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    }
                                                }

                                                int adm = getJugador().getPreparados().size();
                                                adm = adm - 1;
                                                factory = Creacion.getFactory("Lanzarrocas");
                                                Raza escuadrones_1 = factory.getLanzarrocas("Escuadrones");
                                                escuadrones_1 = getJugador().getPreparados().get(adm);
                                                escuadrones_1.modificar_lista(7);
                                                getJugador().getAtacar().add(escuadrones_1);
                                                getJugador().getPreparados().remove(adm);
                                                int vida = getProx().getC_mando().getVida();
                                                vida = vida - ataque_1;
                                                getProx().getC_mando().setVida(vida);
                                                //getProx().getC_mando().getVida().modificar_vida(ataque_1);
                                                if (getProx().getC_mando().getVida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else {
                                                System.out.println("No tiene escuadrones disponibles");
                                            }
                                        } else if (x_2 == 2) {
                                            if (getJugador().getOrigen()[0] != null) {
                                                if (y == 1) {
                                                    if (getJugador().getVehiculo_1().size() > 0) {
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 1 así que se le asignará uno de tipo 2 a sus tropas");
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    }
                                                } else {

                                                    if (getJugador().getVehiculo_2().size() > 0) {
                                                        getJugador().getVehiculo_2().remove(getJugador().getVehiculo_2().size() - 1);
                                                    } else {
                                                        System.out.println("No posee vehiculo de tipo 2 así que se le asignará uno de tipo 1 a sus tropas");
                                                        getJugador().getVehiculo_1().remove(getJugador().getVehiculo_1().size() - 1);
                                                    }
                                                }

                                                int vida = getProx().getC_mando().getVida();
                                                vida = vida - ataque_2;
                                                getProx().getC_mando().setVida(vida);
                                                if (getProx().getC_mando().getVida() < 1) {
                                                    System.out.println("Se destruyó");
                                                } else {
                                                    System.out.println("Sigue con vida");
                                                }

                                            } else {
                                                System.out.println("No tiene especialistas disponibles");
                                            }

                                        }

                                    } else {
                                        System.out.println("No has acabado con todas las edificaciones del oponente");
                                    }
                                    break;


                            }

                        } else {
                            System.out.println("No tiene tropas entrenadas");
                        }
                    } else {
                        System.out.println("No tiene vehiculos disponibles para atacar");
                    }
                    break;

                            
                case 4:
                    if (getProx().getAtacar().size() > 0 /*&& getJugador().getPreparados().size()>0*/) {
                        Scanner def = new Scanner(System.in);
                        System.out.println("¿Con qué desea defender?");
                        System.out.println("1. Con el escuadron");
                        System.out.println("2. con el especialistas");
                        int opi = def.nextInt();
                        Scanner defop = new Scanner(System.in);
                        System.out.println("Cual de los " + getProx().getAtacar().size() + " escuadrones del rival desea atacar");
                        int opi_1 = defop.nextInt();
                        opi_1=opi_1-1;

                        switch (opi) {
                            case 1:
                                if (getJugador().getPreparados().size() > 0) {
                                    factory = Creacion.getFactory("Lanzarrocas");
                                    Raza esc = factory.getLanzarrocas("Escuadrones");
                                    esc = getJugador().getPreparados().get(getJugador().getPreparados().size() - 1);
                                    esc.modificar_ubicacion(opi_1);
                                    esc.modificar_lista(8);
                                    getProx().getAtacar().get(opi_1).modificar_vida(ataque_1);
                                    if (getProx().getAtacar().get(opi_1).vida() < 1) {
                                        System.out.println("Se destruyó las tropa del oponente");
                                        getProx().getAtacar().remove(opi_1);
                                        System.out.println("Su tropa estan disponible nuevamente");
                                    } else {
                                        System.out.println("Sigue con vida");
                                    }
                                } else {
                                    System.out.println("No dispone de tropas entrenadas");
                                }
                                break;
                            case 2:
                                if (getJugador().getOrigen()[0] != null) {
                                    factory = Creacion.getFactory("Lanzarrocas");
                                    Raza esc = factory.getLanzarrocas("Especialistas");
                                    esc = getJugador().getOrigen()[0];
                                    esc.modificar_lista(8);
                                    esc.modificar_ubicacion(opi_1);
                                    getProx().getAtacar().get(opi_1).modificar_vida(20);
                                    if (getProx().getAtacar().get(opi_1).vida() < 1) {
                                        System.out.println("Se destruyó la tropa enemiga");
                                        getProx().getAtacar().remove(opi_1);
                                        System.out.println("Su tropa estan disponibles nuevamente");
                                    } else {
                                        System.out.println("Sigue con vida");
                                    }
                                } else {
                                    System.out.println("No tiene especialistas entrenados");
                                }
                                break;
                        }
                    } else {
                        System.out.println("El rival no tiene tropas en ataque");
                    }
                    break;
                case 5:
                    if(getJugador().getC_mando().getGema()>=precio1 && getJugador().getC_mando().getEnergia()>=precio1){
                    factory = Creacion.getFactory("Lanzarrocas");
                    Raza oro = factory.getLanzarrocas("Generador de Oro");
                    if(getJugador().getRaza()==2){
                        oro.vida_inicial();
                    }
                     else{
                         System.out.println("");
                     }
                    getJugador().getEco1().add(oro);
                    System.out.println("Se construyó un generador de oro");
                     getJugador().getC_mando().setGema(getJugador().getC_mando().getGema()-precio1);
                     getJugador().getC_mando().setEnergia(getJugador().getC_mando().getEnergia()-precio2);}
                    else{
                         System.out.println("No dispone de recursos suficientes");
                     }
                    break;
                case 6:
                     if(getJugador().getC_mando().getOro()>=precio1 && getJugador().getC_mando().getGema()>=precio2){
                    factory = Creacion.getFactory("Lanzarrocas");
                    Raza energia = factory.getLanzarrocas("Generador de Energia");
                    if(getJugador().getRaza()==2){
                        energia.vida_inicial();
                    }
                    else{
                        System.out.println("");
                    }
                    getJugador().getEco2().add(energia);
                    //generador_vida.add(vida);
                    System.out.println("Se construyó un generador de Energia");
                      getJugador().getC_mando().setOro(getJugador().getC_mando().getOro()-precio1);
                     getJugador().getC_mando().setGema(getJugador().getC_mando().getGema()-precio2);}
                     else{
                         System.out.println("No dispone de recursos suficientes");
                     }
                    break;
                case 7:
                     if(getJugador().getC_mando().getEnergia()>=precio1 && getJugador().getC_mando().getOro()>=precio2){
                    factory = Creacion.getFactory("Lanzarrocas");
                    Raza gema = factory.getLanzarrocas("Generador de Gema");
                    if(getJugador().getRaza()==2){
                        gema.vida_inicial();
                    }
                    else{
                        System.out.println("");
                    }
                    getJugador().getEco3().add(gema);
                    //generador_gema.add(gema);
                    System.out.println("Se construyó un generador de gema");
                     getJugador().getC_mando().setEnergia(getJugador().getC_mando().getEnergia()-precio1);
                     getJugador().getC_mando().setOro(getJugador().getC_mando().getOro()-precio2);}
                     else{
                         System.out.println("No dispone de recursos suficientes");
                     }
                    break;
                case 8:
                     if(getJugador().getC_mando().getGema()>=precio1 && getJugador().getC_mando().getEnergia()>=precio2){
                    factory = Creacion.getFactory("Lanzarrocas");
                    Raza entrena = factory.getLanzarrocas("Entrenador");
                    if(getJugador().getRaza()==2){
                        entrena.vida_inicial();
                    }
                    else{
                        System.out.println("");
                    }
                    entrena.estado();
                    getJugador().getEntrenar().add(entrena);
                    //entrenar.add(entrena);
                    System.out.println("Se construyó una edificación para entrenar");
                    getJugador().getC_mando().setGema(getJugador().getC_mando().getGema()-precio1);
                     getJugador().getC_mando().setEnergia(getJugador().getC_mando().getEnergia()-precio2);}
                     else{
                         System.out.println("No dispone de recursos suficientes");
                     }
                    
                    break;
                case 9:
                    if(getJugador().getC_mando().getOro()>=precio1 && getJugador().getC_mando().getGema()>=precio2){
                    factory = Creacion.getFactory("Lanzarrocas");
                    Raza veh_1 = factory.getLanzarrocas("cuatrimotos");
                    if(getJugador().getRaza()==2){
                        veh_1.vida_inicial();
                    }
                    else{
                        System.out.println("");
                    }
                    getJugador().getVehiculo_1().add(veh_1);
                    //vehiculo1.add(veh1);
                    System.out.println("Se construyó un vehiculo tipo 1");
                    getJugador().getC_mando().setOro(getJugador().getC_mando().getOro()-precio1);
                     getJugador().getC_mando().setGema(getJugador().getC_mando().getGema()-precio2);}
                     else{
                         System.out.println("No dispone de recursos suficientes");
                     }
                    break;
                    
                case 10:
                     if(getJugador().getC_mando().getVida()>=precio1 && getJugador().getC_mando().getOro()>=precio2){
                    factory = Creacion.getFactory("Lanzarrocas");
                    Raza veh_2 = factory.getLanzarrocas("tanque");
                    if(getJugador().getRaza()==2){
                        veh_2.vida_inicial();
                    }
                    else{
                        System.out.println("");
                    }
                    getJugador().getVehiculo_2().add(veh_2);
                    //vehiculo2.add(veh2);
                    System.out.println("Se construyó un vehiculo tipo 2");
                     getJugador().getC_mando().setEnergia(getJugador().getC_mando().getEnergia()-precio1);
                     getJugador().getC_mando().setOro(getJugador().getC_mando().getOro()-precio2);}
                     else{
                         System.out.println("No dispone de recursos suficientes");
                     }
                    break;
                case 11:
                    int centro_1=getJugador().getC_mando().getDestreza_1();
                    int centro_2=getJugador().getC_mando().getDestreza_2();
                    int centro_3=getJugador().getC_mando().getDestreza_3();
                    double mando_1=centro_1+(centro_1*0.10); 
                    double mando_2=centro_2+(centro_2*0.30); 
                    double mando_3=centro_3+(centro_3*0.50); 
                    double sum= (mando_1+mando_2+mando_3);
                    sum=sum*0.25;
                    sum=(int)sum/3;
                    
                    System.out.println(sum);
                    
                    if (getJugador().getC_mando().getOro() >= sum && getJugador().getC_mando().getEnergia() >= sum && getJugador().getC_mando().getGema() >= sum) {
                        getJugador().getC_mando().level(mando_1,mando_2,mando_3);
                        
                        int num1 = getJugador().getC_mando().getOro();
                        double res = num1 - sum;
                        getJugador().getC_mando().setOro((int)res);
                        int num2 = getJugador().getC_mando().getEnergia();
                        double res2 = num2 - sum;
                        getJugador().getC_mando().setEnergia((int)res2);
                        int num3 = getJugador().getC_mando().getGema();
                        double res3 = num3 - sum;
                        getJugador().getC_mando().setGema((int)res3);
                    
                        
                        System.out.println("La cantidad almacenada de Oro es de " + getJugador().getC_mando().getDestreza_1());
                        System.out.println("La cantidad almacenada de Elixir es de " + getJugador().getC_mando().getDestreza_2());
                        System.out.println("La cantidad almacenada de Gema es de " + getJugador().getC_mando().getDestreza_3());
                    }
                    else{
                        System.out.println("No dispone de suficientes recursos");
                    }
                    break;
                    
                case 12:
                    int i = 0;
                    int sup=1000;
                    boolean sta = false;
                    factory =  Creacion.getFactory("Lanzarroca");
                    Raza entrena = factory.getLanzarrocas("Entrenador");
                    //sta=getJugador().getPreparados().get(k).question();
                    System.out.println(getJugador().getEntrenar().size() > 0);
                    
                    if (getJugador().getEntrenar().size() > 0) {

                        while (i < getJugador().getEntrenar().size()) {
                            if (getJugador().getEntrenar().get(i).question() != true) {
                                i = i + 1;
                            } else {
                                sup = i;
                                i=getJugador().getEntrenar().size();
                            }

                        }

                        if (sup!=1000) {
                            System.out.println("¿Qué numero de tropa desea entrenar?");
                            System.out.println("1. Escuadrones");
                            System.out.println("2. Especialista");
                            Scanner auxi2 = new Scanner(System.in);
                            int op = auxi2.nextInt();
                            if (op == 1) {
                                factory = Creacion.getFactory("Lanzarrocas");
                                Raza escua = factory.getLanzarrocas("Escuadrones");
                                escua.entrenar();
                                getJugador().getPreparados().add(escua);
                                getJugador().getEntrenar().get(sup).estado();
                                System.out.println("Se entrenó un Escuadron");
                            } else if (op == 2) {
                                if (getJugador().getOrigen()[0] == null) { 
                                    factory = Creacion.getFactory("Lanzarrocas");
                                    Raza me = factory.getLanzarrocas("Especialista");
                                    getJugador().getOrigen()[0] = me;
                                    System.out.println("Se entrenó a Especialista");
                                    getJugador().getEntrenar().get(sup).estado();
                                } else {
                                    System.out.println("Solo se puede tener a un Especialista entrenado");
                                }
                            } else {
                                System.out.println("No eligió ninguna opción valida");
                            }
                        } else {
                            System.out.println("No hay edificación para entrenar disponible");
                        }
                    } else {
                        System.out.println("No tiene edificaciones de entrenamiento");
                    }


                    
                    break;
                    
                case 13:
                   
                    System.out.println("Tienes "+ getJugador().getEntrenar().size() + " Para entrenar tropas");
                    System.out.println("Tienes "+ getJugador().getVehiculo_1().size() + " vehiculo tipo 1");
                    System.out.println("Tienes "+ getJugador().getVehiculo_2().size() + " vehiculo tipo 2 ");
                    //cont=cont+1;
                    //System.exit(0);
                    break;
                case 14:
                    System.exit(0);
                default:
                     System.out.println("");
            }
        }while(opc!=13);       
    }

 

}


