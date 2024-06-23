package gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes;

import java.util.Scanner;

public class JogadaUsuario {

    /* 
    == ESCOLHEDNO LINHA ==
    O usuário deve escolher a linha em que deseja jogar
     */
    public static int leiaCoordenadaLinha() {
        Scanner input = new Scanner(System.in);
        int linha;
        System.out.print("Digite a linha em que deseja jogar: ");
        linha = input.nextInt();
        return linha;
    }

    /* 
    == ESCOLHEDNO COLUNA ==
    O usuário deve escolher a coluna em que deseja jogar
     */
    public static int leiaCoordenadaColuna() {
        Scanner input = new Scanner(System.in);
        int coluna;
        System.out.print("Digite a coluna em que deseja jogar: ");
        coluna = input.nextInt();
        return coluna;
    }

}
