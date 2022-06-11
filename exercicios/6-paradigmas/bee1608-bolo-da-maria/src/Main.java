/*
Autor: Enock Bezerra Ferreira de Souza
Problema: BEE 1608
Título: Bolos da Maria

Descrição:

Dona Maria é uma senhora que está aposentada e faz doces. Ela começou a fazer bolos para complementar a renda da família.

Para fazer um bolo, Dona Maria precisa de certa quantidade de alguns ingredientes diferentes. Cada ingrediente tem um custo fixo por unidade. Ela tem uma quantia de dinheiro D máxima para gastar na compra dos ingredientes. Dentre os tipos de bolos que existem, você deve escolher apenas um tipo, de maneira a maximizar a quantia de bolos.

Calcule o número máximo de bolos de um único tipo que podem ser confeccionados.

Entrada:

Na primeira linha terá um inteiro T (T ≤ 100) indicando o número de casos de teste.

Para cada cada caso de teste, na primeira linha haverá três números inteiros D (1 ≤ D ≤ 109), I (1 ≤ I ≤ 100) e B (1 ≤ B ≤ 100) indicando o dinheiro que Dona Maria tem, o número de ingredientes existentes e a quantidade de tipo de bolos existentes, respectivamente. A próxima linha conterá I números inteiros indicando o preço da unidade de cada ingrediente. Seguem B linhas seguirão descrevendo cada bolo. O i-ésimo bolo é descrito da seguinte maneira: inicialmente há um número Qi (1 ≤ Qi ≤ 100) que indicará quantos ingredientes diferentes serão necessários. Logo em seguida teremos Qi pares de números indicando respectivamente o índice do ingrediente e a quantidade necessária, todos na mesma linha separados por espaços.

A quantia de cada ingrediente em um bolo poderá variar de 1 até 1000. Cada unidade de um ingrediente custará entre 1 e 1000. Os ingredientes na descrição de cada bolo serão diferentes. Os identificadores de ingrediente vão de 0 até I-1.

Saída:

Para cada caso imprima o número máximo de bolos do mesmo tipo que podem ser confeccionados.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int T = Integer.parseInt(scan.nextLine());

        //Loop para cada caso:
        for(int i = 0; i < T; i++)
        {
            long D = scan.nextInt();
            int I = scan.nextInt();
            int B = scan.nextInt();

            Integer[] ingPrecos = new Integer[I];
            //Loop para a coleta de cada preço de cada ingrediente:
            for (int j = 0; j < I; j++)
            {
                ingPrecos[j] = scan.nextInt();
            }

            Integer[] bolosPrecoUni = new Integer[B];
            //Loop para a coleta das descrições de cada bolo:
            for (int k = 0; k < B; k++)
            {
                bolosPrecoUni[k] = 0;
                int ingDif = scan.nextInt();
                //Loop para a coleta de ingredientes diversos para cada bolo e cálculo do preco de cada bolo:
                for (int l = 0; l < ingDif; l++)
                {
                    int ingIndex = scan.nextInt();
                    int ingQtd = scan.nextInt();
                    bolosPrecoUni[k] += (ingQtd * ingPrecos[ingIndex]);
                }
            }

            int maxBolo = calculaMaxBolo(bolosPrecoUni, D);
            System.out.println(maxBolo);

        }
        
        scan.close();
    }

    /**
     * Método que calcula a maior quantidade em que um tipo de bolo pode ser produzido com o dinheiro disponível.
     * @param bolosPrecoUni Array de Integer contendo os precos unitários de cada bolo.
     * @param dinheiro Indica o dinheiro disponível.
     * @return A maior quantidade em que um bolo pode ser produzido.
     */
    public static int calculaMaxBolo(Integer[] bolosPrecoUni, long dinheiro)
    {
        int maxBolo = 0;
        Integer[] maximosBolos = new Integer[bolosPrecoUni.length];

        for (int i = 0; i < bolosPrecoUni.length; i++)
        {
            maximosBolos[i] = 0;
            int multiBolos = 0;
            while(true)
            {
                multiBolos += bolosPrecoUni[i];
                if (multiBolos > dinheiro) { break; }
                maximosBolos[i]++;
            
            }
        }

        for (int k = 0; k < maximosBolos.length; k++)
        {
            if (maximosBolos[k] > maxBolo) { maxBolo = maximosBolos[k]; }
        }

        return maxBolo;
    }
}
