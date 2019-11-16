package cz.muni.fi.pb162.project.geometry;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class representing polygon as ArrayList
 * @author Matej Groman
 */
public class CollectionPolygon extends SimplePolygon {
    private List<Vertex2D> vertexList;

    /**
     * Constructor for this class
     * @param input Vertex2D array of vertexes in this shape
     */
    public CollectionPolygon(Vertex2D[] input) {
        super(input);
        vertexList = new ArrayList<>(List.of(input));
    }

    /**
     * Constructor to create this class from list of Vertices
     * @param input List<Vertex2D>
     */
    public CollectionPolygon(List<Vertex2D> input) {
        super(input);
        vertexList = new ArrayList<>(input);
    }

    @Override
    public Vertex2D getVertex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index should not be < 0");
        }
        return vertexList.get(index % vertexList.size());
    }

    @Override
    public int getNumVertices() {
        return vertexList.size();
    }

    /**
     * Function which returns new CollectionPolygon without most left vertices
     * @return polygon without most left vertices
     */
    public CollectionPolygon withoutLeftmostVertices() {
        if (vertexList.isEmpty()) {
            throw new IllegalArgumentException("Polygon is empty");
        }
        List<Vertex2D> newVertexList = new ArrayList<>();
        double mostLeftX = Double.MAX_VALUE;

        for (Vertex2D v : vertexList) {
            if (v.getX() < mostLeftX) {
                mostLeftX = v.getX();
            }
        }

        for (Vertex2D v : vertexList) {
            if (v.getX() != mostLeftX) {
                newVertexList.add(v);
            }
        }
        return new CollectionPolygon(newVertexList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CollectionPolygon that = (CollectionPolygon) o;
        if (this.vertexList.size() != that.vertexList.size()) {
            return false;
        }
        for (int i = 0; i < vertexList.size(); i++) {
            if (this.vertexList.get(i) == null || that.vertexList.get(i) == null) {
                return false;
            }
            if (this.vertexList.get(i).getX() != that.vertexList.get(i).getX() ||
                    this.vertexList.get(i).getY() != that.vertexList.get(i).getY()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertexList);
    }
}
