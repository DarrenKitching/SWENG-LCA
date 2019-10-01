import java.util.ArrayList;

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
    static ArrayList<Node> nodes = new ArrayList<>();

    public static Node findLCA(Node head, Node nodeOne, Node nodeTwo) {
        Node LCA = null;
        addNodesToList(nodes, head);
        boolean isAncestor[] = new boolean[nodes.size()]; //keep track of which nodes are common ancestors to nodeOne and nodeTwo
        for(int i = 0; i < isAncestor.length; i++)
            isAncestor[i] = false; //initialize all index's to false
        
        return null;
    }

    public static void addNodesToList(ArrayList<Node> nodes, Node root) {
        if(root != null) {
            nodes.add(root);
            nodes.add(root.left);
            nodes.add(root.right);
        }
    }

    public static void main(String args[]) {

    }
}