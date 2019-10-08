import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;

@RunWith(JUnit4.class)
public class LCAtest {
    @Test
    public void testNullInputsBST() {
        LCA lca = new LCA();
        assertEquals(lca.findLCA(null, null, null), null); // Two null inputs
        LCA.Node test = new LCA.Node(5);
        assertEquals(lca.findLCA(null, null, test), null); // First input null
        assertEquals(lca.findLCA(null, test, null), null); // Second input null
    }

    @Test
    public void testNullInputsDAG() {
        LCA lca = new LCA();
        assertEquals(lca.findLCADAG(null, null, null), null); // Two null inputs
        LCA.DagNode test = new LCA.DagNode(5);
        assertEquals(lca.findLCADAG(null, null, test), null); // First input null
        assertEquals(lca.findLCADAG(null, test, null), null); // Second input null
    }

    @Test
    public void smallInputBST() {
        LCA lca = new LCA();
        LCA.Node head = new LCA.Node(1);
        LCA.Node left = new LCA.Node(2);
        LCA.Node right = new LCA.Node(3);
        head.left = left;
        head.right = right;
        assertEquals(LCA.findLCA(head, left, right).value, head.value);
        assertEquals(LCA.findLCA(head, right, left).value, head.value);
    }

    @Test
    public void smallInputDAG() {
        LCA lca = new LCA();
        LCA.DagNode head = new LCA.DagNode(1);
        LCA.DagNode nodeTwo = new LCA.DagNode(2);
        LCA.DagNode nodeThree = new LCA.DagNode(3);
        LCA.DagNode nodeFour = new LCA.DagNode(4);
        head.edges.add(nodeTwo);
        head.edges.add(nodeThree);
        head.edges.add(nodeFour);
        assertEquals(head, LCA.findLCADAG(head, nodeTwo, nodeFour));
    }

    @Test
    public void largeInputBST() {
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
        assertEquals(LCA.findLCA(head, nodeFour, nodeSix).value, head.value);
        assertEquals(LCA.findLCA(head, nodeEight, nodeNine).value, nodeFour.value);
        assertEquals(LCA.findLCA(head, nodeTwelve, nodeSeven).value, nodeThree.value);
        assertEquals(LCA.findLCA(head, nodeFive, nodeEleven).value, nodeFive.value);
    }

    @Test
    public void largeInputDAG() {
        LCA lca = new LCA();
        LCA.DagNode head = new LCA.DagNode(1);
        LCA.DagNode nodeTwo = new LCA.DagNode(2);
        LCA.DagNode nodeThree = new LCA.DagNode(3);
        LCA.DagNode nodeFour = new LCA.DagNode(4);
        LCA.DagNode nodeFive = new LCA.DagNode(5);
        LCA.DagNode nodeSix = new LCA.DagNode(6);
        LCA.DagNode nodeSeven = new LCA.DagNode(7);
        LCA.DagNode nodeEight = new LCA.DagNode(8);
        LCA.DagNode nodeNine = new LCA.DagNode(9);
        LCA.DagNode nodeTen = new LCA.DagNode(10);
        LCA.DagNode nodeEleven = new LCA.DagNode(11);
        LCA.DagNode nodeTwelve = new LCA.DagNode(12);
        LCA.DagNode nodeThirteen = new LCA.DagNode(13);
        LCA.DagNode nodeFourteen = new LCA.DagNode(14);
        LCA.DagNode nodeFifteen = new LCA.DagNode(15);
        head.edges.add(nodeTwo);
        head.edges.add(nodeThree);
        head.edges.add(nodeFour);
        nodeTwo.edges.add(nodeFive);
        nodeTwo.edges.add(nodeSix);
        nodeTwo.edges.add(nodeSeven);
        nodeThree.edges.add(nodeSeven);
        nodeThree.edges.add(nodeEight);
        nodeThree.edges.add(nodeNine);
        nodeThree.edges.add(nodeTen);
        nodeFour.edges.add(nodeEleven);
        nodeFour.edges.add(nodeTwelve);
        nodeFour.edges.add(nodeThirteen);
        nodeFour.edges.add(nodeFourteen);
        nodeFour.edges.add(nodeFifteen);
        assertEquals(nodeThree.value, LCA.findLCADAG(head, nodeThree, nodeSeven).value);
        assertEquals(nodeFour.value, LCA.findLCADAG(head, nodeFifteen, nodeFourteen).value);
        assertEquals(head.value, LCA.findLCADAG(head, nodeTen, nodeFifteen).value);
        assertEquals(head.value, LCA.findLCADAG(head, head, head).value);
        assertEquals(nodeThree.value, LCA.findLCADAG(head, nodeThree, nodeThree).value);
    }

    @Test
    public void unBalancedTreeBST() {
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
        assertEquals(LCA.findLCA(head, nodeFive, nodeSeven).value, head.value);
        assertEquals(LCA.findLCA(head, nodeFour, nodeFive).value, nodeTwo.value);
        assertEquals(LCA.findLCA(head, nodeFive, nodeSix).value, head.value);
    }

    @Test
    public void testSameNodeBST() {
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
        assertEquals(LCA.findLCA(head, nodeFour, nodeFour).value, nodeFour.value);
        assertEquals(LCA.findLCA(head, nodeSix, nodeSix).value, nodeSix.value);
        assertEquals(LCA.findLCA(head, nodeThree, nodeThree).value, nodeThree.value);
        assertEquals(LCA.findLCA(head, head, head).value, head.value);
    }

    @Test
    public void testAddNodesToList() {
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
        ArrayList<LCA.Node> nodes = new ArrayList<>();
        lca.addNodesToList(nodes, head);
        assertEquals(head, nodes.get(0));
        assertEquals(nodeTwo, nodes.get(1));
        assertEquals(nodeThree, nodes.get(2));
        assertEquals(nodeFour, nodes.get(3));
        assertEquals(nodeFive, nodes.get(4));
        assertEquals(nodeSix, nodes.get(5));
        assertEquals(nodeSeven, nodes.get(6));
    }

    @Test
    public void testCheckIfAncestorOneNode() {
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
        assertEquals(true, lca.checkIfAncestor(head, nodeThree));
        assertEquals(false, lca.checkIfAncestor(nodeTwo, nodeThree));
        assertEquals(true, lca.checkIfAncestor(nodeFour, nodeFour));
        assertEquals(false, lca.checkIfAncestor(nodeFour, nodeSix));
    }

    @Test
    public void testCheckIfAncestorTwoNodes() {
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
        assertEquals(true, lca.checkIfAncestor(head, nodeThree, nodeFour));
        assertEquals(true, lca.checkIfAncestor(nodeFour, nodeEight, nodeNine));
        assertEquals(false, lca.checkIfAncestor(nodeFour, nodeSeven, nodeEight));
        assertEquals(true, lca.checkIfAncestor(nodeThree, nodeFourteen, nodeFifteen));
        assertEquals(false, lca.checkIfAncestor(nodeThree, head, nodeFifteen));
    }
}
