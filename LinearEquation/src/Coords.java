public class Coords {
    //instance variables
    private double x, y;

    //Constructors
    public Coords( double x, double y ) {
        this.x = x;
        this.y = y;
    }

    public Coords( double value ) {
        this( value, value );
    }

    public Coords() {
        this( 0 );
    }

    public Coords( Coords other ) {
        this( other.x, other.y );
    }

    //Accessors
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    //Mutators
    public void setX( double x ) {
        this.x = x;
    }

    public void setY( double y ) {
        this.y = y;
    }

    public void reflectOnYAxis() {
        this.x = -x;
    }

    public void reflectOnXAxis() {
        this.y = -y;
    }

    public void reflectOnOrigin() {
        reflectOnXAxis();
        reflectOnYAxis();
    }

    public void translate( double horizontal, double vertical ) {
        this.x += horizontal;
        this.y += vertical;
    }

    public void dilate( double dilationFactor ) {
        this.x *= dilationFactor;
        this.y *= dilationFactor;
    }

    //Other methods
    public double distanceFromOrigin() {
        return Math.sqrt( Math.pow( this.x, 2 ) + Math.pow( this.y, 2 ) );
    }

    public double distanceFrom( Coords other ) {
        return Math.sqrt( Math.pow( other.x - this.x, 2 ) + Math.pow( other.y - this.y, 2 ) );
    }

    public boolean equals( Coords otherPoint ) {
        return otherPoint.x == this.x && otherPoint.y == this.y;
    }

    public double getSlopeOfLineSegment( Coords other ) {
        return ( other.y - this.y ) / ( other.x - this.x );
    }

    public boolean slopeOfLIneSegmentDefined( Coords other ) {
        return other.x != - this.x;
    }
}