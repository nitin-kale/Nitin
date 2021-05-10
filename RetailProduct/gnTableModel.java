package RetailProduct;

import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class gnTableModel extends getResultSet {

	public JTable table;
	public DefaultTableModel model;

	private Object Boolean(boolean b) {
		return null;
	}

	public JTable Tablemodel(JTable table, DefaultTableModel model, String SQL, String[] ColHeader, int col,
			String requiredcheckbox, String vtyperequired, String vtype) throws ClassNotFoundException, SQLException {
		table.setEnabled(true);
		table.setRowHeight(25);
		new gnTable().setTableBasics(table);

		switch (col) {
		case 1:
			Tablemodel1(table, model, SQL, ColHeader, col, requiredcheckbox, vtyperequired, vtype);
			break;
		case 2:
			Tablemodel2(table, model, SQL, ColHeader, col, requiredcheckbox, vtyperequired, vtype);
			break;
		case 3:
			Tablemodel3(table, model, SQL, ColHeader, col, requiredcheckbox, vtyperequired, vtype);
			break;
		case 4:
			Tablemodel4(table, model, SQL, ColHeader, col, requiredcheckbox, vtyperequired, vtype);
			break;
		case 5:
			Tablemodel5(table, model, SQL, ColHeader, col, requiredcheckbox, vtyperequired, vtype);
			break;
		case 6:
			Tablemodel6(table, model, SQL, ColHeader, col, requiredcheckbox, vtyperequired, vtype);
			break;
		case 7:
			Tablemodel7(table, model, SQL, ColHeader, col, requiredcheckbox, vtyperequired, vtype);
			break;
		case 8:
			Tablemodel8(table, model, SQL, ColHeader, col, requiredcheckbox, vtyperequired, vtype);
			break;
		case 9:
			Tablemodel9(table, model, SQL, ColHeader, col, requiredcheckbox, vtyperequired, vtype);
			break;
		case 10:
			Tablemodel10(table, model, SQL, ColHeader, col, requiredcheckbox, vtyperequired, vtype);
			break;
		case 11:
			Tablemodel11(table, model, SQL, ColHeader, col, requiredcheckbox, vtyperequired, vtype);
			break;
		case 12:
			Tablemodel12(table, model, SQL, ColHeader, col, requiredcheckbox, vtyperequired, vtype);
			break;

		case 13:
			Tablemodel13(table, model, SQL, ColHeader, col, requiredcheckbox, vtyperequired, vtype);
			break;

		case 14:
			Tablemodel14(table, model, SQL, ColHeader, col, requiredcheckbox, vtyperequired, vtype);
			break;

		case 15:
			Tablemodel15(table, model, SQL, ColHeader, col, requiredcheckbox, vtyperequired, vtype);
			break;

		case 16:
			Tablemodel15(table, model, SQL, ColHeader, col, requiredcheckbox, vtyperequired, vtype);
			break;

		case 17:
			Tablemodel17(table, model, SQL, ColHeader, col, requiredcheckbox, vtyperequired, vtype);
			break;

		case 18:
			Tablemodel18(table, model, SQL, ColHeader, col, requiredcheckbox, vtyperequired, vtype);
			break;

		case 19:
			Tablemodel19(table, model, SQL, ColHeader, col, requiredcheckbox, vtyperequired, vtype);
			break;

		case 20:
			Tablemodel20(table, model, SQL, ColHeader, col, requiredcheckbox, vtyperequired, vtype);
			break;

		case 21:
			Tablemodel21(table, model, SQL, ColHeader, col, requiredcheckbox, vtyperequired, vtype);
			break;

		case 22:
			Tablemodel22(table, model, SQL, ColHeader, col, requiredcheckbox, vtyperequired, vtype);
			break;

		case 23:
			Tablemodel23(table, model, SQL, ColHeader, col, requiredcheckbox, vtyperequired, vtype);
			break;

		case 24:
			Tablemodel21(table, model, SQL, ColHeader, col, requiredcheckbox, vtyperequired, vtype);
			break;

		case 25:
			Tablemodel21(table, model, SQL, ColHeader, col, requiredcheckbox, vtyperequired, vtype);
			break;

		}
		this.closeconn();
		return table;
	}

	public JTable Tablemodel1(JTable table, DefaultTableModel model, String SQL, String[] ColHeader, int col,
			String requiredcheckbox, String vtyperequired, String vtype) throws ClassNotFoundException, SQLException {

		// new General().msg(SQL);
		model.setColumnIdentifiers(ColHeader);
		rs = this.getSPResult(SQL);
		switch (requiredcheckbox) {
		case "Y":
			while (rs.next()) {
				model.addRow(new Object[] { Boolean(false), rs.getString(1) });
				table.setModel(model);
			}
			rs.close();
			break;
		case "N":
			switch (vtyperequired) {
			case "N":
				while (rs.next()) {
					model.addRow(new Object[] { rs.getString(1) });
					table.setModel(model);
				}
				rs.close();
				break;

			case "Y":
				while (rs.next()) {
					model.addRow(new Object[] { vtype, rs.getString(1) });
					table.setModel(model);
				}
				rs.close();
				break;
			}
		}
		return table;
	}

	public JTable Tablemodel2(JTable table, DefaultTableModel model, String SQL, String[] ColHeader, int col,
			String requiredcheckbox, String vtyperequired, String vtype) throws ClassNotFoundException, SQLException {
		model.setColumnIdentifiers(ColHeader);
		rs = this.getSPResult(SQL);
		switch (requiredcheckbox) {
		case "Y":
			while (rs.next()) {
				model.addRow(new Object[] { Boolean(false), rs.getString(1), rs.getString(2) });
				// new General().msgmodel(model);
				table.setModel(model);
			}
			break;
		case "N":
			switch (vtyperequired) {
			case "N":
				while (rs.next()) {
					model.addRow(new Object[] { rs.getString(1), rs.getString(2) });
					table.setModel(model);
				}
				rs.close();
				break;

			case "Y":
				while (rs.next()) {
					model.addRow(new Object[] { vtype, rs.getString(1), rs.getString(2) });
					// new General().msgmodel(model);
					table.setModel(model);
				}
				rs.close();
				break;
			}
		}
		return table;
	}

	public JTable Tablemodel3(JTable table, DefaultTableModel model, String SQL, String[] ColHeader, int col,
			String requiredcheckbox, String vtyperequired, String vtype) throws ClassNotFoundException, SQLException {
		model.setColumnIdentifiers(ColHeader);
		rs = this.getSPResult(SQL);
		switch (requiredcheckbox) {
		case "Y":
			while (rs.next()) {
				model.addRow(new Object[] { Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3) });
				table.setModel(model);
			}
			rs.close();
			break;
		case "N":
			switch (vtyperequired) {
			case "N":
				while (rs.next()) {
					model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3) });
					table.setModel(model);
				}
				rs.close();
				break;

			case "Y":
				while (rs.next()) {
					model.addRow(new Object[] { vtype, rs.getString(1), rs.getString(2), rs.getString(3) });
					table.setModel(model);
				}
				rs.close();
				break;
			}
		}
		conn.close();
		return table;
	}

	public JTable Tablemodel4(JTable table, DefaultTableModel model, String SQL, String[] ColHeader, int col,
			String requiredcheckbox, String vtyperequired, String vtype) throws ClassNotFoundException, SQLException {
		model.setColumnIdentifiers(ColHeader);
		rs = this.getSPResult(SQL);
		switch (requiredcheckbox) {
		case "Y":
			while (rs.next()) {
				model.addRow(new Object[] { Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4) });
				table.setModel(model);
			}
			rs.close();
			break;
		case "N":
			switch (vtyperequired) {
			case "N":
				while (rs.next()) {
					model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4) });
					table.setModel(model);
				}
				rs.close();
				break;

			case "Y":
				while (rs.next()) {
					model.addRow(
							new Object[] { vtype, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4) });
					table.setModel(model);
				}
				rs.close();
				break;
			}
		}
		conn.close();
		return table;
	}

	public JTable Tablemodel5(JTable table, DefaultTableModel model, String SQL, String[] ColHeader, int col,
			String requiredcheckbox, String vtyperequired, String vtype) throws ClassNotFoundException, SQLException {
		model.setColumnIdentifiers(ColHeader);
		rs = this.getSPResult(SQL);
		switch (requiredcheckbox) {
		case "Y":
			while (rs.next()) {
				model.addRow(new Object[] { Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5) });
				table.setModel(model);
			}
			break;
		case "N":
			switch (vtyperequired) {
			case "N":
				while (rs.next()) {
					model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5) });
					table.setModel(model);
				}
				break;

			case "Y":
				while (rs.next()) {
					model.addRow(new Object[] { vtype, rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5) });
					table.setModel(model);
				}
				break;
			}
		}
		conn.close();
		return table;
	}

	public JTable Tablemodel6(JTable table, DefaultTableModel model, String SQL, String[] ColHeader, int col,
			String requiredcheckbox, String vtyperequired, String vtype) throws ClassNotFoundException, SQLException {
		model.setColumnIdentifiers(ColHeader);
		rs = this.getSPResult(SQL);
		switch (requiredcheckbox) {
		case "Y":
			while (rs.next()) {
				model.addRow(new Object[] { Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6) });
				table.setModel(model);
			}
			break;
		case "N":
			switch (vtyperequired) {
			case "N":
				while (rs.next()) {
					model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6) });
					table.setModel(model);
				}
				break;

			case "Y":
				while (rs.next()) {
					model.addRow(new Object[] { vtype, rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getString(6) });
					table.setModel(model);
				}
				break;
			}
		}
		conn.close();
		return table;
	}

	public JTable Tablemodel7(JTable table, DefaultTableModel model, String SQL, String[] ColHeader, int col,
			String requiredcheckbox, String vtyperequired, String vtype) throws ClassNotFoundException, SQLException {
		model.setColumnIdentifiers(ColHeader);
		rs = this.getSPResult(SQL);
		switch (requiredcheckbox) {
		case "Y":
			while (rs.next()) {
				model.addRow(new Object[] { Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7) });
				table.setModel(model);
			}
			break;
		case "N":
			switch (vtyperequired) {
			case "N":
				while (rs.next()) {
					model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7) });
					table.setModel(model);
				}
				break;

			case "Y":
				while (rs.next()) {
					model.addRow(new Object[] { vtype, rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7) });
					table.setModel(model);
				}
				break;
			}
		}
		return table;
	}

	public JTable Tablemodel8(JTable table, DefaultTableModel model, String SQL, String[] ColHeader, int col,
			String requiredcheckbox, String vtyperequired, String vtype) throws ClassNotFoundException, SQLException {
		model.setColumnIdentifiers(ColHeader);
		rs = this.getSPResult(SQL);
		switch (requiredcheckbox) {
		case "Y":
			while (rs.next()) {
				model.addRow(new Object[] { Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
				table.setModel(model);
			}
			break;
		case "N":
			switch (vtyperequired) {
			case "N":
				while (rs.next()) {
					model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
					table.setModel(model);
				}
				break;

			case "Y":
				while (rs.next()) {
					model.addRow(new Object[] { vtype, rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
					table.setModel(model);
				}
				break;
			}
		}
		return table;
	}

	public JTable Tablemodel9(JTable table, DefaultTableModel model, String SQL, String[] ColHeader, int col,
			String requiredcheckbox, String vtyperequired, String vtype) throws ClassNotFoundException, SQLException {
		model.setColumnIdentifiers(ColHeader);
		rs = this.getSPResult(SQL);
		switch (requiredcheckbox) {
		case "Y":
			while (rs.next()) {
				model.addRow(new Object[] { Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9) });
				table.setModel(model);
			}
			break;
		case "N":
			switch (vtyperequired) {
			case "N":
				while (rs.next()) {
					model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9) });
					table.setModel(model);
				}
				break;

			case "Y":
				while (rs.next()) {
					model.addRow(new Object[] { vtype, rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
							rs.getString(9) });
					table.setModel(model);
				}
				break;
			}
		}
		conn.close();
		return table;
	}

	public JTable Tablemodel10(JTable table, DefaultTableModel model, String SQL, String[] ColHeader, int col,
			String requiredcheckbox, String vtyperequired, String vtype) throws ClassNotFoundException, SQLException {
		model.setColumnIdentifiers(ColHeader);
		rs = this.getSPResult(SQL);
		switch (requiredcheckbox) {
		case "Y":
			while (rs.next()) {
				model.addRow(new Object[] { Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10) });
				table.setModel(model);
			}
			break;
		case "N":
			switch (vtyperequired) {
			case "N":
				while (rs.next()) {
					model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10) });
					table.setModel(model);
				}
				break;

			case "Y":
				while (rs.next()) {
					model.addRow(new Object[] { vtype, rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getString(10) });
					table.setModel(model);
				}
				break;
			}
		}
		conn.close();
		return table;
	}

	public JTable Tablemodel11(JTable table, DefaultTableModel model, String SQL, String[] ColHeader, int col,
			String requiredcheckbox, String vtyperequired, String vtype) throws ClassNotFoundException, SQLException {
		model.setColumnIdentifiers(ColHeader);
		rs = this.getSPResult(SQL);
		switch (requiredcheckbox) {
		case "Y":
			while (rs.next()) {
				model.addRow(new Object[] { Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11) });
				table.setModel(model);
			}
			break;
		case "N":
			switch (vtyperequired) {
			case "N":
				while (rs.next()) {
					model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11) });
					table.setModel(model);
				}
				break;

			case "Y":
				while (rs.next()) {
					model.addRow(new Object[] { vtype, rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getString(10), rs.getString(11) });
					table.setModel(model);
				}
				break;
			}
		}
		conn.close();
		return table;
	}

	public JTable Tablemodel12(JTable table, DefaultTableModel model, String SQL, String[] ColHeader, int col,
			String requiredcheckbox, String vtyperequired, String vtype) throws ClassNotFoundException, SQLException {
		model.setColumnIdentifiers(ColHeader);
		rs = this.getSPResult(SQL);
		switch (requiredcheckbox) {
		case "Y":
			while (rs.next()) {
				model.addRow(new Object[] { Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12) });
				table.setModel(model);
			}
			break;
		case "N":
			switch (vtyperequired) {
			case "N":
				while (rs.next()) {
					model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getString(12) });
					table.setModel(model);
				}
				break;

			case "Y":
				while (rs.next()) {
					model.addRow(new Object[] { vtype, rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12) });
					table.setModel(model);
				}
				break;
			}
		}
		conn.close();
		return table;
	}

	public JTable Tablemodel13(JTable table, DefaultTableModel model, String SQL, String[] ColHeader, int col,
			String requiredcheckbox, String vtyperequired, String vtype) throws ClassNotFoundException, SQLException {
		// new General().msg("WEL Come Model 13"+""+requiredcheckbox + "
		// "+vtyperequired + " "+vtype) ;
		model.setColumnIdentifiers(ColHeader);
		rs = this.getSPResult(SQL);
		switch (requiredcheckbox) {
		case "Y":
			while (rs.next()) {
				model.addRow(new Object[] { Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13) });
				table.setModel(model);
			}
			break;
		case "N":
			switch (vtyperequired) {
			case "N":
				while (rs.next()) {
					// new General().msg(rs.getString(1) + " o-->>
					// "+rs.getString(2) + "0-->> "+rs.getString(3) );
					// new General().msg("WEL Come Model 13"+""+requiredcheckbox
					// + " "+vtyperequired + " "+vtype) ;
					model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13) });
					table.setModel(model);
				}
				break;

			case "Y":
				while (rs.next()) {
					model.addRow(new Object[] { vtype, rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13) });
					table.setModel(model);
				}
				break;
			}
			break;
		}
		conn.close();
		return table;
	}

	public JTable Tablemodel14(JTable table, DefaultTableModel model, String SQL, String[] ColHeader, int col,
			String requiredcheckbox, String vtyperequired, String vtype) throws ClassNotFoundException, SQLException {
		model.setColumnIdentifiers(ColHeader);
		rs = this.getSPResult(SQL);
		switch (requiredcheckbox) {
		case "Y":
			while (rs.next()) {
				model.addRow(new Object[] { Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
						rs.getString(14) });
				table.setModel(model);
			}
			break;
		case "N":
			switch (vtyperequired) {
			case "N":
				while (rs.next()) {
					model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14) });
					table.setModel(model);
				}
				break;

			case "Y":
				while (rs.next()) {
					model.addRow(new Object[] { vtype, rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
							rs.getString(14) });
					table.setModel(model);
				}
				break;
			}
		}
		conn.close();
		return table;
	}

	public JTable Tablemodel15(JTable table, DefaultTableModel model, String SQL, String[] ColHeader, int col,
			String requiredcheckbox, String vtyperequired, String vtype) throws ClassNotFoundException, SQLException {
		model.setColumnIdentifiers(ColHeader);
		rs = this.getSPResult(SQL);
		switch (requiredcheckbox) {
		case "Y":
			while (rs.next()) {
				model.addRow(new Object[] { Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
						rs.getString(14), rs.getString(15) });
				table.setModel(model);
			}
			break;
		case "N":
			switch (vtyperequired) {
			case "N":
				while (rs.next()) {
					model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
							rs.getString(15) });
					table.setModel(model);
				}
				break;

			case "Y":
				while (rs.next()) {
					model.addRow(new Object[] { vtype, rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
							rs.getString(14), rs.getString(15) });
					table.setModel(model);
				}
				break;
			}
		}
		conn.close();
		return table;
	}

	public JTable Tablemodel16(JTable table, DefaultTableModel model, String SQL, String[] ColHeader, int col,
			String requiredcheckbox, String vtyperequired, String vtype) throws ClassNotFoundException, SQLException {
		model.setColumnIdentifiers(ColHeader);
		rs = this.getSPResult(SQL);
		switch (requiredcheckbox) {
		case "Y":
			while (rs.next()) {
				model.addRow(new Object[] { Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
						rs.getString(14), rs.getString(15), rs.getString(16) });
				table.setModel(model);
			}
			break;
		case "N":
			switch (vtyperequired) {
			case "N":
				while (rs.next()) {
					model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
							rs.getString(15), rs.getString(16) });
					table.setModel(model);
				}
				break;

			case "Y":
				while (rs.next()) {
					model.addRow(new Object[] { vtype, rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
							rs.getString(14), rs.getString(15), rs.getString(16) });
					table.setModel(model);
				}
				break;
			}
		}
		conn.close();
		return table;
	}

	public JTable Tablemodel17(JTable table, DefaultTableModel model, String SQL, String[] ColHeader, int col,
			String requiredcheckbox, String vtyperequired, String vtype) throws ClassNotFoundException, SQLException {
		model.setColumnIdentifiers(ColHeader);
		rs = this.getSPResult(SQL);
		switch (requiredcheckbox) {
		case "Y":
			while (rs.next()) {
				model.addRow(new Object[] { Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
						rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17) });
				table.setModel(model);
			}
			break;
		case "N":
			switch (vtyperequired) {
			case "N":
				while (rs.next()) {
					model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
							rs.getString(15), rs.getString(16), rs.getString(17) });
					table.setModel(model);
				}
				break;

			case "Y":
				while (rs.next()) {
					model.addRow(new Object[] { vtype, rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
							rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17) });
					table.setModel(model);
				}
				break;
			}
		}
		conn.close();
		return table;
	}

	public JTable Tablemodel18(JTable table, DefaultTableModel model, String SQL, String[] ColHeader, int col,
			String requiredcheckbox, String vtyperequired, String vtype) throws ClassNotFoundException, SQLException {
		model.setColumnIdentifiers(ColHeader);
		rs = this.getSPResult(SQL);
		switch (requiredcheckbox) {
		case "Y":
			while (rs.next()) {
				model.addRow(new Object[] { Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
						rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18) });
				table.setModel(model);
			}
			break;
		case "N":
			switch (vtyperequired) {
			case "N":
				while (rs.next()) {
					model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
							rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18) });
					table.setModel(model);
				}
				break;

			case "Y":
				while (rs.next()) {
					model.addRow(new Object[] { vtype, rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
							rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18) });
					table.setModel(model);
				}
				break;
			}
		}
		conn.close();
		return table;
	}

	public JTable Tablemodel19(JTable table, DefaultTableModel model, String SQL, String[] ColHeader, int col,
			String requiredcheckbox, String vtyperequired, String vtype) throws ClassNotFoundException, SQLException {
		model.setColumnIdentifiers(ColHeader);
		rs = this.getSPResult(SQL);
		switch (requiredcheckbox) {
		case "Y":
			while (rs.next()) {
				model.addRow(new Object[] { Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
						rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18),
						rs.getString(19) });
				table.setModel(model);
			}
			break;
		case "N":
			switch (vtyperequired) {
			case "N":
				while (rs.next()) {
					model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
							rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19) });
					table.setModel(model);
				}
				break;

			case "Y":
				while (rs.next()) {
					model.addRow(new Object[] { vtype, rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
							rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18),
							rs.getString(19) });
					table.setModel(model);
				}
				break;
			}
		}
		conn.close();
		return table;
	}

	public JTable Tablemodel20(JTable table, DefaultTableModel model, String SQL, String[] ColHeader, int col,
			String requiredcheckbox, String vtyperequired, String vtype) throws ClassNotFoundException, SQLException {
		model.setColumnIdentifiers(ColHeader);
		rs = this.getSPResult(SQL);
		switch (requiredcheckbox) {
		case "Y":
			while (rs.next()) {
				model.addRow(new Object[] { Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
						rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18),
						rs.getString(19), rs.getString(20) });
				table.setModel(model);
			}
			break;
		case "N":
			switch (vtyperequired) {
			case "N":
				while (rs.next()) {
					model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
							rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19),
							rs.getString(20) });
					table.setModel(model);
				}
				break;

			case "Y":
				while (rs.next()) {
					model.addRow(new Object[] { vtype, rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
							rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18),
							rs.getString(19), rs.getString(20) });
					table.setModel(model);
				}
				break;
			}
		}
		conn.close();
		return table;
	}

	public JTable Tablemodel21(JTable table, DefaultTableModel model, String SQL, String[] ColHeader, int col,
			String requiredcheckbox, String vtyperequired, String vtype) throws ClassNotFoundException, SQLException {
		model.setColumnIdentifiers(ColHeader);
		rs = this.getSPResult(SQL);
		switch (requiredcheckbox) {
		case "Y":
			while (rs.next()) {
				model.addRow(new Object[] { Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
						rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18),
						rs.getString(19), rs.getString(20), rs.getString(21) });
				table.setModel(model);
			}
			break;
		case "N":
			switch (vtyperequired) {
			case "N":
				while (rs.next()) {
					model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
							rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19),
							rs.getString(20), rs.getString(21) });
					table.setModel(model);
				}
				break;

			case "Y":
				while (rs.next()) {
					model.addRow(new Object[] { vtype, rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
							rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18),
							rs.getString(19), rs.getString(20), rs.getString(21) });
					table.setModel(model);
				}
				break;
			}
		}
		conn.close();
		return table;
	}

	public JTable Tablemodel22(JTable table, DefaultTableModel model, String SQL, String[] ColHeader, int col,
			String requiredcheckbox, String vtyperequired, String vtype) throws ClassNotFoundException, SQLException {
		model.setColumnIdentifiers(ColHeader);
		rs = this.getSPResult(SQL);
		switch (requiredcheckbox) {
		case "Y":
			while (rs.next()) {
				model.addRow(new Object[] { Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
						rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18),
						rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22) });
				table.setModel(model);
			}
			break;
		case "N":
			switch (vtyperequired) {
			case "N":
				while (rs.next()) {
					model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
							rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19),
							rs.getString(20), rs.getString(21), rs.getString(22) });
					table.setModel(model);
				}
				break;

			case "Y":
				while (rs.next()) {
					model.addRow(new Object[] { vtype, rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
							rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18),
							rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22) });
					table.setModel(model);
				}
				break;
			}
		}
		conn.close();
		return table;
	}

	public JTable Tablemodel23(JTable table, DefaultTableModel model, String SQL, String[] ColHeader, int col,
			String requiredcheckbox, String vtyperequired, String vtype) throws ClassNotFoundException, SQLException {
		model.setColumnIdentifiers(ColHeader);
		rs = this.getSPResult(SQL);
		switch (requiredcheckbox) {
		case "Y":
			while (rs.next()) {
				model.addRow(new Object[] { Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
						rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18),
						rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22), rs.getString(23) });
				table.setModel(model);
			}
			break;
		case "N":
			switch (vtyperequired) {
			case "N":
				while (rs.next()) {
					model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
							rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19),
							rs.getString(20), rs.getString(21), rs.getString(22), rs.getString(23) });
					table.setModel(model);
				}
				break;

			case "Y":
				while (rs.next()) {
					model.addRow(new Object[] { vtype, rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
							rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18),
							rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22), rs.getString(23) });
					table.setModel(model);
				}
				break;
			}
		}
		conn.close();
		return table;
	}

	public JTable Tablemodel24(JTable table, DefaultTableModel model, String SQL, String[] ColHeader, int col,
			String requiredcheckbox, String vtyperequired, String vtype) throws ClassNotFoundException, SQLException {
		model.setColumnIdentifiers(ColHeader);
		rs = this.getSPResult(SQL);
		switch (requiredcheckbox) {
		case "Y":
			while (rs.next()) {
				model.addRow(new Object[] { Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
						rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18),
						rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22), rs.getString(23),
						rs.getString(24) });
				table.setModel(model);
			}
			break;
		case "N":
			switch (vtyperequired) {
			case "N":
				while (rs.next()) {
					model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
							rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19),
							rs.getString(20), rs.getString(21), rs.getString(22), rs.getString(23), rs.getString(24) });
					table.setModel(model);
				}
				break;

			case "Y":
				while (rs.next()) {
					model.addRow(new Object[] { vtype, rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
							rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18),
							rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22), rs.getString(23),
							rs.getString(24) });
					table.setModel(model);
				}
				break;
			}
		}
		conn.close();
		return table;
	}

	public JTable Tablemodel25(JTable table, DefaultTableModel model, String SQL, String[] ColHeader, int col,
			String requiredcheckbox, String vtyperequired, String vtype) throws ClassNotFoundException, SQLException {
		model.setColumnIdentifiers(ColHeader);
		rs = this.getSPResult(SQL);
		switch (requiredcheckbox) {
		case "Y":
			while (rs.next()) {
				model.addRow(new Object[] { Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
						rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18),
						rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22), rs.getString(23),
						rs.getString(24), rs.getString(25) });
				table.setModel(model);
			}
			break;
		case "N":
			switch (vtyperequired) {
			case "N":
				while (rs.next()) {
					model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
							rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19),
							rs.getString(20), rs.getString(21), rs.getString(22), rs.getString(23), rs.getString(24),
							rs.getString(25) });
					table.setModel(model);
				}
				break;

			case "Y":
				while (rs.next()) {
					model.addRow(new Object[] { vtype, rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
							rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18),
							rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22), rs.getString(23),
							rs.getString(24), rs.getString(25) });
					table.setModel(model);
				}
				break;
			}
		}
		conn.close();
		return table;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
