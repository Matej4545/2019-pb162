package cz.muni.fi.pb162.project.geometry;

import java.util.Objects;

/**
 * This class represents some polygon and adds some color to it
 * @author Matej Groman
 */
public class ColoredPolygon {
    private Polygon p;
    private Color color;

    /**
     * Constructor
     * @param polygon which polygon should it represent
     * @param color which color the polygon should have
     */
    public ColoredPolygon(Polygon polygon, Color color) {
        p = polygon;
        this.color = color;
    }

    public Polygon getPolygon() {
        return p;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ColoredPolygon that = (ColoredPolygon) o;
        return Objects.equals(p, that.p) &&
                color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(p, color);
    }
}
