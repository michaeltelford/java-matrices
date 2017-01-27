
package matrices;

/**
 * Used to perform calculations on Matrix objects such as add, subtract and
 * multiply.  All methods are static class methods meaing no instance of this
 * class is needed.
 * @author Michael Telford
 */
public abstract class Calculations {

    public Calculations(){
        // Constructor not used due to class being abstract.
    }

    public static boolean inArray(int value, int[] array){
        for (int i=0; i < array.length; i++){
            if (value == array[i])
                return true;
        }
        return false;
    }

    public static boolean inArray(String value, String[] array){
        for (int i=0; i < array.length; i++){
            if (value.equals(array[i]))
                return true;
        }
        return false;
    }

    public static boolean inArray(Object value, Object[] array){
        for (int i=0; i < array.length; i++){
            if (value == array[i])
                return true;
        }
        return false;
    }

    public static void printArray(int[] a){
        for (int i=0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }

    public static void printArrayln(int[] a){
        for (int i=0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

    public static void printArray(String[] a){
        for (int i=0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }

    public static void printArrayln(String[] a){
        for (int i=0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

    public static void printArray(Object[] a){
        for (int i=0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }

    public static void printArrayln(Object[] a){
        for (int i=0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

    public static int addArrayValues(int[] values){
        int result = 0;
        for (int i=0; i < values.length; i++){
            result += values[i];
        }
        return result;
    }

    public static void fillArray(int[] array, int value){
        for (int i=0; i < array.length; i++){ // For each value in array
            array[i] = value;
        }
    }

    public static boolean hasSameOrder(Matrix a, Matrix b){
        return a.getNumRows() == b.getNumRows() &&
                a.getNumColumns() == b.getNumColumns();
    }

    public static boolean hasSameMaxValues(Matrix a, Matrix b){
        return (a.getMaxValues() == b.getMaxValues());
    }

    // Tests whether the same values occur in any order.
    public static boolean hasSameValues(Matrix a, Matrix b) throws Exception {
        if (!Calculations.hasSameMaxValues(a, b))
            throw new Exception("Cannot compare Matrices objects, " +
                    "Matrix objects have different max values");
        int count = 0;
        for (int i : a.getValues()){ // For each of a's values
            count = a.getAmountOfValues(i);
            if (count != b.getAmountOfValues(i))
                return false;
        }
        return true;
    }

    // Tests whether the same values occur in the same order.
    public static boolean hasSameValuesInOrder(Matrix a, Matrix b){
        return a.getValues() == b.getValues();
    }

    public static Matrix transpose(Matrix a){
        int[] values = new int[a.getNumColumns()];
        Matrix b = new Matrix(a.getNumColumns(), a.getNumRows());
        for (int i=1; i <= a.getNumRows(); i++){
            values = a.getRowValues(i);
            b.setColumnValues(i, values);
        }
        return b;
    }

    public static Matrix add(Matrix a, Matrix b) throws Exception {
        if (!Calculations.hasSameOrder(a, b))
            throw new Exception("Cannot add Matrices objects, " +
                    "Matrix objects are of different order");
        int[] results = new int[a.getMaxValues()];
        for (int i=0; i < a.getValues().length; i++){
            results[i] = a.getValues()[i] + b.getValues()[i];
        }
        Matrix c = new Matrix(a.getNumRows(), a.getNumColumns());
        c.setValues(results);
        return c;
    }

    public static Matrix subtract(Matrix a, Matrix b) throws Exception {
        if (!Calculations.hasSameOrder(a, b))
            throw new Exception("Cannot subtract Matrices objects, " +
                    "Matrix objects are of different order");
        int[] results = new int[a.getMaxValues()];
        for (int i=0; i < a.getValues().length; i++){
            results[i] = a.getValues()[i] - b.getValues()[i];
        }
        Matrix c = new Matrix(a.getNumRows(), a.getNumColumns());
        c.setValues(results);
        return c;
    }

    public static Matrix multiply(Matrix a, int numberOfTimes){
        int[] v = new int[a.getMaxValues()];
        for (int i=0; i < a.getMaxValues(); i++){
            v[i] = a.getValues()[i] * numberOfTimes;
        }
        Matrix c = new Matrix(a.getNumRows(), a.getNumColumns());
        c.setValues(v);
        return c;
    }

    public static Matrix multiply(Matrix a, Matrix b) throws Exception {
        if (a.getNumColumns() != b.getNumRows())
            throw new Exception("Matrix objects cannot be multiplied, "
                    + "Matrix objects are of incorrect order");
        int count = 0;
        int[] values = new int[a.getMaxValues()];
        int[] results = new int[a.getNumRows() * b.getNumColumns()];
        for (int r=0; r < a.getNumRows(); r++){ // For a's rows
            for (int c=0; c < b.getNumColumns(); c++){ // For b's columns
                for (int v=0; v < b.getNumRows(); v++){ // For each value
                    values[v] = a.getRowValues(r+1)[v] *
                            b.getColumnValues(c+1)[v];
                }
                results[count] = Calculations.addArrayValues(values);
                count++;
            }
        }
        Matrix c = new Matrix(a.getNumRows(), b.getNumColumns());
        c.setValues(results);
        return c;
    }

    public static Matrix square(Matrix a) throws Exception {
        if (!a.isSquare())
            throw new Exception("Matrix object order is not square");
        return Calculations.multiply(a, a);
    }
}