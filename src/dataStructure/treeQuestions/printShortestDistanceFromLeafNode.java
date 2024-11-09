package dataStructure.treeQuestions;

public class printShortestDistanceFromLeafNode {

    int lowestDistanceFromLeaf = Integer.MAX_VALUE;
    private int parentSideLeafDistance = Integer.MAX_VALUE;
    private int nodeDistanceFromRoot = -1;

    void lowestDistance(Node root, Node node) {
        if (node == null)
            return;

        // Lowest distance of leaf from node as parent
        distanceFromSpecifiedNode(node, 0);

        // Lowest distance of leaf from node - parent side
        distanceFromParentNodeSide(root, node, 0);
        int lowestDistanceFromParentSideLeaf = parentSideLeafDistance + nodeDistanceFromRoot;

        System.out.println("Lowest distance: ");
        System.out.print(lowestDistanceFromLeaf < lowestDistanceFromParentSideLeaf ? lowestDistanceFromLeaf : lowestDistanceFromParentSideLeaf);
    }

    // Find distance of the closest leaf from parent side as well as distance of specific node from that parent
    void distanceFromParentNodeSide(Node root, Node node, int distance) {
        if (root == null)
            return;

        // Find distance of provided node from root
        if (root == node) {
            nodeDistanceFromRoot = distance;
            return;
        }

        if (root.left == null && root.right == null) {
            if (distance < parentSideLeafDistance)
                parentSideLeafDistance = distance;
            return;
        }

        distanceFromParentNodeSide(root.left, node, distance + 1);
        distanceFromParentNodeSide(root.right, node, distance + 1);
    }

    void distanceFromSpecifiedNode(Node node, int distance) {
        if (node == null)
            return;

        if (node.left == null & node.right == null) {
            if (distance < lowestDistanceFromLeaf) {
                lowestDistanceFromLeaf = distance;
            }
            return;
        }

        distanceFromSpecifiedNode(node.left, distance + 1);
        distanceFromSpecifiedNode(node.right, distance + 1);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.right.left.right = new Node(6);
        root.right.right.right = new Node(7);
        root.right.left.right.left = new Node(8);
        root.right.right.right.left = new Node(9);
        root.right.right.right.left.right = new Node(10);
        Node.printTreeDiagram(root);

        printShortestDistanceFromLeafNode obj = new printShortestDistanceFromLeafNode();
        obj.lowestDistance(root, root.right.right);
    }
}
