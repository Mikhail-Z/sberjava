import com.company.core.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.AdditionalMatchers.*;

@ExtendWith(MockitoExtension.class)
public class Game2018Tests {
    @InjectMocks
    Game2048 game2048;
    @Mock
    private Board<Key, Integer> board;
    @Spy
    private GameHelper gameHelper;
    @Captor
    private ArgumentCaptor<Integer> intCaptor;
    @Captor
    private ArgumentCaptor<ArrayList<Key>> listCaptor;

    @Test
    public void test_init() {
        //arrange
        when(board.availableSpace()).thenReturn(Arrays.asList(new Key(0, 0), new Key(0, 1)));

        //act
        game2048.init();

        //assert
        verify(board, times(1)).fillBoard(any());
        verify(board, times(2)).addItem(any(), intCaptor.capture());
        intCaptor.getAllValues().forEach(value -> assertTrue(value == 2 || value == 4));
    }

    @Test
    public void test_canMove_whenAvailableSpaceExists() {
        //arrange
        when(board.availableSpace()).thenReturn(Arrays.asList(new Key(1, 1), new Key(1, 2)));

        //act
        boolean result = game2048.canMove();

        //assert
        assertTrue(result);
    }

    @Test
    public void test_canMove_whenNoAvaliableSpace() {
        //arrange
        when(board.availableSpace()).thenReturn(new ArrayList<>());

        //act
        boolean result = game2048.canMove();

        //assert
        assertFalse(result);
    }

    @Test
    public void test_move_whenLeftDirection() throws GameOverException {
        //arrange
        List<Key> row1keys = Arrays.asList(new Key(0, 0), new Key(0, 3), new Key(0, 2), new Key(0, 1));
        List<Key> row2keys = Arrays.asList(new Key(1, 0), new Key(1, 3), new Key(1, 2), new Key(1, 1));
        List<Key> row3keys = Arrays.asList(new Key(2, 0), new Key(2, 3), new Key(2, 2), new Key(2, 1));
        List<Key> row4keys = Arrays.asList(new Key(3, 0), new Key(3, 3), new Key(3, 2), new Key(3, 1));
        List<Integer> rowValues = Arrays.asList(1, 2, null, 4);
        List<Key> availableSpace = Arrays.asList(
                new Key(0, 3), new Key(1, 3), new Key(2, 3), new Key(3, 3));
        doReturn(row1keys).when(board).getRow(0);
        doReturn(row2keys).when(board).getRow(1);
        doReturn(row3keys).when(board).getRow(2);
        doReturn(row4keys).when(board).getRow(3);
        doReturn(rowValues).when(board).getValues(anyList());
        doReturn(availableSpace).when(board).availableSpace();

        //act
        game2048.move(Direction.LEFT);

        //assert
        verify(gameHelper, times(Game2048.GAME_SIZE)).moveAndMergeEqual(any());
        verify(board, times(Game2048.GAME_SIZE * Game2048.GAME_SIZE + 1))
                .addItem(any(), intCaptor.capture());
        assertTrue(intCaptor.getAllValues().stream().anyMatch(value -> value.equals(2) || value.equals(4)));
    }

    @Test
    public void test_move_throwsGameOverException() {
        //arrange
        List<Key> row1keys = Arrays.asList(new Key(0, 0), new Key(0, 3), new Key(0, 2), new Key(0, 1));
        List<Key> row2keys = Arrays.asList(new Key(1, 0), new Key(1, 3), new Key(1, 2), new Key(1, 1));
        List<Key> row3keys = Arrays.asList(new Key(2, 0), new Key(2, 3), new Key(2, 2), new Key(2, 1));
        List<Key> row4keys = Arrays.asList(new Key(3, 0), new Key(3, 3), new Key(3, 2), new Key(3, 1));
        List<Integer> rowValues = Arrays.asList(1, 2, 8, 4);
        List<Key> availableSpace = new ArrayList<>();
        doReturn(row1keys).when(board).getRow(0);
        doReturn(row2keys).when(board).getRow(1);
        doReturn(row3keys).when(board).getRow(2);
        doReturn(row4keys).when(board).getRow(3);
        doReturn(rowValues).when(board).getValues(anyList());
        doReturn(availableSpace).when(board).availableSpace();

        //act
        //assert
        assertThrows(GameOverException.class, () -> game2048.move(Direction.LEFT));
        verify(board, times(Game2048.GAME_SIZE * Game2048.GAME_SIZE)).addItem(any(), anyInt());
    }

    @Test
    public void test_addItem_whenSpaceAvailable() throws GameOverException {
        //arrange
        List<Key> availableSpace = Arrays.asList(
                new Key(0, 3), new Key(1, 3), new Key(2, 3), new Key(3, 3));
        doReturn(availableSpace).when(board).availableSpace();

        //act
        game2048.addItem();

        //assert
        verify(board, times(1)).addItem(any(), or(eq(2), eq(4)));
    }

    @Test
    public void test_addItem_throwsGameOverException() {
        //arrange
        List<Key> availableSpace = new ArrayList<>();
        doReturn(availableSpace).when(board).availableSpace();

        //act
        //assert
        assertThrows(GameOverException.class, () -> game2048.addItem());
        verify(board, times(0)).addItem(any(), anyInt());
    }

    @Test
    public void test_hasWin_whenNoMaxValueAchieved() {
        //arrange
        doReturn(128).when(board).getValue(any());

        //act
        //assert
        assertFalse(game2048.hasWin());
        verify(board, times(Game2048.GAME_SIZE * Game2048.GAME_SIZE)).getValue(any());
    }

    @Test
    public void test_hasWin_whenMaxValueAchieved() {
        //arrange
        doReturn(Game2048.WIN_VALUE).when(board).getValue(any());

        //act
        //assert
        assertTrue(game2048.hasWin());
    }
}
