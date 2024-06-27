package animals;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class DuckActions {

    static BiConsumer<String,List<String>> duckBiConsumer=(name, activities)->{
        System.out.println("Name: "+name+" activities: "+activities);
    };

    static Consumer<Duck> duckFatter=s->s.getWeight();

    static Predicate<Duck> duckPredicate=s->s.getWeight()>2000;
    static Predicate<Duck> duckPredicateGender=s->s.getGender().equalsIgnoreCase("F");
    static Predicate<Duck> duckPredicateWeightLess=s->s.getWeight()<7000;
    static Predicate<Duck> duckPredicateWeightMore=s->s.getWeight()>4000;


    static void printName(){

        Consumer<Duck> consumer=s-> System.out.println(s.getName());
        List<Duck> duckList= DuckDatabase.getAllDucks();
        duckList.forEach(consumer);
    }

    static void printNameAndActivities(){//biConsumer from consumer

        List<Duck> ducks=DuckDatabase.getAllDucks();
        ducks.forEach((duck->duckBiConsumer.accept(duck.getName(),duck.getActivities())));
    }

    static void filterDucksByWeight(){
        List<Duck> ducks=DuckDatabase.getAllDucks();
        ducks.forEach((duck->{
            if(duckPredicate.test(duck)) {
                duckBiConsumer.accept(duck.getName(), duck.getActivities());
            }
        }));
    }

    static void filterDucksByGenderAndWeight(){
        List<Duck> ducks=DuckDatabase.getAllDucks();
        ducks.forEach((duck -> {

            if(duckPredicateGender.and(duckPredicate).test(duck)){
                duckBiConsumer.accept(duck.getName() ,duck.getActivities());
            }
        }));
    }

    static void filterDucksByWeightHigher(){
        List<Duck> ducks=DuckDatabase.getAllDucks();
        ducks.forEach((duck->{
            if(duckPredicateWeightLess.and(duckPredicateWeightMore).test(duck)){
                duckBiConsumer.accept(duck.getName(), duck.getActivities());
            }
        }));
    }

    static void printMales(){
        List<Duck> ducks=DuckDatabase.getAllDucks();
        ducks.forEach((duck -> {
            if(duckPredicateGender.negate().test(duck)){
                duckBiConsumer.accept(duck.getName(), duck.getActivities());
            }
        }));
    }

    

    public static void main(String[] args) {
        printNameAndActivities();
        System.out.println("\n weight");
        filterDucksByWeight();
        System.out.println("\ngender and weight");
        filterDucksByGenderAndWeight();
        System.out.println("/n weight between");
        filterDucksByWeightHigher();
        System.out.println("\nprint males");
        printMales();
    }
}
