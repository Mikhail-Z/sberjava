import java.util.List;

public class Game {
    private final Field field;
    private final GameHistory history;

    private static final int LENGTH = 100;
    private static final int HEIGHT = 100;
    private static final int ALIVE_POINTS_COUNT = 1000;

    public Game() {
        this.field = new Field(LENGTH, HEIGHT, ALIVE_POINTS_COUNT);
        this.history = new SerializedGameHistory();
    }

    public void play(int maxIterationCount) {
        for (int i = 0; i < maxIterationCount; i++) {
            if (!playOneIteration()) {
                break;
            }
            showField();
            System.out.printf("========================%d/%d iterations passed=========================", i + 1, maxIterationCount);
        }
    }

    private boolean playOneIteration() {
        final Field oldFieldSnapshot;
        try {
            oldFieldSnapshot = (Field)field.clone();
        } catch (CloneNotSupportedException e) {
            return false;
        }

        for (int y = 0; y < oldFieldSnapshot.getHeight(); y++) {
            for (int x = 0; x < oldFieldSnapshot.getLength(); x++) {
                Point pointFromUnchangedField = oldFieldSnapshot.getPoint(x, y);
                List<Point> neighbourPoints = oldFieldSnapshot.getNeighbours(x, y);
                long alivePointsCount = neighbourPoints.stream()
                        .filter(Point::isAlive)
                        .count();
                if (alivePointsCount == 3 && !pointFromUnchangedField.isAlive()) {
                    field.getPoint(x, y).setAlive(true);
                } else if (pointFromUnchangedField.isAlive() && (alivePointsCount < 2 || alivePointsCount > 3)) {
                    field.getPoint(x, y).setAlive(false);
                }
            }
        }

        if (needsGameStop(oldFieldSnapshot)) {
            return false;
        }

        history.add(field);
        return true;
    }

    private boolean needsGameStop(final Field oldField) {
        if (oldField.equals(this.field)) {
            return true;
        }

        return history.contains(this.field);
    }

    private void showField() {
        System.out.println(field);
    }
}
