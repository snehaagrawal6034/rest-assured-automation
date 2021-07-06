import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {

    public static void main(String[] args) {
//        Consumer<Integer> consumer = integer1 -> {
//            System.out.println(integer1);
//        };
//        consumer.accept(1);
        List<Integer> list = Arrays.asList(1,2,3);
        //1
        // 2
        // 3
        list.stream().forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }
}
