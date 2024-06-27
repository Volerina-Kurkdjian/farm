package wildcards;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppUpperBound {

//    public static void drawAll(List<?> shapes){
//        for(Object o:shapes){
//           o.draw();
//        }
//    }

    //this is bounded type parameter
    public static <T extends Shape> void drawAll(List<T> shapes){
        for(T o:shapes){
            o.draw();
        }
    }

    //this is a wildcard
    public static void print(List<?> list){
        for(Object o:list){
            System.out.println(o);
        }
    }

    //Upper Bound Wildcard <? extends T>
    //Can read items
    //Can not insert(add) items because we don't know to what list it is really pointing to
    public static <T extends Shape> void printUpper(List<? extends T> list){
        for(Object o:list){
            System.out.println(o);
        }
    }


    public static void main(String[] args) {
        List<String> nums= Arrays.asList("Anna","Mickey");
        print(nums);

        List<? extends Serializable> numss= Arrays.asList("Anna","Mickey",1,23.0F);
        print(numss);

        List<Rectangle> rectangles=new ArrayList<>();
        List<Circle> circles=new ArrayList<>();
        rectangles.add(new Rectangle());

        //the Shape is the parent class for Rectangle
        //but List<Shape> is not the parent class for List<Rectangle>
        //to solve this problem we use List<?>(unbounded wildcard) instead of List<Shape>, and we must use Object instead of Shape in the for loop
        drawAll(rectangles);

    }
}
