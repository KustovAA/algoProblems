import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
    private final ITask task;
    private final String path;

    private Tester(ITask task, String path) {
        this.task = task;
        this.path = path;
    }

    private void checkAll() {
        int nr = 0;

        while (true) {
            try {
                File inFile = new File(String.format("%s/test.%d.in", path, nr));
                File outFile = new File(String.format("%s/test.%d.out", path, nr));
                runTest(inFile, outFile, nr);
                nr++;

            } catch (FileNotFoundException e) {
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private void runTest(File inFile, File outFile, int number) throws Exception {
        Scanner inReader = new Scanner(inFile);
        ArrayList<String> inLines = new ArrayList<String>();
        while (inReader.hasNextLine()) {
            String line = inReader.nextLine().trim();
            inLines.add(line);
        }

        Scanner outReader = new Scanner(outFile);
        String expected = outReader.nextLine().trim();
        String actual = task.run(inLines);

        if (expected.equals(actual)) {
            System.out.printf("Test #%d is PASSED!\n", number);
            return;
        }

        System.out.printf("Test #%d is FAILED! Expected: %s, but actual: %s\n", number, expected, actual);
    }

    public static void main(String[] args) {
        try {
            System.out.println("String Task");
            new Tester(new StringTask(), "TestModule/src/0.String").checkAll();
            System.out.println();

            System.out.println("Tickets Task");
            new Tester(new TicketsTask(), "TestModule/src/1.Tickets").checkAll();
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
