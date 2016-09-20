package com.sitech.prm.subject.thread;

public abstract class NodeOperationService {
	
	public void moveNode(Node currentNode, Node newFather){
		int newPostition = getNodeChilrenCount(newFather)+1;
		moveNode(currentNode,newFather,newPostition);
	}
	
	
	public void moveNode(Node currentNode, Node newFather,int position){
		try {
			canOperate(currentNode);
			lockRalatedNode(currentNode);
			changeCurrentNode(currentNode);
			changeSubNodes(currentNode);
			changeBigBrothers(newFather,position);
			changeLittleBrothers(newFather,position);
		}finally{
			unlockRalatedNode(currentNode);
		}
	}
	
	private void canOperate(Node currentNode) throws RuntimeException{
		
		
	}


	private void unlockRalatedNode(Node currentNode) {
		
	}


	private void lockRalatedNode(Node currentNode) {
		lockCurrentNode(currentNode);
		lockSubNodes(currentNode);
		//lockOldFather(currentNode);
		//lockNewFather(currentNode);
		lockBothers(currentNode);
	}


	private void lockBothers(Node currentNode) {
		//"SELECT * FROM INFO_TABLE WHERHE ID = '1' FOR UPDATE NO WAIT"
		
	}


	private void lockNewFather(Node currentNode) {
		// TODO Auto-generated method stub
		
	}


	private void lockOldFather(Node currentNode) {
		// TODO Auto-generated method stub
		
	}


	private void lockSubNodes(Node currentNode) {
		// TODO Auto-generated method stub
		
	}


	private void lockCurrentNode(Node currentNode) {
		// TODO Auto-generated method stub
		
	}


	private void changeLittleBrothers(Node newFather, int position) {
		// TODO Auto-generated method stub
		
	}

	private void changeBigBrothers(Node newFather, int position) {
		// TODO Auto-generated method stub
		
	}

	public void changeCurrentNode(Node currentNode){
		changeCurrentNode4MsgTable(currentNode);
		changeCurrentNode4InfoTable(currentNode);
	}
	
	public abstract void changeCurrentNode4MsgTable(Node currentNode);
	public abstract void changeCurrentNode4InfoTable(Node currentNode);
	
	public void changeSubNodes(Node currentNode){
		int levels = getSubNodeLevels(currentNode);
		for(int i=1;i<=levels;i++){
			changeNLevelSubNode(currentNode,i);
		}
	}
	
	
	private void changeNLevelSubNode(Node currentNode, int sonOfLevelN) {
		
	}

	private int getSubNodeLevels(Node currentNode) {
		return 0;
	}


	public void addNode(){
		
	}
	
	public void deleteNode(){
		
	}
	
	
	
	protected abstract int getNodeChilrenCount(Node node);
	
	
	
	
	class Node{
		public String id;
		public String pid;
		public String name;
		public Node pNode;
		public int level;
	}

}
