import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner scan = new Scanner(System.in);
        int numLinhas = Integer.parseInt(scan.nextLine());

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

        scan.close();
    }

    public static Integer[] simplificador(Integer[] racional)
    {
        int maiorValor = 0;
        if (racional[0] >= racional[1]){ maiorValor = racional[0]; }
        else{ maiorValor = racional[1]; }
    }

}
