package cz.muni.fi.pb162.project.geometry;

/**
 * @author Matej Groman
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

    public String getInfo() {
        return String.format("[%f, %f]", x, y);
    }

    public double sumCoordinates() {
        return x + y;
    }

    public void move(Vertex2D vertex) {
        this.x += vertex.getX();
        this.y += vertex.getY();
    }
}
