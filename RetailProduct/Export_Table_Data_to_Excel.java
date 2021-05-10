package RetailProduct;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import RetailProduct.store_configuration.codeLsnr;

public class Export_Table_Data_to_Excel extends getResultSet {
	private HSSFSheet fSheet;
	private TableModel model;
	private JTable table;

	JTextField filename = new JTextField();
	String vfilename = "";
	JFrame frame = new JFrame();

	private String getFilename() {
		frame = new JFrame();
		frame.setBounds(400, 400, 500, 80);
		frame.setTitle("Enter File Name");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setType(Type.UTILITY);
		frame.setUndecorated(false);
		filename = new JTextField();
		filename.setBackground(Color.BLACK);
		filename.setForeground(Color.WHITE);
		filename.setFont(new Font("Calibri", Font.BOLD, 15));
		// filename.setBounds(1, 1, 100, 50);
		frame.add(filename);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);

		ActionListener cb = new codeLsnr();
		filename.addActionListener(cb);
		filename.grabFocus();
		return vfilename;

	}

	public void exportTable(JTable mytable) {
		table = mytable;
		vfilename = getFilename();
		if (vfilename.length() > 0) {
			new General().msg("Data Exported to  Local Folder   '" + ApplicationDrivename + "' and File Name is   : "
					+ vfilename);
		}
	}

	private void exportDataNow(JTable table) {
		if (vfilename.length() > 0) {
			vfilename = ApplicationDrivename.concat(vfilename).concat(".xls");
			int vrowcount = table.getRowCount();
			if (vrowcount <= 0) {
				new General().msg("No Data Availbale For Export , Run Report First");
				return;
			} else {
				HSSFCell cell;
				try {
					HSSFWorkbook fWorkbook = new HSSFWorkbook();
					TableColumnModel tcm = table.getColumnModel();
					fSheet = fWorkbook.createSheet("new Sheet");
					HSSFFont sheetTitleFont = fWorkbook.createFont();

					// File file = new File("d:/myReport.xls");
					File file = new File(vfilename);

					HSSFCellStyle cellStyle = fWorkbook.createCellStyle();
					sheetTitleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
					model = table.getModel();
					HSSFRow fRow = fSheet.createRow(0);
					//
					for (int j = 0; j < tcm.getColumnCount(); j++) {

						// HSSFCell cell = fRow.createCell((short) j);
						cell = fRow.createCell(j);
						cell.setCellValue(tcm.getColumn(j).getHeaderValue().toString());
					}

					for (int i = 0; i < model.getRowCount(); i++) {
						fRow = fSheet.createRow((short) i + 1);
						for (int j = 0; j < model.getColumnCount(); j++) {
							cell = fRow.createCell((short) j);
							cell.setCellValue(model.getValueAt(i, j).toString());
							cell.setCellStyle(cellStyle);
						}
					}

					FileOutputStream fileOutputStream;
					fileOutputStream = new FileOutputStream(file);
					BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);
					fWorkbook.write(bos);
					bos.close();
					fileOutputStream.close();
					// new General().msg("Data Exported to Local Folder D:\\ and
					// File Name is <<MyReport.xls>>");
					new General().msg("Data Exported to  Local Folder  D:\\  and File Name is   : " + vfilename);

				} catch (Exception e) {
				}
			}
		}
	}

	class codeLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// new General().msg("REacd in Method...");
			vfilename = filename.getText();
			exportDataNow(table);
			frame.setVisible(false);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
