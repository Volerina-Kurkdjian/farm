package animals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AnotherHorseActions {

    public static int ceva(){

        try {  // Optionally throw an exception here
            System.out.print("1");
            return -1;
        }
        catch (Exception e) {
            System.out.print("2");
            return -2;
        }
        finally {
            System.out.print("\n3");
            return -3;  }

    }


    public static List<String> horsenamesList(){

      return  HorseDatabase.getAllHorses().stream()
                .map(Horse::getName)
                .collect(Collectors.toList());
    }

    public static Integer horseUnaryOperator(){
       return HorseDatabase.getAllHorses().stream()
                .reduce(0,(i,s)->i+s.getActivities().size(),(a,b)->a+b);

    }


    public static Integer horseReduce(){
      return  HorseDatabase.getAllHorses().stream()
                .map(Horse::getActivities)
                .map(List::size)
                .reduce(0,(i,s)->i+s);
    }


    public static void main(String[] args) {


//        try { throw new IOException(); }
//        catch (IOException | FileNotFoundException p) {
//
//        }

//        try { System.out.println(Integer.parseInt(args[1])); }
//        catch (ArrayIndexOutOfBoundsException | NumberFormatException e)
//        { System.out.println("Missing or invalid input"); }

        System.out.println("\n"+ceva());

        System.out.println(horsenamesList());

        System.out.println("\n reduce");
        System.out.println(horseUnaryOperator());

        System.out.println("\n reduce 1");
        System.out.println(horseReduce());


        String res = Arrays.asList("one", "two","three","four")
                .stream()
                .reduce("",
                        (accumulatedStr, str) -> accumulatedStr + str);

        System.out.println(res);

        

    }
}
