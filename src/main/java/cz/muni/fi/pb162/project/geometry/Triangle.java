package cz.muni.fi.pb162.project.geometry;

/**
 * Class representing triangle, implementing basic trigonometry functions
 * @author Matej Groman
 */

public class Triangle {
    private Vertex2D[] vertexArray;
    private Triangle[] triangleArray;

    /**
     * Creates triangle object from Vertexes
     * @param a vert A
     * @param b vert B
     * @param c vert C
     */
    public Triangle(Vertex2D a, Vertex2D b, Vertex2D c) {
        vertexArray = new Vertex2D[3];
        vertexArray[0] = a;
        vertexArray[1] = b;
        vertexArray[2] = c;
    }

    public Vertex2D getVertex(int index) {
        if (index < 0 || index > 2) {
            return null;
        }
        return vertexArray[index];
    }

    public void setVertex(int index, Vertex2D vertex) {
        if (index < 0 || index > 2) {
            return;
        }
        vertexArray[index] = vertex;
    }
    @Override
    public String toString() {
        return "Triangle: vertices=" + vertexArray[0].toString() + " "
        + vertexArray[1].toString() + " " + vertexArray[2].toString();
    }

    /**
     * Function to test if triangle is split
     * @return boolean - if split: true, false otherwise
     */
    public boolean isDivided() {
        return triangleArray != null;
    }

    /**
     * Function divides triangle into 3 sub triangles (A, m1, m3), (m1, B, m2), (m3, m2, C)
     *      C
     *      /\
     *m3 -/---\- m2
     *  / \  / \
     * ----+-----
     *  A  m1    B
     * @return true if successful, false otherwise
     */
    public boolean divide() {
        if (isDivided()) return false;

        triangleArray = new Triangle[3];

        Vertex2D m1 = vertexArray[0].createMiddle(vertexArray[1]);
        Vertex2D m2 = vertexArray[1].createMiddle(vertexArray[2]);
        Vertex2D m3 = vertexArray[2].createMiddle(vertexArray[0]);

        triangleArray[0] = new Triangle(vertexArray[0], m1, m3 );
        triangleArray[1] = new Triangle(m1, vertexArray[1], m2 );
        triangleArray[2] = new Triangle(m3, m2, vertexArray[2] );

        return true;
    }

    public Triangle getSubTriangle(int index) {
        if (index < 0 || index > 2 || !isDivided()) return null;
        return triangleArray[index];
    }

}
