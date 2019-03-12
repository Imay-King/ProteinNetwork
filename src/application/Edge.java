package application;

import java.util.List;
/*
 * @Yiming
 * Characteristic for Edge
 */
public class Edge {
	Node a, b;
	boolean is_selfInteraction;
	public Edge(Node a, Node b) {
		this.a = a;
		this.b = b;
	if (a.getName().equals(b.getName())){
		is_selfInteraction = true;   
	}else{
		is_selfInteraction = false;
	}
	}
	public Node[] getNodes(){
		return new Node[]{a, b};
	}
	public boolean is_duplicated(List<Edge> edges){
		for(Edge item: edges){
					//check if the edges are self-interaction
					if(is_selfInteraction){
						return false;
					}
					//This is a undirected network,so we have to check if node pair are same
					else if(a.getName().equals(item.b.getName())&&b.getName().equals(item.a.getName())){		
						return true;
					}
					//Check if the node is the same one 
					else if(a.getName().equals(item.a.getName())&& b.getName().equals(item.b.getName())){
						return true;
					}
				
	
		}
		return false;
	}
}

