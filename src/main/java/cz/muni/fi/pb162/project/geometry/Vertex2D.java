package cz.muni.fi.pb162.project.geometry;

import java.text.DecimalFormat;

/**
 * @author Matej Groman
 *
 * Class representing vertex in 2D space
 * It takes 0 params as we are not supposed to use constructor
 */
public class Vertex2D {
    private double x;
    private double y;

    /**
     * Constructor for vertex
     * @param x value on x-axis
     * @param y value on y-axis
     */
    public Vertex2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     * Returns information about vertex position
     * @return string representation of vertex position
     */
    @Override
    public String toString() {
        String sX = new DecimalFormat("########0.0########").format(x).replaceAll(",", ".");
        String sY = new DecimalFormat("########0.0########").format(y).replaceAll(",", ".");
        return String.format("[%s, %s]", sX, sY);
    }

    /**
     * Sums the X and Y coordinates
     * @param otherVertex - the second vertex to determine middle
     * @return sum of the two coordinates
     */
     public Vertex2D createMiddle(Vertex2D otherVertex) {
         double midX = (this.x + otherVertex.x) /2;
         double midY = (this.y + otherVertex.y) /2;
         return new Vertex2D(midX, midY);
     }
}
