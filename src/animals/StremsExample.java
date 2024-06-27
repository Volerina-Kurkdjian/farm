package animals;

import java.util.LinkedList;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class StremsExample {

    public static void main(String[] args) {
        ToIntFunction<Integer> transformer= x->x;


        var prime= List.of(3,1,4,1,5,9)
                .stream()
                .limit(1)
                .peek(s->{})
                .mapToInt(transformer)
                .peek(s->{})
                .sum();

        System.out.println(prime);

        var list=new LinkedList<>();
        list.add("A");
        list.add("X");
        Stream s=list.stream();
        s.forEach(System.out::println);
        s.forEach(System.out::println);





    }


}
