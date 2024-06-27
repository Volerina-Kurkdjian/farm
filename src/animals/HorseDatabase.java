package animals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class HorseDatabase {


    public static Supplier<Horse> supplierHorse=()->{

        return new Horse("Lola",5,"F","Appaloosa", Arrays.asList("riding","racing","jumping"),Optional.empty());
    };




    public static List<Horse> getAllHorses(){
        Horse h1=new Horse("Lola",5,"F","Appaloosa", Arrays.asList("riding","racing","jumping"), Optional.of(new HorseEquipment("Saddle","Boots")));
        Horse h2=new Horse("D'Artagnian",7,"M","American Belgian Draft", Arrays.asList("riding","racing","jumping","polo","equestrian fencing"),Optional.empty());
        Horse h3=new Horse("Albert",9,"M","Miniature Horse", Arrays.asList("riding","racing","jumping","polo","equestrian fencing","mounting games"),Optional.of(new HorseEquipment("Saddle","Boots")));
        Horse h4=new Horse("Micky",8,"F","Andalousia Horse", Arrays.asList("riding","racing","jumping","polo","equestrian fencing","mounting games"),Optional.of(new HorseEquipment("Saddle1","Boots1")));
        Horse h5=new Horse("Victor",10,"M","Arabian", Arrays.asList("riding","racing","jumping","polo","equestrian fencing","mounting games","horse ball"),Optional.of(new HorseEquipment("Saddle2","Boots2")));
        Horse h6=new Horse("Victor",10,"M","Mustang", Arrays.asList("riding","racing","jumping","polo","mounting games","horse ball"),Optional.of(new HorseEquipment("Saddle1","Boots4")));
        Horse h7=new Horse("Vicky",10,"F","Mustang", Arrays.asList("riding","racing","jumping","polo","mounting games","horse ball"),Optional.empty());
        Horse h8=new Horse("Joiana",10,"F","Mustang", Arrays.asList("riding","racing","jumping","polo"),Optional.of(new HorseEquipment("Saddle1","Boots2")));

        List<Horse> list=Arrays.asList(h1,h2,h3,h4,h5,h6,h7,h8);
        return list;
    }
}
