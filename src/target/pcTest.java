package target;

class Test {
    private static Test singleTon = new Test();
    public static int count1;
    public static int count2 = 0;

    private Test() {
        count1++;
        count2++;
    }

    public static Test getInstance() {
        return singleTon;
    }
}

public class pcTest {
    public static void main(String[] args) {
        Test singleTon = Test.getInstance();
        System.out.println("count1=" + singleTon.count1);
        System.out.println("count2=" + singleTon.count2);
    }
}