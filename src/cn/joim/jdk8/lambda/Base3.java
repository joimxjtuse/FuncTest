package cn.joim.jdk8.lambda;

/**
 * 自定义函数式接口.
 */
public class Base3 {

    public static void main(String[] args) {

        GreetingService serviceWithlambda = message -> {
            System.out.println(message);
        };

        GreetingService serviceWithMethodRefrence = System.out::println;
    }
}
