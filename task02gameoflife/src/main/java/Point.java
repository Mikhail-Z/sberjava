import java.util.Objects;

public class Point {
    private boolean isAlive;

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return isAlive == point.isAlive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isAlive);
    }
}
