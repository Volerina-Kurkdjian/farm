package wildcards;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AppLowerBound {

    //how to read items from lower-bounded wildcard
    public static void showAll(List<? super Number> list){
        for(Object num : list){
            System.out.println(num);
        }
    }



    public static void main(String[] args) {
        List<? super Integer> l1=new ArrayList<Integer>();//only supertypes on the Right handside
        List<? super Integer> l2=new ArrayList<Number>();
        List<? super Integer> l3=new ArrayList<Object>();

        //how to read items from lower-bounded wildcard
        List<Serializable> list=new ArrayList<>();
        list.add("Adam");
        list.add("Ana");
        list.add("Kevin");
        list.add("WOW");
        showAll(list);

        //how to insert items into lower-bounded wildcard
        List<? super Number> arrayList=new ArrayList<>();//only supertypes on the Right handside
        arrayList.add(new Integer(3));
        arrayList.add(new Integer(4));
        arrayList.add(new Integer(5));
        showAll(arrayList);



    }
}
