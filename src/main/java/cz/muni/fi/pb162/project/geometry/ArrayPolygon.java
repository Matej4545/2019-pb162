package cz.muni.fi.pb162.project.geometry;
import java.util.Arrays;

/**
 * Implementation of SimplePolygon using arrays
 * @author Matej Groman
 */
public class ArrayPolygon extends SimplePolygon {
    private Vertex2D[] vertexArray;

    /**
     * Constructor for this class
     * @param input Vertex2D array of vertexes in this shape
     */
    public ArrayPolygon(Vertex2D[] input) {
        if (input == null) {
            throw new IllegalArgumentException("Argument should not be null");
        }
        for (Vertex2D vertex2D : input) {
            if (vertex2D == null) {
                throw new IllegalArgumentException("Argument should not be null");
            }
        }
        vertexArray = Arrays.copyOf(input, input.length);
    }

    /**
     * Gets vertex from array, it the index isn't < 0
     * @param index vertex index, not negative number
     * @return i-th vertex from the array
     */
    @Override
    public Vertex2D getVertex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index should be >= 0");
        }
        int i = index % vertexArray.length;
        return vertexArray[i];
    }

    /**
     * Returns length of array
     * @return length of the array
     */
    @Override
    public int getNumVertices() {
        return vertexArray.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArrayPolygon that = (ArrayPolygon) o;
        return Arrays.equals(vertexArray, that.vertexArray);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(vertexArray);
    }
}
