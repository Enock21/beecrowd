import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner scan = new Scanner(System.in);
        int numLinhas = Integer.parseInt(scan.nextLine());

        int num1 = 0;
        int den1 = 0;
        char operacao = '.';
        int num2 = 0;
        int den2 = 0;
        for (int i = 0; i < numLinhas; i++)
        {
            num1 = scan.nextInt(); //Pega o numerador 1
            scan.next(); //Pula a próxima barra
            den1 = scan.nextInt(); //Pega o denominador 1
            operacao = scan.next().charAt(0); //Pega o sinal que indica a operação
            num2 = scan.nextInt(); //Pega o numerador 2
            scan.next(); //Pula a próxima barra
            den2 = scan.nextInt(); //Pega o denominador 2

        }

        Integer[] resultado;
        switch (operacao)
        {
            case '+':
                resultado = somador(num1, den1, num2, den2);
                break;
            case '-':
                resultado = subtrator(num1, den1, num2, den2);
                break;
            case '*':
                resultado = multiplicador(num1, den1, num2, den2);
                break;
            case '/':
                resultado = divisor(num1, den1, num2, den2);
                break;
            default:
                scan.close();
                throw new IllegalArgumentException("Operação inválida!");
        }

        Integer[][] resultadoSimplificado = simplificador(resultado);
        System.out.println(conversorArrayString(resultadoSimplificado));

        /*
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
        */
    
        scan.close();
    }

    

    /*
    //Deprecated
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
    */

    //Errado!
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

    public static Integer[] somador(int num1, int den1, int num2, int den2)
    {
        Integer[] resultado = new Integer[2];

        resultado[0] = (num1 * den2) + (num2 * den1);
        resultado[1] = den1 * den2;

        return resultado;
    }

    public static Integer[] subtrator(int num1, int den1, int num2, int den2)
    {
        Integer[] resultado = new Integer[2];

        resultado[0] = (num1 * den2) - (num2 * den1);
        resultado[1] = den1 * den2;

        return resultado;
    }

    public static Integer[] multiplicador(int num1, int den1, int num2, int den2)
    {
        Integer[] resultado = new Integer[2];

        resultado[0] = num1 * num2;
        resultado[1] = den1 * den2;

        return resultado;
    }

    public static Integer[] divisor(int num1, int den1, int num2, int den2)
    {
        Integer[] resultado = new Integer[2];

        resultado[0] = num1 * den2;
        resultado[1] = num2 * den1;

        return resultado;
    }

}
