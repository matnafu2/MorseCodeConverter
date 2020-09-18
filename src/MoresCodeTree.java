/**
 * This class is a data structure for the treeNode
 * It implements LinkedConcerterTreeInterface of string and structures a string data
 * according to their moresCode 
 * 
 * @author MIKIAS ATNAFU
 */
import java.util.ArrayList;

public class MoresCodeTree implements LinkedConverterTreeInterface<String>{

	private TreeNode<String> root;
	
	public MoresCodeTree() {
		buildTree();
	}

	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}

	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String result) {
		addNode(root, code, result);
		return this;
	}

	// A recursive method used to add a node in to a tree 	 
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
	     if(code.length() == 1) 
	     {
	    	if(code.charAt(0) == '.') {
	    		//TreeNode<String> leftChild = root.getLeftChild();
	    		root.leftChild = new TreeNode<String>(letter);
	    	}
	    	else if(code.charAt(0) == '-') {
	    		//TreeNode<String> rightChild = root.getRightChild();
	    		root.rightChild = new TreeNode<String>(letter);
	    	}
	    	else
	    		return; 
	     }
		
	     else {
	    	  int index = 0;
			  if(code.charAt(index) == '.') 
				  addNode(root.leftChild, code.substring(++index), letter);  
			  else 
				  addNode(root.rightChild, code.substring(++index), letter);
	     }
	}

	@Override
	public String fetch(String code) {
		if(root != null)
			return fetchNode(root, code);
		else
			return null;
	}

	public String fetchNode(TreeNode<String> root, String code) {
	 
		code = code.trim();
	    if(code.length() == 1) {
	    	if(code.charAt(0) == '.') {
	    		if(root.getLeftChild() != null)
	    			return root.getLeftChild().getData();
	    	}
	        else {
	        	if(root.getRightChild() != null)
	        		return root.getRightChild().getData();	
	        }
	    		
	    }
	    else if(code.length() > 1){
	    	int fetch = 0;
	    	if(code.charAt(fetch) == '.')
	    		return fetchNode(root.getLeftChild(), code.substring(++fetch));
	    	else if(code.charAt(fetch) == '-')
	    		return fetchNode(root.getRightChild(), code.substring(++fetch));
	    	else
	    		return "";
	    }
	    
	    return null;
	}

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void buildTree() {
		 // level 0
		root = new TreeNode<>("");
		// levle 1
		insert(".", "e");
		insert("-", "t");
		// level 2
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		// level 3
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		// level 4
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
		
	}
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> inorder = new ArrayList<>();
		if(root !=  null) 
			LNRoutputTraversal(root, inorder);
		return inorder;
	}

	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root.leftChild != null)
			LNRoutputTraversal(root.leftChild, list);
		
		list.add(root.getData());
		
		if(root.rightChild != null)
			LNRoutputTraversal(root.rightChild, list);
	}
   
}
