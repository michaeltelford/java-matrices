
package matrices;

import java.io.PrintStream;

/**
 * Main class for creating Matrix objects and performing calculations.
 * @author Michael Telford
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        PrintStream out = System.out;
        Matrix a = new Matrix(3, 3);
        int av[] = {-2, 1, 8, 6, -4, 3, -1, 0, 2};
        a.setValues(av);
        a.printMatrix();
        out.println();
        Matrix b = new Matrix(3, 3);
        int bv[] = {-3, 4, 11, 12, -8, 9, -2, 1, 4};
        b.setValues(bv);
        b.printMatrix();
        out.println();
        Matrix ans = Calculations.subtract(a, b);
        ans.printMatrix();
    }
}