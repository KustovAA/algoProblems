public class HeapSort extends Sort {
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

    @Override
    public String run(String[] array) {
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
