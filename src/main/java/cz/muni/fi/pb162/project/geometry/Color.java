package cz.muni.fi.pb162.project.geometry;

/**
 * Enum representing colors
 * @author Matej Groman
 */
public enum Color {

    BLACK,
    WHITE,
    GREY,
    YELLOW,
    GREEN,
    BLUE,
    ORANGE,
    RED;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
