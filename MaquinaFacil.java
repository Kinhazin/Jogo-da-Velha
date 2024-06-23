package gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes;

import static gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes.Jogador.jogadaUsuario;
import static gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes.Jogador.jogar;
import static gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes.Mostrar.imprimePontuacao;
import static gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes.Mostrar.imprimePontuacaoMaquina;
import static gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes.Mostrar.imprimirTabuleiro;
import static gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes.Tabuleiro.limparTabuleiro;
import static gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes.Verificações.posicaoValidaMaquina;
import static gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes.Verificações.verificaVelha;
import static gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes.Verificações.verificaVencedor;
import java.util.Random;

/**
 *
 * @author lkzin
 */
public class MaquinaFacil {

    public static void modoFacil(char tabuleiro[][]) {
        char simbolo = ' ';
        int vencedor, i = 1, a = 0, b = 0, vez = 1;
        System.out.println("== MODO JOGADOR vs MAQUINA ==");

        do {
            imprimePontuacaoMaquina(a, b);
            imprimirTabuleiro(tabuleiro);
            do {
                vencedor = 0;
                if (vez % 2 != 0) {
                    System.out.println("JOGADOR 1:");
                    simbolo = 'X';
                    jogadaUsuario(tabuleiro, simbolo);
                    imprimirTabuleiro(tabuleiro);
                }
                if (vez % 2 == 0) {
                    System.out.println("MAQUINA:");
                    simbolo = 'O';
                    jogadaMaquina(tabuleiro, simbolo);
                    imprimirTabuleiro(tabuleiro);
                }
                vencedor = verificaVencedor(tabuleiro);
                vez++;
                i++;
            } while (i <= 9 && vencedor == 0);
            if (vencedor == 0) {
                i = 1;
                vez --;
                verificaVelha(tabuleiro);
                tabuleiro = limparTabuleiro(tabuleiro);

                if (vez % 2 == 0) {
                    vez = 1;
                }
                if (vez % 2 != 0) {
                    vez = 2;
                }
            }
            if (vencedor == 1) {
                i = 1;
                a = a + 1;
                vez = 1;
                System.out.println("\n == VITORIA DO JOGADOR == ");
                tabuleiro = limparTabuleiro(tabuleiro);
            }
            if (vencedor == 2) {
                i = 1;
                b = b + 1;
                vez = 2;
                System.out.println("\n == VITÓRIA DA MAQUINA == ");
                tabuleiro = limparTabuleiro(tabuleiro);
            }

        } while (a <= 2 && b <= 2);
        System.out.println("== PLACAR FINAL ==");
        imprimePontuacaoMaquina(a, b);

    }
    // numeros aleatorios para  a maquina jogar, a combinação aleatoria é feita até dar uma posicao livre

    public static void jogadaMaquina(char tabuleiro[][], char simbolo) {
        Random random = new Random();
        int linha;
        int coluna;
        boolean verdade;

        do {
            linha = random.nextInt(3);
            coluna = random.nextInt(3);
            verdade = posicaoValidaMaquina(tabuleiro, linha, coluna);
        } while (verdade == false);

        int posicoes[] = new int[2];

        posicoes[0] = linha;
        posicoes[1] = coluna;
        tabuleiro = jogar(tabuleiro, posicoes, simbolo);

    }

}
