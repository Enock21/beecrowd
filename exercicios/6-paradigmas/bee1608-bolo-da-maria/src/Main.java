import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int T = Integer.parseInt(scan.nextLine());

        for(int i = 0; i < T; i++)
        {
            long D = scan.nextInt();
            int I = scan.nextInt();
            int B = scan.nextInt();

            Integer[] ingPrecos = new Integer[I];
            for (int j = 0; j < I; j++)
            {
                ingPrecos[j] = scan.nextInt();
            }

            Integer[] bolosPrecoUni = new Integer[B];
            for (int k = 0; k < I; k++)
            {
                bolosPrecoUni[k] = 0;
                int ingDif = scan.nextInt();
                for (int l = 0; l < ingDif; l++)
                {
                    int ingIndex = scan.nextInt();
                    int ingQtd = scan.nextInt();
                    bolosPrecoUni[k] += (ingQtd * ingPrecos[ingIndex]);
                }
            }

            int maxBolo = calculaMaxBolo(bolosPrecoUni, D);
            System.out.println(maxBolo);
        }
    }

    public static int calculaMaxBolo(Integer[] bolosPrecoUni, long dinheiro)
    {
        int maxBolo = 0;
        Integer[] maximos = new Integer[bolosPrecoUni.length];

        for (int i = 0; i < bolosPrecoUni.length; i++)
        {
            int multiBolos = 0;
            while(true)
            {
                multiBolos += bolosPrecoUni[i];
                if (multiBolos > dinheiro) { break; }
                else if (multiBolos > maximos[i]){ maximos[i] = multiBolos; }
            }
        }

        for (int k = 0; k < maximos.length; k++)
        {
            if (maximos[k] > maxBolo) { maxBolo = maximos[k]; }
        }

        return maxBolo;
    }
}
