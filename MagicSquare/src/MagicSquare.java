import java.util.Arrays;
import java.util.function.BiFunction;

public class MagicSquare {
    private int size;
    private BiFunction<int[], Integer, String> drawer;

    private MagicSquare(int size, BiFunction<int[], Integer, String> drawer) {
        this.size = size;
        this.drawer = drawer;
    }

    private void draw() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(drawer.apply(new int[]{i, j}, size));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Square #1");
        new MagicSquare(9, (arr, size) -> arr[0] < arr[1] ? "#  " : ".  ").draw();
        System.out.println();
        System.out.println("Square #2");
        new MagicSquare(9, (arr, size) -> arr[0] == arr[1] ? "#  " : ".  ").draw();
        System.out.println();
        System.out.println("Square #3");
        new MagicSquare(9, (arr, size) -> arr[0] == size - 1 - arr[1] ? "#  " : ".  ").draw();
        System.out.println();
        System.out.println("Square #4");
        new MagicSquare(9, (arr, size) -> size - 1 - arr[1] > arr[0] - 3 ? "#  " : ".  ").draw();
        System.out.println();
        System.out.println("Square #5");
        new MagicSquare(9, (arr, size) -> arr[1] < (arr[0] + 1) * 2 && arr[1] >= (arr[0] + 1) * 2 - 2 ? "#  " : ".  ").draw();
        System.out.println();
        System.out.println("Square #6");
        new MagicSquare(9, (arr, size) -> arr[0] < size / 2 || arr[1] < size / 2 ? "#  " : ".  ").draw();
        System.out.println();
        System.out.println("Square #7");
        new MagicSquare(9, (arr, size) -> arr[0] >= size / 2 && arr[1] >= size / 2 ? "#  " : ".  ").draw();
        System.out.println();
        System.out.println("Square #8");
        new MagicSquare(9, (arr, size) -> arr[0] == 0 || arr[1] == 0 ? "#  " : ".  ").draw();
        System.out.println();
        System.out.println("Square #9");
        new MagicSquare(9, (arr, size) -> arr[0] > arr[1] + 3 || arr[1] > arr[0] + 3 ? "#  " : ".  ").draw();
        System.out.println();
        System.out.println("Square #10");
        new MagicSquare(9, (arr, size) -> arr[0] < arr[1] && arr[0] >= arr[1] - arr[0] - 1 ? "#  " : ".  ").draw();
        System.out.println();
        System.out.println("Square #11");
        new MagicSquare(9, (arr, size) -> (arr[0] - 1) * (arr[1] - 1) == 0 || (size - arr[0] - 2) * (size - arr[1] - 2) == 0 ? "#  " : ".  ").draw();
        System.out.println();
        System.out.println("Square #16");
        new MagicSquare(9, (arr, size) ->
                (arr[0] > 1 && arr[0] < size - 2) &&
                (arr[1] > 1 && arr[1] < size - 2) &&
                (arr[0] <= arr[1] && arr[0] >= arr[1] - 2 || arr[1] <= arr[0] && arr[1] >= arr[0] - 2) &&
                (arr[0] - 2 <= size - 1 - arr[1] && arr[0] + 1 >= size - 1 - arr[1] || arr[1] <= size - 1 - arr[0] && arr[1] >= size - 1 - arr[0] - 2) ?
                "#  " :
                ".  "
        ).draw();
        System.out.println();
        System.out.println("Square #18");
        new MagicSquare(9, (arr, size) -> (arr[0] < 2 || arr[1] < 2) && !Arrays.equals(arr, new int[]{0, 0}) ? "#  " : ".  ").draw();
        System.out.println();
        System.out.println("Square #19");
        new MagicSquare(9, (arr, size) -> arr[0] * arr[1] == 0 || (size - arr[0] - 1) * (size - arr[1] - 1) == 0 ? "#  " : ".  ").draw();
        System.out.println();
        System.out.println("Square #20");
        new MagicSquare(9, (arr, size) -> arr[0] % 2 == arr[1] % 2 ? "#  " : ".  ").draw();
        System.out.println();
        System.out.println("Square #22");
        new MagicSquare(9, (arr, size) -> (arr[0] + arr[1]) % 3 == 0 ? "#  " : ".  ").draw();
        System.out.println();
        System.out.println("Square #23");
        new MagicSquare(13, (arr, size) -> arr[1] % 2 == 0 && arr[0] % 3 == 0 ? "#  " : ".  ").draw();
        System.out.println();
        System.out.println("Square #24");
        new MagicSquare(9, (arr, size) -> arr[0] == arr[1] || size - 1 - arr[0] == arr[1] ? "#  " : ".  ").draw();
        System.out.println();
        System.out.println("Square #25");
        new MagicSquare(10, (arr, size) -> arr[1] % 3 == 0 || arr[0] % 3 == 0 ? "#  " : ".  ").draw();
        System.out.println();
    }
}
