import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class LinkedBagTest {
    private LinkedBag<String> bag1;
    private LinkedBag<String> bag2;

    @BeforeEach
    void setUp() {
        bag1 = new LinkedBag<>();
        bag2 = new LinkedBag<>();

        bag1.add("a");
        bag1.add("b");
        bag1.add("c");

        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");
    }

    @Test
    void testUnion() {
        BagInterface<String> result = bag1.union(bag2);
        List<String> expected = Arrays.asList("a", "b", "c", "b", "b", "d", "e");
        List<String> actual = Arrays.asList(result.toArray());

        assertTrue(actual.containsAll(expected) && expected.containsAll(actual), "Union operation failed.");
    }

    @Test
    void testIntersection() {
        BagInterface<String> result = bag1.intersection(bag2);
        List<String> expected = Arrays.asList("b");
        List<String> actual = Arrays.asList(result.toArray());

        assertTrue(actual.containsAll(expected) && expected.containsAll(actual), "Intersection operation failed.");
    }

    @Test
    void testDifference() {
        BagInterface<String> result = bag1.difference(bag2);
        List<String> expected = Arrays.asList("a", "c");
        List<String> actual = Arrays.asList(result.toArray());

        assertTrue(actual.containsAll(expected) && expected.containsAll(actual), "Difference operation failed.");
    }
}
