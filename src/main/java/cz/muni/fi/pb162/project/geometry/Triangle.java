package cz.muni.fi.pb162.project.geometry;

/**
 * Class representing triangle, implementing basic trigonometry functions
 * @author Matej Groman
 */

public class Triangle {
    private static final double TRIANGLE_LENGTH_THRESHOLD = 0.001;
    private final Vertex2D[] vertexArray;
    private final Triangle[] triangleArray;

    /**
     * Creates triangle object from Vertexes
     * @param a vert A
     * @param b vert B
     * @param c vert C
     */
    public Triangle(Vertex2D a, Vertex2D b, Vertex2D c) {
        vertexArray = new Vertex2D[3];
        triangleArray = new Triangle[3];

        vertexArray[0] = a;
        vertexArray[1] = b;
        vertexArray[2] = c;
    }

    /**
     * Creates Sierpinsky triangle with defined depth
     * @param a vert A
     * @param b vert B
     * @param c vert C
     * @param depth depth of recursion
     */
    public Triangle(Vertex2D a, Vertex2D b, Vertex2D c, int depth) {
        this(a, b, c);
        divide(depth);
    }

    /**
     * It's normal getter, but pipeline wants something here
     * @param index - which vertex is requested
     * @return - mighty god of Java returns requested vertex under specific circumstances (index is in array)
     */
    public Vertex2D getVertex(int index) {
        if (index < 0 || index > 2) {
            return null;
        }
        return vertexArray[index];
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
        return triangleArray[0] != null;
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
        if (isDivided()) {
            return false;
        }

        Vertex2D m1 = vertexArray[0].createMiddle(vertexArray[1]);
        Vertex2D m2 = vertexArray[1].createMiddle(vertexArray[2]);
        Vertex2D m3 = vertexArray[2].createMiddle(vertexArray[0]);

        triangleArray[0] = new Triangle(vertexArray[0], m1, m3 );
        triangleArray[1] = new Triangle(m1, vertexArray[1], m2 );
        triangleArray[2] = new Triangle(m3, m2, vertexArray[2] );

        return true;
    }

    /**
     * Function recursively divides triangle while depth > 0
     * @param depth
     */
    void divide(int depth) {
        if (depth <= 0) {
            return;
        }
        this.divide();
        for (Triangle t : triangleArray) {
            t.divide(depth-1);
        }
    }

    /**
     * Again, it's just getter for sub triangles
     * @param index which triangle we should return
     * @return the triangle we should return if it exists
     */
    public Triangle getSubTriangle(int index) {
        if (index < 0 || index > 2 || !isDivided()) {
            return null;
        }
        return triangleArray[index];
    }

    /**
     * Function to determine if triangle is equilateral
     * @return T if it is, F otherwise
     */
    public boolean isEquilateral() {
        return isEqualByThreshold(vertexArray[0].distance(vertexArray[1]), vertexArray[1].distance(vertexArray[2]), vertexArray[2].distance(vertexArray[0]));
    }

    /**
     * Helper function to decide if all three sides (using transitivity) are equal (with threshold TRIANGLE_LENGTH_THRESHOLD)
     * @param d1 side a
     * @param d2 side b
     * @param d3 side c
     * @return T if sides are equal with threshold, F otherwise
     */
    private boolean isEqualByThreshold(double d1, double d2, double d3) {
        return Math.abs(d1 - d2) < TRIANGLE_LENGTH_THRESHOLD && Math.abs(d2 - d3) < TRIANGLE_LENGTH_THRESHOLD;
    }
}
