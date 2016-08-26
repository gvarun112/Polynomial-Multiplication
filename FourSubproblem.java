package polyrecur2;

import java.util.Random;

public class FourSubproblem {
    private static final int n = 65536;
    public static void main(String[] args) {
        long initialTime = System.currentTimeMillis();
        int[] Output,List1,List2;
        List1 = new int[n];
        List2 = new int[n];
        
        Random gen = new Random();
        for( int i = 0 ; i < n ; i++) {
            List1[i] = -1+gen.nextInt(1);
            List2[i] = -1+gen.nextInt(1);
        }
        Output = new int[2*n];
        Output = Poly(List1, List2, n);
        for (int i = 0 ; i < 2*n-1 ; i++ ) {
            System.out.print(Output[i]+" ");
        }
        long finalTime = System.currentTimeMillis();
        long timeTaken = finalTime - initialTime;
        System.out.println("\n\nTime taken = " + timeTaken);
}

    private static int[] Poly(int[] List1, int[] List2, int n) {
        
        if (n==1) {
            int List1List2[] = new int[2];
            List1List2[0] = List1[0] * List2[0];
            return List1List2;
        }
        int List1Low[] = new int[n/2];
        int List1High[] = new int[n/2];
        int List2Low[] = new int[n/2];
        int List2High[] = new int[n/2];
        int List1LowHigh[] = new int[n/2];
        int List2LowHigh[] = new int[n/2];
        int List1List2Low[] = new int[n];
        int List1List2High[] = new int[n];
        int List1List2LowHigh[] = new int[n];
        int List1List2HighLow[] = new int[n/2];
        int List1List2Mid[] = new int[n];
        int List1List2[] = new int[2*n];
        
        for (int i = 0 ; i <n/2 ; i++ ) {
            List1Low[i] = List1[i];
            List1High[i] = List1[i+(n/2)];
            List2Low[i] = List2[i];
            List2High[i] = List2[i+(n/2)];
        }
        List1List2Low = Poly(List1Low, List2Low, n/2);  
        List1List2High = Poly(List1High, List2High, n/2);
        List1List2LowHigh = Poly(List1Low, List2High, n/2);
        List1List2HighLow = Poly(List1High, List2Low, n/2);
        
        for(int i = 0 ; i < n ; i++)
            List1List2[i] = List1List2Low[i];
        for(int i = 0 ; i < n ; i++)
            List1List2[i+n] += List1List2High[i];
        for(int i = 0 ; i < n ; i++)
            List1List2[i+n/2] += List1List2LowHigh[i];
        for(int i = 0 ; i < n ; i++)
            List1List2[i+n/2] += List1List2HighLow[i];
        return List1List2;
    }
}