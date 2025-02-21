import java.util.Arrays;

public class BagDriver {
    public static void main(String[] args) {
        // Test with ResizableArrayBag
        System.out.println("===== Testing ResizableArrayBag =====");
        testBag(new ResizableArrayBag<>(), new ResizableArrayBag<>());

        // Test with LinkedBag
        System.out.println("\n===== Testing LinkedBag =====");
        testBag(new LinkedBag<>(), new LinkedBag<>());
    }

    public static void testBag(BagInterface<String> bag1, BagInterface<String> bag2) {
        // Adding elements to Bag 1
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");

        // Adding elements to Bag 2
        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");

        // Display the original bags
        System.out.println("Bag 1: " + Arrays.toString(bag1.toArray()));
        System.out.println("Bag 2: " + Arrays.toString(bag2.toArray()));

        // Performing operations
        BagInterface<String> unionBag = bag1.union(bag2);
        BagInterface<String> intersectionBag = bag1.intersection(bag2);
        BagInterface<String> differenceBag1 = bag1.difference(bag2);
        BagInterface<String> differenceBag2 = bag2.difference(bag1);

        // Display the results
        System.out.println("\nUnion: " + Arrays.toString(unionBag.toArray()));
        System.out.println("Intersection: " + Arrays.toString(intersectionBag.toArray()));
        System.out.println("Difference (Bag1 - Bag2): " + Arrays.toString(differenceBag1.toArray()));
        System.out.println("Difference (Bag2 - Bag1): " + Arrays.toString(differenceBag2.toArray()));
    }
}
