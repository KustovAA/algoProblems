public class InsertionSort extends Sort {
    @Override
    public String run(String[] array) {
        if (array.length > 10000) {
            return null;
        }

        for (int i = 1; i < array.length; i++) {
            String value = array[i];
            int j = i - 1;
            while (j >= 0 && Integer.parseInt(array[j]) > Integer.parseInt(value)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = value;
        }

        return toResult(array);
    }
}
