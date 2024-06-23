package gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes;

import static gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes.JogadaMaquinaDificil.modoDificil;
import static gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes.Jogador.modoJogador;
import static gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes.MaquinaFacil.modoFacil;
import java.util.Scanner;

public class Mostrar {

    /* 
    == MOSTRANDO O TABULEIRO DO JOGO DA VELHA ==
    Função para imprimir o tabuleiro (Matriz 3x3), assim mostrando quais espaços estão preenchidos.
    no jogo da velha
     */
    public static void imprimirTabuleiro(char tabuleiro[][]) {
        System.out.println("");
        for (int i = 0; i < tabuleiro.length; ++i) {
            for (int j = 0; j < tabuleiro[i].length; ++j) {
                System.out.print(" " + tabuleiro[i][j]);
                if (j < tabuleiro[i].length - 1) {
                    System.out.print("  |");
                }
            }

            System.out.println();
            if (i < tabuleiro.length - 1) {
                System.out.println("---+---+---");
            }
        }
        System.out.println("");
    }

    /* 
    == MOSTRANDO O MENU PRINCIPAL ==
    Função para imprimir o menu do jogo e devolver qual modo de jogo foi selecionado
     */
    public static void imprimeMenuPrincipal(char tabuleiro[][]) {
        Scanner input = new Scanner(System.in);
        int escolha, volta = 0;
        do {
            do {
                System.out.println("\n *-* BEM VINDO AO MENU PRINCIPAL *-*\n");
                System.out.println("    * ESCOLHA SEU MODO DE JOGO *\n");
                System.out.println("\n[1] Jogador x Jogador\n[2] Jogador x Computador: Facil\n[3] Jogador x Computador: Dificil");
                System.out.print("Escolha: ");
                escolha = input.nextInt();
            } while (escolha < 1 || escolha > 3);

            switch (escolha) {
                case 1:
                    modoJogador(tabuleiro);
                    volta = 1;
                    break;

                case 2:
                    modoFacil(tabuleiro);
                    volta = 1;
                    break;
                case 3:
                    modoDificil(tabuleiro);
                    volta = 1;
                    break;
            }
        } while (volta == 1);

    }

    /* 
    == MOSTRANDO A PONTUAÇÃO DE CADA JOGADOR ==
     */
    public static void imprimePontuacao(int a, int b) {
        System.out.printf("\nJOGADOR 1: %d ", a);
        System.out.printf("\nJOGADOR 2: %d ", b);
        System.out.println("");
    }
        public static void imprimePontuacaoMaquina(int a, int b) {
        System.out.printf("\nJOGADOR 1: %d ", a);
        System.out.printf("\nJOGADOR 2: %d ", b);
        System.out.println("");
    }

}
