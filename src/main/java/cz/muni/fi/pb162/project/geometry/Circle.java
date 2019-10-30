package cz.muni.fi.pb162.project.geometry;

/**
 * Class representing Circle
 * @author Matej Groman
 */
public class Circle extends GeneralRegularPolygon implements Measurable, Circular {
    /**
     * Constructor to create circle from parameters
     * @param center center of circle
     * @param radius circle radius
     */
    public Circle (Vertex2D center, double radius) {
        super(center, Integer.MAX_VALUE, radius);
        this.setColor(Color.RED);
    }

    /**
     * Nonparametric constructor with default values
     */
    public Circle() {
        super(new Vertex2D(0,0), Integer.MAX_VALUE, 1);
    }

    @Override
    public String toString() {
        return "Circle: center=" + super.getCenter().toString() + ", radius=" + super.getRadius();
    }

    /**
     * Overrided function in GeneralRegularPolygon, because circle should have side length of 0
     * @return 0
     */
    @Override
    public double getEdgeLength() {
        return 0;
    }
}
