package cz.muni.fi.pb162.project.geometry;

/**
 * Class representing square
 * @author Matej Groman
 */
public class Square implements Circular {
    private Vertex2D center;
    private double diameter;

    /**
     * Constructor which creates Square from parameters
     * @param center center of the outer circle
     * @param diameter diameter of the circle (diagonal length in square)
     */
    public Square(Vertex2D center, double diameter) {
        this.center = center;
        this.diameter = diameter;
    }

    /**
     * Constructor which creates Square from any circular object
     * @param obj circular object which will be used to create square
     */
    public Square(Circular obj) {
        this(obj.getCenter(), obj.getRadius()*2);
    }

    /**
     * Function to get a vertex representing square peaks
     * @param index index of the peak
     * @return Vertex2D of the point representing peak
     */
    public Vertex2D getVertex(int index) {
        double radius = diameter/2;
        switch (index) {
            case 0:
                return new Vertex2D(center.getX()-radius, center.getY());
            case 1:
                return new Vertex2D(center.getX(), center.getY()-radius);
            case 2:
                return new Vertex2D(center.getX()+radius, center.getY());
            case 3:
                return new Vertex2D(center.getX(), center.getY()+radius);
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return String.format("Square: vertices=%s %s %s %s",
                getVertex(0), getVertex(1), getVertex(2), getVertex(3));
    }

    public Vertex2D getCenter() {
        return center;
    }

    public double getRadius() {
        return diameter/2;
    }
}
