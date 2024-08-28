import org.junit.Test;
import static org.junit.Assert.*;

public class TwoThreeTreeTest {

    @Test
    public void testInsert() {
        TwoThreeTree tree = new TwoThreeTree();
        tree.insert(8);
        tree.insert(16);
        tree.insert(24);
        tree.insert(32);
        tree.insert(40);

        assertTrue(tree.search(8));
        assertTrue(tree.search(16));
        assertTrue(tree.search(24));
        assertTrue(tree.search(32));
        assertTrue(tree.search(40));


        assertFalse(tree.search(15));
        assertFalse(tree.search(25));
    }

    @Test
    public void testSearch() {
        TwoThreeTree tree = new TwoThreeTree();
        tree.insert(8);
        tree.insert(16);
        tree.insert(24);
        tree.insert(32);
        tree.insert(40);

        assertTrue(tree.search(8));
        assertTrue(tree.search(16));
        assertTrue(tree.search(24));
        assertTrue(tree.search(32));
        assertTrue(tree.search(40));

        assertFalse(tree.search(15));
        assertFalse(tree.search(25));
    }

    @Test
    public void testGetMax() {
        TwoThreeTree tree = new TwoThreeTree();
        tree.insert(8);
        tree.insert(16);
        tree.insert(24);
        tree.insert(32);
        tree.insert(40);

        assertEquals(40, tree.getMax());
    }

    @Test
    public void testDisplayInOrder() {
        TwoThreeTree tree = new TwoThreeTree();
        tree.insert(8);
        tree.insert(16);
        tree.insert(32);
        tree.insert(24);
        tree.insert(40);

        assertEquals("8, 16, 24, 32, 40 ", tree.displayInOrder());
    }
}
