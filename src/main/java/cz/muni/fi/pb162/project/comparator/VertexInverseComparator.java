package cz.muni.fi.pb162.project.comparator;

import cz.muni.fi.pb162.project.geometry.Vertex2D;

import java.util.Comparator;

/**
 * Comparator sort Vertex2D from highest to lowest
 * @author Matej Groman
 */
public class VertexInverseComparator implements Comparator<Vertex2D> {
    @Override
    public int compare(Vertex2D vertex2D, Vertex2D t1) {
        return t1.compareTo(vertex2D);
    }
}
