package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Lambda {

    public static void main(String[] args) {
//        ClickListener clickListener = new ClickListener() {
//            @Override
//            public void onClick(String abc) {
//
//            }
//        };

//        ClickListener clickListener2 = (abc, xyz) -> "xyz";
//        ClickListener clickListener3 = (abc, xyz) -> {
//            return "xyz";
//        };
//        ClickListener clickListener = (abc, xyz) -> null;

        List<Integer> list = Arrays.asList(4,5,6,7);
        list.forEach(integer -> System.out.println(integer));
        for (int i : list) {
            System.out.println(i);
        }

//        clickListener2.onClick("xyz", "abc");
        // parameter ->
    }

    public interface ClickListener {
        String onClick(String abc, String xyz);
        default void arbit() {
            System.out.println("i ma here");
        }
    }

    public interface ClickListener2 {
        default void arbit() {
            System.out.println("you are there");
        }
    }

    class A implements ClickListener, ClickListener2 {

        @Override
        public String onClick(String abc, String xyz) {
            return null;
        }

        @Override
        public void arbit() {
//            System.out.println("you are here");
//            ClickListener.super.arbit();
            ClickListener2.super.arbit();
        }

    }
}
