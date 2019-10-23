package cz.muni.fi.pb162.project.geometry;

/**
 * Parent class representing regular polygons
 * @author Matej Groman
 */
public class GeneralRegularPolygon implements RegularPolygon, Colored {

    private Vertex2D[] vertexArray;
    private Vertex2D center;
    private double radius;
    private int sideCount;
    private Color color = Color.BLACK;

    /**
     * Constructor with basic parameters
     * @param center represents center of the polygon
     * @param radius represents radius of outer circle
     * @param sideCount represent number of Sides
     */
    public GeneralRegularPolygon(Vertex2D center, int sideCount, double radius) {
        this.center = center;
        this.radius = radius;
        this.sideCount = sideCount;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color c) {
        this.color = c;
    }

    @Override
    public int getNumEdges() {
        return sideCount;
    }

    @Override
    public double getEdgeLength() {
        return 2*radius*Math.sin(Math.PI/sideCount);
    }

    @Override
    public Vertex2D getVertex(int index) {
        double x = center.getX() - radius*Math.cos(index*2*Math.PI / sideCount);
        double y = center.getY() - radius*Math.sin(index*2*Math.PI / sideCount);
        return new Vertex2D(x,y);
    }

    @Override
    public Vertex2D getCenter() {
        return center;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public double getWidth() {
        return radius*2;
    }

    @Override
    public double getHeight() {
        return radius*2;
    }

    @Override
    public String toString() {
        return String.format("%s-gon: center=%s, radius=%s, color=%s", sideCount, center, radius, color);
    }
}
