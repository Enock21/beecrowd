import java.io.IOException;
import java.util.Scanner;
 
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

        Integer[] entradaProcessada = conversor(entrada);

        System.out.println(somadorBit(entradaProcessada));
        scan.close();
    }

    static Integer[] conversor(String entrada){
        Integer[] list = new List<Integer>();
        return list;
    }
    
    static Integer somadorBit(Integer[] entrada){
        return 0;
    }
 
}