import java.util.Random;
import java.util.Scanner;

public class pacman {

    private static int puntos = 0;
    private static int movimientos = 0;
    private static int duracionFruta = 0;
    private static int movimientosRestantesParaFruta = 80;
    private static int[][] NPCs = {
        { 10, 13 },
        { 13, 13 },
        { 14, 13 },
        { 17, 13 }
    };

    public static void main(String[] args) {
        int[][] elMapa = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},				
            {1,2,2,2,2,2,2,2,2,2,2,2,2,1,1,2,2,2,2,2,2,2,2,2,2,2,2,1},				
            {1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1},				
            {1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1},				
            {1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1},				
            {1,4,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,4,1},				
            {1,2,1,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,2,1,2,1,1,1,1,2,1},				
            {1,2,1,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,2,1,2,1,1,1,1,2,1},				
            {1,2,2,2,2,2,2,1,2,2,2,2,2,1,1,2,2,2,2,2,1,2,2,2,2,2,2,1},				
            {1,1,1,1,1,1,2,1,1,1,1,1,0,1,1,0,1,1,1,1,1,2,1,1,1,1,1,1},				
            {1,1,1,1,1,1,2,1,1,1,1,1,0,1,1,0,1,1,1,1,1,2,1,1,1,1,1,1},				
            {1,1,1,1,1,1,2,1,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,1,1,1,1,1},				
            {1,1,1,1,1,1,2,1,0,1,1,1,1,0,0,1,1,1,1,0,1,2,1,1,1,1,1,1},				
            {0,0,0,0,0,0,2,0,0,1,0,0,0,0,0,0,0,0,1,0,1,2,0,0,0,0,0,0},				
            {1,1,1,1,1,1,2,1,0,1,1,1,1,1,1,1,1,1,1,0,1,2,1,1,1,1,1,1},				
            {1,1,1,1,1,1,2,1,0,0,0,0,0, 0 ,0,0,0,0,0,0,1,2,1,1,1,1,1,1},				
            {1,1,1,1,1,1,2,1,0,1,1,1,1,1,1,1,1,1,1,0,1,2,1,1,1,1,1,1},				
            {1,1,1,1,1,1,2,1,0,1,1,1,1,1,1,1,1,1,1,0,1,2,1,1,1,1,1,1},				
            {1,2,2,2,2,2,2,2,2,2,2,2,2,1,1,2,2,2,2,2,2,2,2,2,2,2,2,1},				
            {1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1},				
            {1,2,1,1,1,1,2,2,2,1,1,1,2,1,1,2,1,1,1,2,2,2,1,1,1,1,2,1},				
            {1,4,2,2,1,1,2,1,2,2,2,2,2,2,2,2,2,2,2,2,1,2,1,1,2,2,4,1},				
            {1,1,1,2,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,2,1,2,1,1,2,1,1,1},				
            {1,1,1,2,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,2,1,2,1,1,2,1,1,1},				
            {1,2,2,2,2,2,2,1,2,2,2,2,2,1,1,2,2,2,2,2,1,2,2,2,2,2,2,1},				
            {1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1},				
            {1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1},				
            {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},				
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}		
        };
        int[] personaje = {22,13};
		do {
			imprimeMundo(elMapa, personaje, NPCs);
		} while (procesaMovimiento(elMapa, personaje, NPCs));
    }

    private static void limpiaPantalla() {
		System.out.print("\033[H\033[2J");
        System.out.flush();
	}

    private static boolean hayNPC(int[][] losNPCs, int x, int y) {

		for (int unNPC = 0; unNPC < losNPCs.length; unNPC++) {
			if (losNPCs[unNPC][0] == x && losNPCs[unNPC][1] == y) {
				return true;
			}
		}
		return false;
	}

    private static void imprimeMundo(int[][] elMapa, int[] elPersonaje, int[][] losNPCs) {

		limpiaPantalla();

		for (int y = 0; y < elMapa.length; y++) {
			for (int x = 0; x < elMapa[y].length; x++) {
                if (x == elPersonaje[0] && y == elPersonaje[1]) {
                    imprimePersonaje();
                }
                else if (hayNPC(losNPCs, x, y)) {
                    imprimeNPC();
                }
                else {
                    imprimeElemento(elMapa[y][x]);
                }
			}
			System.out.println();
		}
		imprimeStatus(elPersonaje);
	}

    private static void imprimePersonaje() {

		System.out.print(INICIO + BLACK + WHITE_BACKGROUND + " :v" + RESET);

	}

    private static void imprimeNPC() {

		System.out.print(INICIO + BLUE_BOLD + WHITE_BACKGROUND + "^V^" + RESET);

	}

    private static void imprimeElemento(int elementoDelMapa) {

		String[] matrizDeElementos = {
				INICIO + WHITE + WHITE_BACKGROUND + " . " + RESET, // Camino vacio
				INICIO + BLUE + BLUE_BACKGROUND + "[#]" + RESET, //Pared
                INICIO + YELLOW + WHITE_BACKGROUND + " o " + RESET, //Pastilla
				INICIO + BLUE_BOLD + BLUE_BACKGROUND + "~ ~" + RESET,
                INICIO + RED_BOLD + RED_BACKGROUND + " 0 " + RESET, //Pastilla de fuerza,
                "",
                INICIO + RED_BOLD + GREEN_BACKGROUND + "oOo" + RESET //Fruta
		};
		System.out.print(matrizDeElementos[elementoDelMapa]);
	}

    private static void imprimeStatus(int[] elPersonaje) {

		System.out.println("El personaje está en X:[" + elPersonaje[0] + "] Y:[" + elPersonaje[1] + "] | Tienes [ "+ puntos +" ] puntos | Haz hecho [ "+ movimientos +" ] movimientos");
        if(duracionFruta>0){
            System.out.println("Te quedan [ "+ duracionFruta + " ] para que desaparezca la fruta");
        }
        else{
            System.out.println("Te faltan [ "+ movimientosRestantesParaFruta + " ] para que aparezca la fruta");
        }

    }


    private static boolean procesaMovimiento(int[][] elMapa, int[] elPersonaje, int[][] losNPCs) {

		Scanner entrada = new Scanner(System.in);
		String inputUsuario;
		char laDireccion=' ';

		inputUsuario = entrada.nextLine();

		if (inputUsuario.equals("f")) {return false;} else
		if (inputUsuario.equals("w")) {laDireccion='N';} else
		if (inputUsuario.equals("a")) {laDireccion='O';} else
		if (inputUsuario.equals("s")) {laDireccion='S';} else
		if (inputUsuario.equals("d")) {laDireccion='E';} 

		boolean continuar = mueve(elPersonaje, elMapa, laDireccion, false);
        mueveNPCs(elMapa, losNPCs);
        
        if(duracionFruta>0){
            elMapa[15][13] = 6;
        }
        else{
            elMapa[15][13] = 0;
        }
		return continuar;
	}

	private static boolean mueve(int[] unPersonaje, int[][] unMapa, char unaDireccion, boolean esNPC){
		int elPersonajeX, elPersonajeY;
		elPersonajeX = unPersonaje[0];
		elPersonajeY = unPersonaje[1];

        boolean seMueve = false;

		if (unaDireccion=='O') {
			if (elPersonajeX == 0) { 
                elPersonajeX = unMapa[0].length - 1; 
                seMueve= true;
            } 
			else if  (unMapa[elPersonajeY][elPersonajeX - 1] % 2 == 0) {            
                elPersonajeX = elPersonajeX - 1; 
                seMueve= true;
            }
		} else if (unaDireccion=='N') {
			if (elPersonajeY == 0) {
                elPersonajeY = unMapa.length - 1;
                seMueve= true;
            } 
			else if  (unMapa[elPersonajeY - 1][elPersonajeX] % 2 == 0) {        
                elPersonajeY = elPersonajeY - 1;
                seMueve= true;
            }
		} else if (unaDireccion=='E') {
			if (elPersonajeX == unMapa[0].length - 1) {
                 elPersonajeX = 0;
                 seMueve= true;
            } 
			else if  (unMapa[elPersonajeY][elPersonajeX + 1] % 2 == 0) {
                 elPersonajeX = elPersonajeX + 1; 
                 seMueve= true;
                }
		} else if (unaDireccion=='S') {
			if (elPersonajeY == unMapa.length - 1) {
                 elPersonajeY = 0;
                 seMueve= true;
            } 
			else if  (unMapa[elPersonajeY + 1][elPersonajeX] % 2 == 0) { 
                elPersonajeY = elPersonajeY + 1; 
                seMueve= true;
            }
		} 

		unPersonaje[0] = elPersonajeX;
		unPersonaje[1] = elPersonajeY;

        if(!esNPC){
            registraMovimiento(seMueve);
            return registraPuntos(unPersonaje, unMapa);
        }
        else{
            return true;
        }
	}
    
    private static void mueveNPCs(int[][] elMapa, int[][] losNPCs) {

		char[] laDireccion = {'N','S','E','O'};
		char unaDireccion = ' ';

		for (int unNPC = 0; unNPC < losNPCs.length; unNPC++) {
			Random random = new Random();
			unaDireccion = laDireccion[random.nextInt(3)];
			mueve(losNPCs[unNPC], elMapa, unaDireccion, true);
		}
	}

    private static boolean registraPuntos(int[] personaje, int[][] unMapa){
        if(unMapa[personaje[1]][personaje[0]] == 2){
            unMapa[personaje[1]][personaje[0]] = 0;
            puntos++;
        }
        else if(unMapa[personaje[1]][personaje[0]] == 4){
            unMapa[personaje[1]][personaje[0]] = 0 ;
            puntos+=5;
        }
        else if(unMapa[personaje[1]][personaje[0]] == 6){
            unMapa[personaje[1]][personaje[0]] = 0 ;
            duracionFruta = 0;
            movimientosRestantesParaFruta = 80;
            puntos+=10;
        }

        boolean hayPastillas = false;
        for (int y = 0; y < unMapa.length; y++) {
			for (int x = 0; x < unMapa[y].length; x++) {
                if(unMapa[y][x] == 2 || unMapa[y][x] == 4){
                    hayPastillas = true;
                }
			}
		}
        if(!hayPastillas){
            imprimeMundo(unMapa, personaje, NPCs); // Imprimir el mundo por ultima vez
            System.out.println(" Haz ganado el juego con [ "+ puntos +" ] puntos | Haciendo [ "+ movimientos +" ] movimientos");
        }
        return hayPastillas; //Si no hay mas pastillas el juego se termina
    }

    private static void registraMovimiento(boolean seMueve){
        if(seMueve){
            movimientos++;
            checkFruta();
        }
    }
    private static void checkFruta(){
        if(duracionFruta> 0) {
            duracionFruta --;
            if(duracionFruta == 0){
                movimientosRestantesParaFruta = 80;
            }
        }
        else{
            movimientosRestantesParaFruta--;
            if(movimientosRestantesParaFruta < 1){
                duracionFruta = 15;
            }
        }
    }

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