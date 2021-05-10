package RetailProduct;

import org.jfree.chart.ChartPanel;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class View_LineChart extends getResultSet {

	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	JFrame frame;
	JFreeChart chart;
	JLabel label;
	int width = 560; /* Width of the image */
	int height = 300; /* Height of the image */
	File pieChart;
	JFreeChart lineChart;
	ChartPanel chartPanel;
	String chartTitle;

	public View_LineChart(ResultSet rs, String applicationTitle, String vchartTitle, String vtype)
			throws NumberFormatException, SQLException {

		chartTitle = vchartTitle;
		lineChart = ChartFactory.createLineChart(chartTitle, "", "", createDataset(rs, vtype), PlotOrientation.VERTICAL,
				true, true, false);

		chartPanel = new ChartPanel(lineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));

		//
		frame = new JFrame("Meretoo -Business Analytics");
		frame.setBounds(10, 10, 300, 300);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(chartPanel);
		frame.setVisible(true);

	}

	private DefaultCategoryDataset createDataset(ResultSet rs, String vtype)
			throws NumberFormatException, SQLException {

		dataset = new DefaultCategoryDataset();
		while (rs.next()) {
			switch (vtype) {
			case "Month":
				// new General().msg(rs.getString(3)+ " " +rs.getString(2));
				dataset.addValue(Double.parseDouble(rs.getString(10)), "Month", rs.getString(2));
				break;
			default:
				dataset.addValue(Double.parseDouble(rs.getString(11)), "Sales", rs.getString(2));
				break;
			}
		}
		return dataset;
	}

	public static void main(String[] args) {

	}

}// Last