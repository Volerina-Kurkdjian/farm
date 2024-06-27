package BoundedTypeParameters;

class Person implements Comparable<Person>{

    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }


    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.age,o.getAge());
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

public class AppBoundedTypeParameters {

    public static <T extends Comparable> T calculateMin(T num1,T num2){

        if(num1.compareTo(num2)<0){
            return num1;
        }
        return num2;
    }

    public static void main(String[] args) {
        System.out.println(calculateMin("Kevin","Anna"));
        System.out.println(calculateMin(new Person(23,"Kevin"),new Person(24,"Anna")));



    }
}
