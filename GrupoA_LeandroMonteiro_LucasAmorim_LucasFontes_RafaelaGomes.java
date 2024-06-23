/** ********************************************************************************* */
/** Centro Universitario Senac                                                     * */
/** TADS - 1o semestre de 2024                                                     * */
/** Fernando Almeida                                                               * */
/** * */
/** Projeto SEMESTRAL I                                                            * */
/** Arquivo: Grupo A - Leandro Monteiro, Lucas Amorim, Lucas Fontes, Rafaela Gomes * */
/** * */
/** Leandro Monteiro dos Santos                                                    * */
/** Lucas Amorim Maia                                                              * */
/** Lucas Fontes Rodrigues                                                         * */
/** Rafaela Gomes dos Santos                                                       * */
/** * */
/** 28/05/2024                                                                     * */
/** ********************************************************************************* */
package gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes;

import static gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes.Mostrar.imprimeMenuPrincipal;
import static gupoa.leandromonteirolucasamorimlucasfontesrafaelagomes.Tabuleiro.inicializarTabuleiro;
import java.util.Random;
import java.util.Scanner;

public class GrupoA_LeandroMonteiro_LucasAmorim_LucasFontes_RafaelaGomes {


    public static void main(String[] args) {
        char tabuleiro[][];
        tabuleiro = inicializarTabuleiro();
        imprimeMenuPrincipal(tabuleiro);

    }

}