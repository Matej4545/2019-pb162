package cz.muni.fi.pb162.project.geometry;

/**
 * Class representing snowman built from 4 circles
 * @author Matej Groman
 */
public class Snowman {
    private Circular[] circArray;
    private static final int SNOWMAN_HEIGHT = 4;
    private static final double SNOWMAN_FACTOR = 0.8;

    /**
     * Costructor which create snowman
     * @param first Circular object representing first (bottom) circle
     * @param factor parameter representing how much the next circles should be smaller (0, 1>
     */
    public Snowman(Circular first, double factor) {
        circArray = new Circular[SNOWMAN_HEIGHT];
        circArray[0] = first;

        if (factor <= 0 || factor > 1) {
            factor = SNOWMAN_FACTOR;
        }

        for (int i = 1; i < SNOWMAN_HEIGHT; i++) {
            circArray[i] = getNextCircle(circArray[i-1], factor);
        }
    }

    public Circular[] getBalls() {
        return circArray;
    }

    /**
     * Helper function to determine where next ball should be
     * @param previous Previous (lower) circular object
     * @param factor factor of which the next ball should be smaller
     * @return New smaller circle located higher and touching
     */
    private Circle getNextCircle(Circular previous, double factor) {
        double x = previous.getCenter().getX();
        double y = previous.getCenter().getY() + previous.getRadius() + previous.getRadius()*factor;
        return new Circle(new Vertex2D(x,y), previous.getRadius()*factor);
    }
}
