package com.java.tree;

//	 10
//20	25
public class CustomBST {
	
	static TreeNode root;
	static int sum=0;
	
	class TreeNode{
		
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data){
			this.data = data;
		}
	}
	
	public void addNode(int data) {
		
		TreeNode newNode = new TreeNode(data);
		
		if(root == null) {
			root  =  newNode; 
			return;
			}
		TreeNode focusNode = root;
		
		while(true) {
		
			TreeNode parent =  focusNode;
			if(newNode.data < focusNode.data) {
				focusNode = focusNode.left;				
				if(focusNode == null) {
					parent.left = newNode;
					return;
				}
		
			}else {
				focusNode = focusNode.right;
				if(focusNode == null) 
				{
					parent.right = newNode;
					return;
				}
				
			}
	}	
		
	}
	
	public void InOrdertraverse(TreeNode node) {
		
		if(node != null) {
		InOrdertraverse(node.left);
		System.out.println(node.data);
		InOrdertraverse(node.right);
		}
		
	}
	
	public boolean searchElement(int data) {
		
		TreeNode focusNode = root;
		
		while(focusNode.data != data){
			if(data < focusNode.data) {
				focusNode = focusNode.left;
			}else {
				focusNode = focusNode.right;
			}
			if(focusNode == null) return false;
		}
		
		return true;
	}
	
	public int sumOfLeafNodes(){
		
		return traverse(root);	
	}
	
	public boolean isLeaf(TreeNode node) {
		
		if(node.left == null && node.right == null) return true;
		
		return false;
	}
	
	public int traverse(TreeNode node) {
		
		if(node != null) {
			traverse(node.left);
			if(isLeaf(node)) { sum += node.data; }
			traverse(node.right);
		}	
		return sum;
	}
	
	public static void main(String[] args) {
		
		CustomBST bst = new CustomBST();
		bst.addNode(10);
		bst.addNode(5);
		bst.addNode(15);
		bst.addNode(12);
		bst.InOrdertraverse(root);
		System.out.println(bst.searchElement(15));
		System.out.println("Sum Of Leaf Nodes::"+bst.sumOfLeafNodes());
	}

}
