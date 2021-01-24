import com.company.core.Key;
import com.company.core.SquareBoard;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SquareBoardTests {
    @Test
    public void test_fillBoard_successWhenValuesListSizeEqualsBoardSize() {
        //arrange
        int size = 3;
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < size * size - 1; i++) values.add(i);
        values.add(null);

        SquareBoard<Integer> board = new SquareBoard<>(size);
        //act
        board.fillBoard(values);

        //assert
        String expected = "0 1 2 \n3 4 5 \n6 7 null \n";
        assertEquals(expected, board.toString());
    }

    @Test
    public void test_fillBoard_throwsExceptionWhenValuesListLessThanBoardSize() {
        //arrange
        int size = 3;
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < size * size - 1; i++) values.add(i);

        SquareBoard<Integer> board = new SquareBoard<>(size);

        //act
        //assert
        assertThrows(IllegalArgumentException.class, () -> board.fillBoard(values));
    }

    @Test
    public void test_fillBoard_throwsExceptionWhenValuesListMoreThanBoardSize() {
        //arrange
        int size = 3;
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < size * size + 1; i++) values.add(i);

        SquareBoard<Integer> board = new SquareBoard<>(size);

        //act
        //assert
        assertThrows(IllegalArgumentException.class, () -> board.fillBoard(values));
    }

    @Test
    public void test_availableSpace_whenSpaceAvailable() {
        //arrange
        int size = 3;
        List<Integer> values = new ArrayList<>();
        int boardEntriesCount = size * size - 2;
        for (int i = 0; i < boardEntriesCount; i++) values.add(i);
        values.add(null);
        values.add(null);

        SquareBoard<Integer> board = new SquareBoard<>(size);
        board.fillBoard(values);

        List<Key> expected = new ArrayList<>();
        expected.add(new Key(size - 1, size - 2));
        expected.add(new Key(size - 1, size - 1));

        //act
        List<Key> result = board.availableSpace();

        //assert
        assertEquals(expected, result);
    }

    @Test
    public void test_availableSpace_whenNoSpaceAvailable() {
        //arrange
        int size = 3;
        List<Integer> values = new ArrayList<>();
        int boardEntriesCount = size * size;
        for (int i = 0; i < boardEntriesCount; i++) values.add(i);

        SquareBoard<Integer> board = new SquareBoard<>(size);
        board.fillBoard(values);

        List<Key> expected = new ArrayList<>();

        //act
        List<Key> result = board.availableSpace();

        //assert
        assertEquals(expected, result);
    }

    @Test
    public void test_addItem_whenNoValueOnSuchPosition() {
        //arrange
        int size = 3;
        List<Integer> values = new ArrayList<>();
        int boardEntriesCount = size * size - 1;
        for (int i = 0; i < boardEntriesCount; i++) values.add(i);
        values.add(null);

        SquareBoard<Integer> board = new SquareBoard<>(size);
        board.fillBoard(values);

        //act
        board.addItem(new Key(size - 1, size - 1), 10);

        //assert
        String expected = "0 1 2 \n3 4 5 \n6 7 10 \n";
        assertEquals(expected, board.toString());
    }

    @Test
    public void test_addItem_whenValueOnSuchPositionAlreadyExists() {
        //arrange
        int size = 3;
        List<Integer> values = new ArrayList<>();
        int boardEntriesCount = size * size;
        for (int i = 0; i < boardEntriesCount; i++) values.add(i);

        SquareBoard<Integer> board = new SquareBoard<>(size);
        board.fillBoard(values);

        //act
        board.addItem(new Key(size - 1, size - 1), 10);

        //assert
        String expected = "0 1 2 \n3 4 5 \n6 7 10 \n";
        assertEquals(expected, board.toString());
    }

    @Test
    public void test_getKey_whenNoSuchKey() {
        //arrange
        int size = 3;
        List<Integer> values = new ArrayList<>();
        int boardEntriesCount = size * size - 1;
        for (int i = 0; i < boardEntriesCount; i++) values.add(i);
        values.add(null);

        SquareBoard<Integer> board = new SquareBoard<>(size);
        board.fillBoard(values);

        //act
        Key key = board.getKey(size - 1, size - 1);

        //assert
        Key expected = new Key(size - 1, size - 1);
        assertEquals(expected, key);
    }

    @Test
    public void test_getKey_whenKeyExists() {
        //arrange
        int size = 3;
        List<Integer> values = new ArrayList<>();
        int boardEntriesCount = size * size;
        for (int i = 0; i < boardEntriesCount; i++) values.add(i);

        SquareBoard<Integer> board = new SquareBoard<>(size);
        board.fillBoard(values);

        //act
        Key key = board.getKey(size - 1, size - 1);

        //assert
        Key expected = new Key(size - 1, size - 1);
        assertEquals(expected, key);
    }

    @Test
    public void test_getValue_whenNoValueOnSuchPosition() {
        //arrange
        int size = 3;
        List<Integer> values = new ArrayList<>();
        int boardEntriesCount = size * size;
        for (int i = 0; i < boardEntriesCount - 1; i++) values.add(i);
        values.add(null);

        SquareBoard<Integer> board = new SquareBoard<>(size);
        board.fillBoard(values);

        //act
        Integer value = board.getValue(new Key(size - 1, size - 1));

        //assert
        Integer expected = null;
        assertEquals(expected, value);
    }

    @Test
    public void test_getValue_whenValueOnSuchPositionExists() {
        //arrange
        int size = 3;
        List<Integer> values = new ArrayList<>();
        int boardEntriesCount = size * size;
        for (int i = 0; i < boardEntriesCount; i++) values.add(i);

        SquareBoard<Integer> board = new SquareBoard<>(size);
        board.fillBoard(values);

        //act
        Integer value = board.getValue(new Key(size - 1, size - 1));

        //assert
        Integer expected = 8;
        assertEquals(expected, value);
    }
}
