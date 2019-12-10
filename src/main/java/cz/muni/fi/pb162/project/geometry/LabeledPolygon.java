package cz.muni.fi.pb162.project.geometry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Class representing labeled polygon
 * @author Matej Groman
 */
public final class LabeledPolygon extends SimplePolygon implements Polygon, Labelable, Sortable {
    private SortedMap<String, Vertex2D> sMap = new TreeMap<>();

    /**
     * Private constructor which is called by builder class
     * @param input map of string-vertex tuples
     */
    private LabeledPolygon(SortedMap<String, Vertex2D> input) {
        super(input.values());
        sMap.putAll(input);
    }

    @Override
    public Vertex2D getVertex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index must be >0");
        }
        return sMap.get(sMap.keySet().toArray()[index % sMap.size()]);
    }

    @Override
    public int getNumVertices() {
        return sMap.size();
    }

    @Override
    public Vertex2D getVertex(String label) {
        return sMap.get(label);
    }

    @Override
    public Collection<String> getLabels() {
        return Collections.unmodifiableSet(sMap.keySet());
    }

    @Override
    public Collection<String> getLabels(Vertex2D vertex) {
        return sMap.entrySet().stream()
                .filter(key -> key.getValue()
                        .equals(vertex))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Vertex2D> getSortedVertices() {
        return Collections.unmodifiableCollection(sMap.values());
    }

    @Override
    public Collection<Vertex2D> getSortedVertices(Comparator<Vertex2D> comparator) {
        List<Vertex2D> result = new ArrayList<>(sMap.values());
        result.sort(comparator);
        return result;
    }

    /**
     * Function which returns vertices that are in a polygon more than once
     * @return collection of polygons
     */
    public Collection<Vertex2D> duplicateVertices() {
        Map<Vertex2D, Integer> map = new HashMap<>();
        for (Vertex2D v : sMap.values()) {
            map.putIfAbsent(v, 0);
            map.put(v, map.get(v) + 1);
        }
        return map.entrySet().stream()
                .filter(item -> item.getValue() > 1)
                .map(item -> item.getKey())
                .collect(Collectors.toList());
    }

    /**
     * Class satisfiing builder pattern
     * @author Matej Groman
     */
    public static class Builder implements Buildable<LabeledPolygon> {
        private SortedMap<String, Vertex2D> tmpMap = new TreeMap<>();

        @Override
        public LabeledPolygon build() {
            return new LabeledPolygon(tmpMap);
        }

        /**
         * This method store new vertex with label
         * @param label name of the vertex
         * @param vert vertex instance
         * @return Builder or throws error
         */
        public Builder addVertex(String label, Vertex2D vert) {
            if (label == null || vert == null) {
                throw new IllegalArgumentException("label nor vertex can be null");
            }
            tmpMap.put(label, vert);
            return this;
        }
    }
}
