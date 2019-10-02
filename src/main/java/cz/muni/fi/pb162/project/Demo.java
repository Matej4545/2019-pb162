package cz.muni.fi.pb162.project;


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
        Vertex2D v1 = new Vertex2D();
        Vertex2D v2 = new Vertex2D();

        v1.setX(2);
        v1.setY(3);

        v2.setX(1);
        v2.setY(1);

        v1.move(v2);

        System.out.println(v1.getInfo());
        System.out.println(v2.getInfo());
    }
}
