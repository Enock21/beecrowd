import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner scan = new Scanner(System.in);
        int numLinhas = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < numLinhas; i++)
        {
            String calculoStr = scan.nextLine();

            char operacao = ' ';
            for (int j = 0; j < calculoStr.length(); j++)
            {
                if (calculoStr.charAt(j) == '+' ||
                    calculoStr.charAt(j) == '-' ||
                    calculoStr.charAt(j) == '*')
                {
                    operacao = calculoStr.charAt(j);
                    break;
                }else if (j == calculoStr.length() - 1)
                {
                    operacao = '/';
                }
            }

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
        Integer[] calculoArray = new Integer[4];
        
        int count = 0;
        String fatia = "";
        for (int i = 0; i < calculo.length(); i++)
        {
            if (i == calculo.length() - 1)
            {
                fatia += calculo.charAt(i);
                calculoArray[count] = Integer.parseInt(fatia);
            }
            if (calculo.charAt(i) == ' ' ||
                calculo.charAt(i) == '+' ||
                calculo.charAt(i) == '-' ||
                calculo.charAt(i) == '*' ||
                calculo.charAt(i) == '/')
            {
                if (!fatia.equals(""))
                {
                    calculoArray[count] = Integer.parseInt(fatia);
                    count++;
                    fatia = "";
                    continue;
                }else { continue; }
            }

            fatia += calculo.charAt(i);
        }

        int count2 = 0;
        for (int i = 0; i < retorno.length; i++)
        {
            for (int j = 0; j < retorno.length; j++)
            {
                int num = calculoArray[count2];
                retorno[i][j] = num;
                count2++;
            }
        }    

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
            }else
            {
                retorno[1][0] = racional[0];
                retorno[1][1] = racional[1];
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
        Integer[] resultado = new Integer[2];

        int numerador1 = calculo[0][0];
        int denominador1 = calculo[0][1];
        int numerador2 = calculo[1][0];
        int denominador2 = calculo[1][1];

        resultado[0] = (numerador1 * denominador2) + (numerador2 * denominador1);
        resultado[1] = denominador1 * denominador2;

        return resultado;
    }

    public static Integer[] subtrator(Integer[][] calculo)
    {
        Integer[] resultado = new Integer[2];

        int numerador1 = calculo[0][0];
        int denominador1 = calculo[0][1];
        int numerador2 = calculo[1][0];
        int denominador2 = calculo[1][1];

        resultado[0] = (numerador1 * denominador2) - (numerador2 * denominador1);
        resultado[1] = denominador1 * denominador2;

        return resultado;
    }

    public static Integer[] multiplicador(Integer[][] calculo)
    {
        Integer[] resultado = new Integer[2];

        int numerador1 = calculo[0][0];
        int denominador1 = calculo[0][1];
        int numerador2 = calculo[1][0];
        int denominador2 = calculo[1][1];

        resultado[0] = numerador1 * numerador2;
        resultado[1] = denominador1 * denominador2;

        return resultado;
    }

    public static Integer[] divisor(Integer[][] calculo)
    {
        Integer[] resultado = new Integer[2];

        int numerador1 = calculo[0][0];
        int denominador1 = calculo[0][1];
        int numerador2 = calculo[1][0];
        int denominador2 = calculo[1][1];

        resultado[0] = numerador1 * denominador2;
        resultado[1] = numerador2 * denominador1;

        return resultado;
    }

}
