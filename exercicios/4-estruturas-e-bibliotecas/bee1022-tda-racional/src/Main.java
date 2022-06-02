/*
Autor: Enock Bezerra Ferreira de Souza
Problema: BEE 1022
Título: TDA Racional

Descrição

A tarefa aqui neste problema é ler uma expressão matemática na forma de dois números Racionais (numerador / denominador) e apresentar o resultado da operação. Cada operando ou operador é separado por um espaço em branco. A sequência de cada linha que contém a expressão a ser lida é: número, caractere, número, caractere, número, caractere, número. A resposta deverá ser apresentada e posteriormente simplificada. Deverá então ser apresentado o sinal de igualdade e em seguida a resposta simplificada. No caso de não ser possível uma simplificação, deve ser apresentada a mesma resposta após o sinal de igualdade.

Considerando N1 e D1 como numerador e denominador da primeira fração, segue a orientação de como deverá ser realizada cada uma das operações:
Soma: (N1*D2 + N2*D1) / (D1*D2)
Subtração: (N1*D2 - N2*D1) / (D1*D2)
Multiplicação: (N1*N2) / (D1*D2)
Divisão: (N1/D1) / (N2/D2), ou seja (N1*D2)/(N2*D1)

Entrada

A entrada contem vários casos de teste. A primeira linha de cada caso de teste contem um inteiro N (1 ≤ N ≤ 1*104), indicando a quantidade de casos de teste que devem ser lidos logo a seguir. Cada caso de teste contém um valor racional X (1 ≤ X ≤ 1000), uma operação (-, +, * ou /) e outro valor racional Y (1 ≤ Y ≤ 1000).

Saída

A saída consiste em um valor racional, seguido de um sinal de igualdade e outro valor racional, que é a simplificação do primeiro valor. No caso do primeiro valor não poder ser simplificado, o mesmo deve ser repetido após o sinal de igualdade.
*/

import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        
        Scanner scan = new Scanner(System.in);
        int numLinhas = Integer.parseInt(scan.nextLine()); //Lê a quantidade de frações a serem tratadas.

        int num1 = 0;
        int den1 = 0;
        char operacao = '.';
        int num2 = 0;
        int den2 = 0;

        for (int i = 0; i < numLinhas; i++)
        {
            num1 = scan.nextInt(); //Pega o numerador 1
            scan.next(); //Pula a próxima barra
            den1 = scan.nextInt(); //Pega o denominador 1
            operacao = scan.next().charAt(0); //Pega o sinal que indica a operação
            num2 = scan.nextInt(); //Pega o numerador 2
            scan.next(); //Pula a próxima barra
            den2 = scan.nextInt(); //Pega o denominador 2

            Integer[] resultado; //Armazena o resultado do cálculo fracionário sem simplificação.
            switch (operacao)
            {
                case '+':
                    resultado = somador(num1, den1, num2, den2);
                    break;
                case '-':
                    resultado = subtrator(num1, den1, num2, den2);
                    break;
                case '*':
                    resultado = multiplicador(num1, den1, num2, den2);
                    break;
                case '/':
                    resultado = divisor(num1, den1, num2, den2);
                    break;
                default:
                    scan.close();
                    throw new IllegalArgumentException("Operação inválida!");
            }

            Integer[][] resultadoSimplificado = simplificador(resultado); //Armazena o resultado original e sua versão simplificada.
            System.out.println(conversorArrayString(resultadoSimplificado));

        }

            scan.close();
    }

    /**
     * Calcula o Máximo Divisor Comum (MDC) ao numerador e denominador passados como parâmetros.
     * @param a Numerador.
     * @param b Denominador.
     * @return MDC inteiro.
     */
    static int mdc(int a, int b)
    {

        int max = a;
        if (b > max) { max = b; }
        
        int mdc = 1;
        int div = 2;

        do
        {
            if ((a % div == 0) && (b % div == 0))
            {
                mdc *= div;
                a /= div;
                b /= div;
            }else
            {
                div++;
            }
           
        }while(div <= max);

        return mdc;

    }
    
    /**
     * Recebe um array de Integer que representa um número racional. Retorna um array de array que representa dois números racionais: o número passado como parâmetro e sua versão simplificada.
     * @param racional Um array com dois elementos: numerador no índice 0 e o denominador no índice 1.
     * @return Integer[][] que representa dois números fracionários, sendo um o número recebido como parâmetro e o outro a sua versão simplificada.
     */
    static Integer[][] simplificador(Integer[] racional)
    {
        Integer[][] retorno = new Integer[2][2];
        int num = racional[0];
        int den = racional[1];
        int mdcVar = mdc(num, den);

        retorno[0][0] = racional[0];
        retorno[0][1] = racional[1];
        retorno[1][0] = racional[0] / mdcVar;
        retorno[1][1] = racional[1] / mdcVar;

        return retorno;
    }

    /**
     * Converte o resultado do cálculo fracionário junto com sua simplificação em uma string para ser exibida na tela.
     * @param racional Um Integer[][] que contém dois números fracionários, sendo que o segundo é a versão simplificada do primeiro.
     * @return Uma String para ser exibida na tela do terminal.
     */
    public static String conversorArrayString(Integer[][] racional)
    {
        String retorno = racional[0][0] + "/" + racional[0][1] + " = " +
                         racional[1][0] + "/" + racional[1][1];
        return retorno;
    }

    /**
     * Realiza a soma entre dois números racionais e retorna o resultado racional na forma de um array de duas posições.
     */
    public static Integer[] somador(int num1, int den1, int num2, int den2)
    {
        Integer[] resultado = new Integer[2];

        resultado[0] = (num1 * den2) + (num2 * den1);
        resultado[1] = den1 * den2;

        return resultado;
    }

    /**
     * Realiza a subtração entre dois números racionais e retorna o resultado racional na forma de um array de duas posições.
     */
    public static Integer[] subtrator(int num1, int den1, int num2, int den2)
    {
        Integer[] resultado = new Integer[2];

        resultado[0] = (num1 * den2) - (num2 * den1);
        resultado[1] = den1 * den2;

        return resultado;
    }

    /**
     * Realiza a multiplicação entre dois números racionais e retorna o resultado racional na forma de um array de duas posições.
     */
    public static Integer[] multiplicador(int num1, int den1, int num2, int den2)
    {
        Integer[] resultado = new Integer[2];

        resultado[0] = num1 * num2;
        resultado[1] = den1 * den2;

        return resultado;
    }

    /**
     * Realiza a divisão entre dois números racionais e retorna o resultado racional na forma de um array de duas posições.
     */
    public static Integer[] divisor(int num1, int den1, int num2, int den2)
    {
        Integer[] resultado = new Integer[2];

        resultado[0] = num1 * den2;
        resultado[1] = num2 * den1;

        return resultado;
    }

}
