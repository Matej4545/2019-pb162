package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Measurable;
import cz.muni.fi.pb162.project.geometry.Triangle;

/**
 * Class for measuring objects
 * @author Matej Groman
 */
public class Gauger {

    /**
     * Method which prints width and height on standard output
     * @param obj any object implementing Measurable
     */
    public static void printMeasurement(Measurable obj) {
        System.out.println(String.format("Width: %s", obj.getWidth()));
        System.out.println(String.format("Height: %s", obj.getHeight()));
    }

    /**
     * Overriden function which deals with Triangle object - prints specific info
     * @param obj Triangle object
     */
    public static void printMeasurement(Triangle obj) {
        System.out.println(obj);
        printMeasurement((Measurable) obj);
    }
}
