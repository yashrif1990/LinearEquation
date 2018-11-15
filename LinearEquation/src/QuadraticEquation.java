public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation( double a, double b, double c ) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public QuadraticEquation( QuadraticEquation other ) {
        this.a = other.a;
        this.b = other.b;
        this.c = other.c;
    }

    public QuadraticEquation() {
        this.a = 1;
        this.b = 0;
        this.c = 0;
    }

    public QuadraticEquation( double coefficient, Coords vertex ) {
        this.a = coefficient;
        this.b = ( -2 * coefficient * vertex.getX() );
        this.c = ( coefficient * Math.pow( vertex.getX(), 2 ) + vertex.getY() );
    }

    public String toString() {
        return "y = " + this.a + "x^2 + " + this.b + "x + " + this.c;
    }

    public double getDiscriminant() {
        return ( Math.pow( this.b, 2 ) + ( -4 * this.a * this.c ) );
    }

    public boolean hasRealRoots() {
        return getDiscriminant() > 0;
    }

    public boolean hasEqualRoots() {
        return getDiscriminant() == 0;
    }

    public boolean hasMinimum() {
        return this.a < 0;
    }

    public boolean hasMaximum() {
        return this.a > 0;
    }

    public LinearEquation axisOfSymmetry() {
        return new LinearEquation( 1, 0, this.b / ( 2 * this.a ) );
    }

    public Coords vertex() {
        double axis = -this.b / ( this.a * 2 );
        double yVal = ( this.a * Math.pow( axis, 2 ) ) + ( this.b * axis ) + this.c;
        return new Coords( axis, yVal );
    }

    public LinearEquation derivative() {
        return new LinearEquation( ( -this.a * 2 ), 1, -this.b );
    }

    public QuadraticRoots getRoots() {
        double root1;
        double root2;
        double discriminant;
        double part1;
        double part2;

        if ( hasRealRoots() ) {
            discriminant = Math.sqrt( getDiscriminant() );
            part1 = ( -this.b / ( 2 * this.a ) );
            part2 = discriminant / ( this.a * 2 );
            return new QuadraticRoots( part1 + part2, part1 - part2);
        }

        if ( !hasRealRoots() ) {
            discriminant = Math.sqrt( Math.abs( getDiscriminant() ) ) / ( this.a * 2 );
            root1 = ( ( -this.b ) / ( this.a * 2 ) );
            ComplexNumber root = new ComplexNumber( root1, discriminant );
            return new QuadraticRoots( root );
        }

        root1 = ( -this.b / ( 2 * this.a ) );
        root2 = root1;
        return new QuadraticRoots( root1, root2 );
    }
}