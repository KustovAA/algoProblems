import java.util.ArrayList;

public class StringTask implements ITask {
    public String run(ArrayList<String> data) {
        if (data.size() > 0) {
            return Integer.toString(data.get(0).length());
        }

        return "";
    }
}
