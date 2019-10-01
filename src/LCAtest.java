import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LCAtest {
    @Test
    public void testNullInputs() {
        LCA lca = new LCA();
        assertEquals(lca.findLCA(null, null, null), null); // Two null inputs
        LCA.Node test = new LCA.Node(5);
        assertEquals(lca.findLCA(null, null, test), null); // First input null
        assertEquals(lca.findLCA(null, test, null), null); // Second input null
    }

    @Test
    public void smallInput() {
        LCA lca = new LCA();
        LCA.Node head = new LCA.Node(1);
        LCA.Node left = new LCA.Node(2);
        LCA.Node right = new LCA.Node(3);
        head.left = left;
        head.right = right;
        assertEquals(LCA.findLCA(head, left, right), head);
        assertEquals(LCA.findLCA(head, right, left), head);
    }

    @Test
    public void largeInput() {
        LCA lca = new LCA();
        LCA.Node head = new LCA.Node(1);
        LCA.Node nodeTwo = new LCA.Node(2);
        LCA.Node nodeThree = new LCA.Node(3);
        head.left = nodeTwo;
        head.right = nodeThree;
        LCA.Node nodeFour = new LCA.Node(4);
        LCA.Node nodeFive = new LCA.Node(5);
        LCA.Node nodeSix = new LCA.Node(6);
        LCA.Node nodeSeven = new LCA.Node(7);
        nodeTwo.left = nodeFour;
        nodeTwo.right = nodeFive;
        nodeThree.left = nodeSix;
        nodeThree.right = nodeSeven;
        LCA.Node nodeEight = new LCA.Node(8);
        LCA.Node nodeNine = new LCA.Node(9);
        LCA.Node nodeTen = new LCA.Node(10);
        LCA.Node nodeEleven = new LCA.Node(11);
        LCA.Node nodeTwelve = new LCA.Node(12);
        LCA.Node nodeThirteen = new LCA.Node(13);
        LCA.Node nodeFourteen = new LCA.Node(14);
        LCA.Node nodeFifteen = new LCA.Node(15);
        nodeFour.left = nodeEight;
        nodeFour.right = nodeNine;
        nodeFive.left = nodeTen;
        nodeFive.right = nodeEleven;
        nodeSix.left = nodeTwelve;
        nodeSix.right = nodeThirteen;
        nodeSeven.left = nodeFourteen;
        nodeSeven.right = nodeFifteen;
        assertEquals(LCA.findLCA(head, nodeFour, nodeSix), head);
        assertEquals(LCA.findLCA(head, nodeEight, nodeNine), nodeFour);
        assertEquals(LCA.findLCA(head, nodeTwelve, nodeSeven), nodeThree);
        assertEquals(LCA.findLCA(head, nodeFive, nodeEleven), nodeTwo);
    }

    @Test
    public void unBalancedTree() {
        LCA lca = new LCA();
        LCA.Node head = new LCA.Node(1);
        LCA.Node nodeTwo = new LCA.Node(2);
        LCA.Node nodeThree = new LCA.Node(3);
        head.left = nodeTwo;
        head.right = nodeThree;
        LCA.Node nodeFour = new LCA.Node(4);
        LCA.Node nodeFive = new LCA.Node(5);
        LCA.Node nodeSix = new LCA.Node(6);
        LCA.Node nodeSeven = new LCA.Node(7);
        nodeTwo.left = nodeFour;
        nodeFour.left = nodeFive;
        nodeFour.right = nodeSix;
        nodeThree.right = nodeSeven;
        assertEquals(LCA.findLCA(head, nodeFive, nodeSeven), head);
        assertEquals(LCA.findLCA(head, nodeFour, nodeFive), nodeTwo);
        assertEquals(LCA.findLCA(head, nodeFive, nodeSix), nodeTwo);
    }

    @Test
    public void testSameNode() {
        LCA lca = new LCA();
        LCA.Node head = new LCA.Node(1);
        LCA.Node nodeTwo = new LCA.Node(2);
        LCA.Node nodeThree = new LCA.Node(3);
        head.left = nodeTwo;
        head.right = nodeThree;
        LCA.Node nodeFour = new LCA.Node(4);
        LCA.Node nodeFive = new LCA.Node(5);
        LCA.Node nodeSix = new LCA.Node(6);
        LCA.Node nodeSeven = new LCA.Node(7);
        nodeTwo.left = nodeFour;
        nodeTwo.right = nodeFive;
        nodeThree.left = nodeSix;
        nodeThree.right = nodeSeven;
        assertEquals(LCA.findLCA(head, nodeFour, nodeFour), nodeTwo);
        assertEquals(LCA.findLCA(head, nodeSix, nodeSix), nodeThree);
        assertEquals(LCA.findLCA(head, nodeThree, nodeThree), head);
        assertEquals(LCA.findLCA(head, head, head), null);
    }
}
