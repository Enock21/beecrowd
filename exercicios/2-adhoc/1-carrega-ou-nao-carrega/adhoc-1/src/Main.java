import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
 
/**
 * Este programa realiza uma adição entre dois números binários de 32 bits, porém com um erro específico: o bit de carry é sempre 0. Entradas e saídas são sempre em decimal.
 */
public class Main {
 
    /**
     * Devem ser digitados 2 números inteiros no console, separados apenas por um espaço. O resultado é uma soma errônea, feita considerando que todos os bits de carry são iguais a 0. O programa é encerrado quando o usuário digita EOF.
     */
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String entrada;

        do{
            if (scan.hasNextLine()){
                entrada = scan.nextLine();
            } else { break; }

            if (entrada.equals("EOF")) { break; }

            ArrayList<Long> entradaProcessada = conversor(entrada);
            Integer[] respostaBinaria = somadorBit(entradaProcessada);
            Long respostaFinal = conversorBinarioDecimal(respostaBinaria);

            System.out.println(respostaFinal);
        }while (true);

        scan.close();
    }

    /**
     * Transforma a string de entrada em uma lista de inteiros (Long), de forma que os números possam ser trabalhados.
     * 
     * @param entrada Esperam-se dois números inteiros (Long) separados por um espaço.
     * @return Um ArrayList<Long> contendo os números da entrada.
     */
    static ArrayList<Long> conversor(String entrada){
        ArrayList<Long> listLong = new ArrayList<Long>();
        String[] listStr = entrada.split(" ");
        
        for (int i = 0; i < listStr.length; i++){
            listLong.add(Long.parseLong(listStr[i]));
        }

        return listLong;
    }
    
    /**
     * Converte os números de decimal para binário e realiza a soma bit a bit, considerando que todos os bits de carry são iguais a 0.
     * 
     * @param entrada Um ArrayList<Long> com os dois números da entrada.
     * @return O resultado da soma em binário no formato de um array de Integer com 32 posições.
     */
    static Integer[] somadorBit(ArrayList<Long> entrada){
        Integer[] resultadoBinario = new Integer[32];

        Long valor1Atual = entrada.get(0);
        Long valor2Atual = entrada.get(1);

        for (int i = 0; i < 32; i++){
            resultadoBinario[i] = (int) ((valor1Atual % 2) ^ (valor2Atual % 2));
            valor1Atual = valor1Atual / 2;
            valor2Atual = valor2Atual / 2;
        }

        return resultadoBinario;
    }

    /**
     * Converte um número binário em decimal.
     * 
     * @param intBinario Um número binário representado por um Integer[] de 32 posições.
     * @return A representação decimal e inteira (formato long) do número binário da entrada.
     */
    static Long conversorBinarioDecimal(Integer[] intBinario){
        double numDecimal = 0;
        
        for (int i = 0; i < 32; i++){
            numDecimal += intBinario[i] * Math.pow(2, i);
        }

        return (long) numDecimal;
    }
 
}