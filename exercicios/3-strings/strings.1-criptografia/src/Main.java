/*
Autor: Enock Bezerra Ferreira de Souza
Título: BEE 1024 - Criptografia

Descrição: 

Solicitaram para que você construisse um programa simples de criptografia. Este programa deve possibilitar enviar mensagens codificadas sem que alguém consiga lê-las. O processo é muito simples. São feitas três passadas em todo o texto.

Na primeira passada, somente caracteres que sejam letras minúsculas e maiúsculas devem ser deslocadas 3 posições para a direita, segundo a tabela ASCII: letra 'a' deve virar letra 'd', letra 'y' deve virar caractere '|' e assim sucessivamente. Na segunda passada, a linha deverá ser invertida. Na terceira e última passada, todo e qualquer caractere a partir da metade em diante (truncada) devem ser deslocados uma posição para a esquerda na tabela ASCII. Neste caso, 'b' vira 'a' e 'a' vira '`'.

Por exemplo, se a entrada for “Texto #3”, o primeiro processamento sobre esta entrada deverá produzir “Wh{wr #3”. O resultado do segundo processamento inverte os caracteres e produz “3# rw{hW”. Por último, com o deslocamento dos caracteres da metade em diante, o resultado final deve ser “3# rvzgV”.

Entrada:
A entrada contém vários casos de teste. A primeira linha de cada caso de teste contém um inteiro N (1 ≤ N ≤ 1*104), indicando a quantidade de linhas que o problema deve tratar. As N linhas contém cada uma delas M (1 ≤ M ≤ 1*103) caracteres.

Saída:
Para cada entrada, deve-se apresentar a mensagem criptografada.
*/

import java.io.IOException;
import java.util.Scanner;
import java.lang.StringBuilder;
 
public class Main {

    /**
     * Método principal que realiza a leitura e exibição de texto. A primeira linha deve ser um número inteiro correspondente a quantidade de linhas a serem criptografadas. As próximas linhas devem conter um texto. Após cada linha de texto será exibida a sua versão criptografada.
     */
    public static void main(String[] args) throws IOException {
        long numLinhas;
        Scanner scan = new Scanner(System.in);
        numLinhas = Long.parseLong(scan.nextLine());

        for (int i = 0; i < numLinhas; i++){
            StringBuilder texto = new StringBuilder(scan.nextLine());
            StringBuilder cripto1 = primeiroProcessamento(texto);
            StringBuilder cripto2 = segundoProcessamento(cripto1);
            StringBuilder cripto3 = terceiroProcessamento(cripto2);
        
            System.out.println(cripto3);
        }

        scan.close();
    }

    /**
     * Primeiro passo da criptografia, no qual o texto passado como parãmetro tem suas letras trocadas pelo caractere na tabela Ascii que se encontra 3 posições à direita da letra original.
     * @param texto Um texto original do tipo StringBuilder. Esta classe foi usada no lugar da String para promover desempenho.
     */
    public static StringBuilder primeiroProcessamento(StringBuilder texto){
        for (int i = 0; i < texto.length(); i++){
            char charAtual = texto.charAt(i);
            int charAtualAscii = (int) charAtual;

            if (Character.isLetter(charAtual)){
                texto.setCharAt(i, (char) (charAtualAscii + 3));
            }
        }

        return texto;
    }

    /**
     * Segundo passo da criptografia, na qual o texto passado como parâmetro é invertido.
     * @param texto É esperado um texto já modificado pelo primeiro passo da criptografia.
     */
    public static StringBuilder segundoProcessamento(StringBuilder texto){
        texto.reverse();
        return texto;
    }
   
    /**
     * Terceiro e último passo da criptografia no qual, a partir da metade do StringBuilder para a direita, todos os caracteres são deslocados 1 posição para a esquerda de acordo com a tabela Ascii.
     * @param texto É esperado um texto já modificado pelo primeiro e segundo passo da criptografia.
     * @return Texto pronto para exibição final.
     */
    public static StringBuilder terceiroProcessamento(StringBuilder texto){
        for (int i = texto.length() / 2; i < texto.length(); i++){
            Character charAtual = texto.charAt(i);
            int charAtualAscii = (int) charAtual;

            texto.setCharAt(i, (char) (charAtualAscii - 1));
        }

        return texto;
    }
}