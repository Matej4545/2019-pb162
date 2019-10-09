package cz.muni.fi.pb162.project.geometry;

public class Circle {
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
        this(new Vertex2D(0.0, 0.0), 0.0);
    }

     public double getRadius() {
        return radius;
     }

     public Vertex2D getCenter() {
        return center;
     }

     @Override
    public String toString() {
        return "Circle: center=" + center.toString() + ", radius=" + radius;
     }
}
