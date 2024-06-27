import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void showAll(List<? extends Number> list){

        for(Number n:list){
            System.out.println(n);
        }
    }

    public static double sumAll(List<? extends Number> list){

        double sum=0;
        for(Number n:list){
            sum+=n.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {

      List<? extends Number> l1=new ArrayList<>();
         //l1.add(new Integer(23)); can not add items to an upper bound wild card
        // because we can not guarantee to what list it is really pointing to
        // we can only read the items
        List<? extends Number> l=new ArrayList<Integer>();
        List<? extends Number> l2=new ArrayList<Double>();
        List<? extends Number> l3=new ArrayList<Float>();

        showAll(Arrays.asList(1.2f,1.5f,3.8f));

        System.out.println(sumAll(Arrays.asList(2.3,4.5,6.7,10.9)));

    }
}