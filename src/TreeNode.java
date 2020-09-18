/**
 * @author MIKIAS ATANFU
 * A Generic data element class for the moresCodeTree data structure. 
 * This class store stores a data element and a left and right child of the data
 */
public class TreeNode<T> {
    private T data;
    TreeNode<T> leftChild, rightChild;
    
    public TreeNode(T dataNode) {
    	data = dataNode;
    }
    
    /**
     * deep copy constructor, which is used to make a deep copy of the TreeNode
     * @param treeNode a treeNode to make a deep copy form
     */
    public TreeNode(TreeNode<T> treeNode) {
    	data = (T) new TreeNode<T>(treeNode.data);
    	if(treeNode.leftChild != null)
    		leftChild = new TreeNode<T>(treeNode.leftChild);
    	if(treeNode.rightChild != null)
    		rightChild = new TreeNode<T>(treeNode.rightChild);
    }
    
    //getter or the data element
    public T getData() {
    	return data;
    }
  
    public TreeNode<T> getLeftChild() {
    	return leftChild;
    }
    
    public TreeNode<T> getRightChild() {
    	return rightChild;
    }
    
    public String toString() {
		return  "Data: " + data;
	}
    
    public void setData(T data) {
    	this.data = data;
    }
}
