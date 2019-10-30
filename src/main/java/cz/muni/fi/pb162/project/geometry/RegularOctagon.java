package cz.muni.fi.pb162.project.geometry;

/**
 * Class representing 8-gon
 * @author Matej Groman
 */
public class RegularOctagon extends GeneralRegularPolygon {

    /**
     * Constructor for octagon
     * @param center Vertex2D which represents center
     * @param radius double, represents radius
     */
    public RegularOctagon(Vertex2D center, double radius) {
        super(center,8, radius);
    }
}
