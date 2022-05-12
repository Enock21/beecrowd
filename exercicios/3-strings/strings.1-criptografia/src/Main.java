import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
 
/**
 *
 */
public class Main {
    static HashMap<Integer, Character> tabelaAscii = new HashMap<Integer, Character>();
 
    public static void main(String[] args) throws IOException {
        //Error: Time limit exceeded

        adcNaTabela();

        int numLinhas;
        Scanner scan = new Scanner(System.in);
        numLinhas = Integer.parseInt(scan.nextLine());

        String retorno = "";

        for (int i = 0; i < numLinhas; i++){
            String texto = scan.nextLine();
            String cripto = criptografia(texto);
        
            if (i == numLinhas){
                retorno += cripto;
            }else{
                retorno += cripto + "\n";
            }
        }

        System.out.println(retorno);

        scan.close();

    }

    public static void adcNaTabela(){
        tabelaAscii.put(32,' ');
        tabelaAscii.put(33,'!');
        tabelaAscii.put(34,'"');
        tabelaAscii.put(35,'#');
        tabelaAscii.put(36,'$');
        tabelaAscii.put(37,'%');
        tabelaAscii.put(38,'&');
        tabelaAscii.put(39,'\'');
        tabelaAscii.put(40,'(');
        tabelaAscii.put(41,')');
        tabelaAscii.put(42,'*');
        tabelaAscii.put(43,'+');
        tabelaAscii.put(44,',');
        tabelaAscii.put(45,'-');
        tabelaAscii.put(46,'.');
        tabelaAscii.put(47,'/');
        tabelaAscii.put(48,'0');
        tabelaAscii.put(49,'1');
        tabelaAscii.put(50,'2');
        tabelaAscii.put(51,'3');
        tabelaAscii.put(52,'4');
        tabelaAscii.put(53,'5');
        tabelaAscii.put(54,'6');
        tabelaAscii.put(55,'7');
        tabelaAscii.put(56,'8');
        tabelaAscii.put(57,'9');
        tabelaAscii.put(58,':');
        tabelaAscii.put(59,';');
        tabelaAscii.put(60,'<');
        tabelaAscii.put(61,'=');
        tabelaAscii.put(62,'>');
        tabelaAscii.put(63,'?');
        tabelaAscii.put(64,'@');
        tabelaAscii.put(65,'A');
        tabelaAscii.put(66,'B');
        tabelaAscii.put(67,'C');
        tabelaAscii.put(68,'D');
        tabelaAscii.put(69,'E');
        tabelaAscii.put(70,'F');
        tabelaAscii.put(71,'G');
        tabelaAscii.put(72,'H');
        tabelaAscii.put(73,'I');
        tabelaAscii.put(74,'J');
        tabelaAscii.put(75,'K');
        tabelaAscii.put(76,'L');
        tabelaAscii.put(77,'M');
        tabelaAscii.put(78,'N');
        tabelaAscii.put(79,'O');
        tabelaAscii.put(80,'P');
        tabelaAscii.put(81,'Q');
        tabelaAscii.put(82,'R');
        tabelaAscii.put(83,'S');
        tabelaAscii.put(84,'T');
        tabelaAscii.put(85,'U');
        tabelaAscii.put(86,'V');
        tabelaAscii.put(87,'W');
        tabelaAscii.put(88,'X');
        tabelaAscii.put(89,'Y');
        tabelaAscii.put(90,'Z');
        tabelaAscii.put(91,'[');
        tabelaAscii.put(92,'\\');
        tabelaAscii.put(93,']');
        tabelaAscii.put(94,'^');
        tabelaAscii.put(95,'_');
        tabelaAscii.put(96,'`');
        tabelaAscii.put(97,'a');
        tabelaAscii.put(98,'b');
        tabelaAscii.put(99,'c');
        tabelaAscii.put(100,'d');
        tabelaAscii.put(101,'e');
        tabelaAscii.put(102,'f');
        tabelaAscii.put(103,'g');
        tabelaAscii.put(104,'h');
        tabelaAscii.put(105,'i');
        tabelaAscii.put(106,'j');
        tabelaAscii.put(107,'k');
        tabelaAscii.put(108,'l');
        tabelaAscii.put(109,'m');
        tabelaAscii.put(110,'n');
        tabelaAscii.put(111,'o');
        tabelaAscii.put(112,'p');
        tabelaAscii.put(113,'q');
        tabelaAscii.put(114,'r');
        tabelaAscii.put(115,'s');
        tabelaAscii.put(116,'t');
        tabelaAscii.put(117,'u');
        tabelaAscii.put(118,'v');
        tabelaAscii.put(119,'w');
        tabelaAscii.put(120,'x');
        tabelaAscii.put(121,'y');
        tabelaAscii.put(122,'z');
        tabelaAscii.put(123,'{');
        tabelaAscii.put(124,'|');
        tabelaAscii.put(125,'}');
        tabelaAscii.put(126,'~');
        tabelaAscii.put(128,'Ç');
        tabelaAscii.put(129,'ü');
        tabelaAscii.put(130,'é');
        tabelaAscii.put(131,'â');
        tabelaAscii.put(132,'ä');
        tabelaAscii.put(133,'à');
        tabelaAscii.put(134,'å');
        tabelaAscii.put(135,'ç');
        tabelaAscii.put(136,'ê');
        tabelaAscii.put(137,'ë');
        tabelaAscii.put(138,'è');
        tabelaAscii.put(139,'ï');
        tabelaAscii.put(140,'ï');
    }

    //Tentativa de realizar os 3 processamentos em um único laço for para promover agilidade
    public static String criptografia(String texto){
        String retorno = "";

        for (int i = texto.length() - 1; i >= 0; i--){
            char charAtual = texto.charAt(i);
            int charAtualAscii = (int) charAtual;

            if (i < texto.length() / 2){
                if (Character.isLetter(charAtual)){
                    retorno += tabelaAscii.get(charAtualAscii + 3);
                }else{
                    retorno += charAtual;
                }
            }else{
                if (Character.isLetter(charAtual)){
                    retorno += tabelaAscii.get(charAtualAscii + 2);
                }else{
                    retorno += tabelaAscii.get(charAtualAscii - 1);
                }
            }
            
        }

        return retorno;
    }
    
    //Deprecated
    public static String primeiroProcessamento(String texto){
        String retorno = "";

        for (int i = 0; i < texto.length(); i++){
            char charAtual = texto.charAt(i);
            int charAtualAscii = (int) charAtual;

            if (Character.isLetter(charAtual)){
                retorno += tabelaAscii.get(charAtualAscii + 3);
            }else{
                retorno += charAtual;
            }
        }

        return retorno;
    }

    //Deprecated
    public static String segundoProcessamento(String texto){
        String retorno = "";

        for (int i = texto.length() - 1; i >= 0; i--){
            retorno += texto.charAt(i);
        }

        return retorno;
    }

    public static String terceiroProcessamento(String texto){
        String retorno = "";

        for (int i = 0; i < texto.length() / 2; i++){
            retorno += texto.charAt(i);
        }

        for (int i = texto.length() / 2; i < texto.length(); i++){
            Character charAtual = texto.charAt(i);
            int charAtualAscii = (int) charAtual;
            retorno += tabelaAscii.get(charAtualAscii - 1);
        }

        return retorno;
    }
 
}