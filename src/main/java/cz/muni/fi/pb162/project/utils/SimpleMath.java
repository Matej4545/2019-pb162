package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Polygon;

/**
 * Class for doing math
 * @author Matej Groman
 */
public class SimpleMath {
    /**
     * Returns the smallest X vertex value
     * @param polygon input triangle from which we want the minX
     * @return the smallest X vertex value
     */
    public static double minX(Polygon polygon) {
        double result = Double.POSITIVE_INFINITY;
        for (int i = 0; i < polygon.getNumVertices(); i++) {
            result = Double.min(polygon.getVertex(i).getX(), result);
        }
        return result;
    }

    /**
     * Returns the smallest Y vertex value
     * @param polygon input triangle from which we want the minY
     * @return the smallest Y vertex value
     */
    public static double minY(Polygon polygon) {
        double result = Double.POSITIVE_INFINITY;
        for (int i = 0; i < polygon.getNumVertices(); i++) {
            result = Double.min(polygon.getVertex(i).getY(), result);
        }
        return result;
    }

    /**
     * Returns the largest X vertex value
     * @param polygon input triangle from which we want the maxX
     * @return the largest X vertex value
     */
    public static double maxX(Polygon polygon) {
        double result = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < polygon.getNumVertices(); i++) {
            result = Double.max(polygon.getVertex(i).getX(), result);
        }
        return result;
    }

    /**
     * Returns the largest Y vertex value
     * @param polygon input triangle from which we want the maxY
     * @return the largest Y vertex value
     */
    public static double maxY(Polygon polygon) {
        double result = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < polygon.getNumVertices(); i++) {
            result = Double.max(polygon.getVertex(i).getY(), result);
        }
        return result;
    }

}
