package application;

import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class BarchartController {
	@FXML
    private CategoryAxis BarDegreeNumber;

    @FXML
    private NumberAxis BarNodeNumber;

    @FXML
    private BarChart<String,Integer> distributionGraph;
    @FXML
    public Network network;
   
    @FXML 
    public void initialize(){
    	System.out.println("start a ");
       	XYChart.Series<String, Integer> series=new XYChart.Series<>();
        String val=this.network.getDistribution(this.network.caldistribution());
        System.out.println(val);
        val=val.substring(0,val.length());
    	String[] arr=val.split(",");
    	String[] arr1=Arrays.stream(arr).filter(s->(s!=null && s.length()>0)).toArray(String[]::new);
  /*  	for(int i=0;i<arr1.length;i++){
    		System.out.println(arr1[i]);
    	}
    	*/
    	List<String> values=Arrays.asList(arr1);
    	List<Integer> chartvalues=network.parseToInt(values);
    	for(int i=0;i<chartvalues.size();i++){
    		BarDegreeNumber.setCategories(FXCollections.<String>observableArrayList(arr1[i]));
    		System.out.println(chartvalues.get(i));
    		if(i%2==0){
    			series.getData().add(new XYChart.Data<>(values.get(i), chartvalues.get(i+1)));
    		}
    	BarNodeNumber.setLowerBound(0);
    	BarNodeNumber.setUpperBound(300);
    	BarNodeNumber.setTickUnit(1);    	
  // 	ObservableList<XYChart<String, Integer>> data= FXCollections.observableArrayList();
    		distributionGraph.getData().add(series);
    }
    	}
    	
    }
   
