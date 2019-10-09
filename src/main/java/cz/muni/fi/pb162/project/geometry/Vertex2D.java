package cz.muni.fi.pb162.project.geometry;

import java.text.DecimalFormat;

/**
 * @author Matej Groman
 *
 * Class representing vertex in 2D space
 * It takes 0 params as we are not supposed to use constructor
 */
public class Vertex2D {
    private final double x;
    private final double y;

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

    public double getY() {
        return y;
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

    /**
     * Function to get eucliedan distance.
      * @param vertex Other 2D vertex
     * @return euciledan distance of the two vectors
     */
     double distance(Vertex2D vertex) {
         if (vertex == null) {
             return -1.0;
         }
         double partialRes = Math.pow(Math.abs(vertex.getX() - this.x),2) + Math.pow(Math.abs(vertex.getY() - this.y),2);
         return Math.sqrt(partialRes);
     }
}
