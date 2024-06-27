import java.util.Arrays;
import java.util.List;

public class SecondSmallestArr {


    public static void main(String[] args) {
        // find the second smallest number from given array
       List<Integer> arr= Arrays.asList();

        int[] array=new int[]{2,4,1,3,6,5,9,8};

        int temporary;
        int[] secondarr=new int[array.length];

        for(int i=array[0];i<array.length;i++){
            for(int j=array[1];j<array.length;j++){

                secondarr[i] = array[i];

            }
        }

        for(int i=0;i<secondarr.length;i++){
            System.out.println(secondarr[i]);
        }

    }
}
