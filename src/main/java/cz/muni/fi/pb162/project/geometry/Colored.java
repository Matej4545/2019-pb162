package cz.muni.fi.pb162.project.geometry;

/**
 * Interface for getting and setting color
 * @author Matej Groman
 */
public interface Colored {

    /**
     * Getter for color
     * @return Color enum object
     */
    Color getColor();

    /**
     * Setter for color
     * @param c Color object to be set
     */
    void setColor(Color c);
}
