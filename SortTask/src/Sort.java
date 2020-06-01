public abstract class Sort {
    protected void swap(String[] array, int i, int j) {
        String tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    protected String toResult(String[] array) {
        StringBuilder result = new StringBuilder();
        for (String s : array) {
            result.append(s);
            result.append(" ");
        }

        result.setLength(result.length() - 1);
        return result.toString();
    }

    public abstract String run(String[] array);
}
