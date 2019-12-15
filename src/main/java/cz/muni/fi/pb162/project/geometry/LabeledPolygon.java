package cz.muni.fi.pb162.project.geometry;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InvalidClassException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Class representing labeled polygon
 * @author Matej Groman
 */
public final class LabeledPolygon extends SimplePolygon implements Polygon, Labelable, Sortable, PolygonWritable {
    private SortedMap<String, Vertex2D> sMap = new TreeMap<>();
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

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
        return Collections.unmodifiableCollection(sMap.values()).stream().distinct().collect(Collectors.toList());
    }

    @Override
    public Collection<Vertex2D> getSortedVertices(Comparator<Vertex2D> comparator) {
        List<Vertex2D> result = new ArrayList<>(sMap.values());
        result.sort(comparator);
        return result.stream().distinct().collect(Collectors.toList());
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
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public void write(OutputStream os) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os))) {
            for (Map.Entry<String, Vertex2D> s : sMap.entrySet()) {
                bw.write(String.format("%s %s %s", s.getValue().getX(), s.getValue().getY(), s.getKey()));
                bw.newLine();
            }
        }
    }

    @Override
    public void write(File file) throws IOException {
        write(new FileOutputStream(file));
    }

    /**
     * Method for creating JSON formatted representation of this class instance
     * @param os output stream
     * @throws IOException on Error with files
     */
    public void writeJson(OutputStream os) throws IOException {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(os));
            bw.write(gson.toJson(sMap));
        } finally {
            if (bw != null) {
                bw.flush();
            }
        }
    }

    /**
     * Class satisfiing builder pattern
     * @author Matej Groman
     */
    public static class Builder implements Buildable<LabeledPolygon>, PolygonReadable {
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

        @Override
        public PolygonReadable read(InputStream is) throws IOException {
            SortedMap<String, Vertex2D> tmpRead = new TreeMap<>();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                String line = null;
                while ((line = br.readLine()) != null) {
                    Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)? -?\\d+(\\.\\d+)? .+");
                    Matcher matcher = pattern.matcher(line);
                    if (!matcher.find()) {
                        throw new IOException("invalid data format: " + line);
                    }

                    String[] parsed = line.split(" ", 3);

                    for (String p : parsed) {
                        if (p.equals("")) {
                            throw new InvalidClassException("The imput is empty");
                        }
                    }

                    tmpRead.put(parsed[2],
                            new Vertex2D(Double.parseDouble(parsed[0]), Double.parseDouble(parsed[1])));
                }
                for (Map.Entry<String, Vertex2D> s : tmpRead.entrySet()) {
                    this.addVertex(s.getKey(), s.getValue());
                }
            }
            return this;
        }

        @Override
        public PolygonReadable read(File file) throws IOException {
            read(new FileInputStream(file));
            return this;
        }
    }
}
