public class QuadraticRoots {
    private ComplexNumber root1;
    private ComplexNumber root2;

    public QuadraticRoots( double r1, double r2 ) {
        this.root1 = new ComplexNumber( r1,0 );
        this.root2 = new ComplexNumber( r2,0 );
    }

    public QuadraticRoots( ComplexNumber r1 ) {
        this.root1 = r1;
        this.root2 = new ComplexNumber( r1.getRealMagnitude(), -r1.getImaginaryMagnitude() );
    }

    public ComplexNumber getRoot1() {
        return root1;
    }

    public ComplexNumber getRoot2() {
        return root2;
    }


    public QuadraticEquation getQuadEquation() {

    }

    public String toString() {
        double a = root1.getRealMagnitude();
        double b = root1.getImaginaryMagnitude();
        double c = root2.getRealMagnitude();
        double d = root2.getImaginaryMagnitude();

        if ( b == 0 && d == 0 )
            return "(" + a + ", 0) and (" + c + ", 0)";
        if ( b == 0 )
            return "(" + a + ", 0) and (" + c + " + " + d + "i, 0)";
        if ( d == 0 )
            return "(" + a + " + " + b + "i, 0) and (" + c + ", 0)";
        if ( d < 0 && b < 0 )
            return "(" + a + " - " + Math.abs( b ) + "i, 0) and (" + c + " - " + Math.abs( d ) + "i, 0)";
        if ( b < 0 )
            return "(" + a + " - " + Math.abs( b ) + "i, 0) and (" + c + " + " + d + "i, 0)";
        if ( d < 0 )
            return "(" + a + " + " + b + "i, 0) and (" + c + " - " + Math.abs( d ) + "i, 0)";


        return "(" + a + " + " + b + "i, 0) and (" + c + " + " + d + "i, 0)";
    }

    public boolean areValid() {
        return ( ( root1.getRealMagnitude() == root2.getRealMagnitude() && root1.getImaginaryMagnitude() == -root2.getImaginaryMagnitude() ) || ( root1.getImaginaryMagnitude() == 0 && root2.getImaginaryMagnitude() == 0 ) );
    }

}
