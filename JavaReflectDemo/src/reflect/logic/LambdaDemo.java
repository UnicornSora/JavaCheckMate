package reflect.logic;

/**
 * Created by eszha on 2016/12/7.
 */
public class LambdaDemo {
    interface Printer {
        void print(String val);
    }

    public void printSomething(String something, Printer printer) {
        printer.print(something);
    }

    public static void main(String[] args) {
        LambdaDemo lambdaDemo = new LambdaDemo();
        String demostring = "lambda";
        Printer printer = val -> System.out.println(val);
        lambdaDemo.printSomething(demostring, printer);
    }
}
