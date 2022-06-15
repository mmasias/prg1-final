import java.util.Random;
import java.util.Scanner;

class UnLaberinto {
	public static void main(String[] args) {
        int[][] unMapa = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
            {1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1},
            {1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1},
            {1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1},
            {1, 4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 1},
            {1, 2, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 2, 1},
            {1, 2, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 2, 1},
            {1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1},
            {1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 2, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 2, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 2, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 2, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 2, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 2, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 2, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 2, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 2, 1, 1, 1, 1, 1, 1},
            {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
            {1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1},
            {1, 2, 1, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 1, 2, 1},
            {1, 4, 2, 2, 1, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 1, 2, 2, 4, 1},
            {1, 1, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 1, 1},
            {1, 1, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 1, 1},
            {1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1},
            {1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1},
            {1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1},
            {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    int[][] elPersonaje = { { 14, 21  } };
    int[] elReloj = {12,0};
    int[] TurnosConBaya = {0};
    int[][] losNPCs = {
            { 10, 13 },
            { 12, 13 },
            { 15, 13 },
            { 17, 13 }
    };
    int[] ContadorTiempo = {0};
    do {
        pasaElTiempo(elReloj);
        imprimeMundo(unMapa, elPersonaje, losNPCs, elReloj, TurnosConBaya, ContadorTiempo);
    } while (procesaMovimiento(unMapa, elPersonaje, losNPCs) && Cancelar == 0);
}

private static void pasaElTiempo(int[] elReloj) {

    elReloj[1]=elReloj[1]+10;
    if (elReloj[1]==60){
        elReloj[0]++;
        elReloj[1]=0;
    }
    if (elReloj[0]==24){
        elReloj[0]=0;
        elReloj[1]=0;
    }
}



private static boolean procesaMovimiento(int[][] elMapa, int[][] elPersonaje, int[][] losNPCs) {

    Scanner entrada = new Scanner(System.in);
    String inputUsuario;
    char laDireccion=' ';

    inputUsuario = entrada.nextLine();

    if (inputUsuario.equals("f")) {return false;} else
    if (inputUsuario.equals("w")) {laDireccion='N';} else
    if (inputUsuario.equals("a")) {laDireccion='O';} else
    if (inputUsuario.equals("s")) {laDireccion='S';} else
    if (inputUsuario.equals("d")) {laDireccion='E';} 

    mueveNPCs(elMapa, losNPCs);
    mueve(elPersonaje[0], elMapa, laDireccion);
    return true;
}

private static void mueve(int[] unPersonaje, int[][] unMapa, char unaDireccion ){

    int elPersonajeX, elPersonajeY;
    elPersonajeX = unPersonaje[0];
    elPersonajeY = unPersonaje[1];

    if (unaDireccion=='O') {
        if (elPersonajeX == 0) { elPersonajeX = unMapa[0].length - 1; } 
        else if  (unMapa[elPersonajeY][elPersonajeX - 1] % 2 == 0) { elPersonajeX = elPersonajeX - 1; }
    } else if (unaDireccion=='N') {
        if (elPersonajeY == 0) {elPersonajeY = unMapa.length - 1;} 
        else if  (unMapa[elPersonajeY - 1][elPersonajeX] % 2 == 0) { elPersonajeY = elPersonajeY - 1; }
    } else if (unaDireccion=='E') {
        if (elPersonajeX == unMapa[0].length - 1) { elPersonajeX = 0;} 
        else if  (unMapa[elPersonajeY][elPersonajeX + 1] % 2 == 0) { elPersonajeX = elPersonajeX + 1; }
    } else if (unaDireccion=='S') {
        if (elPersonajeY == unMapa.length - 1) { elPersonajeY = 0;} 
        else if  (unMapa[elPersonajeY + 1][elPersonajeX] % 2 == 0) { elPersonajeY = elPersonajeY + 1; }
    } 

    unPersonaje[0] = elPersonajeX;
    unPersonaje[1] = elPersonajeY;	
}

private static void mueveNPCs(int[][] elMapa, int[][] losNPCs) {

    char[] laDireccion = {'N','S','E','O'};
    char unaDireccion = ' ';

    for (int unNPC = 0; unNPC < losNPCs.length; unNPC++) {
        Random random = new Random();
        unaDireccion = laDireccion[random.nextInt(3)];
        mueve(losNPCs[unNPC], elMapa, unaDireccion);
    }
}

private static boolean hayNPC(int[][] losNPCs, int i, int j) {

    for (int unNPC = 0; unNPC < losNPCs.length; unNPC++) {
        if (losNPCs[unNPC][0] == j && losNPCs[unNPC][1] == i) {
            return true;
        }
    }
    return false;
}

private static void limpiaPantalla() {

    System.out.print("\033[H\033[2J");
    System.out.flush();
}

private static void imprimeMundo(int[][] elMapa, int[][] elPersonaje, int[][] losNPCs, int[] elReloj, int[]TurnosConBaya, int[] ContadorTiempo) {

    limpiaPantalla();
    imprimeBordeHorizontal(elMapa[0].length);

    int contadorPuntos = 0;
    int puntosPosibles = 0;
    ContadorTiempo[0] = ContadorTiempo[0] + 1;
    

    for (int i = 0; i < elMapa.length; i = i + 1) {
        imprimeBordeVertical(false);
        for (int j = 0; j < elMapa[i].length; j = j + 1) {
            if (ContadorTiempo[0] == 80){
                elMapa[15][13] = 6;
                elMapa[15][14] = 6;
            } else if (((int)ContadorTiempo[0] <= 95 && (int)ContadorTiempo[0] >= 80) || (elPersonaje[i][j] == 6)){
                if (elPersonaje[i][j]==6){
                    contadorPuntos = contadorPuntos + 10;
                }
                elMapa[15][13] = 0;
                elMapa[15][14] = 0;
                ContadorTiempo[0] = 0;
                
            }
            if (elMapa[i][j]== 0){
                contadorPuntos = contadorPuntos + 1;
            }

            if (elMapa[i][j]== 2){
                puntosPosibles = puntosPosibles + 1; 
            }

                if (i == elPersonaje[0][1] && j == elPersonaje[0][0]) {
                
                    if (i == elPersonaje[0][1] && j == elPersonaje[0][0] && elMapa[i][j] == 4){
                        int Turnos = 20;
                        contadorPuntos = contadorPuntos - 1;
                        TurnosConBaya[0] = Turnos;
                    } 

                    imprimePersonaje();
                } else {
                    if (hayNPC(losNPCs, i, j)) {
                        imprimeNPC();
                    } else {
                        imprimeElemento(elMapa[i][j]);
                    }
                }
            }
        imprimeBordeVertical(true);
    }
    if(TurnosConBaya[0] > 0){
        TurnosConBaya[0] = TurnosConBaya[0] - 1;
    }
    
    imprimeBordeHorizontal(elMapa[0].length);
    imprimeStatus(elPersonaje, losNPCs, elReloj,contadorPuntos, puntosPosibles, TurnosConBaya);
    
    if (puntosPosibles <= 0){
        Cancelar = 1;
        }
    
}

private static void imprimeStatus(int[][] elPersonaje, int[][] losNPCs, int[] elReloj, int contadorPuntos, int puntosPosibles, int[] TurnosConBaya) {

    System.out.println("Son las ["+elReloj[0]+"]:["+elReloj[1]+"] / El personaje está en X:[" + elPersonaje[0][0] + "] Y:[" + elPersonaje[0][1] + "]");
    for (int unNPC = 0; unNPC < losNPCs.length; unNPC++) {
        System.out.print("NPC[" + unNPC + "]=(" + losNPCs[unNPC][0] + "," + losNPCs[unNPC][1] + ") - ");
    }

    System.out.println("Puntos obtenidos: [" + contadorPuntos + "] Puntos faltantes: [" + puntosPosibles + "]");
    if (TurnosConBaya[0] >= 0){
        System.out.println("Turnos con Poder: [" + TurnosConBaya[0] + "]");
    }

}

private static void imprimeElemento(int elementoDelMapa) {

    String[] matrizDeElementos = {
            INICIO + WHITE_BACKGROUND + "   " + RESET,
            INICIO + BLACK_BACKGROUND + "   " + RESET,
            INICIO + YELLOW_BACKGROUND + "   " + RESET,
            INICIO + RESET,
            INICIO + RED_BACKGROUND + "   " + RESET,
            INICIO + RESET,
            INICIO + GREEN_BACKGROUND + "   " + RESET,
            
    };
    System.out.print(matrizDeElementos[elementoDelMapa]);
}

private static void imprimePersonaje() {

    System.out.print(INICIO + BLACK_BOLD + CYAN_BACKGROUND + "\\O/" + RESET);

}

private static void imprimeNPC() {

    System.out.print(INICIO + YELLOW_BOLD + GREEN_BACKGROUND + "^V^" + RESET);

}

private static void imprimeBordeHorizontal(int laLongitud) {

    System.out.print("+");
    for (int j = 0; j < laLongitud; j = j + 1) {
        System.out.print("---");
    }
    System.out.println("+");

}

private static void imprimeBordeVertical(boolean esBordeDerecho) {

    System.out.print("|");
    if (esBordeDerecho) {
        System.out.println();
    }

}

static int Cancelar = 0;
private static String INICIO = "\033[";
private static String RESET = "\033[0m";

private static String BLACK = "0;30";
private static String RED = "0;31";
private static String GREEN = "0;32";
private static String YELLOW = "0;33";
private static String BLUE = "0;34";
private static String PURPLE = "0;35";
private static String CYAN = "0;36";
private static String WHITE = "0;37";

private static String BLACK_BOLD = "1;30";
private static String RED_BOLD = "1;31";
private static String GREEN_BOLD = "1;32";
private static String YELLOW_BOLD = "1;33";
private static String BLUE_BOLD = "1;34";
private static String PURPLE_BOLD = "1;35";
private static String CYAN_BOLD = "1;36";
private static String WHITE_BOLD = "1;37";

private static String BLACK_BACKGROUND = ";40m";
private static String RED_BACKGROUND = ";41m";
private static String GREEN_BACKGROUND = ";42m";
private static String YELLOW_BACKGROUND = ";43m";
private static String BLUE_BACKGROUND = ";44m";
private static String PURPLE_BACKGROUND = ";45m";
private static String CYAN_BACKGROUND = ";46m";
private static String WHITE_BACKGROUND = ";47m";

}
    
