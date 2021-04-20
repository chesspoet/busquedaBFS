/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradleproject1;

/**
 *
 * @author oswaldo
 */
public class BusquedaBFS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Operaciones n;
        n= new Operaciones(5,7);
        n.crearMatriz();
        n.setxIni(0);
        n.setyIni(0);
        n.setxFin(4);
        n.setyFin(3);
        n.asigIniFin();
        n.asignarParedes();
        n.imprimirMatriz();
        n.realizaRecorrido();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        n.imprimirMatriz();
        n.imprimiListaW();
        n.buscarRuta();
        n.imprimiListaGana();
    }
    
}
