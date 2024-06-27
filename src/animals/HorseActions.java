package animals;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class HorseActions {

    static Predicate<Horse> horsePredicateAgeSmaller=s->s.getAge()<11;
    static Predicate<Horse> horsePredicateAgeBigger=s->s.getAge()>6;

    static Predicate<Horse> horsePredicateActivitiesNumber=s->s.getActivities().size()>3;
    static Predicate<Horse> horsePredicateActivitiesNumber1=s->s.getActivities().size()<6;

    static Consumer<Horse> horseConsumer=s-> System.out.println("Name of horse: "+s.getName()+" age "+s.getAge()+" pedigree "+s.getPedegree());

    static Function<List<Horse>, Map<String,List<String>>> functionHorsesMapActivities=(horses->{

        Map<String,List<String>> horsesActivities=new HashMap<>();

        horses.forEach((horse->{
            horsesActivities.put(horse.getName(),horse.getActivities());
        }));

        return horsesActivities;

    });

    static Function<List<Horse>,Map<String,List<String>>> getFunctionHorsesMapActivities=(horses->{
            Map<String,List<String>> horsesActivities=new HashMap<>();

            horses.forEach((horse->{
                if(horsePredicateAgeBigger.and(horsePredicateAgeSmaller).and(horsePredicateActivitiesNumber).and(horsePredicateActivitiesNumber1).test(horse)) {
                    horsesActivities.put(horse.getName(), horse.getActivities());
                }
            }));

            return horsesActivities;

    });


    //horses with age between 6 and 11 years and activities number >3 and <5
    public static void filterHorseAges(){

       List<Horse> list= HorseDatabase.getAllHorses();
        System.out.println(getFunctionHorsesMapActivities.apply(list));

    }

    public static List<String> getNames(){
        List<Horse> list= HorseDatabase.getAllHorses();
       return  list.stream().map(Horse::getName).collect(toList());
    }

    public static Set<List<String>> getActivitiesWithPredicates(){
        List<Horse> list= HorseDatabase.getAllHorses();

        return list.stream().filter(horsePredicateActivitiesNumber.and(horsePredicateActivitiesNumber1)).map(Horse::getActivities).collect(Collectors.toSet());
    }



    public static Set<String> getActivitiesWithoutDuplicates(){
        List<Horse> list= HorseDatabase.getAllHorses();
        return list.stream()
                .map(Horse::getActivities)
                .flatMap(List::stream)
                .collect(Collectors.toSet());
    }

    //flatMap() is combining two collections into a single one, 2 arrays into one array, 2 lists into one list
    public static List<String> getActivitiesAsList(){
        List<Horse> list= HorseDatabase.getAllHorses();
        return list.stream()
                .map(Horse::getActivities)
                .flatMap(List::stream)
                .sorted()
                .collect(toList());

    }

    public static List<String> sortHorseByName(){
        List<Horse> list= HorseDatabase.getAllHorses();

        return list.stream()
                .sorted(Comparator.comparing(Horse::getName))
                .map(Horse::getName)
                .collect(toList());
    }

    public static List<Integer> sortHorseByAgeAscending(){
        List<Horse> list= HorseDatabase.getAllHorses();

        return list.stream()
                .sorted(Comparator.comparing(Horse::getAge))
                .map(Horse::getAge)
                .collect(toList());
    }

    public static List<Horse> sortWholeHorseByAgeDescending(){
        List<Horse> list= HorseDatabase.getAllHorses();

        return list.stream()
                .sorted(Comparator.comparing(Horse::getAge))
                .collect(toList());
    }

    //filter() input to the filter() is a Predicate Functional Interface
    public static List<String> filteredHorsesByGender(){
        List<Horse> list= HorseDatabase.getAllHorses();

        return list.stream()
                .filter(Horse->Horse.getGender().equals("F"))
                .map(Horse::getName)
                .collect(toList());
    }

    //reduce is a terminal operation; reduces the contents of a stream to a single value
    

        public static Optional<String> getName(){
          Optional<Horse> name=  Optional.ofNullable(HorseDatabase.supplierHorse.get());
           if(name.isPresent()) {
               return name.map(Horse::getName);
           }
           else return Optional.empty();
        }

        public static String optionalOrElse(){
           List<Horse>horses= HorseDatabase.getAllHorses();

           Optional<Horse> ourHorse=horses.stream().filter(s->s.getName().equals("Joiana")).findAny();

           return ourHorse.map(s->s.getName().toUpperCase()).orElse("the optional is empty!");
        }

        public static Integer optionalOrElseGet(){
            List<Horse>horses= HorseDatabase.getAllHorses();

           List<Integer> listAges= horses.stream()
                    .map(Horse::getAge)
                    .sorted()
                    .collect(toList());

           Optional<Integer> optionalSum=listAges.stream().reduce((a,b)->a+b);
           return optionalSum.orElseGet(()->0);
        }


        public static void optionalFilter(){
            List<Horse> lista=  HorseDatabase.getAllHorses();

            List<Horse> lista1=lista.stream()
                    .filter(s->s.getName().equals("Vicky"))
                    .collect(toList());

            Optional<Horse> horse=lista1.stream().findAny();
            Optional<String> name=Optional.ofNullable(horse.get().getName());

            System.out.println(name.get());

        }

        public static void optionalFilterNumberOfActivities(){
            List<Horse> lista=  HorseDatabase.getAllHorses();

           List<String> lista1= lista.stream()
                    .filter(s->s.getActivities().size()<=6)
                   .map(Horse::getActivities)
                   .flatMap(Collection::stream)
                   .collect(toList());

            System.out.println("optionalFilterNumberOfActivities");
            System.out.println(lista1);

            Optional<String> optionalsth=Optional.of(lista1.stream()
                    .filter(s->s.equalsIgnoreCase("racing"))
                            .distinct()
                    .collect(Collectors.joining()));

            Optional<String> optionalsth1=Optional.of(lista1.stream()
                    .filter(s->s.equalsIgnoreCase("racing")).collect(Collectors.joining()));

            System.out.println("\n Ce e aici ? "+optionalsth.get());
            System.out.println("\n Ce e aici ? "+optionalsth1.get());

            System.out.println(optionalsth1.map(s->s.subSequence(0,6)).get());
        }

        //map
        static void optionalFilterAge(){
            List<Horse> lista=HorseDatabase.getAllHorses();

            List<Integer> opt= lista.stream()
                    .map(Horse::getAge)
                    .collect(Collectors.toList());

            Optional<Integer> optInt= opt.stream().filter(s->s==5).findAny();

            System.out.println(optInt.get());

          Optional<String> optPedigree= lista.stream()
                    .filter(s->s.getPedegree().equals("Miniature Horse"))
                          .map(s->s.getPedegree())
                    .findAny();

            System.out.println(optPedigree);

        }

        public static void OptionalFlatMap(){

           List<Horse>list= HorseDatabase.getAllHorses();

          Optional<HorseEquipment> horseEquipment= list.stream()
                   .filter(s->s.getHorseEquipment().get().getSaddle().equals("Saddle"))
                   .map(s->s.getHorseEquipment())
                   .findFirst().get();

            horseEquipment.ifPresent(System.out::println);

        }

        public static void sortHorsesAfterSaddle(){
            List<Horse>list= HorseDatabase.getAllHorses();
            System.out.println("---------------");
           List<Optional<HorseEquipment>> optional= list.stream()
                    .map(Horse::getHorseEquipment)
                   .collect(toList());

           optional.forEach(System.out::println);

           //flatMap gets an optional object inside another optional object
            //The flatMap gets each optional value (if we used map we would get each Optional rather than its value).
            System.out.println("--------------------------------------");
           Optional<HorseEquipment> horseEquipment=optional.stream()
                   .flatMap(Optional::stream)//NU MERGEA CU MAP NU STIU DE CE
                   .filter(s->s.getSaddle().equals("Saddle1"))
                   .collect(toList()).stream()
                   .findAny();

            System.out.println(horseEquipment);
        }

        public static void  filteredOptional(){
        List<Horse>list= HorseDatabase.getAllHorses();

        //avem lista de Horse
            //din lista de Horse luam lista de Optional
       List<HorseEquipment>horseEquipmentList= list.stream()
                .map(s->s.getHorseEquipment())
                .flatMap(Optional::stream)
               .filter(s->s.getSaddle().endsWith("1"))
                .collect(toList());

       horseEquipmentList.forEach(System.out::println);

       horseEquipmentList.stream()
               .map(s->s.getSaddle())
               .filter(s->s.endsWith("1"))
               .collect(toList());

    }

    public static void main(String[] args) {

        if(true) {
//            System.out.println(functionHorsesMapActivities.apply(HorseDatabase.getAllHorses()));
//            filterHorseAges();
//            System.out.println(getNames());
//            System.out.println("\n activities");
//            System.out.println(getActivitiesWithPredicates());
//            System.out.println("\n distinct activities");
//            System.out.println(getActivitiesWithoutDuplicates());
//            System.out.println("\ngetActivitiesAsList: ");
//            System.out.println(getActivitiesAsList());
//            System.out.println("\n get horses compared by name");
//            System.out.println(sortHorseByName());
//            System.out.println("\n sort horse by age ascending");
//            System.out.println(sortHorseByAgeAscending());
//            System.out.println("\n whole horses: ");
//            System.out.println(sortWholeHorseByAgeDescending());
//            System.out.println("\n filtering female horses");
//            System.out.println(filteredHorsesByGender());

            var arr1 = new int[]{2, 12, 90};
            var arr2 = new int[]{13, 7, 1};

            Stream.of(arr1, arr2)
                    .flatMapToInt(IntStream::of)
                    .forEach(System.out::println);

            if (getName().isPresent()) {
                System.out.println(getName().get().length());
            }
        }

        if(true) {
            System.out.println("\n Optional! ");
            Optional<String> name = Optional.ofNullable(HorseDatabase.supplierHorse.get().getName());
            System.out.println(name);
            System.out.println("\n value of optional!");
            System.out.println(name.get());

            System.out.println("\n Is the optional full or not?");
            System.out.println(name.isPresent());

            System.out.println("\n the name is:");
            System.out.println(optionalOrElse());
            System.out.println("\n sum of all ages: ");
            System.out.println(optionalOrElseGet());

            optionalFilter();
            optionalFilterNumberOfActivities();

            optionalFilterAge();
        }

        OptionalFlatMap();
        sortHorsesAfterSaddle();
        filteredOptional();
    }
}
