import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ResizableArrayBagTest {
    private ResizableArrayBag<String> bag1;
    private ResizableArrayBag<String> bag2;

    @BeforeEach
    void setUp() {
        bag1 = new ResizableArrayBag<>();
        bag2 = new ResizableArrayBag<>();

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
        String[] expected = {"a", "b", "c", "b", "b", "d", "e"};
        assertArrayEquals(expected, result.toArray(), "Union operation failed.");
    }

    @Test
    void testIntersection() {
        BagInterface<String> result = bag1.intersection(bag2);
        String[] expected = {"b"};
        assertArrayEquals(expected, result.toArray(), "Intersection operation failed.");
    }

    @Test
    void testDifference() {
        BagInterface<String> result = bag1.difference(bag2);
        String[] expected = {"a", "c"};
        assertArrayEquals(expected, result.toArray(), "Difference operation failed.");
    }
}
