package cz.muni.fi.pb162.project.geometry;

/**
 * Class representing snowman built from 4 circles
 * @author Matej Groman
 */
public class Snowman {
    private RegularPolygon[] polyArray;
    private static final int SNOWMAN_HEIGHT = 3;
    private static final double SNOWMAN_FACTOR = 0.8;

    /**
     * Costructor which create snowman
     * @param first Circular object representing first (bottom) circle
     * @param factor parameter representing how much the next circles should be smaller (0, 1>
     */
    public Snowman(RegularPolygon first, double factor) {
        polyArray = new RegularPolygon[SNOWMAN_HEIGHT];
        polyArray[0] = first;

        if (factor <= 0 || factor > 1) {
            factor = SNOWMAN_FACTOR;
        }

        for (int i = 1; i < SNOWMAN_HEIGHT; i++) {
            polyArray[i] = getNextCircle(polyArray[i-1], factor);
        }
    }

    public RegularPolygon[] getBalls() {
        return polyArray;
    }

    /**
     * Helper function to determine where next ball should be
     * @param previous Previous (lower) circular object
     * @param factor factor of which the next ball should be smaller
     * @return New smaller circle located higher and touching
     */
    private RegularPolygon getNextCircle(RegularPolygon previous, double factor) {
        double x = previous.getCenter().getX();
        double y = previous.getCenter().getY() + previous.getRadius() + previous.getRadius()*factor;
        return new GeneralRegularPolygon(new Vertex2D(x,y), previous.getNumEdges(),previous.getRadius()*factor);
    }
}
