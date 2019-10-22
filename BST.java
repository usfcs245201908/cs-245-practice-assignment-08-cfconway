public class BST<T> 
{	Node<T> root;
	public BST()
	{
		this.root = null;	
	}
	public class Node<T>
	{	Comparable data;
		Node<T> left;
		Node<T> right;
		public Node(Comparable item)
		{
			this.data = item;
			this.left = null;
			this.right = null;
		}


	}
	public boolean find(Comparable item)
	{
		return find(root, item);


	}

	protected boolean find(Node root, Comparable item)
	{
		if(root == null )	
			return false;
		else if (root.data.compareTo(item) == 0)
			return true;
		else if (root.data.compareTo(item) > 0)
			return find(root.left, item);
		else
			return find(root.right, item);
	
	} 


	public void insert(Comparable item)
	{
		root = insert(root, item);

	}
	private Node insert(Node node, Comparable item)
	{  		
		if(node == null)
		{
			return new Node(item);
			
		}
		else if(node.data.compareTo(item) > 0)
		{ //item > root, so insert left
			 node.left = insert(node.left, item);
		}

		else {//item less than root so inserr right
			 node.right = insert(node.right, item);
		}
	
		return node;
	}

	public void print()
	{
		print(root);
	}
	public void print(Node root)
	{
		if(root!= null)
		{
			print(root.left);
			System.out.println(root.data);
			print(root.right);
		}
	}

	public void delete(Comparable item)
	{
		root = delete(root, item);
	}

	public Node delete(Node root, Comparable item)
	{
		if(root == null)
			return root;
		if (item.compareTo(root.data)> 0)
			root.left = delete(root.left, item);
		else if (item.compareTo(root.data) < 0)
			root.right = delete(root.right, item);
		else
		{
			if(root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			root.data = minValue(root.right);
			root.right = delete(root.right, root.data);
		}

		return root;
	}
	public Comparable minValue(Node root)
	{
		Comparable min = root.data;
		while(root.left!= null)
		{
			min = root.left.data;
			root = root.left;
		} 
		return min;
	}

}