package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.exception.EmptyDrawableException;
import cz.muni.fi.pb162.project.exception.MissingVerticesException;
import cz.muni.fi.pb162.project.exception.TransparentColorException;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * Class representing draw surface
 * @author Matej Groman
 */
public class Paper implements Drawable, PolygonFactory {
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
            throw new TransparentColorException("The color is the same as paper (white).");
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
        if (polygonList.isEmpty()) {
            throw new EmptyDrawableException("The paper was already empty.");
        }
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

    @Override
    public Polygon tryToCreatePolygon(List<Vertex2D> vertices) throws MissingVerticesException {
        if (vertices == null) {
            throw new NullPointerException("Argument is null");
        }
        List<Vertex2D> myVertices = new ArrayList<>(vertices);

        try {
            return new CollectionPolygon(myVertices);
        } catch (IllegalArgumentException e) {
            myVertices = myVertices.stream().filter(x -> x != null).collect(Collectors.toList());
            return new CollectionPolygon(myVertices);
        }
    }

    @Override
    public void tryToDrawPolygons(List<List<Vertex2D>> collectionPolygons) throws EmptyDrawableException {
        int drawCount = 0;
        Throwable cause = null;
        for(List<Vertex2D> l : collectionPolygons) {
            try {
                drawPolygon(tryToCreatePolygon(l));
                drawCount++;
            } catch(TransparentColorException e) {
                cause = e;
                this.drawingColor = Color.BLACK;
            } catch(MissingVerticesException|NullPointerException e) {
                cause = e;
            }
        }
        if (drawCount == 0) {
            throw new EmptyDrawableException("",cause);
        }
    }

    /**
     * Function to get polygons with specified color
     * @param color Color which we want to query
     * @return List<Polygon> with polygons with the color
     */
    public Collection<Polygon> getPolygonsWithColor(Color color) {
        return polygonList.stream().filter(x->x.getColor() == color)
                .map(ColoredPolygon::getPolygon).collect(Collectors.toList());
    }
}
