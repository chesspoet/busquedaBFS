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
public class Operaciones {

    private Nodo matriz[][];
    private LinkedList<Coordenadas[]> listaW;
    private LinkedList<Coordenadas> listaV;
    private final Pila pilaW;
    private Coordenadas orden;
    private Coordenadas coorde[];
    private int turno;
    private int dimA;
    private int dimB;
    private int o;
    private int xIni;
    private int xFin;
    private int yIni;
    private int yFin;
    
    public Operaciones(int dimA, int dimB) {
        this.dimA = dimA;
        this.dimB = dimB;
        matriz = new Nodo[dimA][dimB];
        listaW = new LinkedList<Coordenadas[]>();
        listaV = new LinkedList<Coordenadas>();
        pilaW = new Pila();

    }
    public void realizaRecorrido() {
        this.turno = 1;
        int control = 0;
        boolean solucion = true;
        boolean primero = true;
        int i = xIni, j = yIni;
      
        Coordenadas aux2 = new Coordenadas(i, j);
        listaV.add(aux2);
        this.imprimirMatriz();
        do {
            coorde = new Coordenadas[2];
            //Revisamos los vecinos hacia enfente
            //Derecha
            if (agregar(i, j + 1)) {
                Coordenadas cor = new Coordenadas(i, j + 1);
                coorde[o] = cor;
                o++;
            } else {
                if (this.esGanador(i, j + 1)) {
                    Coordenadas cor = new Coordenadas(i, j + 1);
                    coorde[o] = cor;
                    solucion=false;
                    o++;
                }
            }
            //Izquierda
            if (agregar(i, j - 1)) {
                Coordenadas cor = new Coordenadas(i, j - 1);
                coorde[o] = cor;
                o++;
            } else {
                if (this.esGanador(i, j - 1)) {
                    Coordenadas cor = new Coordenadas(i, j - 1);
                    coorde[o] = cor;
                    solucion=false;
                    o++;
                }
            }
            //Arriba
            if (agregar(i - 1, j)) {
                Coordenadas cor = new Coordenadas(i - 1, j);
                coorde[o] = cor;
                o++;
            } else {
                if (this.esGanador(i - 1, j)) {
                    Coordenadas cor = new Coordenadas(i - 1, j);
                    coorde[o] = cor;
                    solucion=false;
                    o++;
                }
            }
            //Abajo
            if (agregar(i + 1, j)) {
                Coordenadas cor = new Coordenadas(i + 1, j);
                coorde[o] = cor;
                o++;
            } else {
                if (this.esGanador(i + 1, j)) {
                    Coordenadas cor = new Coordenadas(i + 1, j);
                    coorde[o] = cor;
                    solucion=false;
                    o++;
                }
            }
            if (orden != null || control == 0) {
                listaW.add(coorde);
            }

            o = 0;
            if (coorde[0] != null || coorde[1] != null) {
                pilaW.push(coorde);
            }
            System.out.println("_______");
            pilaW.imprimirPila();
            System.out.println("_________");
            if (turno == 1) {
                orden = pilaW.eliminar();
                if (orden != null) {
                    i = orden.getX();
                    j = orden.getY();
                    Coordenadas aux = new Coordenadas(i, j);
                    listaV.add(aux);
                    turno = 2;
                }

            } else {
                orden = pilaW.eliminar2();
                if (orden != null && orden.getX() >= 0 && orden.getY() >= 0) {
                    i = orden.getX();
                    j = orden.getY();
                    Coordenadas aux = new Coordenadas(i, j);
                    listaV.add(aux);

                }

                turno = 1;
            }

            control++;
        } while (solucion);
        this.imprimiListaW();
        this.imprimiListaV();
    }
    public void asigIniFin(){
          matriz[this.xIni][this.yIni].setA('I');
        matriz[this.xFin][this.yFin].setA('S');
    }
    public boolean esGanador(int x, int y) {
        Boolean ganador = false;
        if (y >= 0 && y < this.dimB && x >= 0 && x < this.dimA) {
            if (matriz[x][y].getA() == 'S') {
                ganador = true;
            }
        }
        return ganador;
    }

    public boolean agregar(int x, int y) {
        boolean respuesta = false;
        if (y >= 0 && y < this.dimB && x >= 0 && x < this.dimA) {
            if (matriz[x][y].getA() == 'O' && matriz[x][y].isVisita() == false) {
                matriz[x][y].setVisita(true);
                matriz[x][y].setA('V');
                respuesta = true;
            }
        }
        return respuesta;

    }

    public void crearMatriz() {
        for (int i = 0; i < dimA; i++) {
            for (int j = 0; j < dimB; j++) {
                Nodo n = new Nodo(i, j, 'O', false);
                matriz[i][j] = n;
            }
        }
    }

