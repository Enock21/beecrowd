import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int numCasos = Integer.parseInt(scan.nextLine());
       
        for (int i = 0; i < numCasos; i++)
        {
            int f1 = scan.nextInt();
            int f2 = scan.nextInt();
            System.out.println(mdc(f1, f2));
        }

        scan.close();
    }

    /**
     * Realiza o mdc entre os números f1 e f2 usando o algoritmo de Euclides.
     * @param f1
     * @param f2
     * @return
     */
    static int mdc(int f1, int f2)
    {
        int maior = f1;
        int menor = f2;
        int temp = 0; //Variável cujo propósito é o de temporariamente guardar um valor durante uma troca de valores entre duas variáveis.

        do
        {
            if (menor > maior)
            {
                temp = maior;
                maior = menor;
                menor = temp;
            }

            maior = maior - menor;            
        }while(menor > 0);

        return maior;
    }

    /**
     * Calcula o Máximo Divisor Comum (MDC) de dois números passados como parâmetros. (DEPRECATED)
     * @param a Numerador.
     * @param b Denominador.
     * @return MDC inteiro.
     
    static int mdc(int a, int b)
    {

        int max = a;
        if (b > max) { max = b; }
        
        int mdc = 1;
        int div = 2;

        do
        {
            if ((a % div == 0) && (b % div == 0))
            {
                mdc *= div;
                a /= div;
                b /= div;
            }else
            {
                div++;
            }
           
        }while(div <= max);

        return mdc;

    }
    */
}