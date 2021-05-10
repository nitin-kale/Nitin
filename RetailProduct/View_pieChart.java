 package RetailProduct;

import java.awt.Color;
import java.awt.Toolkit;
import java.io.*; 
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset; 

 

public class View_pieChart  extends getResultSet{
	
	ChartPanel chartPanel ;
  	DefaultPieDataset dataset = new DefaultPieDataset( );
 	JFrame frame;
 	JFreeChart chart;
 	JLabel label;
    int width = 560;    /* Width of the image */
    int height = 300;   /* Height of the image */ 
    File pieChart ;
    String chartTitle ;
    
    
	public File drawPieChart(ResultSet rs1, String vchartTitle , String[] Col, String vtype) throws NumberFormatException, SQLException, IOException
	{
	 	chartTitle = vchartTitle ;
   		frame = new JFrame("Meretoo -Business Analytics") ;
		frame.setBounds(100,100,600,600);
		frame.setResizable(true);
		frame.setAlwaysOnTop(true);
 		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 		label = new JLabel();
 		
     		while( rs1.next( ) ) 
    		{
    			switch(vtype)
    			{
		 			  case "Month" :
	  	 				  dataset.setValue( rs1.getString( 2) , Double.parseDouble( rs1.getString( 11)));
		                  break;
		           
		           	case "Brand" :
	 	  				  dataset.setValue( rs1.getString( 2) , Double.parseDouble( rs1.getString( 11)));
 	 	  				  break;
 
		           	case "Category" :
	 	  				  dataset.setValue( rs1.getString( 2) , Double.parseDouble( rs1.getString( 11)));
 	 	  				  break;
 			  
		           	case "SubCategory" :
	 	  				  dataset.setValue( rs1.getString( 2) , Double.parseDouble( rs1.getString( 11)));
  	 	  				  break;

		           	case "Group" :
	 	  				  dataset.setValue( rs1.getString( 2) , Double.parseDouble( rs1.getString( 11)));
  	 	  				  break;

		           	case "SubGroup" :
	 	  				  dataset.setValue( rs1.getString( 2) , Double.parseDouble( rs1.getString( 11)));
  	 	  				  break;

 			  }
    	}
 	  	         chart = ChartFactory.createPieChart(   chartTitle,   // chart title           
		         dataset,          // data           
		         true,             // include legend          
		         true,           
		         false );

  	 	         chartPanel = new ChartPanel( chart );        
  	 	         chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
  
  	      		  width = 1300;    /* Width of the image */
			      height = 275;   /* Height of the image */ 
	 		      pieChart = new File( ProductPath ,"Pie_Chart.jpeg" );
 	
	 		      if (pieChart.exists())
 			      {
 			    	  pieChart.delete();
 			    	  saveImage();
  			      }
 	
			      if (!pieChart.exists())
 			      {
  			    	 saveImage();
  			      }
 			      return pieChart;
 	}

	
public void saveImage() throws IOException
{
  
   	ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
    // showinFrame();
}
	
	
public void showinFrame()
{
 	frame = new JFrame("Meretoo -Business Analytics") ;
	frame.setBounds(10,10,600,600);
	frame.setResizable(true);
	frame.setAlwaysOnTop(true);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    frame.remove(label);
	label = new JLabel();
	label.setEnabled(false);
	label.setBounds(1,1,1200,600);

    chart = ChartFactory.createPieChart(   chartTitle,   // chart title           
	         dataset,          // data           
	         true,             // include legend          
	         true,           
	         false );

	 	chartPanel = new ChartPanel( chart );        
    	chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        

	width = 1300;    /* Width of the image */
    height = 800;   /* Height of the image */ 
    
    pieChart = new File( ProductPath ,"Pie_Chart.jpeg" );
    frame.getContentPane().add(chartPanel);
    frame.setVisible(true);
	
}
	
   public static void main( String[ ] args )  {
      
	   
        }
}