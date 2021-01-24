import com.company.core.GameHelper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;


public class GameHelperTests {

    @Test
    public void test_moveAndMergeEqual_whenAllValuesDifferentWithoutFreeSpace() {
        //arrange
        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(4);
        values.add(8);
        GameHelper gameHelper = new GameHelper();
        
        //act
        List<Integer> result = gameHelper.moveAndMergeEqual(values);

        //assert
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(8);
        
        assertEquals(expected, result);
    }

    @Test
    public void test_moveAndMergeEqual_whenAllValuesDifferentWithFreeSpace() {
        //arrange
        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(null);
        values.add(4);
        values.add(8);
        GameHelper gameHelper = new GameHelper();

        //act
        List<Integer> result = gameHelper.moveAndMergeEqual(values);

        //assert
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(4);
        expected.add(8);
        expected.add(null);

        assertEquals(expected, result);
    }

    @Test
    public void test_moveAndMergeEqual_whenEqualValuesWithMaxSpaceBetween() {
        //arrange
        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(null);
        values.add(null);
        values.add(1);
        GameHelper gameHelper = new GameHelper();

        //act
        List<Integer> result = gameHelper.moveAndMergeEqual(values);

        //assert
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(null);
        expected.add(null);
        expected.add(null);

        assertEquals(expected, result);
    }

    @Test
    public void test_moveAndMergeEqual_whenThreeValuesAreMerged() {
        //arrange
        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(1);
        values.add(null);
        values.add(2);
        GameHelper gameHelper = new GameHelper();

        //act
        List<Integer> result = gameHelper.moveAndMergeEqual(values);

        //assert
        List<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(null);
        expected.add(null);
        expected.add(null);

        assertEquals(expected, result);
    }

    @Test
    public void test_moveAndMergeEqual_whenSeveralDifferentMerges() {
        //arrange
        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(1);
        values.add(4);
        values.add(4);
        GameHelper gameHelper = new GameHelper();

        //act
        List<Integer> result = gameHelper.moveAndMergeEqual(values);

        //assert
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(8);
        expected.add(null);
        expected.add(null);

        assertEquals(expected, result);
    }
}
