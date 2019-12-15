package cz.muni.fi.pb162.project.demo;

import cz.muni.fi.pb162.project.geometry.LabeledPolygon;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

import java.io.File;
import java.io.IOException;

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
     * @throws IOException when using file polygon-ok.txt
     */
    public static void main(String[] args) throws IOException {
        LabeledPolygon.Builder labeledPolyBuilder = new LabeledPolygon.Builder();
        try {
            LabeledPolygon p = labeledPolyBuilder
                    .addVertex("vrchol x", new Vertex2D(123,456))
                    .read(new File("polygon-ok.txt"))
                    .build();

            p.writeJson(System.out);
            System.out.println("Hello World!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
