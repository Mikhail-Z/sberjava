import java.util.*;

public class Field {
    private int length;
    private int height;
    private Point[][] points;

    public Field(int length, int height, int alivePointsCount) {
        this.length = length;
        this.height = height;
        this.points = new Point[height][length];
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.length; j++) {
                this.points[i][j] = new Point();
            }
        }
        initPoints(alivePointsCount);
    }

    private void initPoints(int alivePointsCount) {
        int alivePointsCountRemained = alivePointsCount;
        while (alivePointsCountRemained > 0) {
            Random rand = new Random();
            int x = rand.nextInt(length);
            int y = rand.nextInt(height);
            Point point = points[y][x];
            if (!point.isAlive()) {
                points[y][x].setAlive(true);
                alivePointsCountRemained--;
            }
        }
    }

    public List<Point> getNeighbours(int x, int y) {
        int x0, y0, x1, y1;
        if (x == 0) {
            x0 = x;
        } else {
            x0 = x - 1;
        }

        if (x == length - 1) {
            x1 = x;
        } else {
            x1 = x + 1;
        }

        if (y == 0) {
            y0 = y;
        } else {
            y0 = y - 1;
        }

        if (y == height - 1) {
            y1 = y;
        } else {
            y1 = y + 1;
        }

        return getPointsFromLocation(x0, y0, x1, y1, x, y);
    }

    public Point getPoint(int x, int y) {
        return points[y][x];
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < length; x++) {
                if (points[y][x].isAlive()) {
                    sb.append("+");
                } else {
                    sb.append("-");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Field newField = new Field(this.length, this.height, 0);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < length; x++) {
                newField.getPoint(x, y).setAlive(getPoint(x, y).isAlive());
            }
        }
        return newField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return length == field.length &&
                height == field.height &&
                Arrays.equals(points, field.points);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(length, height);
        result = 31 * result + Arrays.hashCode(points);
        return result;
    }

    private List<Point> getPointsFromLocation(int x0, int y0, int x1, int y1, int xExclude, int yExclude) {
        List<Point> points = new ArrayList<Point>();
        for (int y = y0; y <= y1; y++) {
            for (int x = x0; x <= x1; x++) {
                if (x == xExclude && y == yExclude) continue;
                points.add(this.points[y][x]);
            }
        }
        return points;
    }
}