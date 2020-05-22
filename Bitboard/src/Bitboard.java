import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Bitboard implements ITask {
    private final String mode;

    public Bitboard(String mode) {
        this.mode = mode;
    }

    @Override
    public String run(ArrayList<String> data) throws Exception {
        switch (mode) {
            case "king":
                return king(Integer.parseInt(data.get(0)));
            case "knight":
                return knight(Integer.parseInt(data.get(0)));
            case "FEN":
                return FEN(data.get(0));
        }

        return "";
    }

    private String getResult(BigInteger mask) {
        int count = 0;
        BigInteger tmp = mask;
        while (tmp.compareTo(BigInteger.ZERO) != 0) {
            tmp = tmp.and(tmp.subtract(BigInteger.ONE));
            count++;
        }

        return String.format("%s %s", String.valueOf(count), mask.toString());
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

        return getResult(mask);
    }

    private String knight(int place) {
        BigInteger start = BigInteger.ONE.shiftLeft(place);
        BigInteger closeLeft = start.and(new BigInteger("FEFEFEFEFEFEFEFE", 16));
        BigInteger farLeft = start.and(new BigInteger("FCFCFCFCFCFCFCFC", 16));
        BigInteger closeRight = start.and(new BigInteger("7F7F7F7F7F7F7F7F", 16));
        BigInteger farRight = start.and(new BigInteger("3F3F3F3F3F3F3F3F", 16));

        BigInteger mask = closeLeft
                                .shiftLeft(15)
                                .or(farLeft.shiftLeft(6))
                                .or(farLeft.shiftRight(10))
                                .or(closeLeft.shiftRight(17))
                                .or(closeRight.shiftRight(15))
                                .or(farRight.shiftRight(6))
                                .or(farRight.shiftLeft(10))
                                .or(closeRight.shiftLeft(17));

        return getResult(mask);
    }

    private String FEN(String fen) {
        HashMap<Character, BigInteger> board = new HashMap<>();
        Set<Character> blacks = Set.of('r', 'n', 'b', 'q', 'k', 'p');
        Set<Character> whites = Set.of('R', 'N', 'B', 'Q', 'K', 'P');
        String[] table = fen.split("/");

        for (int i = table.length - 1; i >= 0 ; i--) {
            char[] line = table[i].toCharArray();
            int pos = 0;
            for (char c : line) {
                if (blacks.contains(c) || whites.contains(c)) {
                    BigInteger value = BigInteger.ONE.shiftLeft((table.length - 1 - i) * 8 + pos);
                    if (board.containsKey(c)) {
                        board.put(
                                c,
                                board.get(c).or(value)
                        );
                    } else {
                        board.put(c, value);
                    }
                    pos++;
                } else if (Character.isDigit(c)) {
                    pos += Integer.parseInt(String.valueOf(c));
                }
            }
        }

        return String.format(
                "%s %s %s %s %s %s %s %s %s %s %s %s",
                board.getOrDefault('P', BigInteger.ZERO),
                board.getOrDefault('N', BigInteger.ZERO),
                board.getOrDefault('B', BigInteger.ZERO),
                board.getOrDefault('R', BigInteger.ZERO),
                board.getOrDefault('Q', BigInteger.ZERO),
                board.getOrDefault('K', BigInteger.ZERO),
                board.getOrDefault('p', BigInteger.ZERO),
                board.getOrDefault('n', BigInteger.ZERO),
                board.getOrDefault('b', BigInteger.ZERO),
                board.getOrDefault('r', BigInteger.ZERO),
                board.getOrDefault('q', BigInteger.ZERO),
                board.getOrDefault('k', BigInteger.ZERO)
        );
    }
}
