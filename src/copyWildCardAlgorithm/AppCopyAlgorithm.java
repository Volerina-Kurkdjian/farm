package copyWildCardAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppCopyAlgorithm {

    //upperbound wildcard for reading
    //lowerbound wildcard for insertion
    public static <T> void copy(List<? extends T> source, List<? super T> destination){
        for(int i=0;i< source.size();i++){
            destination.add(source.get(i));
        }
    }

    public static void main(String[] args) {
        List<String> list= Arrays.asList("Adam","Eve","Corina");
        List<String> destinationList=new ArrayList<>();
        copy(list,destinationList);
        System.out.println(destinationList);
    }
}
