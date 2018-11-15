public class Main {
    public static void main( String[] args ) {
        QuadraticEquation myEq = new QuadraticEquation(1, 2, 4);
        Coords vertex = myEq.vertex();
        QuadraticRoots roots = myEq.getRoots();
        System.out.println(vertex);
        System.out.println(roots);
    }
}
