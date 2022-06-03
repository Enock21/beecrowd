/*
Autor: Enock Bezerra Ferreira de Souza.
Problema: BEE 1028.
Título: Figurinhas.

Descrição

Ricardo e Vicente são aficionados por figurinhas. Nas horas vagas, eles arrumam um jeito de jogar um “bafo” ou algum outro jogo que envolva tais figurinhas. Ambos também têm o hábito de trocarem as figuras repetidas com seus amigos e certo dia pensaram em uma brincadeira diferente. Chamaram todos os amigos e propuseram o seguinte: com as figurinhas em mãos, cada um tentava fazer uma troca com o amigo que estava mais perto seguindo a seguinte regra: cada um contava quantas figurinhas tinha. Em seguida, eles tinham que dividir as figurinhas de cada um em pilhas do mesmo tamanho, no maior tamanho que fosse possível para ambos. Então, cada um escolhia uma das pilhas de figurinhas do amigo para receber. Por exemplo, se Ricardo e Vicente fossem trocar as figurinhas e tivessem respectivamente 8 e 12 figuras, ambos dividiam todas as suas figuras em pilhas de 4 figuras (Ricardo teria 2 pilhas e Vicente teria 3 pilhas) e ambos escolhiam uma pilha do amigo para receber.

Entrada

A primeira linha da entrada contém um único inteiro N (1 ≤ N ≤ 3000), indicando o número de casos de teste. Cada caso de teste contém 2 inteiros F1 (1 ≤ F1 ≤ 1000) e F2 (1 ≤ F2 ≤ 1000) indicando, respectivamente, a quantidade de figurinhas que Ricardo e Vicente têm para trocar.

Saída

Para cada caso de teste de entrada haverá um valor na saída, representando o tamanho máximo da pilha de figurinhas que poderia ser trocada entre dois jogadores.
*/

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int numCasos = Integer.parseInt(scan.nextLine());
       
        for (int i = 0; i < numCasos; i++)
        {
            int f1 = scan.nextInt();
            int f2 = scan.nextInt();
            System.out.println(mdc(f1, f2));
        }

        scan.close();
    }

    /**
     * Realiza o mdc entre os números f1 e f2 usando o algoritmo de Euclides.
     */
    static int mdc(int f1, int f2)
    {
        int maior = f1;
        int menor = f2;
        int temp = 0; //Variável cujo propósito é o de temporariamente guardar um valor durante uma troca de valores entre duas variáveis.

        do
        {
            if (menor > maior)
            {
                temp = maior;
                maior = menor;
                menor = temp;
            }

            maior = maior - menor;            
        }while(menor > 0);

        return maior;
    }
}