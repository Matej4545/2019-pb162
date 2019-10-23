package cz.muni.fi.pb162.project.demo;


import cz.muni.fi.pb162.project.geometry.GeneralRegularPolygon;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

/**
 * Class for running main method.
 *
 * @author Matej Groman
 */
public class Demo {

    /**
     * Runs the code.
     *
     * @param args command line arguments, will be ignored
     */
    public static void main(String[] args) {
        System.out.println(new GeneralRegularPolygon(new Vertex2D(0,0), 8, 1));
    }
}
