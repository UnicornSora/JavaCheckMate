import java.util.Scanner;

public class TestScanner {

    public static void main(String[] args) {
        getParamForConsole();
    }

    private static void getParamForConsole() {
        System.out.println("请输入+—*来获取结果，输入exit退出");
        Scanner scanner = new Scanner(System.in);
        String c = scanner.next();
        if (!"exit".equals(c)) {
            doSomeThing(c);
        } else {
            System.out.println("退出");
        }
    }

    private static void doSomeThing(String c) {
        switch (c) {
            case "+": {
                for (int p = 1; p < 10; p++) {
                    for (int o = 1; o <= p; o++) {
                        System.out.print(p + "+" + o + "=" + (p + o) + "\t");
                    }
                    System.out.print("\n");
                }
            }
            System.out.println("你输入的是'+'，的到加法口诀");
            break;
            case "-":
                System.out.println("你输入的是'-'，得到减法口诀");
                break;
            case "*": {
                for (int i = 1; i < 10; i++) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print(i + "*" + j + "=" + (i * j) + "\t");
                    }
                    System.out.print("\n");
                }
            }
            System.out.println("你输入的是*，得到乘法口诀");
            break;
            default:
                System.out.println("请输入+—*来获取结果，输入exit退出");
                break;
        }
        getParamForConsole();
    }
}
