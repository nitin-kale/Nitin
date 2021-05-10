package RetailProduct;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class gnAudit extends getResultSet {

	private Connection con1, con2, con3;
	String DBdetail;
	String vcomp;
	String vstore;
	String vdocno;
	String vdocdate;
	String vtype;
	String vuser;
	String varticle;
	String vname;
	String vedtype;
	String vvalue;
	String vremark;
	String vtime;
	String vqty;
	String vrate;
	String vdisc;

	public void insertBillingStatus(String xvtrtype, String vvdocno, String vvdocdate, String vvremark)
			throws Throwable {

		vcomp = new gnConfig().getCompanycode();
		vstore = new gnConfig().getStoreID();
		vdocno = vvdocno;
		vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);

		vuser = new General().getUsercode();
		vtime = new General().getTime();
		varticle = "0";
		vname = "No Name";
		vqty = "0";
		vrate = "0";
		vvalue = "0";
		vremark = vvremark;
		vtype = xvtrtype;
		vdisc = "0";

		String SQL1 = "  update  transaction_audit1  set Remark =  '" + vvremark + "' where company_code  = '" + vcomp
				+ "' and   site_code = '" + vstore + "'  and  docno ='" + vdocno + "'  and  docdate = '" + vdocdate
				+ "'  and type = '" + vtype + "' ";
		// + "('"+vcomp+"' , '"+vstore+"' , '"+vtype+"' , '"+vdocno+"' ,
		// '"+vdocdate+"' , '"+varticle+"' , '"+vname+"' ,'"+vqty+"' ,
		// '"+vrate+"' , '"+vdisc+"', '"+vvalue+"' , '"+vuser+"' ,
		// '"+vremark+"', '"+vtime+"')" ;
		this.getResult(SQL1);

		// String SQL1 = " insert into transaction_audit1 values('"+vcomp+"' ,
		// '"+vstore+"' , '"+vtype+"' , '"+vdocno+"' , '"+vdocdate+"' ,
		// '"+varticle+"' , '"+vname+"' ,'"+vqty+"' , '"+vrate+"' , '"+vdisc+"',
		// '"+vvalue+"' , '"+vuser+"' , '"+vremark+"', '"+vtime+"')" ;
		// this.getResult(SQL1);

	}

	public void insertBillingRecord(String xvtrtype, String vvdocno, String vvdocdate, String vvremark)
			throws Throwable {

		vcomp = new gnConfig().getCompanycode();
		vstore = new gnConfig().getStoreID();
		vdocno = vvdocno;
		vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);

		vuser = new General().getUsercode();
		vtime = new General().getTime();
		varticle = "0";
		vname = "No Name";
		vqty = "0";
		vrate = "0";
		vvalue = "0";
		vremark = vvremark;
		vtype = xvtrtype;
		vdisc = "0";

		String SQL1 = "  insert  into  transaction_audit1 values('" + vcomp + "' , '" + vstore + "' , '" + vtype
				+ "' , '" + vdocno + "' , '" + vdocdate + "' , '" + varticle + "' , '" + vname + "' ,'" + vqty + "' , '"
				+ vrate + "' , '" + vdisc + "',  '" + vvalue + "' ,     '" + vuser + "' ,  '" + vremark + "',   '"
				+ vtime + "')";
		// new General().msg(SQL1);
		this.getResult(SQL1);

	}

	public void updateAuditRecord(String xvtrtype, String vvdocno, String vvdocdate, String vvarticle, String vvname,
			String xvqty, String xvrate, String xvdisc, String xvalue, String vvremark) throws Throwable {
		vcomp = new gnConfig().getCompanycode();
		vstore = new gnConfig().getStoreID();
		vdocno = vvdocno;
		vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);

		vuser = new General().getUsercode();
		vtime = new General().getTime();
		varticle = vvarticle;
		vname = vvname;
		vqty = xvqty;
		vrate = xvrate;
		vvalue = xvalue;
		vremark = vvremark;
		vtype = xvtrtype;
		vdisc = xvdisc;

		String SQL1 = "  insert  into  transaction_audit1 values('" + vcomp + "' , '" + vstore + "' , '" + vtype
				+ "' , '" + vdocno + "' , '" + vdocdate + "' , '" + varticle + "' , '" + vname + "' ,'" + vqty + "' , '"
				+ vrate + "' , '" + vdisc + "',  '" + vvalue + "' ,  '" + vuser + "' ,  '" + vremark + "',    '" + vtime
				+ "')";
		// new General().msg(SQL1);
		this.getResult(SQL1);

	}

	public void updateInfo(String xvtrtype, String vvdocno, String vvdocdate, String vvarticle, String vvname,
			String xvqty, String xvrate, String xvdisc, String xvalue) throws Throwable {
		// new General().msg("Yes I Reached Here ... ");
		vcomp = new gnConfig().getCompanycode();
		vstore = new gnConfig().getStoreID();
		vdocno = vvdocno;
		vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);

		vname = vvname;
		vqty = xvqty;
		vrate = xvrate;
		vvalue = xvalue;
		vremark = "Qty/Change/Discount Edited";
		vtype = xvtrtype;
		vdisc = xvdisc;

		prst = null;
		int vbatchSize = 1;
		final int batchSize = vbatchSize;
		int TotalRecordinsert = 0;
		String vmanufdt = "0";
		String vexpdate = "0";
		con3 = (Connection) this.getConnection();
		con3.setAutoCommit(false);
		String prdetail = "Insert into    transaction_audit1(Company_code , Site_code  , Type,"
				+ "docno , docdate,  Article_code  ,  Name,   qty , rate, disc , value , remark , time , usercode , "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			int row = table.getRowCount();
			for (int k = 0; k < row; k++) {
				prst = con3.prepareStatement(prdetail);
				prst.setString(1, vcomp);
				prst.setString(2, vstore);
				prst.setString(3, vtype);
				prst.setString(4, vdocno);
				prst.setString(5, vdocdate);
				prst.setString(6, varticle);
				prst.setString(7, vname);
				prst.setString(8, vqty);
				prst.setString(9, vrate);
				prst.setString(10, vdisc);
				prst.setString(11, vvalue);
				prst.setString(12, vremark);
				prst.setString(13, new General().getTime());
				prst.setString(14, new General().getUsercode());
				new General().msg("prst" + "" + prst);
				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				DBdetail = "Sucess";
				if (TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					DBdetail = "Sucess";
				}
				prst.executeBatch();
				DBdetail = "Sucess";
			}
		} catch (SQLException e) {
			new General().msg("Audit --->Detail Error" + e.getMessage());
			System.out.println(e.getLocalizedMessage());
			con3.rollback();
			DBdetail = "Fail";
		} finally {
			if (DBdetail == "Sucess") {
				con3.commit();
				con3.close();
				new General().msg("Record Added to audit table ..");
			}
			if (prst != null) {
				prst.close();
			}
		}
	}

}// Last
