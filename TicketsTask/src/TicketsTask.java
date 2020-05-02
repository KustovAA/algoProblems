import java.util.ArrayList;

public class TicketsTask implements ITask {
    public String run(ArrayList<String> data) throws Exception {
        if (data.size() < 1) {
            return "";
        }

        int num = Integer.parseInt(data.get(0));

        if (num < 1 || num > 10) {
            throw new Exception("incorrect args, num should be between 1 and 10");
        }

        ArrayList<Long> resArray = new ArrayList<Long>();
        ArrayList<Long> tempArray = new ArrayList<Long>();

        for (int i = 0; i < 10; i++) resArray.add(1L);
        for (int i = 0; i < num * 9 - 9; i++) resArray.add(0L);

        for (int i = 0; i < num - 1; i++) {
            for (int j = 0; j < resArray.size(); j++) {
                if (j < 10) {
                    long sum = 0L;
                    for (int k = j; k >= 0 ; k--) {
                        sum += resArray.get(k);
                    }
                    tempArray.add(sum);

                } else {
                    long sum = 0L;
                    for (int k = j; k > j - 10; k--) {
                        sum += resArray.get(k);
                    }
                    tempArray.add(sum);
                }
            }
            resArray = tempArray;
            tempArray = new ArrayList<Long>();
        }

        long result = 0L;
        for (Long value : resArray) {
            result += value * value;
        }
        return Long.toString(result);
    }
}
