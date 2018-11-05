import java.util.Arrays;

public class LinearEquation {
    private double a, b, c;

    public static boolean areValidParams( double a, double b ) {
        return !( a == 0 && b == 0 );
    }

    public LinearEquation( double a, double b, double c ) {
        this.a = a; this.b = b; this.c = c;
    }

    public LinearEquation( double slope, Coords point ) {
        this.a = slope;
        this.b = -1;
        this.c = ( slope * -point.getX() ) + point.getY();
    }

    public LinearEquation( LinearEquation other ) {
        this.a = other.a;
        this.b = other.b;
        this.c = other.c;
    }

    public LinearEquation( Coords point1, Coords point2 ) {
        this.a = point2.getY() - point1.getY();
        this.b = point2.getX() - point1.getX();
        this.c = ( point1.getX() * point2.getY() ) + ( point1.getY() * point2.getX() );
    }

    public LinearEquation( LinearEquation other, Coords point ) {
        double slope = other.a / -other.b;
        this.a = slope;
        this.b = -1;
        this.c = ( slope * -point.getY() ) + point.getY();
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public boolean slopeDefined() {
        return b != 0;
    }

    public boolean hasYIntercept() {
        return !isVertical();
    }

    public boolean hasXIntercept() {
        return !isHorizontal();
    }

    public double slope() {
        if ( slopeDefined() ) return ( this.a /  -this.b );
        return Double.parseDouble(null );
    }

    public double yIntercept() {
        if ( hasYIntercept() )
            return ( c / -b );
        return Double.parseDouble( null );
    }

    public double xIntercept() {
        if ( hasXIntercept() )
            return ( c / -a );
        return Double.parseDouble( null );
    }

    public double slopeOfPerpendicularLine() {
        if ( slopeDefined() )
            return ( -1 / slope() );
        return Double.parseDouble( null );
    }

    public boolean isIncreasing() {
        return slope() > 0;
    }

    public boolean isDecreasing() {
        return slope() < 0;
    }

    public boolean isHorizontal() {
        return slope() == 0;
    }

    public boolean isVertical() {
        return !slopeDefined();
    }

    public boolean isValidLinearEquation() {
        return areValidParams( this.a, this.b );
    }

    public boolean isDirectVariation() {
        return yIntercept() == 0 && xIntercept() == 0;
    }

    public boolean isAFunction() {
        return slopeDefined();
    }

    public boolean equals( LinearEquation other ) {
        return Arrays.toString( gcf( other.a, other.b, other.c ) ).equals( Arrays.toString( gcf( this.a, this.b, this.c ) ) );
    }

    public LinearEquation parallelLine( Coords point ) {
        return new LinearEquation( slope(), point );
    }

    public LinearEquation perpendicularLine( Coords point ) {
        return new LinearEquation( this.slopeOfPerpendicularLine(), point );
    }

    public double shortestDistanceFrom( Coords point ) {
        return ( Math.abs( ( this.a * point.getX() ) + ( this.b * point.getY() ) + ( this.c ) ) / Math.sqrt( Math.pow( this.a, 2 ) + Math.pow( this.b, 2 ) ) );
    }

    public LinearEquation inverseFunction() {
        return new LinearEquation( this.b , this.a, this.c );
    }

    public Coords pointOfIntersection( LinearEquation other ) {
        if ( !this.isValidLinearEquation() || !other.isValidLinearEquation() ) return null;
        if ( this.isVertical() || other.isVertical() ) return null;
        if ( this.slope() == other.slope() ) return null;
        if ( this.isVertical() && other.isHorizontal() ) return new Coords( this.xIntercept(), other.yIntercept() );
        if ( this.isHorizontal() && other.isVertical() ) return new Coords( this.yIntercept(), other.xIntercept() );

        return new Coords( ( ( this.c * other.b ) - ( this.b * other.c ) ) / ( ( this.b * other.a ) - ( this.a * other.b ) ), ( ( this.a * other.c ) - ( this.c * other.a ) ) / ( ( this.b * other.a ) - ( this.a * other.b ) ) );
    }

    public boolean isParallel( LinearEquation other ) {
        return this.a == other.a && this.b == other.b;
    }

    public boolean isPerpendicular( LinearEquation other ) {
        return this.slopeOfPerpendicularLine() == other.slope();
    }

    public String toString() {
        return "" + this.a + "x + " + this.b + "y + " + this.c + " = 0";
    }

    public String getSlopeInterceptForm() {
        return "y = " + slope() + "x + " + yIntercept();
    }

    private double[] gcf ( double a, double b , double c ) {
        double[] gcf = new double[3];

        if ( Math.abs( a ) <= Math.abs( b ) && Math.abs( a ) <= Math.abs( c ) && a != 0 ) {
            gcf[ 0 ] = 1;
            gcf[ 1 ] = b / a;
            gcf[ 2 ] = c / a;
            return  gcf;
        }

        if ( Math.abs( b ) <= Math.abs( a ) && Math.abs( b ) <= Math.abs( c ) && b != 0 ) {
            gcf[ 0 ] = a / b;
            gcf[ 1 ] = 1;
            gcf[ 2 ] = c / b;
            return  gcf;
        }

        gcf[ 0 ] = a / c;
        gcf[ 1 ] = b / c;
        gcf[ 2 ] = 1;
        return  gcf;
    }
}