public class Main
{
    public static void main(String[] args)
    {
        Node D = new Node(null,null,null,'D');
        Node F = new Node(null,null,null,'F');
        Node G = new Node(null,null,null,'G');
        Node J = new Node(null,null,null,'J');
        Node L = new Node(null,null,null,'L');
        Node O = new Node(null,null,null,'O');
        Node P = new Node(null,null,null,'P');
        Node R = new Node(null,null,null,'R');
        Node V = new Node(null,null,null,'V');
        Node S = new Node(P,R,V,'S');
        Node N = new Node(J,L,O,'N');
        Node E = new Node(D,F,G,'E');
        Node M = new Node(E,N,S,'M');

        printNode(M);
    } // end main()

    // recursive function
    public static void printNode(Node rootNode)
    {
        // Do the "work"
        System.out.printf("Node: %s | Left: %s | Middle: %s | Right: %s%n",
                rootNode,rootNode.left, rootNode.middle,rootNode.right);

        // Checking left node, recursive call if required
        if(rootNode.left != null)
        {
            printNode(rootNode.left);
        }

        // Checking the middle node, recursive call if required
        if(rootNode.middle != null)
        {
            printNode(rootNode.middle);
        }

        // Checking the right node, recursive call if required
        if(rootNode.right != null)
        {
            printNode(rootNode.right);
        }
    } // end printNode()

} // end Main

class Node
{
    // Node properties/fields
    public Node left;
    public Node middle;
    public Node right;
    public char value;

    Node(Node left, Node middle, Node right, char value)
    {
        this.left = left;
        this.middle = middle;
        this.right = right;
        this.value = value;
    } // end constructor

    public String toString()
    {
        return String.valueOf(this.value);
    } // end toString()
} // end class Node