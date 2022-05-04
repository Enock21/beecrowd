import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
 
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Main {
 
    public static void main(String[] args) throws IOException {
 
        Scanner scan = new Scanner(System.in);
        String entrada = scan.nextLine();

        ArrayList<Integer> entradaProcessada = conversor(entrada);

        System.out.println(somadorBit(entradaProcessada));
        scan.close();
    }

    /**
     * Transforma a string de entrada em uma lista de inteiros, de
     * forma que os números possam ser trabalhados.
     */
    static ArrayList<Integer> conversor(String entrada){
        ArrayList<Integer> listInt = new ArrayList<Integer>();
        String[] listStr = entrada.split(" ");
        
        for (int i = 0; i < listStr.length; i++){
            listInt.add(Integer.parseInt(listStr[i]));
        }

        return listInt;
    }
    
    /**
     * Realiza soma bit a bit.
     * @param entrada: 
     * @return
     */
    static Integer[] somadorBit(ArrayList<Integer> entrada){
        Integer[] resultadoBinario = new Integer[32];

        int valor1Atual = entrada.get(0);
        int valor2Atual = entrada.get(1);
        for (int i = 0; i < 32; i++){
            resultadoBinario[i] = (valor1Atual % 2) ^ (valor2Atual % 2);
            valor1Atual = valor1Atual / 2;
            valor2Atual = valor2Atual / 2;
        }

        return resultadoBinario;
    }

    static Integer conversorBinarioDecimal(Integer[] intBinario){
        Integer numDecimal = 0;
        
        for (int i = 0; i < 32; i++){
            numDecimal = numDecimal + intBinario[i] * Math.pow(2, i);//Problema de conversao
        }
    }
 
}