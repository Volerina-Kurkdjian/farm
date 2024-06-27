package generics;

class Hashtable<K,V>{

    private K key;
    private V value;

    public Hashtable(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Hashtable{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}

public class AppGenerics {


    public static <T,V> boolean checkEquality(T value1, V value2){
        if(value1==value2){
            return true;
        }
        return false;
    }

    public static <T> boolean checkEquality1(T t1, T t2) {
        return t1.equals(t2);
    }

    public static void main(String[] args) {
        Hashtable hashtable=new Hashtable("Kevin",22);
        Hashtable hashtable1=new Hashtable(22,23);

        System.out.println(checkEquality(1,2.4));
        System.out.println( checkEquality1(1,2.4));
        System.out.println( checkEquality1(1,1));



    }

}
