
package gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes;

import static gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes.Mostrar.imprimePontuacao;
import static gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes.Mostrar.imprimirTabuleiro;
import static gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes.Tabuleiro.limparTabuleiro;
import static gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes.Verificações.posicaoValida;
import static gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes.Verificações.verificaVelha;
import static gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes.Verificações.verificaVencedor;

public class Jogador {
     public static void modoJogador(char tabuleiro[][]) {
        System.out.println("\n == MODO JOGADOR == ");
        int i = 1;
        char simbolo = ' ';
        int vencedor, a = 0, b = 0, vez = 1;

        do {
            imprimePontuacao(a, b);
            imprimirTabuleiro(tabuleiro);
            do {
                if (vez % 2 != 0) {
                    System.out.println("JOGADOR 1:");
                    simbolo = 'X';
                }
                if (vez % 2 == 0) {
                    System.out.println("JOGADOR 2:");
                    simbolo = 'O';
                }
                jogadaUsuario(tabuleiro, simbolo);
                imprimirTabuleiro(tabuleiro);
                vencedor = verificaVencedor(tabuleiro);
                i++;
                vez++;
            } while (i <= 9 && vencedor == 0);
            if (vencedor == 0) {
                vez--;
                verificaVelha(tabuleiro);
                tabuleiro = limparTabuleiro(tabuleiro);
                if (vez % 2 == 0) {
                    vez = 1;
                }if (vez % 2 != 0) {
                    vez = 2;
                }
            }
            if (vencedor == 1) {
                a = a + 1;
                i = 1;
                vez = 1;
                System.out.println("\n == VITORIA DO JOGADOR 1 == ");
                tabuleiro = limparTabuleiro(tabuleiro);
            }
            if (vencedor == 2) {
                b = b + 1;
                i = 1;
                vez = 2;
                System.out.println("\n == VITORIA DO JOGADOR 2 == ");
                tabuleiro = limparTabuleiro(tabuleiro);
            }

        } while (a <= 2 && b <= 2);
        System.out.println("== PLACAR FINAL ==");
        imprimePontuacao(a, b);
    }
     
     
    public static char[][] jogar(char tabuleiro[][], int posicoes[], char simbolo) {
        tabuleiro[posicoes[0]][posicoes[1]] = simbolo;
        return tabuleiro;
    }

    // usuario jogando
    public static void jogadaUsuario(char tabuleiro[][], char simbolo) {

        int posicoes[] = posicaoValida(tabuleiro);
        tabuleiro = jogar(tabuleiro, posicoes, simbolo);

    }

}

