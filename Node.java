final class Node
{

	// Friendly data; accessible by other package routines
	Item  	element;
	Node 	leftChild;
	Node 	rightChild;


	Node()
	{
		this( null );
	}

	Node( Item theElement )
	{
		this( theElement, null, null );
	}

	Node( Item theElement, Node lt, Node rt )
	{
		element = theElement;
		leftChild = lt;
		rightChild = rt;
	}

	/**
	 * Return the size of the binary tree rooted at t.
	 */
	static int size( Node t )
	{
		if( t == null )
			return 0;
		else
			return 1 + size( t.leftChild ) + size( t.rightChild );
	}

	void printPreOrder( )
	{
		System.out.println( element );       // Node
		if( leftChild != null )
			leftChild.printPreOrder( );           // Left
		if( rightChild != null )
			rightChild.printPreOrder( );          // Right
	}


	void printPostOrder( )
	{
		if( leftChild != null )
			leftChild.printPostOrder( );          // Left
		if( rightChild != null )
			rightChild.printPostOrder( );         // Right
		System.out.println( element );       // Node
	}

	void printInOrder( )
	{
		if( leftChild != null )
			leftChild.printInOrder( );            // Left
		System.out.println( element );       // Node
		if( rightChild != null )
			rightChild.printInOrder( );           // Right
	}


	/**
	 * Return a reference to a node that is the root of a
	 * duplicate of the binary tree rooted at the current node.
	 */
	Node duplicate( )
	{
		Node root = new Node( element );

		if( leftChild != null )            // If there's a left subtree
			root.leftChild = leftChild.duplicate( );    // Duplicate; attach
		if( rightChild != null )          // If there's a right subtree
			root.rightChild = rightChild.duplicate( );  // Duplicate; attach
		return root;                      // Return resulting tree
	}

}