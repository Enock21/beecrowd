import java.io.IOException;
import java.util.HashMap;
 
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Main {

    static HashMap<Integer, String> tabelaAscii = new HashMap<Integer, String>();
 
    public static void main(String[] args) throws IOException {
        tabelaAscii.put(32," ");
        tabelaAscii.put(33,"!");
        tabelaAscii.put(34,"\"");
        tabelaAscii.put(35,"#");
        tabelaAscii.put(36,"$");
        tabelaAscii.put(37,"%");
        tabelaAscii.put(38,"&");
        tabelaAscii.put(39,"'");
        tabelaAscii.put(40,"(");
        tabelaAscii.put(41,")");
        tabelaAscii.put(42,"*");
        tabelaAscii.put(43,"+");
        tabelaAscii.put(44,",");


        String teste = "a b c d é ñ";
        String[] testeList = teste.split(" ");

        for (int i = 0; i < testeList.length; i++){
            System.out.println(testeList[i]);
        }
 
    }

    public static String getTabelaAscii(int indice){

    }
 
}