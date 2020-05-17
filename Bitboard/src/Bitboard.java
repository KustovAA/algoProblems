import java.math.BigInteger;
import java.util.ArrayList;

public class Bitboard implements ITask {
    private final String mode;

    public Bitboard(String mode) {
        this.mode = mode;
    }

    @Override
    public String run(ArrayList<String> data) throws Exception {
        if (mode.equals("king")) {
            return king(Integer.parseInt(data.get(0)));
        }

        return "";
    }

    private String king(int place) {
        BigInteger k = BigInteger.ONE.shiftLeft(place);
        BigInteger kL = k.and(new BigInteger("FEFEFEFEFEFEFEFE", 16));
        BigInteger kR = k.and(new BigInteger("7F7F7F7F7F7F7F7F", 16));

        BigInteger mask = kL
                            .shiftLeft(7)
                            .or(k.shiftLeft(8))
                            .or(kR.shiftLeft(9))
                            .or(kL.shiftRight(1))
                            .or(kR.shiftLeft(1))
                            .or(kL.shiftRight(9))
                            .or(k.shiftRight(8))
                            .or(kR.shiftRight(7));

        int count = 0;
        BigInteger tmp = mask;
        while (tmp.compareTo(BigInteger.ZERO) != 0) {
            tmp = tmp.and(tmp.subtract(BigInteger.ONE));
            count++;
        }

        return String.format("%s %s", String.valueOf(count), mask.toString());
    }
}
