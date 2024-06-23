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

public class JogadaMaquinaDificil {

    public static void modoDificil(char tabuleiro[][]) {
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
                    jogadaMaquinaDificil(tabuleiro, simbolo, vez);
                    imprimirTabuleiro(tabuleiro);
                }
                vencedor = verificaVencedor(tabuleiro);
                vez++;
                i++;
            } while (i <= 9 && vencedor == 0);
            if (vencedor == 0) {
                i = 1;
                verificaVelha(tabuleiro);
                tabuleiro = limparTabuleiro(tabuleiro);
                vez --;
                if (vez % 2 == 0) {
                    vez = 1;
                } else if (vez % 2 != 0) {
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
                System.out.println("\n == VITORIA DA MAQUINA == ");
                tabuleiro = limparTabuleiro(tabuleiro);
            }

        } while (a <= 2 && b <= 2);
        System.out.println("== PLACAR FINAL ==");
        imprimePontuacaoMaquina(a, b);

    }

    /*JOGADA DA MAQUIANA É BASEADA NA VEZ QUE ELE VAI JOGAR
    Na 1º ele tenta jogar no meio, se não estiver livre ele joga em um canto
    Na 2º ele checa se o jogador 1 tem chance de ganahr, caso nao ele joga em um canto
    Na 3º para frente ele ve se tem chance de vitoria, caso nao ele ve se o jogador 1 tem chance, caso nao ele ve se ter cantos livres, caso nao ele joga em bordas aleatorias
    
     */
    public static void jogadaMaquinaDificil(char tabuleiro[][], char simbolo, int vez) {
        int posicoes[] = new int[2];

        if (vez == 2) {
            if (tabuleiro[1][1] != 'X') {
                posicoes[0] = 1;
                posicoes[1] = 1;

            } else if (vez == 2 && tabuleiro[1][1] == 'X') {
                posicoes = canto(tabuleiro);
            }
        }

        if (vez == 4) {
            posicoes = bloquear(tabuleiro);
            if (posicoes[0] == 5 && posicoes[1] == 5) {
                posicoes = canto(tabuleiro);
            }
        }

        if (vez >= 6) {
            posicoes = ganhar(tabuleiro);
            if (posicoes[0] == 4 && posicoes[1] == 4) {
                posicoes = bloquear(tabuleiro);
                if (posicoes[0] == 5 && posicoes[1] == 5) {
                    posicoes = canto(tabuleiro);
                    {
                        if (posicoes[0] == 7 && posicoes[1] == 7) {
                            posicoes = borda(tabuleiro);
                        }
                    }
                }
            }
        }

        tabuleiro = jogar(tabuleiro, posicoes, simbolo);

    }

    // CASO DE VITORIA, SE O COMPUTADOR TIVER DUAS PEÇAS EM SEQUENCIA, ELE COLOCA NA TERCEIRA.
    // obs, ele devolve 4, 4 caso nenhuma dessas condições forem verdadeiras  
    public static int[] ganhar(char tabuleiro[][]) {
        int[] jogadas = new int[2];

        if (tabuleiro[1][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[1][2] != 'X') {
            jogadas[0] = 1;
            jogadas[1] = 2;
        } else if (tabuleiro[1][1] == 'O' && tabuleiro[1][2] == 'O' && tabuleiro[1][0] != 'X' && tabuleiro[1][0] != 'O') {
            jogadas[0] = 1;
            jogadas[1] = 0;
        } else if (tabuleiro[1][0] == 'O' && tabuleiro[1][2] == 'O' && tabuleiro[1][1] != 'X' && tabuleiro[1][1] != '0') {
            jogadas[0] = 1;
            jogadas[1] = 1;
        } else if (tabuleiro[0][0] == 'O' && tabuleiro[0][1] == 'O' && tabuleiro[0][2] != 'X' && tabuleiro[0][2] != 'O') {
            jogadas[0] = 0;
            jogadas[1] = 2;
        } else if (tabuleiro[0][0] == 'O' && tabuleiro[0][2] == 'O' && tabuleiro[0][1] != 'X' && tabuleiro[0][1] != 'O') {
            jogadas[0] = 0;
            jogadas[1] = 1;
        } else if (tabuleiro[0][1] == 'O' && tabuleiro[0][2] == 'O' && tabuleiro[0][0] != 'X' && tabuleiro[0][0] != '0') {
            jogadas[0] = 0;
            jogadas[1] = 0;
        } else if (tabuleiro[2][0] == 'O' && tabuleiro[2][1] == 'O' && tabuleiro[2][2] != 'X' && tabuleiro[2][2] != 'O') {
            jogadas[0] = 2;
            jogadas[1] = 2;
        } else if (tabuleiro[2][0] == 'O' && tabuleiro[2][2] == 'O' && tabuleiro[2][1] != 'X' && tabuleiro[2][1] != 'O') {
            jogadas[0] = 2;
            jogadas[1] = 1;
        } else if (tabuleiro[2][1] == 'O' && tabuleiro[2][2] == 'O' && tabuleiro[2][0] != 'X' && tabuleiro[2][0] != 'O') {
            jogadas[0] = 2;
            jogadas[1] = 0;
        } else if (tabuleiro[0][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][2] != 'X' && tabuleiro[2][2] != 'O') {
            jogadas[0] = 2;
            jogadas[1] = 2;
        } else if (tabuleiro[1][1] == 'O' && tabuleiro[0][1] == 'O' && tabuleiro[2][1] != 'X' && tabuleiro[2][1] != 'O') {
            jogadas[0] = 2;
            jogadas[1] = 1;
        } else if (tabuleiro[1][1] == 'O' && tabuleiro[0][2] == 'O' && tabuleiro[2][0] != 'X' && tabuleiro[2][0] != 'O') {
            jogadas[0] = 2;
            jogadas[1] = 0;
        } else if (tabuleiro[2][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[0][0] != 'X' && tabuleiro[0][0] != 'O') {
            jogadas[0] = 0;
            jogadas[1] = 0;
        } else {
            jogadas[0] = 4;
            jogadas[1] = 4;
        }

        return jogadas;
    }

    //CASO O X ESTEJA PÉRTO DE GANHAR, O COMPUTADOR JOGA O PARA IMPEDIR
    // obs, ele devolve 5, 5 caso nenhuma dessas condições forem verdadeiras 
    public static int[] bloquear(char tabuleiro[][]) {
        int[] jogadas = new int[2];

        if (tabuleiro[1][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[1][2] != 'O') {
            jogadas[0] = 1;
            jogadas[1] = 2;
        } else if (tabuleiro[1][1] == 'X' && tabuleiro[1][2] == 'X' && tabuleiro[1][0] != 'O') {
            jogadas[0] = 1;
            jogadas[1] = 0;
        } else if (tabuleiro[1][0] == 'X' && tabuleiro[1][2] == 'X' && tabuleiro[1][1] != 'O') {
            jogadas[0] = 1;
            jogadas[1] = 1;
        } else if (tabuleiro[0][0] == 'X' && tabuleiro[0][1] == 'X' && tabuleiro[0][2] != 'O') {
            jogadas[0] = 0;
            jogadas[1] = 2;
        } else if (tabuleiro[0][0] == 'X' && tabuleiro[0][2] == 'X' && tabuleiro[0][1] != 'O') {
            jogadas[0] = 0;
            jogadas[1] = 1;
        } else if (tabuleiro[0][1] == 'X' && tabuleiro[0][2] == 'X' && tabuleiro[0][0] != 'O') {
            jogadas[0] = 0;
            jogadas[1] = 0;
        } else if (tabuleiro[2][0] == 'X' && tabuleiro[2][1] == 'X' && tabuleiro[2][2] != 'O') {
            jogadas[0] = 2;
            jogadas[1] = 2;
        } else if (tabuleiro[2][0] == 'X' && tabuleiro[2][2] == 'X' && tabuleiro[2][1] != 'O') {
            jogadas[0] = 2;
            jogadas[1] = 1;
        } else if (tabuleiro[2][1] == 'X' && tabuleiro[2][2] == 'X' && tabuleiro[2][0] != 'O') {
            jogadas[0] = 2;
            jogadas[1] = 0;
        } else if (tabuleiro[0][1] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][1] != 'O') {
            jogadas[0] = 2;
            jogadas[1] = 1;
        } else if (tabuleiro[0][0] == 'X' && tabuleiro[1][0] == 'X' && tabuleiro[2][0] != 'O') {
            jogadas[0] = 2;
            jogadas[1] = 0;
        } else if (tabuleiro[2][2] == 'X' && tabuleiro[1][2] == 'X' && tabuleiro[0][2] != 'O') {
            jogadas[0] = 0;
            jogadas[1] = 2;
        } else if (tabuleiro[0][2] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][0] != 'O') {
            jogadas[0] = 2;
            jogadas[1] = 0;
        } else if (tabuleiro[0][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][2] != 'O') {
            jogadas[0] = 2;
            jogadas[1] = 2;
        } else if (tabuleiro[1][1] == 'X' && tabuleiro[2][2] == 'X' && tabuleiro[0][0] != 'O') {
            jogadas[0] = 0;
            jogadas[1] = 0;
        } else if (tabuleiro[0][0] == 'X' && tabuleiro[2][0] == 'X' && tabuleiro[1][0] != 'O') {
            jogadas[0] = 1;
            jogadas[1] = 0;
        } else {
            jogadas[0] = 5;
            jogadas[1] = 5;
        }
        return jogadas;
    }

    //CASO TENHA UM CANTO LIVRE COM SEU INVESO LIVRE TAMBEM, ELE DA PREFENRECIA PARA ESSA JOGADA, CASO NAO, ELE APENAS JOGA EM UM CANTO LIBRE
    public static int[] canto(char tabuleiro[][]) {
        int posicoes[] = new int[2], local;
        int linha, coluna;

        if (tabuleiro[0][0] != 'X' && tabuleiro[0][0] != 'O' && tabuleiro[0][2] != 'X' && tabuleiro[0][2] != 'O') {
            posicoes[0] = 0;
            posicoes[1] = 0;
        } else if (tabuleiro[0][0] != 'X' && tabuleiro[0][0] != 'O' && tabuleiro[2][0] != 'X' && tabuleiro[2][0] != 'O') {
            posicoes[0] = 2;
            posicoes[1] = 0;
        } else if (tabuleiro[2][0] != 'X' && tabuleiro[2][0] != 'O' && tabuleiro[2][2] != 'X' && tabuleiro[2][2] != 'O') {
            posicoes[0] = 2;
            posicoes[1] = 2;
        } else if (tabuleiro[2][2] != 'X' && tabuleiro[2][2] != 'O' && tabuleiro[0][2] != 'X' && tabuleiro[0][2] != 'O') {
            posicoes[0] = 0;
            posicoes[1] = 2;
        } else if (tabuleiro[0][0] != 'X' && tabuleiro[0][0] != 'O') {
            posicoes[0] = 0;
            posicoes[1] = 0;
        } else if (tabuleiro[0][2] != 'X' && tabuleiro[0][2] != 'O') {
            posicoes[0] = 0;
            posicoes[1] = 2;
        } else if (tabuleiro[2][2] != 'X' && tabuleiro[2][2] != 'O') {
            posicoes[0] = 2;
            posicoes[1] = 2;
        } else if (tabuleiro[2][0] != 'X' && tabuleiro[2][0] != 'O') {
            posicoes[0] = 2;
            posicoes[1] = 0;
        } else {
            posicoes[0] = 7;
            posicoes[1] = 7;
        }

        return posicoes;
    }

    // AS BORDAS SAO JOGADAS DE FORMA ALEATORIA
    public static int[] borda(char tabuleiro[][]) {
        Random random = new Random();
        int posicoes[] = new int[2], local, linha, coluna;
        boolean veridico;

        do {
            local = random.nextInt(4);

            switch (local) {
                case 0:
                    posicoes[0] = 0;
                    posicoes[1] = 1;
                    break;
                case 1:
                    posicoes[0] = 1;
                    posicoes[1] = 0;
                    break;
                case 2:
                    posicoes[0] = 2;
                    posicoes[1] = 1;
                    break;
                case 3:
                    posicoes[0] = 1;
                    posicoes[1] = 2;
                    break;
            }
            linha = posicoes[0];
            coluna = posicoes[1];
            veridico = posicaoValidaMaquina(tabuleiro, linha, coluna);
        } while (veridico == false);
        return posicoes;
    }

}
