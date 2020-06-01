import java.util.ArrayList;

public class SortTask implements ITask {
    private final Sort sort;

    public SortTask(String mode) {
        switch (mode) {
            case "selection":
                sort = new SelectionSort();
                break;
            case "insertion":
                sort = new InsertionSort();
                break;
            case "shell":
                sort = new ShellSort();
                break;
            case "heap":
                sort = new HeapSort();
                break;
            default:
                sort = null;
        }
    }

    @Override
    public String run(ArrayList<String> data) throws Exception {
        if (sort == null) {
            return "";
        }

        return sort.run(data.get(1).split(" "));
    }
}