    public void imprimiListaW() {
        System.out.println("___________________________________________");
        System.out.println("");
        for (int i = 0; i < listaW.size(); i++) {
            if (listaW.get(i)[0] != null) {
                System.out.print("(" + listaW.get(i)[0].getX() + "," + listaW.get(i)[0].getY() + ")" + "      ");
            } else {
                System.out.print("");
            }

            if (listaW.get(i)[1] != null) {
                System.out.println("(" + listaW.get(i)[1].getX() + "," + listaW.get(i)[1].getY() + ")");
            } else {
                System.out.println("");
            }
        }
        System.out.println("");
        System.out.println("___________________________________________");
        System.out.println("" + listaW.size());
    }

    public void imprimiListaV() {
        System.out.println("___________________________________________");
        System.out.println("");
        for (int i = 0; i < listaV.size(); i++) {
            if (listaV.get(i) != null) {
                System.out.println("(" + listaV.get(i).getX() + "," + listaV.get(i).getY() + ")");
            } else {
                System.out.println("Hay basurapatron");
            }
        }
        System.out.println("___________________________________________");
        System.out.println("" + listaV.size());
    }

    public void imprimirMatriz() {
        for (int i = 0; i < dimA; i++) {
            for (int j = 0; j < dimB; j++) {
                System.out.print("" + matriz[i][j].getX());
                System.out.print("" + matriz[i][j].getY());
                System.out.print("" + matriz[i][j].getA());
                System.out.print("" + matriz[i][j].isVisita() + "    ");
            }
            System.out.println("");
        }
    }

    public Nodo[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(Nodo[][] matriz) {
        this.matriz = matriz;
    }

    public int getDimA() {
        return dimA;
    }

    public void setDimA(int dimA) {
        this.dimA = dimA;
    }

    public int getDimB() {
        return dimB;
    }

    public void setDimB(int dimB) {
        this.dimB = dimB;
    }

    

    public String[][] hacerLista() {
        String lista[][];
        lista = new String[listaV.size()][3];
        for (int i = 0; i < listaV.size(); i++) {
            lista[i][0] = "(" + listaV.get(i).getX() + "," + listaV.get(i).getY() + ")";
            if (listaW.get(i)[0] != null) {
                lista[i][1] = "(" + listaW.get(i)[0].getX() + "," + listaW.get(i)[0].getY() + ")";
            } else {
                lista[i][1] = "";
            }
            if (listaW.get(i)[1] != null) {
                lista[i][2] = "(" + listaW.get(i)[1].getX() + "," + listaW.get(i)[1].getY() + ")";
            } else {
                lista[i][2] = "";
            }
        }
        return lista;
    }

    public void asignarParedes() {
        this.matriz[1][1].setA('#');
        this.matriz[0][3].setA('#');
        this.matriz[2][1].setA('#');
        this.matriz[1][5].setA('#');
        this.matriz[3][2].setA('#');
        this.matriz[3][3].setA('#');
        this.matriz[4][0].setA('#');
        this.matriz[4][2].setA('#');
        this.matriz[4][5].setA('#');

        this.matriz[1][1].setVisita(true);
        this.matriz[0][3].setVisita(true);
        this.matriz[2][1].setVisita(true);
        this.matriz[1][5].setVisita(true);
        this.matriz[3][2].setVisita(true);
        this.matriz[3][3].setVisita(true);
        this.matriz[4][0].setVisita(true);
        this.matriz[4][2].setVisita(true);
        this.matriz[4][5].setVisita(true);
    }

    public int getxIni() {
        return xIni;
    }

    public void setxIni(int xIni) {
        this.xIni = xIni;
    }

    public int getxFin() {
        return xFin;
    }

    public void setxFin(int xFin) {
        this.xFin = xFin;
    }

    public int getyIni() {
        return yIni;
    }

    public void setyIni(int yIni) {
        this.yIni = yIni;
    }

    public int getyFin() {
        return yFin;
    }

    public void setyFin(int yFin) {
        this.yFin = yFin;
    }

    public Coordenadas returnElementoV(int i) {
        return listaV.get(i);
    }

    public Coordenadas[] returnElementoW(int i) {
        return listaW.get(i);
    }

    public LinkedList<Coordenadas[]> getListaW() {
        return listaW;
    }

    public LinkedList<Coordenadas> getListaV() {
        return listaV;
    }

    public void setListaV(LinkedList<Coordenadas> listaV) {
        this.listaV = listaV;
    }

    public void setListaW(LinkedList<Coordenadas[]> listaW) {
        this.listaW = listaW;
    }

}
