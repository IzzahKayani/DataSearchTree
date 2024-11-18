import org.w3c.dom.Node;

public class RedBlackTree <Key extends Comparable<Key>, Value>
{
    private static final boolean RED   = true;
    private static final boolean BLACK = false;

    private Node root; // BST root
    private int size; // number of key-value pairs

    private class Node
    {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private boolean color; // parent link color

        public Node(Key key, Value value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    // Search: returns value of associated key or null if it doesn't exist
    public Value get(Key key)
    {return get(root, key);}

    public Value get(Node h, Key key)
    {
        while(h != null)
        {
            int cmp = key.compareTo(h.key);
            if (cmp < 0)
                h = h.left;
            else if (cmp > 0)
                h = h.right;
            else
                return h.value;
        }
        return null;
    }

    // does the key exist?
    public boolean contains (Key key)
    {return get(key) != null;}

    // Red-Black Tree Insertion

    public void put(Key key, Value value)
    {
        root = insert(root, key, value);
        root.color = BLACK;
    }

    private Node insert(Node h, Key key, Value value)
    {
        if(h == null)
        {
            size++;
            return new Node(key, value, RED);
        }

        int cmp = key.compareTo(h.key);
        if (cmp < 0)
            h.left = insert(h.left, key, value);
        else if(cmp > 0)
            h.right = insert(h.right, key, value);
        else // if the key already exists within the tree, prints out an error stating the product already exists
            System.out.println("Error: user ID already exists");

        //fixes any incorrect red links
        if(isRed(h.right) && !isRed(h.left)) // right is red, rotate left
            h = rotateLeft(h);
        if (isRed(h.left)  &&  isRed(h.left.left)) // two lefts are red in a row, rotate right
            h = rotateRight(h);
        if (isRed(h.left)  &&  isRed(h.right)) // both children are red, flip colors
            flipColors(h);
        return h;
    }

    // Red tree rotate and check functions

    //checks if the node is red and not null
    private boolean isRed(Node h)
    {
        if(h == null)
            return false;
        return h.color == RED;
    }

    // when two left nodes in a row are red
    private Node rotateRight(Node h)
    {
        assert (h != null) && isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    // when a right child is red
    private Node rotateLeft(Node h)
    {
        assert (h != null) && isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    // when both children are red and the node is black, flips the colors
    // now node is red and the children are black
    private void flipColors(Node h)
    {
        assert !isRed(h) && isRed(h.left) && isRed(h.right);
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    // Basic Utility

    public int getSize()
    {return size;}

    public boolean isEmpty()
    {return size == 0;}
}
