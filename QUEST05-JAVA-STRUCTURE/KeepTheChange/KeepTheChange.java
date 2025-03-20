import java.util.*;

public class KeepTheChange {
    public static List<Integer> computeChange(int amount, Set<Integer> coins) {
        int[] op = new int[amount + 1];
        Arrays.fill(op, Integer.MAX_VALUE);
        op[0] = 0;

        int[] coinUsed = new int[amount + 1];

        for(int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (op[i - coin] + 1 < op[i]) {
                    op[i] = op[i - coin] + 1;
                    coinUsed[i] = coin;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int remainingAmount = amount;
        while (remainingAmount > 0) {
            int coin = coinUsed[remainingAmount];
            result.add(coin);
            remainingAmount -= coin;
        }

        return result;
    }
}