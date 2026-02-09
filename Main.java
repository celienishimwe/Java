package practice;

public class Main {
    public static void main(String[] args) {
        NumberOperations numOper = new NumberOperations();
       int result1 = numOper.multiply(2,3);
        int result2 = numOper.multiply(3,4,5);
        double result3 = numOper.multiply(2.4,4.5);

        System.out.println("result one :" + " " + result1);
        System.out.println("result two :" + " " + result2);
        System.out.println("result three :" + " " + result3);
    }
}
