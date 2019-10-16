package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Triangle;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

/**
 * Class for doing math
 * @author Matej Groman
 */
public class SimpleMath {
    /**
     * Returns the smallest X vertex value
     * @param triangle input triangle from which we want the minX
     * @return the smallest X vertex value
     */
    public static double minX(Triangle triangle) {
        double result = Double.POSITIVE_INFINITY;
        for (int i = 0; i < 3; i++) {
            result = Double.min(triangle.getVertex(i).getX(), result);
        }
        return result;
    }

    /**
     * Returns the smallest Y vertex value
     * @param triangle input triangle from which we want the minY
     * @return the smallest Y vertex value
     */
    public static double minY(Triangle triangle) {
        double result = Double.POSITIVE_INFINITY;
        for (int i = 0; i < 3; i++) {
            result = Double.min(triangle.getVertex(i).getY(), result);
        }
        return result;
    }

    /**
     * Returns the largest X vertex value
     * @param triangle input triangle from which we want the maxX
     * @return the largest X vertex value
     */
    public static double maxX(Triangle triangle) {
        double result = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < 3; i++) {
            result = Double.max(triangle.getVertex(i).getX(), result);
        }
        return result;
    }

    /**
     * Returns the largest Y vertex value
     * @param triangle input triangle from which we want the maxY
     * @return the largest Y vertex value
     */
    public static double maxY(Triangle triangle) {
        double result = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < 3; i++) {
            result = Double.max(triangle.getVertex(i).getY(), result);
        }
        return result;
    }

}
