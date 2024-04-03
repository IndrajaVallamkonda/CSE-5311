class Node {
	int key;
	Node left, right;

	public Node(int item) {
		key = item;
		left = right = null;
	}
}

public class BinarySearchTree {
	Node root = null;
	Node insert(Node node, int key) {
		if (node == null) {
			node = new Node(key);
			return node;
		}
		if (key < node.key)
			node.left = insert(node.left, key);
		else if (key > node.key)
			node.right = insert(node.right, key);
		return node;
	}

	Node search(Node root, int key) {
		if (root == null || root.key == key)
			return root;

		if (root.key < key)
			return search(root.right, key);

		return search(root.left, key);
	}
	
	Node deleteNode(Node root, int key) {
        if (root == null)
            return root;
        if (root.key > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.key < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (root.left == null) {
            Node temp = root.right;
            return temp;
        } else if (root.right == null) {
            Node temp = root.left;
            return temp;
        }

        else {
 
            Node succParent = root;
            Node succ = root.right;
            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }
            if (succParent != root)
                succParent.left = succ.right;
            else
                succParent.right = succ.right;
 
            root.key = succ.key;
            return root;
        }
    }
    void printInorder(Node root)
    {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.key + " ");
        printInorder(root.right);
    }
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
	    int key = 6;
		tree.root = tree.insert(tree.root, 50);
		tree.insert(tree.root, 30);
		tree.insert(tree.root, 20);
		tree.insert(tree.root, 40);
		tree.insert(tree.root, 70);
		tree.insert(tree.root, 60);
		tree.insert(tree.root, 80);
		if (tree.search(tree.root, key) == null)
			System.out.println(key + " not found");
		else
			System.out.println(key + " found");

		key = 70;
		if (tree.search(tree.root, key) == null)
			System.out.println(key + " not found");
		else
			System.out.println(key + " found");
		
		tree.deleteNode(tree.root, 70);
		System.out.println("delete node 70");
		if (tree.search(tree.root, key) == null)
			System.out.println(key + " not found");
		else
			System.out.println(key + " found");
		
		System.out.print("Tree - ");
		tree.printInorder(tree.root);
	}
}

// Output:-
// 6 not found
// 70 found
// delete node 70
// 70 not found
// Tree - 20 30 40 50 60 80 
