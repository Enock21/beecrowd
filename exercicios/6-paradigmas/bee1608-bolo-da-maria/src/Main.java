import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int T = Integer.parseInt(scan.nextLine());

        for(int i = 0; i < T; i++)
        {
            int resultadoFinal = 1;

            long D = scan.nextInt();
            int I = scan.nextInt();
            int B = scan.nextInt();

            Integer[] ingPrecos = new Integer[I];
            for (int j = 0; j < I; j++)
            {
                ingPrecos[j] = scan.nextInt();
            }

            Integer[] bolosDesc = new Integer[B];
            for (int k = 0; k < I; k++)
            {
                int ingDif = scan.nextInt();
                for (int l = 0; l < ingDif; l++)
                {
                    int ingIndex = scan.nextInt();
                    int ingQtd = scan.nextInt();
                    //Funcao a ser implementada
                    
                }
            }
        }
    }
}
