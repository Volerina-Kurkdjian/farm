package animals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SomeMainClass {

    public static void main(String[] args) {
        List<SomeLibraryClass> myObjs = List.of(
                new SomeLibraryClass("abc"), // generates "abc"
                new SomeLibraryClass("bca"), // generates "bca"
                new SomeLibraryClass("def"), // generates "def"
                new SomeLibraryClass("def"), // generates "def"
                new SomeLibraryClass("fed"), // generates "fed"
                new SomeLibraryClass("ghi")  // generates "ghi"
        );

        List<SomeLibraryClass> distinctObjs = new ArrayList<>(myObjs.stream()
                .collect(Collectors.toMap(
                        obj -> reorderString(obj.getSomeProperty()),
                        Function.identity(),
                        (existing, replacement) -> existing)
                )
                .values());

        assert(distinctObjs.size() == 3);
    }


    private static String reorderString(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }


    static class SomeLibraryClass {


        private final String someProperty;


        SomeLibraryClass(String val) {
            someProperty = val;
        }


        public String getSomeProperty() {
            return someProperty;
        }

        // No equals method
    }
}
