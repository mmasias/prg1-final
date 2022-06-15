package sergio_mayen;
import java.util.Scanner;

public class pacman{

    public static void main(String[] args){
        int[][] pacmanMapa ={
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},				
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},				
            {1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1},				
            {1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1},				
            {1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1},				
            {1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,1},				
            {1,0,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1},				
            {1,0,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1},				
            {1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},				
            {1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1},				
            {1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1},				
            {1,1,1,1,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,1,1,1,1,1,1},				
            {1,1,1,1,1,1,1,0,1,0,1,1,1,0,0,0,1,1,1,0,1,0,1,1,1,1,1,1,1,1},				
            {0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0},				
            {1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1},				
            {1,1,1,1,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,1,1,1,1,1,1},				
            {1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1},				
            {1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1},				
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1},				
            {1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1,1},				
            {1,0,1,1,1,1,1,0,0,0,1,1,1,0,1,1,0,1,1,1,0,0,0,1,1,1,1,0,1,1},				
            {1,2,0,0,1,1,1,0,1,0,1,1,1,0,1,1,0,1,1,1,0,1,0,1,1,0,0,2,1,1},				
            {1,1,1,0,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,1,1,1,1},				
            {1,1,1,0,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,0,1,0,1,1,0,1,1,1,1},				
            {1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,1,0,0,0,0,0,1,0,0,0,0,0,0,1,1},				
            {1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1},				
            {1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1},				
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},				
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
        };

        int[] pacMan = {0,0};
        do {
			dibujaMundo(pacmanMapa, pacMan);
		} while (movimientoPacman(pacmanMapa, pacMan));
    }

    private static void limpiaPantalla() {
		System.out.print("\033[H\033[2J");
        System.out.flush();
		System.out.println("\u2324\u2324");
	}

    private static void dibujaBordeH(int laLongitud) {

		System.out.print("+");
		for (int x = 0; x < laLongitud; x++) {
			System.out.print("---");
		}
		System.out.println("+");
	}

	private static void dibujaBordeV(boolean borde) {

		System.out.print("|");
		if (borde) {
			System.out.println();
		}

	}

    private static void dibujaPersonaje() {

		System.out.print(INICIO + WHITE + BLACK_BACKGROUND + " :)" + RESET);

	}

    private static boolean movimientoPacman(int[][] pacmanMapa, int[] pacman) {

		Scanner entrada = new Scanner(System.in);
		String inputUsuario;
		char laDireccion=' ';

		inputUsuario = entrada.nextLine();

		if (inputUsuario.equals("f")) {return false;} else
		if (inputUsuario.equals("w")) {laDireccion='N';} else
		if (inputUsuario.equals("a")) {laDireccion='O';} else
		if (inputUsuario.equals("s")) {laDireccion='S';} else
		if (inputUsuario.equals("d")) {laDireccion='E';} 

		mueve(pacman, pacmanMapa, laDireccion);
		return true;
	}

    private static void mueve(int[] pacman, int[][] pacmanMapa, char unaDireccion ){
		int elPacmanX, elPacmanY;
		elPacmanX = pacman[0];
		elPacmanY = pacman[1];

		if (unaDireccion=='O') {
			if (elPacmanX == 0) { elPacmanX = pacmanMapa[0].length - 1; } 
			else if  (pacmanMapa[elPacmanY][elPacmanX - 1] % 2 == 0) { elPacmanX = elPacmanX - 1; }
		} else if (unaDireccion=='N') {
			if (elPacmanY == 0) {elPacmanY = pacmanMapa.length - 1;} 
			else if  (pacmanMapa[elPacmanY - 1][elPacmanX] % 2 == 0) { elPacmanY = elPacmanY - 1; }
		} else if (unaDireccion=='E') {
			if (elPacmanX == pacmanMapa[0].length - 1) { elPacmanX = 0;} 
			else if  (pacmanMapa[elPacmanY][elPacmanX + 1] % 2 == 0) { elPacmanX = elPacmanX + 1; }
		} else if (unaDireccion=='S') {
			if (elPacmanY == pacmanMapa.length - 1) { elPacmanY = 0;} 
			else if  (pacmanMapa[elPacmanY + 1][elPacmanX] % 2 == 0) { elPacmanY = elPacmanY + 1; }
		} 

		pacman[0] = elPacmanX;
		pacman[1] = elPacmanY;
        
        registraPuntos(pacman, pacmanMapa);
        //teletransporte(unPersonaje, unMapa);
        //poder(unPersonaje, unMapa);
	}

    private static void dibujaMundo(int[][] pacmanMapa, int[] pacman) {

		limpiaPantalla();
		dibujaBordeH(pacmanMapa[0].length);

		for (int y = 0; y < pacmanMapa.length; y++) {
			dibujaBordeV(false);
			for (int x = 0; x < pacmanMapa[y].length; x++) {
                if (x == pacman[0] && y == pacman[1]) {
                    dibujaPersonaje();
                } else {
                        imprimeElemento(pacmanMapa[y][x]);
                }
			}
			dibujaBordeV(true);
		}
		dibujaBordeH(pacmanMapa[0].length);
		imprimeStatus(pacman);
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