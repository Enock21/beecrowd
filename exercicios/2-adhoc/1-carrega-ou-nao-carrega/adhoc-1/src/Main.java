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

    /** Transforma a string de entrada em uma lista de inteiros, de
     * forma que os números possam ser trabalhados.
    */
    static ArrayList<Integer> conversor(String entrada){
        ArrayList<Integer> listInt = new ArrayList<Integer>();
        String[] listStr = entrada.split(" ");
        listInt.add(Integer.parseInt(listStr[0]));
        listInt.add(Integer.parseInt(listStr[1]));
        return listInt;
    }
    
    static Integer somadorBit(ArrayList<Integer> entrada){
        return 0;
    }
 
}