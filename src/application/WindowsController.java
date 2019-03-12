package application;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Window;
/*
 * @Yiming 
 * This is controller for user interface,all components would be defined here
 */
public class WindowsController {
	@FXML
	private TextField CountDegreeId;
	@FXML
	private TextField AddInteractionId;
	@FXML
	private Button loadbtn;
	@FXML
	private Button savebtn;
	@FXML
	public Network network;
	@FXML
	private Label data;
	@FXML
	private Window windows;
	@FXML
	private Window windowssave;
	@FXML
	private TextArea table;
	@FXML
	private String content;
	@FXML
	private Alert  alert=new Alert(AlertType.INFORMATION);
	@FXML
	private Label degreeNumber;
	@FXML
	private ArrayList<Node> nodes;
	@FXML		//method for showing file information
	public void showData() {
//		Class<Network> cls=Network.class;
	//	Method med=cls.getMethod("FindHubs", Integer.class);
		String hubs=Arrays.toString(network.FindHubs());
		if(network.getNodes().size()<1){
			alert.setTitle("File-Chosen Message!");
			alert.setHeaderText(null);
			alert.setContentText("Please choose the right file!");
			alert.showAndWait();
		}else{
			data.setText("The number of nodes is:"+ network.getNodes().size()+"\n"
								+"The average degree of nodes is :"+ network.averageDegree()+"\n"
								+"The value of highest degree is "+network.FindMaxDegree() +"\n"
								
			// Arrays.toString(network.FindHubs()).length()
	                		+"The Hubs are:"+hubs.substring(1,hubs.length()-1));
		}
	}
	@FXML	//method for showing result for counting degrees
	public void showTable(){
		String title="Degree"+"\t"+"Number of same degree nodes"+"\n";
		table.clear();
		table.appendText(title+network.getDistribution(network.caldistribution()));
		table.setEditable(false);
	}
	@FXML	//method for loading files
	public void loadfile() throws IOException{
		
			FileChooser filechooser=new FileChooser();
			File selectedFile=filechooser.showOpenDialog(windows);
		if(selectedFile!=null){
			this.network=new Network();
			network.readFile(selectedFile);
			showData();
			showTable();
		}
	}
	@FXML	// method for adding interaction
	public void addInter(){
		if(network!=null){		//judge if it is a empty network
		String txt=AddInteractionId.getText();
		System.out.println(txt);
		String a=txt.split(";")[0];
		String b=txt.split(";")[1];
		Node a1=new Node(a);
		Node b1=new Node(b);
/*
 * method for checking if added interaction has already exist
 * 		if()
 */
		try{	
		this.network.addInteraction(a1, b1);
		showData();
		showTable();
		alert.setTitle("Add Interaction Message!");
		alert.setHeaderText(null);
		alert.setContentText("You have added an interaction!");
		alert.showAndWait();
		}catch(Exception e){
		e.printStackTrace();
		}
		}else{
			alert.setContentText("Please load a file first!");
			alert.setHeaderText(null);
			alert.showAndWait();
		}
	}
	@FXML	//method for showing degree number for a node
	public void showNodeDegree(){
		String nodeName = CountDegreeId.getText().trim();
		if(network!=null)		//judge if it is a empty network
		{
		//System.out.println(nodeName);
			if(!"".equals(nodeName)){	//judge if user input a nodename
				int number = 0;
				try {
    		
					number = this.network.countDegree(nodeName);
					System.out.println(number);
				} catch(Exception e) {
					e.printStackTrace();
				}
				if (number < 1) {
					degreeNumber.setText("'" + nodeName + "' is a invalid node");
				} else {
					degreeNumber.setText("The degree of " + nodeName + " is: " + Integer.toString(number));
				}
				
			}else{
				degreeNumber.setText("'" + nodeName + "' is a invalid node");
			}
		}else {
			alert.setContentText("Please load a file first!");
			alert.setHeaderText(null);
			alert.showAndWait();
		}
		}
	@FXML	//method for saving files
	public void saveDistribution(){
		String title="Degree"+"\t"+"Number of same degree nodes"+"\n";
		String content=title+network.getDistribution(network.caldistribution());
	//	System.out.println(content);
		FileChooser filechooser=new FileChooser();
		//Set Extension filter for text files
		FileChooser.ExtensionFilter filter=new FileChooser.ExtensionFilter("TXT files(*.txt)","*.txt");
		filechooser.getExtensionFilters().add(filter);
		//show save file dialog
		File file=filechooser.showSaveDialog(windowssave);
		if(file!=null){
			this.network=new Network();
			network.savefiles(content, file);
			alert.setContentText("Congradulations! File has been saved");
			alert.setHeaderText(null);
			alert.showAndWait();
//			JOptionPane.showMessageDialog(null, "");
		}else{
			alert.setContentText("Saving file failed");
			alert.setHeaderText(null);
			alert.showAndWait();
			
		}
		
		
	}
	 
	@FXML
	public void HandleShowHistoStatistics() {
		Main m=new Main();
		m.showStatistics(this.network);
	}

	
}
