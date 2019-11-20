package cz.muni.fi.pb162.project.geometry;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
 * Class representing draw surface
 * @author Matej Groman
 */
public class Paper implements Drawable {
    private List<ColoredPolygon> polygonList;
    private Color drawingColor = Color.BLACK;

    /**
     * Default constructor
     */
    public Paper(){
        polygonList = new ArrayList<>();
    }

    /**
     * Constructor which takes existing drawable object as input
     * @param input drawable object
     */
    public Paper(Drawable input) {
        polygonList = new ArrayList<>(input.getAllDrawnPolygons());
    }

    @Override
    public void changeColor(Color color) {
        this.drawingColor = color;
    }

    @Override
    public void drawPolygon(Polygon polygon) {
        if (drawingColor == Color.WHITE) {
            return;
        }

        if (polygonList.contains(new ColoredPolygon(polygon, drawingColor))) {
            return;
        }
        polygonList.add(new ColoredPolygon(polygon, drawingColor));
    }

    @Override
    public void erasePolygon(ColoredPolygon polygon) {
        polygonList.remove(polygon);
    }

    @Override
    public void eraseAll() {
        polygonList.clear();
    }

    @Override
    public Collection<ColoredPolygon> getAllDrawnPolygons() {
        return Collections.unmodifiableList(polygonList);
    }

    @Override
    public int uniqueVerticesAmount() {
        Set<Vertex2D> uniqueVertices = new HashSet<>();
        for (ColoredPolygon p : polygonList) {
            for (int i = 0; i < p.getPolygon().getNumVertices(); i++) {
                uniqueVertices.add(p.getPolygon().getVertex(i));
            }
        }
        return uniqueVertices.size();
    }
}
