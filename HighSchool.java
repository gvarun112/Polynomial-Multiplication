package polymulti;

import java.util.ArrayList;
import java.util.Random;

public class HighSchool {
    private static final int n = 65536;
    public static void main(String[] args) {
        ArrayList<Integer> List1 = new ArrayList<>();
        ArrayList<Integer> List2 = new ArrayList<>();
        ArrayList<Integer> Output = new ArrayList<>();
        long initialTime = System.currentTimeMillis();
        Random gen = new Random();
        for( int i = 0 ; i < n ; i++) {
            List1.add(-1+gen.nextInt(1));
            List2.add(-1+gen.nextInt(1));
        }
        Output = multiply(List1, List2);
        System.out.println("Output:"+Output);
        long finalTime = System.currentTimeMillis();
        long timeTaken = finalTime - initialTime;
        System.out.println("\nTime taken = " + timeTaken);
    }
    
    private static ArrayList<Integer> multiply(ArrayList<Integer> list1,ArrayList<Integer> list2) {
        ArrayList<Integer> array =new ArrayList<Integer>(list1.size()+list2.size());
        for (int i=0;i<list1.size()+list2.size()-1;i++)
            array.add(i, 0);
        for (int i = 0; i < list1.size(); i++)
            for (int j = 0; j < list2.size(); j++)
                array.set(i+j, ((list1.get(i) * list2.get(j))+array.get(i+j)));
    return array;
    }
}