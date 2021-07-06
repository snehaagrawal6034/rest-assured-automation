import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        // map -> transforming individuals elements.
//        System.out.println(addTwo(Arrays.asList(1, 2, 3),2));


        Function<Integer, Integer> addTwoFunction = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer + 2;
            }
        };

        Function<Integer, Integer> multipltTwoFunction = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * 2;
            }
        };

        Function<String, Integer> stringLengthFunction = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };


        System.out.println(map(Arrays.asList(1,2,3), addTwoFunction));
        System.out.println(map(Arrays.asList(1,2,3), multipltTwoFunction));
        System.out.println(length(Arrays.asList("Sds", "SDsd"), stringLengthFunction));

    }

//    public static List<Integer> addTwo(List<Integer> integers, int k) {
//        List<Integer> result = new ArrayList<>(integers.size());
//        for (Integer integer : integers) {
//            result.add(integer + k);
//        }
//        return result;
//    }

    public static List<Integer> map(List<Integer> integers, Function<Integer, Integer> function) {
        List<Integer> result = new ArrayList<>(integers.size());
        for (Integer integer : integers) {
            result.add(function.apply(integer));
        }
        return result;
    }

    public static List<Integer> length(List<String> strings, Function<String, Integer> function) {
        List<Integer> result = new ArrayList<>(strings.size());
        for (String integer : strings) {
            result.add(function.apply(integer));
        }
        return result;
    }
}
