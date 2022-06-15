import java.util.Random;
import java.util.Scanner;
public class Pacman{
	private static String INICIO = "\033[";
	private static String RESET = "\033[0m";
    private static String BLACK = "0;30";
    private static String RED = "0;31";
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
    public static void main(String[] args){
        int[][] unMapa = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1},
            {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1},
            {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1},
            {1,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,1},
            {1,0,1,1,1,1,0,1,2,1,1,1,1,1,1,1,1,1,1,2,1,0,1,1,1,1,0,1},
            {1,0,1,1,1,1,0,1,2,1,1,1,1,1,1,1,1,1,1,2,1,0,1,1,1,1,0,1},
            {1,0,0,0,0,0,0,1,2,2,2,2,2,1,1,2,2,2,2,2,1,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,0,1,1,1,1,1,2,1,1,2,1,1,1,1,1,0,1,1,1,1,1,1},
            {1,1,1,1,1,1,0,1,1,1,1,1,2,1,1,2,1,1,1,1,1,0,1,1,1,1,1,1},
            {1,1,1,1,1,1,0,1,2,2,2,2,2,2,2,2,2,2,2,2,1,0,1,1,1,1,1,1},
            {1,1,1,1,1,1,0,1,2,1,1,1,1,2,2,1,1,1,1,2,1,0,1,1,1,1,1,1},
            {2,2,2,2,2,2,0,2,2,1,2,2,2,2,2,2,2,2,1,2,2,0,2,2,2,2,2,2},
            {1,1,1,1,1,1,0,1,2,1,1,1,1,1,1,1,1,1,1,2,1,0,1,1,1,1,1,1},
            {1,1,1,1,1,1,0,1,2,2,2,2,2,2,6,2,2,2,2,2,1,0,1,1,1,1,1,1},
            {1,1,1,1,1,1,0,1,2,1,1,1,1,1,1,1,1,1,1,2,1,0,1,1,1,1,1,1},
            {1,1,1,1,1,1,0,1,2,1,1,1,1,1,1,1,1,1,1,2,1,0,1,1,1,1,1,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,0,1,0,1,1,1,1,0,1},
            {1,0,1,1,1,1,0,0,0,1,1,1,0,1,1,0,1,1,0,0,1,0,1,1,1,1,0,1},
            {1,4,0,0,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,4,1},
            {1,1,1,0,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,1,1,1},
            {1,1,1,0,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,1,1,1},
            {1,0,0,0,0,0,0,1,0,0,0,0,0,1,1,0,0,0,0,0,1,0,0,0,0,0,0,1},
            {1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1},
            {1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
        };
        
