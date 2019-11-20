package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.exception.MissingVerticesException;
import cz.muni.fi.pb162.project.utils.SimpleMath;

import java.util.Collection;

/**
 * Class representing Simple polygon
 * @author Matej Groman
 */
public abstract class SimplePolygon implements Polygon {

    SimplePolygon(Vertex2D[] input) {
        if (input == null) {
            throw new IllegalArgumentException("Argument should not be null");
        }

        if (input.length < 3) {
            throw new MissingVerticesException("Less than 3 vertices");
        }

        for (Vertex2D vertex2D : input) {
            if (vertex2D == null) {
                throw new IllegalArgumentException("Argument should not be null");
            }
        }
    }

    SimplePolygon(Collection<Vertex2D> input) {
        if (input == null) {
            throw new IllegalArgumentException("Argument should not be null");
        }

        if (input.size() < 3) {
            throw new MissingVerticesException("Less than 3 vertices");
        }

        for (Vertex2D vertex2D : input) {
            if (vertex2D == null) {
                throw new IllegalArgumentException("Argument should not be null");
            }
        }
    }
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
