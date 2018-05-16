/**
 * Creates a Node with content and two children, a left and a right one, each of which contains an adress to a new Node.
 * If said adress is null, that means the Node is a leaf and the Tree it's in can't be traversed any further.
 * @version 1.0
 * @author S. Larsson<br> A. Ebeling<br> M. Tijanic
 */

public class Node
{

	/** 
	 * Element in Node which is an Item. This is the content of the Node and where information can be stored.
	 * 
	 */
	public Item element;
	/** 
	 * Used to traverse. Stores an adress to the next Node.
	 */
	public Node leftChild;
	/** 
	 * Used to traverse. Stores an adress to the next Node.
	 */
	public Node rightChild;

	/** 
	 * Class constructor which takes no arguments.
	 */
	public Node()
	{
		this( null );
	}

	/** 
	 * Class constructor, takes Item as argument.
	 * @param theElement Item with information.
	 */
	public Node( Item theElement )
	{
		this( theElement, null, null );
	}
	/** 
	 * Class constructor, takes an Item and two Nodes as argument to create a branch or leaf in MakeTree.
	 * 
	 * @param theElement Item with information.
	 * @param lt Create a left child which is a Node. A null value means won't traverse further.
	 * @param rt Create a ight child which is a Node. A null value means won't traverse further.
	 */
	public Node( Item theElement, Node lt, Node rt )
	{
		element = theElement;
		leftChild = lt;
		rightChild = rt;
	}

	/** 
	 * Prints pre-order with no return.
	 */
	public void printPreOrder( )
	{
		System.out.println( element );       // Node
		if( leftChild != null )
			leftChild.printPreOrder( );           // Left
		if( rightChild != null )
			rightChild.printPreOrder( );          // Right
	}

	/** 
	 * Prints post-order with no return.
	 */
	public void printPostOrder( )
	{
		if( leftChild != null )
			leftChild.printPostOrder( );          // Left
		if( rightChild != null )
			rightChild.printPostOrder( );         // Right
		System.out.println( element );       // Node
	}
	/** 
	 * Print in order with no return.
	 */
	public void printInOrder( )
	{
		if( leftChild != null )
			leftChild.printInOrder( );            // Left
		System.out.println( element );       // Node
		if( rightChild != null )
			rightChild.printInOrder( );           // Right
	}
}