public class ShellSort extends Sort {
    @Override
    public String run(String[] array) {
        int k = 1;
        for (int gap = hibbardGap(k, array.length); gap > 0; gap = hibbardGap(++k, array.length)) {
            for (int i = 0; i + gap < array.length; i++) {
                int j = i + gap;
                String value = array[j];
                while (j - gap >= 0 && Integer.parseInt(array[j - gap]) > Integer.parseInt(value)) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = value;
            }
        }

        return toResult(array);
    }

    private int frankLazaurusGap(int k, int length) {
        return 2*(length / (int) Math.pow(2, k+1)) - 1;
    }

    private int shellGap(int k, int length) {
        return length / (int) Math.pow(2, k);
    }

    private int hibbardGap(int k, int length) {
        return length / ((int) Math.pow(2, k) - 1);
    }
}
