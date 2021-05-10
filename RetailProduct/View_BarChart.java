package RetailProduct;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class View_BarChart extends getResultSet {

	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	JFrame frame;
	JFreeChart chart;
	JLabel label;
	int width = 560; /* Width of the image */
	int height = 300; /* Height of the image */
	File pieChart;
	String chartTitle;

	public View_BarChart(ResultSet rs, String applicationTitle, String vchartTitle, String vtype) throws SQLException {
		chartTitle = vchartTitle;
		JFreeChart barChart = ChartFactory.createBarChart(chartTitle, "Category", "Value",

				createDataset(rs, vtype), PlotOrientation.VERTICAL, true, true, false);

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));

		//
		frame = new JFrame("Meretoo -Business Analytics");
		// frame.setBounds(100,100,300,300);
		frame.setBounds(0, 177, 1300, 461);
		frame.setResizable(true);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setUndecorated(false);
		// frame.remove(label);
		label = new JLabel();
		label.setEnabled(false);
		label.setBounds(1, 1, 1200, 600);

		label.setIcon(new ImageIcon(ProductPath + "Pie_Chart.jpeg"));
		// frame.getContentPane().add(label);
		frame.getContentPane().add(chartPanel);

		frame.setVisible(true);

		//

	}

	private CategoryDataset createDataset(ResultSet rs, String vtype) throws SQLException {

		dataset = new DefaultCategoryDataset();
		while (rs.next()) {
			switch (vtype) {
			case "Month":
				// new General().msg(rs.getString(3)+ " " +rs.getString(2));
				dataset.addValue(Double.parseDouble(rs.getString(10)), rs.getString(2), rs.getString(2));
				break;
			case "GLMONTH":
				// new General().msg(rs.getString(1)+ " " +rs.getString(4));
				dataset.addValue(Double.parseDouble(rs.getString(4)), rs.getString(1), rs.getString(1));
				break;

			default:
				dataset.addValue(Double.parseDouble(rs.getString(11)), rs.getString(2), rs.getString(2));
				break;

			}
		}
		return dataset;
	}

	public static void main(String[] args) {

	}

}