import java.util.Random;

public class ExceptionUtilTool {

    public static void getException() throws Exception {
        Random random = new Random();
        int result = random.nextInt(10);
        if (result < 5) {
            throw new Exception("Random error occurred！");
        }
    }
}
