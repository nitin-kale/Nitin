package RetailProduct;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class gnLineChart extends Application {

	String vChartTitle = "";
	String vseriesName = "";

	ResultSet rs;
	JTable table;
	int xcol;
	int ycol;

	String vcomp = "9999"; // new gnConfig().getCompanyCode() ;
	String vstore = "9999";// new gnConfig().getStoreID() ;
	String vfinyear = "17-18"; // new gnFinYear().getReportingFinYear() ;
	String vvtype = "Month";
	static Stage classStage = new Stage();

	XYChart.Series series = new XYChart.Series();
	final CategoryAxis xAxis = new CategoryAxis();
	final NumberAxis yAxis = new NumberAxis();

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) throws SQLException, ClassNotFoundException {
		table = new gnPublicVariable().table;
		Stage classStage = stage;
		xcol = new gnPublicVariable().xcol;
		ycol = new gnPublicVariable().ycol;
		series.setName("Sales Report");
		stage.setTitle("Line Chart Sample");
		xAxis.setLabel(" Month");
		yAxis.setLabel("Sales");

		final LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
		lineChart.setTitle("My Chart Data");

		String SQL3 = "Call   view_SalesData( '" + vvtype + "', " + vcomp + "," + vstore + ", '" + vfinyear + "' ,'"
				+ vfinyear + "')";
		new General().msg(SQL3);
		rs = new getBaseConnection().getSPResult(SQL3);
		while (rs.next()) {
			new General().msg(rs.getString(2) + "==> " + rs.getString(3));
			series.getData().add(new XYChart.Data(rs.getString(2), Integer.parseInt(rs.getString(3))));
		}

		lineChart.getData().add(series);
		Scene scene = new Scene(lineChart, 800, 600);
		stage.setScene(scene);
		stage.show();
		stage.setAlwaysOnTop(true);

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		launch(args);
	}

}
