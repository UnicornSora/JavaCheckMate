public class AutoTestTool {

    public static void autoAction(String browserName, String action, String value) throws Exception {
        System.out.println(browserName + " " + action + " " + value);
        ExceptionUtilTool.getException();
    }

    public static void autoAction(String browserName, String action1, String value1, String action2, String value2) throws Exception {
        System.out.println(browserName + " " + action1 + " " + value1 + " " + action2 + " " + value2);
        ExceptionUtilTool.getException();
    }
}
