package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;



/*
 * @Yiming
 * Manipulations for a network
 */


public class Network {
     
	private ArrayList<Node> nodes=new ArrayList<Node>();
	private ArrayList<Edge> edges=new ArrayList<Edge>();
	
	public ArrayList<Node> getNodes(){
		return this.nodes;
	}
	public ArrayList<Edge> getEdges(){
		return this.edges;
	}
   public Network(){
	    				//This is a empty network 
   }
 
   public void readFile(File f) throws IOException{
	 try{
	   Scanner scanner =new Scanner(f);
//	   Path file=Paths.get(filename);
	  while(scanner.hasNextLine()){
		   String line=scanner.nextLine();
		   String[] elements=line.split("\t"); 
			Node a=new Node(elements[0]);
			Node b=new Node(elements[1]);
		//	System.out.format(a.getName()+"\t"+b.getName()+"\n");
			
			addInteraction(a, b);
			//print();
		   }
		   scanner.close();
/*	  for (Node item: nodes){
		  System.out.println(item.getName()+"\t"+item.getDegree());
	  }*/
	   }catch(IOException x){
		   System.err.format("IOException: %s%n", x);
	   }
	   
   }

public void addInteraction(Node a,Node b){
	   Edge edge=new Edge(a,b);		//Create new edges and identify whether the edges are duplicated 
	   
	   if(edge!=null)
	   {
		   if(!edge.is_duplicated(edges))
		   {
			   edges.add(edge);
			   if(!a.is_duplicated(nodes))
			   {
				   nodes.add(a);
			//   System.out.println("a is added");
			   }
			 //  System.out.println("now for b");
			   if (!b.is_duplicated(nodes))
			   {
				   nodes.add(b);
			//	   System.out.println("b is added");
			   }
			   
		    } 
	   }
}
   
   public int countDegree(String nodeName){		// count node degree
	   int nodeDegree=1;
	   for (Node item:nodes){
		   if(nodeName.equals(item.getName())){
			   nodeDegree= item.getDegree();
		   }
	   }
	   return nodeDegree;
   }
   public String averageDegree(){
	   
	   double sum=0;
	   double average;
	   for (Node item:nodes){
		   sum+=item.getDegree();
	   }
//	   System.out.println(sum);
//	   System.out.println(nodes.size());
	   average=sum/nodes.size();
	   NumberFormat nf=NumberFormat.getNumberInstance() ; //Format the double,keep four decimal
	   nf.setMaximumFractionDigits(4); 
	   String s= nf.format(average) ; 
	   return s;
	   
   }
   public int FindMaxDegree(){
	   int maxDegree=0;
	   int n=0;		//This is a counter
	   for(Node item:nodes){
		   if(maxDegree==0||item.getDegree()>maxDegree){
			   maxDegree=item.getDegree();
		   }else if (item.getDegree()==maxDegree){
			   n+=1;
		   }
	   }
	   return maxDegree;
	   
   }
   
   public String[] FindHubs(){
	   int maxDegree=0,i=0,n=0;
	   for(Node item:nodes){
		   if(maxDegree==0||item.getDegree()>maxDegree){
			   maxDegree=item.getDegree();
		   }else if (item.getDegree()==maxDegree){
			   n+=1;
		   }
	   }
	   //Find the number of degree and then find hub
	   String[] hub=new String[n];
	   for(Node item:nodes){
		   if(item.getDegree()== maxDegree){
			   hub[i]=item.getName();
			   System.out.println(hub[i]);
		   }
	   }
//	   System.out.println("The highest degree is :"+maxDegree);
	   return hub;
   }
   public String getDistribution(HashMap<String,Integer> distribution){
	   String dis="";    //append all the results for dis
	   for (String str:distribution.keySet()){
		   dis += str+"\t\t\t"+distribution.get(str)+"\n";
	   }
	//   System.out.println(dis);
	   return dis;
   }

   public List<Integer> parseToInt(List<String> str) {
	   List<Integer> numberlist=new ArrayList<>();
	   	for(String num:str){
	   		numberlist.add(Integer.parseInt(num));
	   	}
	   		return numberlist;
   			}

   public HashMap<String, Integer> caldistribution(){
	   HashMap<String, Integer> numDistribution=new HashMap<>();
	   for(Node item:nodes){
		   String degree=Integer.toString(item.getDegree());
//		   System.out.println(item.getName()+"\t"+item.getDegree());
	//	   System.out.println(degree);
		   int count=0;
//		   System.out.println(numDistribution.get(degree));
		   if(numDistribution.containsKey(degree)){
			   count=numDistribution.get(degree);
		   }
		   count++;
		   numDistribution.put(degree,count);
	   }
/*	   String dis="";
	   for (String str:numDistribution.keySet()){
		   
		    dis += str+"\t\t"+numDistribution.get(str)+"\n";
	   }
	   System.out.println(dis);
*/
	   return numDistribution;
	   
   }
   public void savefiles(String content,File file){
		try{
			FileWriter writer=new FileWriter(file);
			writer.write(content);
			writer.close();
				}catch(IOException e){
			e.printStackTrace();
			System.out.println("Save Fail!");
		}
	}
     
   
   
}
