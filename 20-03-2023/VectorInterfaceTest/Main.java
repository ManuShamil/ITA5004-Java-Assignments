package VectorInterfaceTest;

import java.util.Scanner;

interface IMathObject<T> {
    public T add(T t);
    public T multiply(T t);
}

class Vector implements IMathObject<Vector> {
    private int x;
    private int y;
    private int z;

    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector add(Vector v) {
        Vector result = new Vector( this.x, this.y, this.z );
        Vector vector = (Vector) v;
        result.x += vector.x;
        result.y += vector.y;
        result.z += vector.z;

        return result;
    }

    public Vector multiply(Vector v) {
        Vector result = new Vector( this.x, this.y, this.z );
        Vector vector = (Vector) v;
        result.x *= vector.x;
        result.y *= vector.y;
        result.z *= vector.z;
        return result;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + this.z + ")";
    }
}

class Matrix implements IMathObject<Matrix> {
    private int[][] matrix;
    private int rows;
    private int columns;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
        this.rows = matrix.length;
        this.columns = matrix[0].length;
    }

    public Matrix add( Matrix other ) {
        Matrix result = new Matrix( new int[this.rows][this.columns] );
        for ( int i=0; i<this.rows; i++ )
            for ( int j=0; j<this.columns; j++ )
                result.matrix[i][j] = this.matrix[i][j] + other.matrix[i][j];
        return result;
    }

    public Matrix multiply( Matrix other ) {
        Matrix result = new Matrix( new int[this.rows][other.columns] );
        for ( int i=0; i<this.rows; i++ )
            for ( int j=0; j<other.columns; j++ )
                for ( int k=0; k<this.columns; k++ )
                    result.matrix[i][j] += this.matrix[i][k] * other.matrix[k][j];
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++)
                result += this.matrix[i][j] + " ";
            result += "\n";
        }
        return result;
    }
}


public class Main {

    private static Matrix readMatrixFromStdIn( String matrixName, int m, int n, Scanner reader ) {
        int[][] matrix = new int[m][n];

        System.out.println( String.format( "Enter Matrix %s: ", matrixName ) );

        for ( int i=0; i<m; i++ )
            for ( int j=0; j<n; j++ )
                matrix[i][j] = reader.nextInt();
        
        return new Matrix( matrix );
    }

    private static Vector readVectorFromStdIn (String vectorName, Scanner reader) {

        int x, y, z;
        System.out.println( String.format( "Enter Vector %s: ", vectorName ) );

        x = reader.nextInt();
        y = reader.nextInt();
        z = reader.nextInt();

        return new Vector(x, y, z);
    }

    public static void main(String[] args) {

        Scanner reader = new Scanner( System.in );

        Vector vecA = readVectorFromStdIn("A", reader);
        Vector vecB = readVectorFromStdIn("B", reader );

        Vector sumVec = vecA.add( vecB );
        Vector productVec = vecA.multiply( vecB );

        System.out.println( String.format("vecA + vecB = %s", sumVec.toString() ) );
        System.out.println( String.format("vecA x vecB = %s", productVec.toString() ) );


        Matrix matA = readMatrixFromStdIn("A", 3, 3, reader);
        Matrix matB = readMatrixFromStdIn("B", 3, 3, reader);
        
        Matrix sumMatrix = matA.add( matB );
        Matrix prodMatrix = matA.multiply( matB );

        // System.out.println( String.format("\nmatA -> \n%s", matA.toString() ) );
        // System.out.println( String.format("\nmatB -> \n%s", matB.toString() ) );

        System.out.println( String.format("\nmatA + matB -> \n%s", sumMatrix.toString() ) );
        System.out.println( String.format("matA * matB -> \n%s", prodMatrix.toString() ) );

        reader.close();

    }
}