import java.math.BigInteger;
import java.util.ArrayList;

public class FiboTask implements ITask {
    private String mode;

    public FiboTask(String mode) {
        this.mode = mode;
    }

    @Override
    public String run(ArrayList<String> data) throws Exception {
        if (data.size() < 1) {
            throw new Error("incorrect args, should be 1 int");
        }

        if (mode.equals("iterative")) {
            return iterative(Long.parseLong(data.get(0))).toString();
        }

        if (mode.equals("matrix")) {
            return matrix(Long.parseLong(data.get(0))).toString();
        }

        return null;
    }

    private BigInteger iterative(long n) {
        if (n < 2) {
            return new BigInteger(String.valueOf(n));
        }

        BigInteger f = new BigInteger("0");
        BigInteger f1 = new BigInteger("1");
        BigInteger tmp;

        for (int i = 2; i <= n; i++) {
            tmp = f.add(f1);
            f = f1;
            f1 = tmp;
        }

        return f1;
    }

    private BigInteger matrix(long n) {
        if (n <= 2) {
            return new BigInteger(String.valueOf(Math.min(n, 1)));
        }

        return Matrix.FibIdentity().power(n - 1).getDataByCoords(0, 0);
    }
}
