
package matrices;

/**
 * Used to create an instance of a Matrix of which calculations can be
 * performed.
 * @author Michael Telford
 */
public class Matrix {

    private int numRows;
    private int numColumns;
    private int[] values;

    public Matrix(int rows, int columns){
        this.numRows = rows;
        this.numColumns = columns;
        this.values = new int[this.numRows * this.numColumns];
    }

    public Matrix(int[] rowsColumnsValues){
        this.numRows = rowsColumnsValues[0];
        this.numColumns = rowsColumnsValues[1];
        this.values = new int[this.numRows * this.numColumns];
        int[] i = new int[rowsColumnsValues.length - 2];
        System.arraycopy(rowsColumnsValues, 2, i, 0, i.length);
        this.setValues(i);
    }

    public Matrix(int rows, int columns, int i){
        this.numRows = rows;
        this.numColumns = columns;
        this.setValuesI(i);
    }

    public int getMaxValues(){
        return this.numColumns * this.numRows;
    }

    public boolean isSquare(){
        return this.numRows == this.numColumns;
    }

    public boolean hasValue(int value){
        for (int i=0; i < this.values.length; i++){
            if (value == this.values[i])
                return true;
        }
        return false;
    }

    public int[] getAllValuePositions(int value){
        int count = 0;
        int[] pos = new int[this.getMaxValues()];
        for (int i=0; i < this.getMaxValues(); i++){ // For each value
            if (value == this.values[i]){
                pos[count] = i;
                count++;
            }
        }
        return pos;
    }

    public int getAmountOfValues(int value){
        int count = 0;
        for (int i=0; i < this.getMaxValues(); i++){
            if (value == this.values[i])
                count++;
        }
        return count;
    }

    public int getFirstValuePosition(int value){
        for (int i=0; i < this.values.length; i++){ // For each value
            if (value == this.values[i])
                return i;
        }
        return -1;
    }

    public boolean hasValues(int[] values){
        int count = 0;
        for (int i=0; i < values.length; i++){
            int value = values[i];
            for (int n=0; n < this.values.length; n++){
                if (value == this.values[n])
                    count++;
            }
        }
        return (count == values.length);
    }

    public String getOrder(){
        String order;
        order = this.getNumRows() + " * " + this.getNumColumns();
        return order;
    }

    public int[] getValues(){
        return this.values;
    }

    public void setValues(int[] values){
        for (int i = 0; i < values.length; i++){
            this.values[i] = values[i];
        }
    }

    public void setValuesI(int i){
        this.values = new int[this.getMaxValues()];
        for (int n=0; n < this.getMaxValues(); n += this.numColumns+1){
            this.values[n] = i;
        }
    }

    public int getNumRows(){
        return this.numRows;
    }

    public void setNumRows(int rows){
        this.numRows = rows;
    }

    public int getNumColumns(){
        return this.numColumns;
    }

    public void setNumColumns(int columns){
        this.numColumns = columns;
    }

    public int getValue(int row, int column){
        int position = 0;
        position = (row - 1) * this.numColumns;
        position += column;
        return this.values[position -1];
    }

    public void setValue(int row, int column, int value){
        int position = 0;
        position = (row - 1) * this.numColumns;
        position += column;
        this.values[position -1] = value;
    }

    // Do not give zero indexed position parameter
    public void setValue(int position, int value){
        this.values[position-1] = value;
    }

    public void setRowValues(int row, int[] values){
        int position = (row - 1) * this.numColumns;
        System.arraycopy(values, 0, this.values, position, this.numColumns);
    }

    public void setColumnValues(int column, int[] values){
        int position = column - 1;
        for (int i=0; i < this.numRows; i++){
            this.values[position] = values[i];
            position += this.numColumns;
        }
    }

    public int[] getRowValues(int row){
        int position = (row - 1) * this.numColumns;
        int[] v = new int[this.numColumns];
        System.arraycopy(this.values, position, v, 0, v.length);
        return v;
    }

    public int[] getColumnValues(int column){
        int position = column - 1;
        int[] v = new int[this.numRows];
        for (int i=0; i < this.numRows; i++){
            v[i] = this.values[position];
            position += this.numColumns;
        }
        return v;
    }

    public void printMatrix(){
        int offset = 0;
        for (int n = 0; n < this.numRows; n++){
            System.out.print("| ");
            for (int i = 0; i < this.numColumns; i++){
                System.out.print(this.values[offset++] + " ");
            }
            System.out.print("|\n");
        }
    }
}