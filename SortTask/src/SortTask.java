import java.util.ArrayList;
import java.util.Arrays;

public class SortTask implements ITask {
    private final String mode;

    public SortTask(String mode) {
        this.mode = mode;
    }

    @Override
    public String run(ArrayList<String> data) throws Exception {
        switch (mode) {
            case "selection":
                return selection(data.get(1).split(" "));
            case "insertion":
                return insertion(data.get(1).split(" "));
            case "shell":
                return shell(data.get(1).split(" "));
            case "heap":
                return heap(data.get(1).split(" "));
        }

        return null;
    }

    private void swap(String[] array, int i, int j) {
        String tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private void heapify(String[] array, int root, int size) {
        int L = 2 * root + 1;
        int R = L + 1;
        int X = root;

        if (L < size && Integer.parseInt(array[X]) < Integer.parseInt(array[L])) X = L;
        if (R < size && Integer.parseInt(array[X]) < Integer.parseInt(array[R])) X = R;
        if (X == root) return;
        swap(array, X, root);
        heapify(array, X, size);
    }

    private String toResult(String[] array) {
        StringBuilder result = new StringBuilder();
        for (String s : array) {
            result.append(s);
            result.append(" ");
        }

        result.setLength(result.length() - 1);
        return result.toString();
    }

    private String selection(String[] array) {
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

    private String insertion(String[] array) {
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

    private String shell(String[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
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

    private String heap(String[] array) {
        for (int i = array.length / 2; i >= 0 ; i--) {
            heapify(array, i, array.length);
        }

        for (int i = array.length - 1; i >= 0 ; i--) {
            swap(array, 0, i);
            heapify(array, 0, i);
        }

        return toResult(array);
    }
}
