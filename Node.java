final class Node
{

	// Friendly data; accessible by other package routines
	Item     element;
	Node left;
	Node right;


	Node( )
	{
		this( null );
	}

	Node( Object theElement )
	{
		this( theElement, null, null );
	}

	Node( Object theElement, Node lt, Node rt )
	{
		element = theElement;
		left    = lt;
		right   = rt;
	}

	/**
	 * Return the size of the binary tree rooted at t.
	 */
	static int size( Node t )
	{
		if( t == null )
			return 0;
		else
			return 1 + size( t.left ) + size( t.right );
	}

	/**
	 * Return the height of the binary tree rooted at t.
	 */
	static int height( Node t )
	{
		if( t == null )
			return -1;
		else
			return 1 + Math.max( height( t.left ), height( t.right ) );
	}

	void printPreOrder( )
	{
		System.out.println( element );       // Node
		if( left != null )
			left.printPreOrder( );           // Left
		if( right != null )
			right.printPreOrder( );          // Right
	}


	void printPostOrder( )
	{
		if( left != null )
			left.printPostOrder( );          // Left
		if( right != null )
			right.printPostOrder( );         // Right
		System.out.println( element );       // Node
	}

	void printInOrder( )
	{
		if( left != null )
			left.printInOrder( );            // Left
		System.out.println( element );       // Node
		if( right != null )
			right.printInOrder( );           // Right
	}


	/**
	 * Return a reference to a node that is the root of a
	 * duplicate of the binary tree rooted at the current node.
	 */
	Node duplicate( )
	{
		Node root = new Node( element );

		if( left != null )            // If there's a left subtree
			root.left = left.duplicate( );    // Duplicate; attach
		if( right != null )          // If there's a right subtree
			root.right = right.duplicate( );  // Duplicate; attach
		return root;                      // Return resulting tree
	}

}