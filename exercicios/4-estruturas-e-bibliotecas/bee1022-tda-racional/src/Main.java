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
        int numLinhas = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < numLinhas; i++)
        {
            String calculoStr = scan.nextLine();

            char operacao = calculoStr.charAt(6);

            Integer[][] calculoArrayInt = conversorStringArray(calculoStr);
            
            Integer[] resultado;

            switch (operacao)
            {
                case '+':
                    resultado = somador(calculoArrayInt);
                    break;
                case '-':
                    resultado = subtrator(calculoArrayInt);
                    break;
                case '*':
                    resultado = multiplicador(calculoArrayInt);
                    break;
                case '/':
                    resultado = divisor(calculoArrayInt);
                    break;
                default:
                    throw new IllegalArgumentException("Operação inválida!");
            }

            Integer[][] resultadoComSimplificacao = simplificador(resultado);
            String resultadoFinalStr = conversorArrayString(resultadoComSimplificacao);
            System.out.println(resultadoFinalStr);
        }

        scan.close();
    }

    public static Integer[][] conversorStringArray(String calculo)
    {
        Integer[][] retorno = new Integer[2][2];

        String numerador1Str = "" + calculo.charAt(INDEX_NUMERADOR1);
        int numerador1 = Integer.parseInt(numerador1Str);

        String denominador1Str = "" + calculo.charAt(INDEX_DENOMINADOR1);
        int denominador1 = Integer.parseInt(denominador1Str);

        String numerador2Str = "" + calculo.charAt(INDEX_NUMERADOR2);
        int numerador2 = Integer.parseInt(numerador2Str);

        String denominador2Str = "" + calculo.charAt(INDEX_DENOMINADOR2);
        int denominador2 = Integer.parseInt(denominador2Str);

        retorno[0][0] = numerador1;
        retorno[0][1] = denominador1;
        retorno[1][0] = numerador2;
        retorno[1][1] = denominador2;

        return retorno;
    }
    
    public static Integer[][] simplificador(Integer[] racional)
    {
        Integer[][] retorno = new Integer[2][2];
        retorno[0][0] = racional[0];
        retorno[0][1] = racional[1];

        int maiorValor = 0;
        if (racional[0] >= racional[1]){ maiorValor = racional[0]; }
        else{ maiorValor = racional[1]; }

        for (int num = 2; num < maiorValor; num++)
        {
            if ((racional[0] % num == 0) &&
                (racional[1] % num == 0))
            {
                retorno[1][0] = racional[0] / num;
                retorno[1][1] = racional[1] / num;
            }
        }

        return retorno;
    }
    
    public static String conversorArrayString(Integer[][] racional)
    {
        String retorno = racional[0][0] + "/" + racional[0][1] + " = " +
                         racional[1][0] + "/" + racional[1][1];
        return retorno;
    }

    public static Integer[] somador(Integer[][] calculo)
    {
        return null;
    }

    public static Integer[] subtrator(Integer[][] calculo)
    {
        return null;
    }

    public static Integer[] multiplicador(Integer[][] calculo)
    {
        return null;
    }

    public static Integer[] divisor(Integer[][] calculo)
    {
        return null;
    }

}
