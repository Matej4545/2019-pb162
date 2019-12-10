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
        if (vertex2D.getX() == t1.getX()) {
            if (vertex2D.getY() == t1.getY()) {
                return 0;
            }
            return vertex2D.getY() < t1.getY()?1:-1;
        }
        return vertex2D.getX() < t1.getX()?1:-1;
    }
}
