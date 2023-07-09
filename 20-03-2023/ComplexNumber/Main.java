package ComplexNumber;

class Complex {
    private float realNum;
    private float imaginaryNum;

    Complex() {
        this.realNum = 0;
        this.imaginaryNum = 0;
    }

    Complex(float realNum, float imaginaryNum) {
        this.realNum = realNum;
        this.imaginaryNum = imaginaryNum;
    }

    public float getRealPart() {
        return realNum;
    }

    public float getImaginaryPart() {
        return imaginaryNum;
    }

    public Complex add( Complex b ) {
        return new Complex(  
            this.getRealPart() + b.getRealPart(),
            this.getImaginaryPart() + b.getImaginaryPart() 
        );
    }

    public Complex subtract( Complex b ) {
        return new Complex(  
            this.getRealPart() - b.getRealPart(),
            this.getImaginaryPart() - b.getImaginaryPart() 
        );
    }

    @Override
    public String toString() {
        return String.format("( %s, %s)", realNum, imaginaryNum );
    }
}

public class Main {

    public static void main(String[] args) {
        Complex compA = new Complex(50, 134);
        Complex compB = new Complex(25, 34);

        System.out.println(String.format("compA -> %s", compA));
        System.out.println(String.format("compB -> %s", compB));

        Complex sumComplex = compA.add(compB);
        System.out.println(String.format("compA + compB -> %s", sumComplex));

        Complex differenceComplex = compA.subtract(compB);
        System.out.println(String.format("compA - compB -> %s", differenceComplex));
    }
}