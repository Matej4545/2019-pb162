package cz.muni.fi.pb162.project.geometry;

/**
 * Class representing square
 * @author Matej Groman
 */
public class Square extends GeneralRegularPolygon implements Circular {
    /**
     * Constructor which creates Square from parameters
     * @param center center of the outer circle
     * @param diameter diameter of the circle (diagonal length in square)
     */
    public Square(Vertex2D center, double diameter) {
        super(center, 4, diameter/2);
    }

    /**
     * Constructor which creates Square from any circular object
     * @param obj circular object which will be used to create square
     */
    public Square(Circular obj) {
        this(obj.getCenter(), obj.getRadius()*2);
    }

    @Override
    public String toString() {
        return String.format("Square: vertices=%s %s %s %s",
                getVertex(0), getVertex(1), getVertex(2), getVertex(3));
    }
}
