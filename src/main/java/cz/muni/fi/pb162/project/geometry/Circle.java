package cz.muni.fi.pb162.project.geometry;

/**
 * Class representing Circle
 * @author Matej Groman
 */
public class Circle implements Measurable, Circular {
    private final Vertex2D center;
    private final double radius;

    /**
     * Constructor to create circle from parameters
     * @param center center of circle
     * @param radius circle radius
     */
    public Circle (Vertex2D center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    /**
     * Nonparametric constructor creates default circle via other constructor
     */
    public Circle() {
        this(new Vertex2D(0.0, 0.0), 1.0);
    }

    @Override
     public double getRadius() {
        return radius;
     }
    @Override
     public Vertex2D getCenter() {
        return center;
     }

    @Override
     public String toString() {
        return "Circle: center=" + center.toString() + ", radius=" + radius;
     }

     public double getWidth() {
        return radius*2;
     }

     public double getHeight() {
        return getWidth();
     }
}
