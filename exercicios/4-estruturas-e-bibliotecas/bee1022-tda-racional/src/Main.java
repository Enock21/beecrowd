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

        scan.close();
    }

    static int mdc(int a, int b)
    {

        int mdc = 1;
        int div = 2;

        do
        {
            if (a % div == 0)
            {
                a /= div;
            }
            if (b % div == 0)
            {
                b /= div;
            }
            if (a % div == 0 && b % div == 0)
            {
                mdc *= div;
            }
            if (a % div != 0 && b % div != 0)
            {
                div++;
            }
        }while(a > 1 && b > 1);

        return mdc;

    }
    
    static Integer[][] simplificador(Integer[] racional)
    {
        Integer[][] retorno = new Integer[2][2];
        int mdc = mdc(racional[0], racional[1]);

        retorno[0][0] = racional[0];
        retorno[0][1] = racional[1];
        retorno[1][0] = racional[0] / mdc;
        retorno[1][1] = racional[1] / mdc;

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
