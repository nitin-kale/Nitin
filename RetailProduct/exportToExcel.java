package RetailProduct;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class exportToExcel extends getResultSet {
	HSSFWorkbook wb;
	XSSFWorkbook wb1;
	HSSFSheet sheet;
	XSSFSheet sheet1;
	DefaultTableModel model;
	String Path;

	private String varticle = "";
	private String vname = " ";
	private String vnamelngth = " ";
	private String vshname = " ";
	private String vshnamelngth = " ";
	private String vpksize = " ";
	private String vuom = " ";
	private String vcost = "0.00";
	private String vsp = "0.00";
	private String vmrp = "0.00";

	private String vloc = " ";
	private String vopstock = "0";
	private String vbatch = "N";

	private String vqty = "0.00";
	private String vcostvalue = "0.00";
	private String vtran = "0.00";
	private String vmanuf = "0.00";
	private String vpacking = "0.00";
	private String voth = "0.00";
	private String vlandingcost = "0.00";
	private String vtaxper = "0.00";
	private String vbalqty = "0";
	private String vtax = "0";

	// Configuration Fields
	private String vmodule = "";
	private String vno = "";
	private String vparameter = "";
	private String vvalue = "";
	private String vdfvalue = "";
	private String vshow = "";
	private String vdesc = "";

	public DefaultTableModel uploadconfigData(String vfile, DefaultTableModel model)
			throws SQLException, FileNotFoundException {
		FileInputStream strm = new FileInputStream(vfile);
		try {
			wb = new HSSFWorkbook(strm);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheetAt(0);
		int row = sheet.getPhysicalNumberOfRows();
		for (int k = 0; k < row; k++) {
			HSSFRow rw = sheet.getRow(k);
			for (int col = 0; col < rw.getPhysicalNumberOfCells(); col++) {
				System.out.println("Value is:" + "" + col);
				HSSFCell vcell = sheet.getRow(k).getCell(col);
				System.out.println("TRype:" + "" + vcell.getCellType());

				switch (vcell.getCellType()) {
				case HSSFCell.CELL_TYPE_STRING:
					switch (col) {
					case 0:
						vmodule = sheet.getRow(k).getCell(col).getStringCellValue().trim();
						break;
					case 1:
						vno = sheet.getRow(k).getCell(col).getStringCellValue();
						System.out.println("Value is:" + "" + vno);
						break;
					case 2:
						vparameter = sheet.getRow(k).getCell(col).getStringCellValue().trim();
						break;
					case 3:
						vdfvalue = sheet.getRow(k).getCell(col).getStringCellValue().trim();
						break;
					case 4:
						vvalue = sheet.getRow(k).getCell(col).getStringCellValue().trim();
						break;
					case 5:
						vshow = sheet.getRow(k).getCell(col).getStringCellValue().trim();
						break;
					case 6:
						vdesc = sheet.getRow(k).getCell(col).getStringCellValue().trim();
						break;
					default:
						break;
					}
				}
			}
			model.insertRow(0, new Object[] { vmodule, vno, vparameter, vdfvalue, vvalue, vshow, vdesc });
		}
		return model;
	}

	public DefaultTableModel ReadExcelData(String vfile, DefaultTableModel model)
			throws SQLException, FileNotFoundException {
		FileInputStream strm = new FileInputStream(vfile);
		try {
			wb = new HSSFWorkbook(strm);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheetAt(0);
		// new General().msgSheet(sheet) ;
		int row = sheet.getPhysicalNumberOfRows();
		for (int k = 0; k < row; k++) {
			HSSFRow rw = sheet.getRow(k);
			for (int col = 0; col < rw.getPhysicalNumberOfCells(); col++) {
				HSSFCell vcell = sheet.getRow(k).getCell(col);
				switch (vcell.getCellType()) {
				case HSSFCell.CELL_TYPE_STRING:
					switch (col) {
					case 0:
						varticle = sheet.getRow(k).getCell(col).getStringCellValue().trim();
						// case 0 : varticle =
						// Double.toString(sheet.getRow(k).getCell(col).getNumericCellValue()).trim();
						break;
					case 1:
						vname = sheet.getRow(k).getCell(col).getStringCellValue().trim();
						break;
					case 2:
						vloc = sheet.getRow(k).getCell(col).getStringCellValue().trim();
						break;
					case 3:
						vbatch = sheet.getRow(k).getCell(col).getStringCellValue().trim();
						break;
					case 4:
						vopstock = sheet.getRow(k).getCell(col).getStringCellValue().trim();
						break;
					default:
						break;
					}
				}
			}
			model.insertRow(0, new Object[] { varticle, vname, vloc, vbatch, vopstock });
		}
		return model;
	}

	public DefaultTableModel ReadOpstockfromExcel(String vfile, DefaultTableModel model)
			throws SQLException, FileNotFoundException {
		FileInputStream strm = new FileInputStream(vfile);
		try {
			wb = new HSSFWorkbook(strm);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheetAt(0);
		// new General().msgSheet(sheet) ;
		int row = sheet.getPhysicalNumberOfRows();
		for (int k = 0; k < row; k++) {
			HSSFRow rw = sheet.getRow(k);
			for (int col = 0; col < rw.getPhysicalNumberOfCells(); col++) {
				HSSFCell vcell = sheet.getRow(k).getCell(col);
				switch (vcell.getCellType()) {
				case HSSFCell.CELL_TYPE_STRING:
					switch (col) {
					case 0:
						varticle = sheet.getRow(k).getCell(col).getStringCellValue();
						break;
					case 1:
						vname = sheet.getRow(k).getCell(col).getStringCellValue();
						break;
					case 2:
						vqty = sheet.getRow(k).getCell(col).getStringCellValue();
						break;
					case 3:
						vuom = sheet.getRow(k).getCell(col).getStringCellValue();
						break;
					case 4:
						vcost = sheet.getRow(k).getCell(col).getStringCellValue();
						break;
					case 5:
						vcostvalue = sheet.getRow(k).getCell(col).getStringCellValue();
						break;
					case 6:
						vsp = sheet.getRow(k).getCell(col).getStringCellValue();
						break;
					case 7:
						vmrp = sheet.getRow(k).getCell(col).getStringCellValue();
						break;
					case 8:
						vbalqty = sheet.getRow(k).getCell(col).getStringCellValue();
						break;
					case 9:
						vtax = sheet.getRow(k).getCell(col).getStringCellValue();
						break;
					case 10:
						vbatch = sheet.getRow(k).getCell(col).getStringCellValue();
						break;
					default:
						break;
					}
				}
			}
			model.insertRow(0,
					new Object[] { varticle, vname, vqty, vuom, vcost, vcostvalue, vsp, vmrp, vbalqty, vtax, vbatch });
		}
		return model;
	}

	public DefaultTableModel uploadOpeningStock(String vfile, DefaultTableModel model)
			throws SQLException, FileNotFoundException {
		FileInputStream strm = new FileInputStream(vfile);
		try {
			wb = new HSSFWorkbook(strm);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheetAt(0);
		// new General().msgSheet(sheet) ;
		int row = sheet.getPhysicalNumberOfRows();
		for (int k = 0; k < row; k++) {
			HSSFRow rw = sheet.getRow(k);
			for (int col = 0; col < rw.getPhysicalNumberOfCells(); col++) {
				HSSFCell vcell = sheet.getRow(k).getCell(col);
				switch (vcell.getCellType()) {
				case HSSFCell.CELL_TYPE_STRING:
					switch (col) {
					case 0:
						varticle = sheet.getRow(k).getCell(col).getStringCellValue();
						break;
					case 1:
						vname = sheet.getRow(k).getCell(col).getStringCellValue();
						break;
					case 2:
						vqty = sheet.getRow(k).getCell(col).getStringCellValue();
						break;
					case 3:
						vcost = sheet.getRow(k).getCell(col).getStringCellValue();
						break;
					case 4:
						vmrp = sheet.getRow(k).getCell(col).getStringCellValue();
						break;
					case 5:
						vsp = sheet.getRow(k).getCell(col).getStringCellValue();
						break;
					case 6:
						vbatch = sheet.getRow(k).getCell(col).getStringCellValue();
						break;
					default:
						break;
					}
				}
			}
			model.insertRow(0, new Object[] { varticle, vname, vqty, vcost, vmrp, vsp, vbatch });
		}
		return model;
	}

	public DefaultTableModel ArticleMasterExcelData(String vfile, DefaultTableModel model)
			throws SQLException, FileNotFoundException {
		new General().msg(vfile);
		FileInputStream strm = new FileInputStream(vfile);
		try {
			wb = new HSSFWorkbook(strm);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheetAt(0);
		int row = sheet.getPhysicalNumberOfRows();
		for (int k = 0; k < row; k++) {
			HSSFRow rw = sheet.getRow(k);
			for (int col = 0; col < rw.getPhysicalNumberOfCells(); col++) {
				HSSFCell vcell = sheet.getRow(k).getCell(col);
				switch (vcell.getCellType()) {
				case HSSFCell.CELL_TYPE_STRING:
					switch (col) {

					case 0:
						varticle = sheet.getRow(k).getCell(col).getStringCellValue().trim();
						break;
					case 1:
						vname = sheet.getRow(k).getCell(col).getStringCellValue().trim();
						break;
					case 2:
						vnamelngth = "0";

						break;
					case 3:
						vshname = sheet.getRow(k).getCell(col).getStringCellValue().trim();
						break;

					case 4:
						vshnamelngth = "0";

						break;
					case 5:
						vpksize = sheet.getRow(k).getCell(col).getStringCellValue().trim();
						break;
					case 6:
						vuom = sheet.getRow(k).getCell(col).getStringCellValue().trim();
						break;
					case 7:
						vmrp = sheet.getRow(k).getCell(col).getStringCellValue().trim();
						break;
					case 8:
						vsp = sheet.getRow(k).getCell(col).getStringCellValue().trim();
						break;
					case 9:
						vcost = sheet.getRow(k).getCell(col).getStringCellValue().trim();
						break;

					case 10:
						vtax = sheet.getRow(k).getCell(col).getStringCellValue().trim();
						break;

					case 11:
						vbatch = sheet.getRow(k).getCell(col).getStringCellValue().trim();
						break;

					default:
						break;
					}
				}
			}
			model.insertRow(0, new Object[] { varticle, vname, vnamelngth, vshname, vshnamelngth, vpksize, vuom, vmrp,
					vsp, vcost, vtax, vbatch });

		}
		return model;
	}

}
