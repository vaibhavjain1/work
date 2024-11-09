package dataStructure.treeQuestions;


class Distance
{
    int minDis = Integer.MAX_VALUE;
}

class BinaryTree
{
    // This function finds the closest leaf to root.  This distance
    // is stored at *minDist.
    void findLeafDown(Node root, int lev, Distance minDist)
    {

        // base case
        if (root == null)
            return;

        // If this is a leaf node, then check if it is closer
        // than the closest so far
        if (root.left == null && root.right == null)
        {
            if (lev < (minDist.minDis))
                minDist.minDis = lev;

            return;
        }

        // Recur for left and right subtrees
        findLeafDown(root.left, lev + 1, minDist);
        findLeafDown(root.right, lev + 1, minDist);
    }

    // This function finds if there is closer leaf to x through
    // parent node.
    int findThroughParent(Node root, Node x, Distance minDist)
    {
        // Base cases
        if (root == null)
            return -1;

        if (root == x)
            return 0;

        // Search x in left subtree of root
        int l = findThroughParent(root.left, x, minDist);

        // If left subtree has x
        if (l != -1)
        {
            // Find closest leaf in right subtree
            findLeafDown(root.right, l + 2, minDist);
            return l + 1;
        }

        // Search x in right subtree of root
        int r = findThroughParent(root.right, x, minDist);

        // If right subtree has x
        if (r != -1)
        {
            // Find closest leaf in left subtree
            findLeafDown(root.left, r + 2, minDist);
            return r + 1;
        }

        return -1;
    }

    // Returns minimum distance of a leaf from given node x
    int minimumDistance(Node root, Node x)
    {
        // Initialize result (minimum distance from a leaf)
        Distance d = new Distance();

        // Find closest leaf down to x
        findLeafDown(x, 0, d);

        // See if there is a closer leaf through parent
        findThroughParent(root, x, d);

        return d.minDis;
    }

    // Driver program
    public static void main(String[] args)
    {
        // Let us create Binary Tree shown in above example
        Node root = new Node(1);
        root.left = new Node(12);
        root.right = new Node(13);

        root.right.left = new Node(14);
        root.right.right = new Node(15);


        root.right.right.left = new Node(23);
        root.right.right.right = new Node(24);


        root.right.right.left.left = new Node(5);
        root.right.right.left.left.left = new Node(-5);
        root.right.right.left.right = new Node(6);
        root.right.right.left.right.right = new Node(-6);
        root.right.right.right.left = new Node(7);
        root.right.right.right.left.left = new Node(-7);
        root.right.right.right.right = new Node(8);
        root.right.right.right.right.right = new Node(-8);

        Node x = root.right.right;

        Node.printTreeDiagram(root);
        BinaryTree tree = new BinaryTree();
        System.out.println("The closest leaf to node with value "
                + x.key + " is at a distance of "
                + tree.minimumDistance(root, x));
    }
}