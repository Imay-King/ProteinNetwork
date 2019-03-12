package application;

import java.io.File;
import java.io.IOException;
/*
 * @Yiming
 * This is test file for important functions
 */

public class JunitTest {

	@org.junit.Test
	public void testshowdata() throws IOException {
		Network nw=new Network();
		File f=new File("PPInetwork.txt");
		nw.readFile(f);
	}
	@org.junit.Test
	public void testAddInter(){
	//	 ArrayList<Node> nw.getNodes()=new ArrayList<Node>();
	//	 ArrayList<Edge> edges=new ArrayList<Edge>();
		 Node b=new Node("P35439");
		 Node a=new Node("P35433");
		Network nw=new Network();
		System.out.println(nw.getNodes().size());
		nw.addInteraction(a, b);
		System.out.println(nw.getNodes().size());
		for (Node item: nw.getNodes()){
			  System.out.println(item.getName()+"\t"+item.getDegree());
		  }
		
		System.out.println(nw.getNodes().size());
	}
	@org.junit.Test
	public void testAverage() throws IOException{
		Network nw=new Network();
		File f=new File("PPInetwork.txt");
		nw.readFile(f);
	//    ArrayList<Node> nodes=new ArrayList<Node>();
		System.out.println(nw.getNodes().size());
		System.out.println(nw.averageDegree());
	}
	@org.junit.Test
	public void testCountDegree() throws IOException{
		Network nw=new Network();
		File f=new File("test.txt");
		nw.readFile(f);
		System.out.println(nw.countDegree("P21708"));
		
	}
	@org.junit.Test
	public void testFindHubs()throws IOException{
		Network nw=new Network();
		File f=new File("PPInetwork.txt");
		nw.readFile(f);
		nw.FindHubs();
	}
	public void testCalDis()throws IOException{
		Network nw=new Network();
		File f=new File("PPInetwork.txt");
		nw.readFile(f);
		System.out.println(nw.caldistribution());
	}
	
}
