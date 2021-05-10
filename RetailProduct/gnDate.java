package RetailProduct;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class gnDate extends getResultSet {

	public JFrame frame;
	private UtilDateModel model;
	public JDatePanelImpl datePanel;
	public JDatePickerImpl datePicker;
	public String vbeginstatus;
	private String vcomp;
	private String vstore;
	Date xbegindate;
	Date xlastDate;
	private String SQL;
	String status;

	public String getMonthName(String vdate) throws ClassNotFoundException, SQLException {
		String vtype = "Month";
		String vmonName = "";
		vdate = new gnConfig().date_ConverttoDBforamt(vdate);
		String SQL = "Call gnDateRelated('" + vtype + "', '" + vdate + "')";
		//new General().msg(SQL);
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			vmonName = rs.getString(1);
		}

		return vmonName;
	}

	public String getDayName(String vdate) throws ClassNotFoundException, SQLException {
		String vtype = "Day";
		String vdayName = "";
		vdate = new gnConfig().date_ConverttoDBforamt(vdate);
		String SQL = "Call gnDateRelated('" + vtype + "', '" + vdate + "')";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			vdayName = rs.getString(1);
		}
		return vdayName;

	}

	public String getYear(String vdate) throws ClassNotFoundException, SQLException {
		String vtype = "Year";
		String vyear = "";
		vdate = new gnConfig().date_ConverttoDBforamt(vdate);
		String SQL = "Call gnDateRelated('" + vtype + "', '" + vdate + "')";

		rs = this.getSPResult(SQL);
		while (rs.next()) {
			vyear = rs.getString(1);
		}
		return vyear;

	}

	public String getTrCount(String vtype, String vdate) throws Throwable {
		String allow = "N";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String vfinyear = new gnFinYear().getReportingFinYear();
		String SQL1 = "call   date_checkDateAllow( '" + vtype + "', " + vcomp + ", " + vstore + ", '" + vdate + "' , '"
				+ vfinyear + "')";
		// new General().msg(SQL1);
		rs1 = this.getSPResult(SQL1);
		if (rs1.next()) {
			int vcunt = Integer.parseInt(rs1.getString(1));
			if (vcunt == 0) {
				allow = "Y";
				new gnLogger().loggerInfoEntry("gnDate Check Date Related", "Date Allow");

			} else {
				allow = "N";
				new gnLogger().loggerInfoEntry("gnDate Check Date Related", "Date Not Allow");
			}
		}
		return allow;

	}

	public String checkBackDateTrAllow(String vtype, String vdate) throws Throwable {
		String allow = "N";
		String cvtype = "C" + vtype;
		String vdatem = vdate;
		vdate = new gnConfig().date_ConverttoDBforamt(vdate);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String vfinyear = new gnFinYear().getReportingFinYear();

		allow = getTrCount(cvtype, vdate);

		switch (allow) {
		case "Y":
			allow = "Y";
			new gnLogger().loggerInfoEntry("gnDate Check Date Related", "Back Date Allow");
			break;
		case "N":
			String SQL = "call   date_checkDateAllow( '" + vtype + "', " + vcomp + ", " + vstore + ", '" + vdate
					+ "', '" + vfinyear + "')";
			// new General().msg(SQL);
			rs = this.getSPResult(SQL);
			while (rs.next()) {
				// new General().msg(allow);
				allow = rs.getString(1);
			}
			break;
		}
		String vstatus = new gnFinYear().checkDateRanegforFinyear(vdatem, vdatem);

		if (vstatus != "Sucess") {
			allow = "N";
			new General().msg("Check Day Begin Date..." + "Open Date Is:" + "" + vdatem);
		}
		return allow;
	}

	public String getmefullDate(String vdate) throws SQLException, ClassNotFoundException {
		String getdate = "";
		String vyear = "";
		String vfinyearFDate = "";
		String vfinyearLDate = "";

		if (vdate.length() == 4) {

			String vday = vdate.substring(0, 2);
			String vmon = vdate.substring(2, 4);
			// SQL = "call date_getYear()" ;
			// rs = this.getSPResult(SQL);
			// if (rs.next())
			// {
			// vyear = rs.getString(1) ;
			// }

			try {
				vfinyearFDate = new gnFinYear().getFirstDateofFinYear().substring(6, 10);
				vfinyearLDate = new gnFinYear().getLastDateofFinYear().substring(6, 10);

			} catch (Throwable e) {
				e.printStackTrace();
			}

			if (Integer.parseInt(vmon) >= 1 && Integer.parseInt(vmon) <= 3) {
				// int vvyear = Integer.parseInt(vyear)+1 ;
				// vyear = Integer.toString(vvyear) ;
				vyear = vfinyearLDate;
			} else {
				vyear = vfinyearFDate;
			}

			getdate = vday + "." + vmon + "." + vyear;
		}

		return getdate;
	}

	public String getLastClosedDate() throws Throwable {
		String vcloseDate = "";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		SQL = "call day_getLastCloseDate(" + vcomp + ", " + vstore + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vcloseDate = rs.getString(1);
			new gnLogger().loggerInfoEntry("gnDate Check Date Related", "Getting Last Close date");
		} else {
			vcloseDate = "0";
		}

		return vcloseDate;
	}

	public String getBeginDateValidation(String vbegindate) throws Throwable {
		status = "Fail";
		String vcloseDate = "";
		try {
			vcloseDate = getLastClosedDate();
		} catch (Exception e1) {
			new General().msg(e1.getMessage());
		}
		try {
			if (vcloseDate == "0") {
				new General().msg("You Are Doing first time Day begin Wel come ...");
				status = "Sucess";
				return status;
			}

			if (vcloseDate != "0") {
				Date dt = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
				String date = sdf.format(dt);
				xbegindate = sdf.parse(vbegindate);
				xlastDate = sdf.parse(vcloseDate);
			}

			if (xbegindate.after(xlastDate)) {
				status = "Sucess";
				return status;
			}

			if (xbegindate.before(xlastDate)) {
				String vreopenAllow = this.DayReopenAllow();
				if (vreopenAllow == "Y") {
					status = "Sucess";
					new DayBegin().reopen = "Y";
					new gnLogger().loggerInfoEntry("gnDate Check Date Related", "Reopen Allow");
				} else {
					new General().msg("Day Reopen is Not allow");
					status = "Fail";
					new gnLogger().loggerInfoEntry("gnDate Check Date Related", "Day Reopen Not Allow");
				}
				return status;
			}

			if (xbegindate.equals(xlastDate)) {
				String vreopenAllow = this.DayReopenAllow();
				if (vreopenAllow == "Y") {
					status = "Sucess";
					new DayBegin().reopen = "Y";
				} else {
					new General().msg("Day Reopen is Not allow");
					status = "Fail";
				}
				return status;
			}
		} catch (Exception e) {
			new General().msg(e.getLocalizedMessage());
		}
		return status;

	}

	public String checkDayEndDoneOfDate(String vdate) throws Throwable {
		status = "N";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdate = new gnConfig().date_ConverttoDBforamt(vdate);
		return status;
	}

	public String CheckTransactionDateValid(String vtrtype, String vdate) {
		String status = "Sucess";
		switch (vtrtype) {
		case "SALE":
			break;
		case "GRN":
			break;
		case "PR":
			break;
		case "SR":
			break;
		case "PV":
			break;
		case "RV":
			break;
		}
		return status;

	}

	public String checkDayBegin() throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String vallow = new gnConfig().checkDaybegin(vcomp, vstore);
		switch (vallow) {
		case "N":
			new General().msg(" Day Begin not done ... Complete Day Begin Process First");
			new gnLogger().loggerInfoEntry("gnDate Check Date Related", "Day Begin Not Done Message");
			vbeginstatus = "Fail";
			break;
		case "Y":
			vbeginstatus = "Sucess";
			break;
		}
		return vallow;

	}

	class action implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			String value = e.getSource().toString();
			new General().msg(value);
			java.util.Date Date = model.getValue();
		}
	}

	public void getCalender() {
		String vdate;
		try {
			model = new UtilDateModel();
			model.setDate(2017, 4, 8);
			datePanel = new JDatePanelImpl(model);
			datePicker = new JDatePickerImpl(datePanel);
			datePicker.getJFormattedTextField().setBounds(0, 0, 250, 70);
			datePicker.getButtonFocusable();
			datePicker.add(new JButton("OK"));
			datePanel.setDoubleClickAction(true);

			frame = new JFrame();
			frame.setBounds(200, 250, 250, 70);
			frame.setResizable(false);
			// frame.add(datePanel) ;
			frame.add(datePicker);
			frame.getContentPane();
			frame.setVisible(true);
			frame.setAlwaysOnTop(true);
		} catch (Exception e) {

		} finally {
			// vdate = getSelectedDate() ;
		}

		// return vdate ;
	}

	public String getSelectedDate() {
		// Date selectedDate = new Date() ;//(Date)
		// datePicker.getModel().getValue();
		Date selectedDate = (Date) datePicker.getModel().getValue();
		SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
		String date = ft.format(selectedDate);
		frame.dispose();
		return date;
	}

	public String getfxDate() {
		String vdate = new General().getDate();

		DatePicker vpicker = new DatePicker();
		Scene scene = new Scene(vpicker);
		JFXPanel jpanel = new JFXPanel();
		jpanel.setScene(scene);
		frame.add(jpanel, 100, 100);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
		return vdate;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		gnDate get = new gnDate();
		// Date vdate = get.getCalender();
		try {
		} catch (Exception e) {

		}
		// new General().msg("Date Selected is:" +" "+vdate);
	}

}// last