        int[][]Personaje = {{14,21}};
        int[][]losNPC = {{12,13},{13,13},{14,13},{15,13}};
        int[] turnosPastilla = {0};
        do{
            ImprimeMapa(unMapa,Personaje,losNPC,turnosPastilla);
            monedasRestantes(unMapa);
        }while (secDex(unMapa,Personaje,losNPC,turnosPastilla));
    }
    
    static boolean secDex(int[][]elMapa,int[][]Personaje,int[][]losNPC,int[]turnos){
        Scanner entrada = new Scanner(System.in);
        String inputUsuario;
        inputUsuario = entrada.nextLine();
        char direccion=' ';
        if(inputUsuario.equals("w")) {direccion='N';} else
        if(inputUsuario.equals("s")) {direccion='S';} else
        if(inputUsuario.equals("a")) {direccion='E';} else
        if(inputUsuario.equals("d")) {direccion='O';} else
        if(inputUsuario.equals("f")){return false;}
        direccionNPCs(elMapa,losNPC);
        Mover(elMapa, Personaje[0], direccion,turnos);
        if(seguirVivo(Personaje, losNPC)==false || hayMonedas==false){
            return false;
        }
        return true;
    }    

    static void direccionNPCs(int[][]elMapa,int[][]losNPC){
        char[] direcciones = {'N','S','E','O'};
        char direccionSelect = ' ';
        for(int unNPC=0;unNPC < losNPC.length;unNPC++){
            Random random = new Random();
            direccionSelect = direcciones[random.nextInt(4)];
            MoverNPC(elMapa,losNPC[unNPC],direccionSelect);
        }
    }   

    static void MoverNPC(int[][] elMapa, int[]losNPC,char direccionSelect){
        int posicionYNPC = losNPC[1];
        int posicionXNPC = losNPC[0];
        if(direccionSelect == 'N' && (elMapa[posicionYNPC-1][posicionXNPC]%2==0)){posicionYNPC = posicionYNPC - 1;}else
        if(direccionSelect == 'S' && (elMapa[posicionYNPC+1][posicionXNPC]%2==0)){posicionYNPC = posicionYNPC + 1;}else
        if(direccionSelect == 'E' && (elMapa[posicionYNPC][posicionXNPC-1]%2==0)){posicionXNPC = posicionXNPC - 1;}else
        if(direccionSelect == 'O' && (elMapa[posicionYNPC][posicionXNPC+1]%2==0)){posicionXNPC = posicionXNPC + 1;}
    }
    
    static void Mover(int[][] elMapa, int[]Personaje,char direccion,int[]turnos){
        int posicionY = Personaje[1];
        int posicionX = Personaje[0];
        int turnosRestantes = turnos[0];
        if(direccion == 'N' && (elMapa[posicionY-1][posicionX]%2==0)){posicionY = posicionY - 1;}else
        if(direccion == 'S' && (elMapa[posicionY+1][posicionX]%2==0)){posicionY = posicionY + 1;}else
        if(direccion == 'E' && (elMapa[posicionY][posicionX-1]%2==0)){posicionX = posicionX - 1;}else
        if(direccion == 'O' && (elMapa[posicionY][posicionX+1]%2==0)){posicionX = posicionX + 1;}
        if(elMapa[posicionY][posicionX]==0){
            puntos = puntos + 1;
            elMapa[posicionY][posicionX]=2;
        }
        if(elMapa[posicionY][posicionX]==4){
            puntos = puntos + 5;
            turnosRestantes = 21;
            elMapa[posicionY][posicionX]=2;
        }
        turnos[0] = turnosRestantes;
        restTurn(turnos);
        movimientosHechos = movimientosHechos + 1;
        if(elMapa[posicionY][posicionX]==6){
            puntos = puntos + 10;
            elMapa[posicionY][posicionX]=2;
        }
        Personaje[1] = posicionY;
        Personaje[0] = posicionX;
    } 

    static void restTurn(int[] turnosRestantes){
        if(turnosRestantes[0]>0){
            turnosRestantes[0] = turnosRestantes[0] - 1;
            NPCvulne(turnosRestantes);
        }
    }    
    
    static boolean NPCvulne(int[]turnosRestantes){
        if(turnosRestantes[0]>0){
            estaVulnerable = true;
            return estaVulnerable;
        }
        estaVulnerable = false;
        return estaVulnerable;
    }    

    static boolean seguirVivo(int[][]Personaje,int[][]elNPC){
        int personajeX = Personaje[0][0];
        int personajeY = Personaje[0][1];

        if((personajeY==elNPC[0][1] && personajeX==elNPC[0][0]) && estaVulnerable==true){
            elNPC[0][1] = 13;
            elNPC[0][0] = 13;
            puntos = puntos + 10;
            return true;
        }

        if((personajeY==elNPC[1][1] && personajeX==elNPC[1][0]) && estaVulnerable==true){
            elNPC[1][1] = 13;
            elNPC[1][0] = 13;
            puntos = puntos + 10;

            return true;
        }
        if((personajeY==elNPC[2][1] && personajeX==elNPC[2][0]) && estaVulnerable==true){
            elNPC[2][1] = 13;
            elNPC[2][0] = 13;
            puntos = puntos + 10;

            return true;
        }

        if((personajeY==elNPC[3][1] && personajeX==elNPC[3][0]) && estaVulnerable==true){
            elNPC[3][1] = 13;
            elNPC[3][0] = 13;
            puntos = puntos + 10;
            return true;
        }
        
        return true;
    }    

    static void monedasRestantes(int[][]elMapa){
        int monedasRestantes;
        monedasRestantes=0;
        for(int i=0;i<elMapa.length;i++){
            for(int j=0;j<elMapa[i].length;j++){
                if(elMapa[i][j]==0 || elMapa[i][j]==4){
                    monedasRestantes = monedasRestantes + 1;   
                }
            }
        }

        System.out.println("Te quedan: " + "[" + monedasRestantes + "]");
        System.out.println("Puntos: " + puntos);
        if(monedasRestantes==0){
            System.out.println("Fin");
            hayMonedas=false;
        }
    }

    static void ImprimeMapa(int[][] MapaPre, int[][]Personaje,int[][]losNPC,int[] turnos){
        
        limpiaPantalla();
        ImprimeBorde(MapaPre[0].length);

        for(int i=0;i<MapaPre.length;i++){
            for(int j=0;j<MapaPre[i].length;j++){
                if(puedoVer(i,j,Personaje)){
                    if(i==Personaje[0][1] && j==Personaje[0][0]){
                        ImprimePersonaje();
                    }else{
                        if(hayNPC(losNPC, i, j)){
                            ImprimeNPC();
                        }else{
                            ImprimeElemento(MapaPre[i][j]);
                        } 
                    } 
                }
                else{
                    System.out.print("   ");
                } 
            }
            System.out.println();
        }
        ImprimeBorde(MapaPre[0].length);
        System.out.println("Movimientos hechos: " + "[" + movimientosHechos + "]");
    }

    static void limpiaPantalla() {

		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

    static void ImprimeBorde(int LongitudH){
        for(int j=0;j<LongitudH;j++){
            System.out.print("---");
        }
        System.out.println();
    }

    static boolean puedoVer(int i, int j, int[][] Personaje){
        return true;
    }
 
    static void ImprimePersonaje(){
        System.out.print(INICIO + WHITE_BOLD + BLACK_BACKGROUND + "\\0/" + RESET);
    }    

    static boolean hayNPC(int[][] losNPC, int i, int j) {

		for (int unNPC = 0; unNPC < losNPC.length; unNPC++) {
			if (losNPC[unNPC][0] == j && losNPC[unNPC][1] == i) {
				return true;
			}
		}
		return false;
	}

    static void ImprimeNPC(){
        if(estaVulnerable==true){
            System.out.print(INICIO + YELLOW + BLACK_BACKGROUND + "^|^" + RESET);
        }else{
            System.out.print(INICIO + YELLOW_BOLD + BLACK_BACKGROUND + "^|^" + RESET);
        }
    }

    static void ImprimeElemento(int i){
        String[] Elementos = {
            INICIO + YELLOW_BOLD + BLACK_BACKGROUND + " . " + RESET,
            INICIO + BLUE_BOLD + BLACK_BACKGROUND +  "[#]" + RESET,
            INICIO + WHITE_BOLD + BLACK_BACKGROUND + " . " + RESET, "",
            INICIO + RED_BOLD + BLACK_BACKGROUND + " a " + RESET, "",
            INICIO + GREEN_BOLD + BLACK_BACKGROUND + "(?)" + RESET,
        };
        System.out.print(Elementos[i]);
    }
    static boolean estaVulnerable=false;
    static boolean hayMonedas=true;
    static int puntos=0;
    static int movimientosHechos=0;
}