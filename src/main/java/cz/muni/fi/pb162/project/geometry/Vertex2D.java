package cz.muni.fi.pb162.project.geometry;

import java.util.Locale;

/**
 * @author Matej Groman
 *
 * Class representing vertex in 2D space
 * It takes 0 params as we are not supposed to use constructor
 */
public class Vertex2D {
    private double x = 0.0;
    private double y = 0.0;


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
    public String getInfo() {
        return String.format(Locale.ROOT,"[%.1f, %.1f]", x, y);
    }

    /**
     * Sums the X and Y coordinates
     * @return sum of the two coordinates
     */
    public double sumCoordinates() {
        return x + y;
    }

    /**
     * Moves vertex by values of another one
     * @param vertex vertex by which coordinates will this one move
     */
    public void move(Vertex2D vertex) {
        this.x += vertex.getX();
        this.y += vertex.getY();
    }
}
