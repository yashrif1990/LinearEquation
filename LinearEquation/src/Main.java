import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main( String[] args ) {
        Coords pointTest = new Coords( 5, 20 );

        Coords point1 = new Coords( 1, 2 );
        Coords point2 = new Coords( 2, 1 );
        Coords point3 = new Coords( 6, 5 );
        Coords point4 = new Coords( 7, 8 );
        Coords point5 = new Coords( 10, 9 );
        Coords point6 = new Coords( -1, -1 );
        Coords point7 = new Coords( 1, 0 );
        Coords point8 = new Coords( -2, 35 );
        Coords point9 = new Coords( 1, 4 );
        Coords point10 = new Coords( 654, -1 );

        ArrayList<Coords> points = new ArrayList<>();
        points.addAll( Arrays.asList( point1, point2, point3, point4, point5, point6, point7, point8, point9, point10 ) );

        System.out.println( Coords.closestPointToOrigin(points) );
        System.out.println( pointTest.closestPoint( points) );
    }
}
