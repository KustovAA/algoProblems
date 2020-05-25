import java.math.BigInteger;
import java.util.ArrayList;

public class GreatestCommonDivisorTask implements ITask {
    private String mode;

    public GreatestCommonDivisorTask(String mode) {
        this.mode = mode;
    }

    @Override
    public String run(ArrayList<String> data) throws Exception {
        if (data.size() < 2) {
            throw new Error("incorrect args, should be 2 int");
        }

        if (mode.equals("subtraction")) {
            return subtraction(
                new BigInteger(data.get(0), 10),
                new BigInteger(data.get(1), 10)
            ).toString(10);
        }

        if (mode.equals("remainder")) {
            return remainder(
                new BigInteger(data.get(0), 10),
                new BigInteger(data.get(1), 10)
            ).toString(10);
        }

        if (mode.equals("binary")) {
            return binary(
                    new BigInteger(data.get(0), 10),
                    new BigInteger(data.get(1), 10)
            ).toString(10);
        }

        return null;
    }

    private BigInteger subtraction(BigInteger a, BigInteger b) {
        while (!b.equals(a)) {
            if (a.compareTo(b) > 0) a = a.subtract(b);
            else b = b.subtract(a);
        }
        return a;
    }

    private BigInteger remainder(BigInteger a, BigInteger b) {
        while (!a.equals(BigInteger.ZERO) && !b.equals(BigInteger.ZERO)) {
            if (a.compareTo(b) > 0) a = a.mod(b);
            else b = b.mod(a);
        }
        return a.max(b);
    }

    private BigInteger binary(BigInteger a, BigInteger b) {
        BigInteger multiplicator = BigInteger.ONE;

        while (!a.equals(b)) {
            boolean isAUpdated = false;
            boolean isBUpdated = false;

            if (a.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                a = a.divide(BigInteger.TWO);
                isAUpdated = true;
            }

            if (b.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                b = b.divide(BigInteger.TWO);
                isBUpdated = true;
            }

            if (isAUpdated && isBUpdated) {
                multiplicator = multiplicator.multiply(BigInteger.TWO);
            }

            if (!isAUpdated && !isBUpdated) {
                if (a.compareTo(b) > 0) {
                    a = a.subtract(b);
                } else {
                    b = b.subtract(a);
                }
            }
        }

        return a.multiply(multiplicator);
    }
}
