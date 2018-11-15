public class ComplexNumber {
    private double a;
    private double b;

    public ComplexNumber( double a, double b ) {
        this.a = a;
        this.b = b;
    }

    public ComplexNumber( ComplexNumber other ) {
        this.a = other.a;
        this.b = other.b;
    }

    public double getRealMagnitude() {
        return this.a;
    }

    public double getImaginaryMagnitude() {
        return this.b;
    }

    @Override public String toString() {
        if ( a == 0 && b == 0 )
            return "0";
        if ( a == 0 && b != 0 )
            return b + "i";
        if ( a != 0 && b == 0 )
            return "" + a;
        return this.a + " + " + this.b + "i";
    }

    public void add( double scalar ) {
        this.a += scalar;
    }

    public void add( ComplexNumber other ) {
        this.a += other.a;
        this.b += other.b;
    }

    public void subtract( double scalar ) {
        this.a -= scalar;
    }

    public void subtract( ComplexNumber other ) {
        this.a -= other.a;
        this.b -= other.b;
    }

    public void multiply( double scalar ) {
        this.a *= scalar;
        this.b *= scalar;
    }

    public void multiply( ComplexNumber other ) {
        //the middle
        double temp = ( this.a * other.b ) + ( this.b * other.a );

        //Deals with i^2
        this.a *= other.a;
        this.b *= other.b;
        this.b *= -1;

        //Sets values
        this.a += this.b;
        this.b = temp;
    }

    public boolean divideBy( double scalar ) {
        if ( scalar != 0 ) {
            this.a /= scalar;
            this.b /= scalar;
            return true;
        }
        return false;
    }

    public boolean divideBy( ComplexNumber other ) {
        if ( other.a != 0 && other.b != 0 ) {
            double tempA = ( ( this.a * other.a ) + ( this.b * other.b ) ) / ( Math.pow( other.a, 2 ) + Math.pow( other.b, 2 ) );
            double tempB = ( ( this.b * other.a ) - ( this.a * other.b ) ) / ( Math.pow( other.a, 2 ) + Math.pow( other.b, 2 ) );
            this.a = tempA;
            this.b = tempB;
            return true;
        }
        return false;
    }
}