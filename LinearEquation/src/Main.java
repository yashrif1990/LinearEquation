public class Main {
    public static void main( String[] args ) {
        LinearEquation line1 = new LinearEquation(1, -1, 1 );
        LinearEquation line2 = new LinearEquation( -1, -1, 50 );
        Coords rand = new Coords( 0 );
        System.out.println( line2.shortestDistanceFrom( rand ) );
    }
}
