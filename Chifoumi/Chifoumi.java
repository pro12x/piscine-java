public class Chifoumi {
    public static ChifoumiAction getActionBeatenBy(ChifoumiAction chifoumiAction) {
        return switch (chifoumiAction) {
            case ChifoumiAction.ROCK -> ChifoumiAction.SCISSORS;
            case ChifoumiAction.PAPER -> ChifoumiAction.ROCK;
            case ChifoumiAction.SCISSORS -> ChifoumiAction.PAPER;
        };
    }
}
