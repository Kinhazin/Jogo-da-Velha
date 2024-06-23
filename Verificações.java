
package gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes;

import static gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes.JogadaUsuario.leiaCoordenadaColuna;
import static gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes.JogadaUsuario.leiaCoordenadaLinha;


public class Verificações {
    
    /*
    CHAMAOS A FUNCAO LINHA E ENQUANTO O USUARIO NAO NUMEROS ENTRE 0 A 2 ELE NAO AVANÇA, ASSIM SERVINDO PARA LINHA E COLUNA
    CASO APOS TER DIGITADO AMBAS E O ESPAÇO ESTIVER SENDO UTILIZADO, ELE VOLTA PARA REALIZAR LINHA E COLUNA NOVAMENTE
    RETORNA UM VETOR[2]
     */
    public static int[] posicaoValida(char tabuleiro[][]) {
        int posicoes[] = new int[2];

        boolean pode;
        int linha, coluna;
        do {
            do {
                linha = leiaCoordenadaLinha();
                if (linha > 2 || linha < 0) {
                    System.out.println("\nPosicao invalida");
                    pode = false;
                } else {
                    pode = true;
                }
            } while (pode == false);

            do {
                coluna = leiaCoordenadaColuna();
                if (coluna > 2 || coluna < 0) {
                    System.out.println("\nPosicao invalida");
                    pode = false;
                } else {
                    pode = true;
                }
            } while (pode == false);

            if (tabuleiro[linha][coluna] == 'X' || tabuleiro[linha][coluna] == 'O') {
                System.out.println("\nPosicao invalida");
                pode = false;
            } else {
                pode = true;
            }
        } while (pode == false);

        posicoes[0] = linha;
        posicoes[1] = coluna;
        return posicoes;
    }

    // VALIDADOR EXCLUSIVO PARA MAQUINA, JÁ QUE NAO PRECISA CHECKAR OS NUMEROS DIGITADOS, APENAS SE A POSIÇÃO ESTÁ OCUPADA OU NAO
    public static boolean posicaoValidaMaquina(char tabuleiro[][], int linha, int coluna) {

        boolean pode = false;

        if (tabuleiro[linha][coluna] == 'X' || tabuleiro[linha][coluna] == 'O') {
            pode = false;
        } else if (tabuleiro[linha][coluna] != 'X' && tabuleiro[linha][coluna] != 'O') {
            pode = true;
        }

        return pode;
    }
    
    
    // TODAS AS POSSIBILIDADES DE VITORIA, CASO X GANHE = JOGADOR 1, CASO JOGADOR 2 = MAQUINA
    public static int verificaVencedor(char tabuleiro[][]) {
        int vencedor = 0;
        if (tabuleiro[0][0] == 'X' && tabuleiro[0][1] == 'X' && tabuleiro[0][2] == 'X') {
            vencedor = 1;
        }
        if (tabuleiro[1][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[1][2] == 'X') {
            vencedor = 1;
        }
        if (tabuleiro[2][0] == 'X' && tabuleiro[2][1] == 'X' && tabuleiro[2][2] == 'X') {
            vencedor = 1;
        }
        if (tabuleiro[0][0] == 'X' && tabuleiro[1][0] == 'X' && tabuleiro[2][0] == 'X') {
            vencedor = 1;
        }
        if (tabuleiro[0][1] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][1] == 'X') {
            vencedor = 1;
        }
        if (tabuleiro[0][2] == 'X' && tabuleiro[1][2] == 'X' && tabuleiro[2][2] == 'X') {
            vencedor = 1;
        }
        if (tabuleiro[0][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][2] == 'X') {
            vencedor = 1;
        }
        if (tabuleiro[0][2] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][0] == 'X') {
            vencedor = 1;
        }

        if (tabuleiro[0][0] == 'O' && tabuleiro[0][1] == 'O' && tabuleiro[0][2] == 'O') {
            System.out.println("O jogador 2 venceu");
            vencedor = 2;
        }
        if (tabuleiro[1][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[1][2] == 'O') {
            System.out.println("O jogador 2 venceu");
            vencedor = 2;
        }
        if (tabuleiro[2][0] == 'O' && tabuleiro[2][1] == 'O' && tabuleiro[2][2] == 'O') {
            System.out.println("O jogador 2 venceu");
            vencedor = 2;
        }
        if (tabuleiro[0][0] == 'O' && tabuleiro[1][0] == 'O' && tabuleiro[2][0] == 'O') {
            System.out.println("O jogador 2 venceu");
            vencedor = 2;
        }
        if (tabuleiro[0][1] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][1] == 'O') {
            System.out.println("O jogador 2 venceu");
            vencedor = 2;
        }
        if (tabuleiro[0][2] == 'O' && tabuleiro[1][2] == 'O' && tabuleiro[2][2] == 'O') {
            System.out.println("O jogador 2 venceu");
            vencedor = 2;
        }
        if (tabuleiro[0][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][2] == 'O') {
            System.out.println("O jogador 2 venceu");
            vencedor = 2;
        }
        if (tabuleiro[0][2] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][0] == 'O') {
            System.out.println("O jogador 2 venceu");
            vencedor = 2;
        }
        if (vencedor == 1) {
            System.out.println("VITORIA DO JOGADOR 1");
        } else if (vencedor == 2) {
            System.out.println("VITORIA DO JOGADOR 2");
        }
        return vencedor;
    }

    public static void verificaVelha(char tabuleiro[][]) {
        int vencedor = verificaVencedor(tabuleiro);
        if (vencedor == 0) {
            System.out.println("== EMPATE ==");
        }

    }

}
