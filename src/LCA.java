import java.util.ArrayList;
import java.util.LinkedList;

class LCA {
    public static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static class DagNode {
        int value;
        ArrayList<DagNode> edges;

        DagNode(int value) {
            this.value = value;
            edges = new ArrayList<>();
        }

        DagNode(int value, ArrayList<DagNode> edges) {
            this.value = value;
            this.edges = edges;
        }
    }

    public static Node findLCA(Node head, Node nodeOne, Node nodeTwo) {
        Node LCA = null;
        ArrayList<Node> nodes = new ArrayList<>();
        addNodesToList(nodes, head);
        boolean isAncestor[] = new boolean[nodes.size()]; //keep track of which nodes are common ancestors to nodeOne and nodeTwo
        for (int i = 0; i < isAncestor.length; i++)
            isAncestor[i] = false; //initialize all index's to false
        for (int i = 0; i < nodes.size(); i++) {
            if (checkIfAncestor(nodes.get(i), nodeOne, nodeTwo)) {
                isAncestor[i] = true;
            }
        }
        for (int i = 0; i < nodes.size(); i++) {
            if (isAncestor[i])
                LCA = nodes.get(i);
        }
        return LCA;
    }

    public static DagNode findLCADAG(DagNode head, DagNode nodeOne, DagNode nodeTwo) {
        DagNode LCA = null;
        ArrayList<DagNode> nodes = new ArrayList<>();
        addNodesToListDAG(nodes, head);
        boolean isAncestor[] = new boolean[nodes.size()];
        for (int i = 0; i < isAncestor.length; i++)
            isAncestor[i] = false;
        for (int i = 0; i < nodes.size(); i++) {
            if (checkIfAncestorDAG(nodes.get(i), nodeOne, nodeTwo)) {
                isAncestor[i] = true;
            }
        }
        for (int i = 0; i < nodes.size(); i++) {
            if(isAncestor[i])
                LCA = nodes.get(i);
        }
        return LCA;
    }

    public static boolean checkIfAncestor(Node node, Node nodeOne, Node nodeTwo) {
        if (checkIfAncestor(node, nodeOne) && checkIfAncestor(node, nodeTwo))
            return true;
        return false;
    }

    public static boolean checkIfAncestor(Node node, Node nodeOne) {
        if (node == null)
            return false;
        if (node == nodeOne)
            return true;
        else if (checkIfAncestor(node.left, nodeOne) || checkIfAncestor(node.right, nodeOne))
            return true;
        else
            return false;
    }

    public static boolean checkIfAncestorDAG(DagNode node, DagNode nodeOne) {
        if (node == null)
            return false;
        if (node == nodeOne)
            return true;
        else {
            for (int i = 0; i < node.edges.size(); i++) {
                if (checkIfAncestorDAG(node.edges.get(i), nodeOne)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkIfAncestorDAG(DagNode node, DagNode nodeOne, DagNode nodeTwo) {
        if (checkIfAncestorDAG(node, nodeOne) && checkIfAncestorDAG(node, nodeTwo))
            return true;
        return false;
    }

    public static void addNodesToList(ArrayList<Node> nodes, Node root) {
        if (root != null) {
            LinkedList<Node> queue = new LinkedList<>();
            queue.add(root);
            Node cur;
            while (queue.size() != 0) {
                cur = queue.get(0);
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
                nodes.add(cur);
                queue.remove(0);
            }
        }
    }

    public static void addNodesToListDAG(ArrayList<DagNode> nodes, DagNode root) {
        if (root != null) {
            LinkedList<DagNode> queue = new LinkedList<>();
            queue.add(root);
            DagNode cur;
            while (queue.size() != 0) {
                cur = queue.get(0);
                for (int i = 0; i < cur.edges.size(); i++) {
                    queue.add(cur.edges.get(i));
                }
                nodes.add(cur);
                queue.remove(0);
            }
        }
    }

    public static void main(String args[]) {

    }
}