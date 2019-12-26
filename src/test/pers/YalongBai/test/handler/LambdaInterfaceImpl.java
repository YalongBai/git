package test.pers.YalongBai.test.handler;

import test.pers.YalongBai.test.utils.LambdaInterface;

import java.util.Arrays;
import java.util.stream.Stream;


public class LambdaInterfaceImpl implements LambdaInterface {
    @Override
    public void doLambda() {
        System.out.println("继承方法执行doLambda()");
    }

    public static void main(String[] args) {
        String[] a = {"a", "b", "c", "d", "dd"};
        Arrays.sort(a, (temp1, temp2)->temp1.compareTo(temp2));
        for (String as: a) {
            System.out.println(as);
        }

        Stream<String> stream = Arrays.stream(a);
        stream.sorted((temp1, temp2)->temp2.compareTo(temp1)).forEach((temp3)-> System.out.println(temp3));
        System.out.println(Arrays.toString(a));
    }
}
