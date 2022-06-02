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
     * Calcula o Máximo Divisor Comum (MDC) de dois números passados como parâmetros.
     * @param a Numerador.
     * @param b Denominador.
     * @return MDC inteiro.
     */
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
}