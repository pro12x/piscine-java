public class DoOp {
    public static String operate(String[] args) {
        if (args.length == 3) {
            int first = Integer.parseInt(args[0]);
            char sign = args[1].charAt(0);
            int second = Integer.parseInt(args[2]);

            return switch (sign) {
                case '+' -> String.valueOf(first + second);
                case '-' -> String.valueOf(first - second);
                case '*' -> String.valueOf(first * second);
                case '/' -> second == 0 ? "Error" : String.valueOf(first / second);
                case '%' -> second == 0 ? "Error" : String.valueOf(first % second);
                default -> "Error";
            };
        }
        return "it depend on the input";
    }
}
