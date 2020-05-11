import java.math.BigInteger;
import java.util.Arrays;

public class Matrix {
    private int width;
    private int height;
    private BigInteger[][] data;

    public Matrix(int width, int height) {
        this.width = width;
        this.height = height;
        data = new BigInteger[width][height];
    }

    BigInteger getDataByCoords(int n, int m) {
        return data[n][m];
    }

    static Matrix FibIdentity() {
        Matrix identity = new Matrix(2, 2);

        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++) {
                if (i == j) {
                    identity.data[i][j] = new BigInteger("1");
                } else {
                    identity.data[i][j] = new BigInteger("0");
                }
            }

        return identity;
    }

    static Matrix FibBase() {
        Matrix base = new Matrix(2, 2);

        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++) {
                if (j == 1 && i == 1) {
                    base.data[i][j] = new BigInteger("0");
                } else {
                    base.data[i][j] = new BigInteger("1");
                }
            }

        return base;
    }

    public Matrix multiply(Matrix mat) {
        Matrix result = new Matrix(width, height);

        for(int i = 0; i < width; i++) {
            for(int j = 0; j < width; j++) {
                result.data[i][j] = new BigInteger("0");
                for(int k = 0; k < width; k++)
                {
                    result.data[i][j] = result.data[i][j].add(this.data[i][k].multiply(mat.data[k][j]));
                }
            }
        }

        return result;
    }

    public Matrix power(long n) {
        Matrix result = Matrix.FibIdentity();
        Matrix base =  Matrix.FibBase();

        if (n == 0) {
            return base;
        }

        while (n > 1) {
            if ((n & 1) == 1) {
                result = result.multiply(base);
            }

            base = base.multiply(base);
            n >>= 1;
        }

        return result.multiply(base);
    }
}
