import model.*;

import java.util.Date;

public class Program {

    public static void main(String[] args) {
        IArray<Integer> singleArray = new SingleArray<>();
        IArray<Integer> vectorArray = new VectorArray<>(1000);
        IArray<Integer> factorArray = new FactorArray<>();
        IArray<Integer> matrixArray = new MatrixArray<>();
        testAddArray(singleArray, 100000);
        testAddArray(vectorArray, 1000000);
        testAddArray(factorArray, 10000000);
        testAddArray(matrixArray, 10000000);

//        matrixArray.add(13, 9);
//        System.out.println(matrixArray.get(20));
//        System.out.println(matrixArray.remove(9));
//        System.out.println(matrixArray.remove(9));
//        System.out.println(matrixArray.remove(9));
//        System.out.println(matrixArray.size());
    }

    private static void testAddArray(IArray<Integer> data, int total) {
        long start = System.currentTimeMillis();

        for (int j = 0; j < total; j ++)
            data.add(j);

        System.out.println(data + " testAddArray: " +
                (System.currentTimeMillis() - start));
    }
}
