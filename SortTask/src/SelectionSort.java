public class SelectionSort extends Sort {
    @Override
    public String run(String[] array) {
        if (array.length > 10000) {
            return null;
        }

        for (int i = 0; i < array.length; i++) {
            int minValue = Integer.parseInt(array[i]);
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                int value = Integer.parseInt(array[j]);
                if (value < minValue) {
                    minValue = value;
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }

        return toResult(array);
    }
}
