import java.util.Scanner;
import java.util.ArrayList;

public class Main 
{
    static final int INDEX_NUMERADOR1 = 0;
    static final int INDEX_DENOMINADOR1 = 4;
    static final int INDEX_NUMERADOR2 = 8;
    static final int INDEX_DENOMINADOR2 = 12;

    public static void main(String[] args) throws Exception 
    {
        Scanner scan = new Scanner(System.in);
        //int numLinhas = Integer.parseInt(scan.nextLine());

        //TEMPORARIO
        String calculo = scan.nextLine();
        ArrayList<Integer[]> resultado = conversorStringArray(calculo);

        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                System.out.println(resultado.get(i)[j]);
            }
        }

        /*
        for (int i = 0; i < numLinhas; i++)
        {
            String calculo = scan.nextLine();
            char operacao = calculo.charAt(6);
            
            switch (operacao)
            {
                case '+':
                    System.out.println(somador(calculo));
                    break;
                case '-':
                    System.out.println(subtrator(calculo));
                    break;
                case '*':
                    System.out.println(multiplicador(calculo));
                    break;
                case '/':
                    System.out.println(divisor(calculo));
                    break;
                default:
                    System.out.println("Operação inválida!");
                    break;
            }
        }
        */

        scan.close();
    }

    public static ArrayList<Integer[]> conversorStringArray(String calculo)
    {
        ArrayList<Integer[]> retorno = new ArrayList<Integer[]>(2);

        String numerador1Str = "" + calculo.charAt(INDEX_NUMERADOR1);
        int numerador1 = Integer.parseInt(numerador1Str);

        String denominador1Str = "" + calculo.charAt(INDEX_DENOMINADOR1);
        int denominador1 = Integer.parseInt(denominador1Str);

        String numerador2Str = "" + calculo.charAt(INDEX_NUMERADOR2);
        int numerador2 = Integer.parseInt(numerador2Str);

        String denominador2Str = "" + calculo.charAt(INDEX_DENOMINADOR2);
        int denominador2 = Integer.parseInt(denominador2Str);

        retorno.get(0)[0] = numerador1;
        retorno.get(0)[1] = denominador1;
        retorno.get(1)[0] = numerador2;
        retorno.get(1)[1] = denominador2;

        return retorno;
    }
    
    public static Integer[] simplificador(Integer[] racional)
    {
        int maiorValor = 0;
        if (racional[0] >= racional[1]){ maiorValor = racional[0]; }
        else{ maiorValor = racional[1]; }

        for (int num = 2; num < maiorValor; num++)
        {
            if ((racional[0] % num == 0) &&
                (racional[1] % num == 0))
            {
                racional[0] = racional[0] / num;
                racional[1] = racional[1] / num;
            }
        }

        return racional;
    }
    
    public static String somador(String calculo)
    {
        return "somador";
    }

    public static String subtrator(String calculo)
    {
        return "subtrator";
    }

    public static String multiplicador(String calculo)
    {
        return "multiplicador";
    }

    public static String divisor(String calculo)
    {
        return "divisor";
    }

}
