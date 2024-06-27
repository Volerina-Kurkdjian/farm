package animals;

import java.util.Arrays;
import java.util.List;

public class DuckDatabase {

    public static List<Duck> getAllDucks(){

        Duck d1=new Duck("Dorothy",1000,"F", Arrays.asList("swimming","quacking","flying","dancing"));
        Duck d2=new Duck("Ducky",5000,"M", Arrays.asList("swimming","quacking","flying","fighting"));
        Duck d3=new Duck("Bogdan",7000,"M", Arrays.asList("swimming","quacking","flying","fighting","screaming","annoying me"));
        Duck d4=new Duck("Ancutza",4000,"F", Arrays.asList("swimming","quacking","flying","fighting","screaming","singing"));
        Duck d5=new Duck("Lili",4000,"F", Arrays.asList("swimming","quacking","flying","fighting","screaming","singing"));
        List<Duck> ducks=Arrays.asList(d1,d2,d3,d4,d5);
        return ducks;
    }
}
