
package gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes;


public class Tabuleiro {
        /* 
    == CRIANDO O TABULEIRO DA VELHA ==  
    A matriz é um char 3x3, pois o jogo da velha tem 3 linhas e 3 colunas
    O tipo é char, pois se preenche com X ou O
     */
    public static char[][] inicializarTabuleiro() {
        char tabuleiro[][] = new char[3][3];
        return tabuleiro;
    }

 



    public static char[][] limparTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = '\0';
            }
        }
        return tabuleiro;
    }
    
}
