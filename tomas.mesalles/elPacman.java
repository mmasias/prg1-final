import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class elPacman{

    public static void main (String[] args){

        int[][] matrizDelMapa = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,2,2,2,2,2,2,2,2,2,2,2,2,1,1,2,2,2,2,2,2,2,2,2,2,2,2,1},
            {1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1},
            {1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1},
            {1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1},
            {1,8,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,8,1},
            {1,2,1,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,2,1,2,1,1,1,1,2,1},
            {1,2,1,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,2,1,2,1,1,1,1,2,1},
            {1,2,2,2,2,2,2,1,2,2,2,2,2,1,1,2,2,2,2,2,1,2,2,2,2,2,2,1},
            {1,1,1,1,1,1,2,1,1,1,1,1,0,1,1,0,1,1,1,1,1,2,1,1,1,1,1,1},
            {1,1,1,1,1,1,2,1,1,1,1,1,0,1,1,0,1,1,1,1,1,2,1,1,1,1,1,1},
            {1,1,1,1,1,1,2,1,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,1,1,1,1,1},
            {1,1,1,1,1,1,2,1,0,1,1,1,1,0,0,1,1,1,1,0,1,2,1,1,1,1,1,1},
            {4,0,0,0,0,0,2,0,0,1,0,0,0,0,0,0,0,0,1,0,0,2,0,0,0,0,0,4},
            {1,1,1,1,1,1,2,1,0,1,1,1,1,1,1,1,1,1,1,0,1,2,1,1,1,1,1,1},
            {1,1,1,1,1,1,2,1,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,1,1,1,1,1},
            {1,1,1,1,1,1,2,1,0,1,1,1,1,1,1,1,1,1,1,0,1,2,1,1,1,1,1,1},
            {1,1,1,1,1,1,2,1,0,1,1,1,1,1,1,1,1,1,1,0,1,2,1,1,1,1,1,1},
            {1,2,2,2,2,2,2,2,2,2,2,2,2,1,1,2,2,2,2,2,2,2,2,2,2,2,2,1},
            {1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1},
            {1,2,1,1,1,1,2,2,2,1,1,1,2,1,1,2,1,1,1,2,2,2,1,1,1,1,2,1},
            {1,8,2,2,1,1,2,1,2,2,2,2,2,2,2,2,2,2,2,2,1,2,1,1,2,2,8,1},
            {1,1,1,2,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,2,1,2,1,1,2,1,1,1},
            {1,1,1,2,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,2,1,2,1,1,2,1,1,1},
            {1,2,2,2,2,2,2,1,2,2,2,2,2,1,1,2,2,2,2,2,1,2,2,2,2,2,2,1},
            {1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1},
            {1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1},
            {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
        };

        int[][] pacmanPosicion = {{13, 21}};
		int[] contadorTurnos = {1};
		int[][] losFantasmas = {
			{10, 13},
			{12, 13},
			{15, 13},
			{17, 13}
		};
		int[] puntosObtenidos = {0};
        int[] contadorInvincibilidad = {0};
		int[] tiempoDeFruta = {0};

		//if (puntosObtenidos[0] < 244){
			do {
				pasoDelTiempo(contadorTurnos, contadorInvincibilidad, matrizDelMapa, tiempoDeFruta);
				imprimirElMundo(matrizDelMapa, pacmanPosicion, losFantasmas, puntosObtenidos, contadorInvincibilidad, contadorTurnos);
			} while ((procesaMovimiento(matrizDelMapa, pacmanPosicion, losFantasmas)));
		//} else {
		//	imprimirElMundo(matrizDelMapa, pacmanPosicion, losFantasmas, puntosObtenidos);
		//	System.out.println("Has obtenido todas las monedas, y ganado el juego!");
		//}
    }

	private static void pasoDelTiempo(int[] contadorTurnos, int[] contadorInvincibilidad, int[][] matrizDelMapa, int[] tiempoDeFruta) {
		contadorTurnos[0] = contadorTurnos[0] + 1;

		if (contadorInvincibilidad[0] > 0){
			contadorInvincibilidad[0] = contadorInvincibilidad[0] - 1;
		}
		if (contadorTurnos[0] % 80 == 0){
			tiempoDeFruta[0] = 15;
			double espacioParaFruta = Math.random();
			if (espacioParaFruta > 0.5){
				matrizDelMapa[15][13] = 6;
			} else {
				matrizDelMapa[15][14] = 6;
			}
		}
		if (tiempoDeFruta[0] > 0){
			tiempoDeFruta[0] = tiempoDeFruta[0] - 1;
		}
		if (tiempoDeFruta[0] == 0){
			if (matrizDelMapa[15][13] == 6){
				matrizDelMapa[15][13] = 0;
			}
			if (matrizDelMapa[15][14] == 6){
				matrizDelMapa[15][13] = 0;
			}
		}
	}

	private static boolean procesaMovimiento(int[][] elMapa, int[][] pacmanPosicion, int[][] losFantasmas) {

		Scanner entrada = new Scanner(System.in);
		String inputUsuario;
		char laDireccion = ' ';

		inputUsuario = entrada.nextLine();

		if (inputUsuario.equals("w")) {laDireccion = 'N';} else
		if (inputUsuario.equals("a")) {laDireccion = 'O';} else
		if (inputUsuario.equals("s")) {laDireccion = 'S';} else
		if (inputUsuario.equals("d")) {laDireccion = 'E';} else
		if (inputUsuario.equals("f")) {return false;}

        mover(pacmanPosicion[0], elMapa, laDireccion);
		moverFantasmas(elMapa, losFantasmas);
		return true;
	}

	private static void mover(int[] unPersonaje, int[][] matrizDelMapa, char unaDireccion ){

		int pacmanPosicionX, pacmanPosicionY;
		pacmanPosicionX = unPersonaje[0];
		pacmanPosicionY = unPersonaje[1];

		if (unaDireccion == 'N') {
			if (pacmanPosicionY == 0) {pacmanPosicionY = matrizDelMapa.length - 1;}
			else if  (matrizDelMapa[pacmanPosicionY - 1][pacmanPosicionX] % 2 == 0) {pacmanPosicionY = pacmanPosicionY - 1;}
		}
		else if (unaDireccion == 'O') {
			if (pacmanPosicionX == 0) {pacmanPosicionX = matrizDelMapa[0].length - 1;}
			else if  (matrizDelMapa[pacmanPosicionY][pacmanPosicionX - 1] % 2 == 0) {pacmanPosicionX = pacmanPosicionX - 1;}
		}
		else if (unaDireccion == 'S') {
			if (pacmanPosicionY == matrizDelMapa.length - 1) {pacmanPosicionY = 0;} 
			else if  (matrizDelMapa[pacmanPosicionY + 1][pacmanPosicionX] % 2 == 0) {pacmanPosicionY = pacmanPosicionY + 1;}
		}
		else if (unaDireccion == 'E') {
			if (pacmanPosicionX == matrizDelMapa[0].length - 1) {pacmanPosicionX = 0;} 
			else if  (matrizDelMapa[pacmanPosicionY][pacmanPosicionX + 1] % 2 == 0) {pacmanPosicionX = pacmanPosicionX + 1;}
		}

		unPersonaje[0] = pacmanPosicionX;
		unPersonaje[1] = pacmanPosicionY;	
	}

	private static void moverFantasmas(int[][] elMapa, int[][] losFantasmas) {

		char[] laDireccion = {'N','O','S','E'};
		char unaDireccion = ' ';

		for (int unFantasma = 0; unFantasma < losFantasmas.length; unFantasma = unFantasma + 1) {
			Random random = new Random();
			
			unaDireccion = laDireccion[random.nextInt(4)];
			mover(losFantasmas[unFantasma], elMapa, unaDireccion);
		}
	}

	private static boolean hayFantasma(int[][] losFantasmas, int i, int j) {

		for (int unFantasma = 0; unFantasma < losFantasmas.length; unFantasma = unFantasma + 1) {
			if (losFantasmas[unFantasma][0] == j && losFantasmas[unFantasma][1] == i) {
				return true;
			}
		}
		return false;
	}

	private static void limpiaPantalla() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

    private static void imprimirElMundo(int[][] elMapa, int[][] pacmanPosicion, int[][] losFantasmas, int[] puntosObtenidos, int[] contadorInvincibilidad, int[] contadorTurnos) {

		limpiaPantalla();

		for (int i = 0; i < elMapa.length; i = i + 1) {
			
			for (int j = 0; j < elMapa[i].length; j = j + 1) {
					if ((i == pacmanPosicion[0][1] && j == pacmanPosicion[0][0]) && elMapa[i][j] == 2){
						elMapa[i][j] = 0;
						puntosObtenidos[0] = puntosObtenidos[0] + 1;
					} else if ((i == pacmanPosicion[0][1] && j == pacmanPosicion[0][0]) && elMapa[i][j] == 6){
						elMapa[i][j] = 0;
						puntosObtenidos[0] = puntosObtenidos[0] + 10;
					} else if ((i == pacmanPosicion[0][1] && j == pacmanPosicion[0][0]) && elMapa[i][j] == 8){
						elMapa[i][j] = 0;
						puntosObtenidos[0] = puntosObtenidos[0] + 5;
                        contadorInvincibilidad[0] = 20;
					}

					if (i == pacmanPosicion[0][1] && j == pacmanPosicion[0][0]) {
						imprimePersonaje();
					} else {
						if (hayFantasma(losFantasmas, i, j)) {
							imprimeFantasma(contadorInvincibilidad);
						} else {
							imprimeElemento(elMapa[i][j]);
						}
					}
			}
            System.out.println();
		}		
        imprimeStatus(pacmanPosicion, losFantasmas, puntosObtenidos, contadorTurnos, contadorInvincibilidad);
	}

    private static void imprimeStatus(int[][] pacmanPosicion, int[][] losFantasmas, int[] puntosObtenidos, int[] contadorTurnos, int[] contadorInvincibilidad) {

		System.out.println("Movimiento numero: [" + contadorTurnos[0] +"]");
		System.out.println("Movimientos de invincibilidad restantes: [" + contadorInvincibilidad[0] +"]");
		System.out.println("Puntos: [" + puntosObtenidos[0] + "]");
		System.out.println("\nPacman posicion = (" + pacmanPosicion[0][0] + ", " + pacmanPosicion[0][1] + ")");
		for (int unFantasma = 0; unFantasma < losFantasmas.length; unFantasma = unFantasma + 1) {
			System.out.println("Fantasma [#" + unFantasma + "] = (" + losFantasmas[unFantasma][0] + ", " + losFantasmas[unFantasma][1] + ")");
		}
	}

	private static void imprimeElemento(int elementoDelMapa) {

		String[] matrizDeElementos = {
				INICIO + YELLOW + WHITE_BACKGROUND + "   " + RESET, //0
				INICIO + BLACK + BLACK_BACKGROUND + "[ ]" + RESET, //1
				INICIO + YELLOW + WHITE_BACKGROUND + " . " + RESET, //2
				INICIO + BLUE_BOLD + BLUE_BACKGROUND + "~ ~" + RESET, //3
				INICIO + WHITE_BOLD + PURPLE_BACKGROUND + " @ " + RESET, //4
                INICIO + YELLOW + WHITE_BACKGROUND + "   " + RESET, //5
                INICIO + YELLOW + GREEN_BACKGROUND + " & " + RESET, //6
                INICIO + YELLOW + WHITE_BACKGROUND + "   " + RESET, //7
                INICIO + YELLOW + RED_BACKGROUND + " O " + RESET //8
		};
		System.out.print(matrizDeElementos[elementoDelMapa]);
	}

	private static void imprimePersonaje() {
		System.out.print(INICIO + BLACK + YELLOW_BACKGROUND + "°< " + RESET);
	}

	private static void imprimeFantasma(int[] contadorInvincibilidad) {
		if (contadorInvincibilidad[0] > 0){
			System.out.print(INICIO + YELLOW_BOLD + BLUE_BACKGROUND + "°#°" + RESET);
		} else {
			System.out.print(INICIO + YELLOW_BOLD + RED_BACKGROUND + "°w°" + RESET);
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