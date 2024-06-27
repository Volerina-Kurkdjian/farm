package defaultexamples;

import animals.Horse;
import animals.HorseDatabase;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class DefaultMethodExample2 {


    static Consumer<Horse> horseConsumer=(horse-> System.out.println(horse));


    public static void sortByname(List<Horse> horseList){

        System.out.println("After sort!");
        Comparator<Horse> nameComparator= Comparator.comparing(Horse::getName);
        horseList.sort(nameComparator);
        horseList.forEach(horseConsumer);
    }

    public static void main(String[] args) {

        List<Horse> list= HorseDatabase.getAllHorses();
        System.out.println("Before sort!");
        list.forEach(horseConsumer);

        sortByname(list);






    }
}
