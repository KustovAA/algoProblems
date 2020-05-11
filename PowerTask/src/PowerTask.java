import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;

public class PowerTask implements ITask {
    @Override
    public String run(ArrayList<String> data) throws Exception {
        if (data.size() < 2) {
            throw new Error("incorrect args, should be 2 int");
        }

        String result = binaryLogarithmic(
                new BigDecimal(data.get(0)),
                Integer.parseInt(data.get(1))
        ).toString();

        return result.substring(0, Math.min(result.length(), 17));
    }

    private BigDecimal binaryLogarithmic(BigDecimal base, int power) {
        if (power == 0) {
            return BigDecimal.ONE;
        }

        BigDecimal result = new BigDecimal("1");

        while (power > 1) {
            if (power % 2 != 0) {
                result = result.multiply(base);
                power--;
            }

            base = base.multiply(base);
            power /= 2;
        }

        return result.multiply(base, MathContext.DECIMAL64);
    }
}
