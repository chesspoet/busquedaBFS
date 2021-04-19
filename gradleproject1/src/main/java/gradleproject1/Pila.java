/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradleproject1;

import java.util.LinkedList;

/**
 *
 * @author oswaldo
 */
public class Pila {

    private LinkedList<Coordenadas[]> pila;
    private int elementos;

    public Pila() {
        pila = new LinkedList<Coordenadas[]>();
    }

    public void push(Coordenadas o[]) {
        pila.addLast(o);
        this.setElementos(pila.size());
    }

    public Coordenadas eliminar() {
        Coordenadas cor;
        cor = pila.getFirst()[0];
        return cor;
    }

    public Coordenadas eliminar2() {
        Coordenadas cor;
        cor = pila.getFirst()[1];
        pila.removeFirst();
        return cor;
    }

    public void imprimirPila() {
        for (int i = 0; i < pila.size(); i++) {
            if (pila.get(i)[0] != null) {
                System.out.print("(" + pila.get(i)[0].getX() + "," + pila.get(i)[0].getY() + ")" + "      ");
            } else {
                System.out.print("holagggg");
            }

            if (pila.get(i)[1] != null) {
                System.out.println("(" + pila.get(i)[1].getX() + "," + pila.get(i)[1].getY() + ")" + "      ");
            } else {
                System.out.println("(hola gola ");
            }
        }
    }

    public boolean isVacia() {
        if (pila.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
    public int numElem(){
        return pila.size();
    }
    public int getElementos() {
        return elementos;
    }

    public void setElementos(int elementos) {
        this.elementos = elementos;
    }

}
