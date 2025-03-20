// package Chifoumi;

public class Chifoumi {
    public static ChifoumiAction getActionBeatenBy(ChifoumiAction chifoumiAction) {
        return switch (chifoumiAction) {
            case ROCK -> ChifoumiAction.SCISSOR;
            case PAPER -> ChifoumiAction.ROCK;
            case SCISSOR -> ChifoumiAction.PAPER;
            default -> throw new IllegalArgumentException("Unexpected value: " + chifoumiAction);
        };
    }
}
