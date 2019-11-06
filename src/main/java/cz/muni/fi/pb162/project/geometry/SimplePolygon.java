package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.utils.SimpleMath;
/**
 * Class representing Simple polygon
 * @author Matej Groman
 */
public abstract class SimplePolygon implements Polygon {

    @Override
    public double getWidth() {
        return SimpleMath.maxX(this) - SimpleMath.minX(this);
    }

    @Override
    public double getHeight() {
        return SimpleMath.maxY(this) - SimpleMath.minY(this);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("Polygon: vertices =");
        for (int i = 0; i < this.getNumVertices(); i++) {
            output.append(" ");
            output.append(this.getVertex(i).toString());
        }
        return output.toString();
    }
}
