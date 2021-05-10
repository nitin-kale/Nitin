package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class FXlinechart {

	private JFrame frame;
	Axis<String> xAxis;
	NumberAxis yAxis = null;
	LineChart<String, Number> lineChart;
	JFXPanel fx;
	int col1;
	int col2;

	/**
	 * Launch the application.
	 * 
	 * @throws SQLException
	 */

	public JFXPanel getChart(JTable table, int x, int y) throws SQLException {
		col1 = x;
		col2 = y;
		fx = new JFXPanel();
		// lineChart.getData().clear();
		fx.setBounds(100, 100, 450, 300);
		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();

		int row = table.getRowCount();
		for (int i = 0; i < row; row++) {
			series.getData().add(new XYChart.Data<String, Number>(table.getValueAt(i, col1).toString(),
					Integer.parseInt(table.getValueAt(i, col2).toString())));
		}
		xAxis = new CategoryAxis();
		yAxis = new NumberAxis();
		xAxis.setLabel("Number of Month");
		yAxis.setLabel("Amount");
		lineChart = new LineChart<String, Number>(xAxis, yAxis);
		lineChart.setTitle("My Chart");
		lineChart.getData().add(series);
		series.setName("Pay Scale");
		Scene scene = new Scene(lineChart, 800, 600);
		scene.setUserData(lineChart);
		fx.setScene(scene);
		fx.setRequestFocusEnabled(true);
		lineChart.setMouseTransparent(true);
		fx.setBackground(Color.cyan);
		fx.setAutoscrolls(true);
		fx.setBackground(Color.WHITE);
		// frame.add(fx);
		return fx;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FXlinechart window = new FXlinechart();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FXlinechart() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JFXPanel fx = new JFXPanel();
		// lineChart.getData().clear();
		fx.setBounds(100, 100, 450, 300);
		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
		series.getData().add(new XYChart.Data<String, Number>("Apr", 2000));
		series.getData().add(new XYChart.Data<String, Number>("May", 12000));
		series.getData().add(new XYChart.Data<String, Number>("June", 5000));
		series.getData().add(new XYChart.Data<String, Number>("Jul", 200));
		series.getData().add(new XYChart.Data<String, Number>("Aug", 2000));
		xAxis = new CategoryAxis();
		yAxis = new NumberAxis();
		xAxis.setLabel("Number of Month");
		yAxis.setLabel("Amount");

		// creating the chart
		lineChart = new LineChart<String, Number>(xAxis, yAxis);
		lineChart.setTitle("My Chart");
		lineChart.getData().add(series);
		series.setName("Pay Scale");
		Scene scene = new Scene(lineChart, 800, 600);
		scene.setUserData(lineChart);
		fx.setScene(scene);
		fx.setRequestFocusEnabled(true);
		lineChart.setMouseTransparent(true);
		fx.setBackground(Color.cyan);
		fx.setAutoscrolls(true);
		fx.setBackground(Color.WHITE);
		frame.add(fx);
	}

}
