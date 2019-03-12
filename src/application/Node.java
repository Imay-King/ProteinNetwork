package application;

import java.util.List;

/*
 * @Yiming
 * Characteristics for Node
 * 
 */
public class Node {
	String name;
	int degree=0; //initializing the degree is 0
	public  Node(){
		this.name= "";    
	}
	public Node(String nodeName){
		this.name=nodeName;
	}
	public String getName(){
		return this.name;
	}
	public int getDegree(){
	   return this.degree+1; //as for each vertex with loop, we consider it 2 degrees 
	}
	public void addDegree(){
		this.degree += 1;
	//	System.out.println("degree is "+ this.degree);
	}
	public boolean is_duplicated(List<Node> nodes){		//judging if the node is duplicated
		boolean duplicate_state =false;
//		System.out.println(nodes);
		for (Node item: nodes){
//			System.out.println(this.name);
//			System.out.println(item.getName());
		  if(this.name.equals(item.getName())){
		   		 item.addDegree();
		   		 duplicate_state=true;
		  }
		}
		return duplicate_state;
	}
}
