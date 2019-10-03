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

    public static Node findLCA(Node head, Node nodeOne, Node nodeTwo) {
        Node LCA = null;
        ArrayList<Node> nodes = new ArrayList<>();
        addNodesToList(nodes, head);
        boolean isAncestor[] = new boolean[nodes.size()]; //keep track of which nodes are common ancestors to nodeOne and nodeTwo
        for(int i = 0; i < isAncestor.length; i++)
            isAncestor[i] = false; //initialize all index's to false
        for(int i = 0; i < nodes.size(); i++) {
            if(checkIfAncestor(nodes.get(i), nodeOne, nodeTwo)) {
                isAncestor[i] = true;
            }
        }
        Node lca = null;
        for(int i = 0; i < nodes.size(); i++) {
            if(isAncestor[i])
                lca = nodes.get(i);
        }
        return lca;
    }

    public static boolean checkIfAncestor(Node node, Node nodeOne, Node nodeTwo) {
        if(checkIfAncestor(node, nodeOne) && checkIfAncestor(node, nodeTwo))
            return true;
        return false;
    }

    public static boolean checkIfAncestor(Node node, Node nodeOne) {
        if(node == null)
            return false;
        if(node == nodeOne)
            return true;
        else if(checkIfAncestor(node.left, nodeOne) || checkIfAncestor(node.right, nodeOne))
            return true;
        else
            return false;
    }

    public static void addNodesToList(ArrayList<Node> nodes, Node root) {
        if(root != null) {
            LinkedList<Node> queue = new LinkedList<>();
            queue.add(root);
            Node cur;
            while(queue.size() != 0) {
                cur = queue.get(0);
                if(cur.left != null)
                    queue.add(cur.left);
                if(cur.right != null)
                    queue.add(cur.right);
                nodes.add(cur);
                queue.remove(0);
            }
        }
    }

    public static void main(String args[]) {

    }
}