package RetailProduct;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ImportCsv {

	public Connection connection;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Connection connection = new getResultSet().getConnection();
	}

	static void readCsvUsingLoad(String Type, String FilePath) {
		try (Connection connection = new getResultSet().getConnection()) {

			// ===========Configuration Upload in Table ms_configuration_master
			// ==================//
			if (Type == "Configuration") {
				// new General().msg(FilePath);
				FilePath = FilePath.replace(File.separator, "//");
				// new General().msg(FilePath);

				// String loadQuery = "LOAD DATA LOCAL INFILE '" +
				// "D://JAVA//Master_data_upload//nk4.csv" + "' INTO TABLE
				// ms_configuration_master FIELDS TERMINATED BY ','" ; //+ "
				// LINES TERMINATED BY '\n' (txn_amount, card_number,
				// terminal_id) ";
				String loadQuery = "LOAD DATA LOCAL INFILE '" + FilePath
						+ "' INTO TABLE ms_configuration_master FIELDS TERMINATED BY ','"; // +
																							// "
																							// LINES
																							// TERMINATED
																							// BY
																							// '\n'
																							// (txn_amount,
																							// card_number,
																							// terminal_id)
																							// ";

				System.out.println(loadQuery);
				Statement stmt = connection.createStatement();
				stmt.execute(loadQuery);
				new General().msg(" Configuration Master Data Uploaded Sucessfully");
			}
			// =========================Focus Above Only ====================//

			// =============Tax Master ====================
			if (Type == "TaxMaster") {
				// String loadQuery = "LOAD DATA LOCAL INFILE '" +
				// "D://JAVA//Master_data_upload//nk4.csv" + "' INTO TABLE
				// ms_configuration_master FIELDS TERMINATED BY ','" ; //+ "
				// LINES TERMINATED BY '\n' (txn_amount, card_number,
				// terminal_id) ";
				String loadQuery = "LOAD DATA LOCAL INFILE '" + FilePath
						+ "' INTO TABLE ms_Tax_master  FIELDS TERMINATED BY ','"; // +
																					// "
																					// LINES
																					// TERMINATED
																					// BY
																					// '\n'
																					// (txn_amount,
																					// card_number,
																					// terminal_id)
																					// ";

				System.out.println(loadQuery);
				Statement stmt = connection.createStatement();
				stmt.execute(loadQuery);
				new General().msg(" Configuration Master Data Uploaded Sucessfully");
			}

			// =================Tax Master

			if (Type == "Article") {
				String loadQuery = "LOAD DATA LOCAL INFILE '" + FilePath
						+ "' INTO TABLE msArticle_master FIELDS TERMINATED BY ','"; // +
																					// "
																					// LINES
																					// TERMINATED
																					// BY
																					// '\n'
																					// (txn_amount,
																					// card_number,
																					// terminal_id)
																					// ";
				System.out.println(loadQuery);
				Statement stmt = connection.createStatement();
				stmt.execute(loadQuery);
				new General().msg(" Article Master Data Uploaded Sucessfully");
			}

			if (Type == "SalesPrice") {
				String loadQuery1 = "LOAD DATA LOCAL INFILE '" + FilePath
						+ "' INTO TABLE Article_Sales_price FIELDS TERMINATED BY ','"; // +
																						// "
																						// LINES
																						// TERMINATED
																						// BY
																						// '\n'
																						// (txn_amount,
																						// card_number,
																						// terminal_id)
																						// ";
				System.out.println(loadQuery1);
				Statement stmt = connection.createStatement();
				stmt.execute(loadQuery1);
				new General().msg("Sales Price Data Uploaded Sucessfully");

			}
			if (Type == "EanMaster") {
				String loadQuery1 = "LOAD DATA LOCAL INFILE '" + FilePath
						+ "' INTO TABLE  ms_ean_master FIELDS TERMINATED BY ','"; // +
																					// "
																					// LINES
																					// TERMINATED
																					// BY
																					// '\n'
																					// (txn_amount,
																					// card_number,
																					// terminal_id)
																					// ";
				System.out.println(loadQuery1);
				Statement stmt = connection.createStatement();
				stmt.execute(loadQuery1);
				new General().msg("Ean Master Data  Uploaded Sucessfully");

			}

			if (Type == "MasterTable") {
				String loadQuery1 = "LOAD DATA LOCAL INFILE '" + FilePath
						+ "' INTO TABLE  master_table FIELDS TERMINATED BY ','"; // +
																					// "
																					// LINES
																					// TERMINATED
																					// BY
																					// '\n'
																					// (txn_amount,
																					// card_number,
																					// terminal_id)
																					// ";
				System.out.println(loadQuery1);
				Statement stmt = connection.createStatement();
				stmt.execute(loadQuery1);
				new General().msg("Ean Master Data  Uploaded Sucessfully");

			}

			if (Type == "All") {
				/// 1
				new gnConfig().TableRefresh();
				String Comp = "CompanyMaster.csv";
				String loadQuery1 = "LOAD DATA LOCAL INFILE '" + FilePath + Comp
						+ "' INTO TABLE  ms_company_Master FIELDS TERMINATED BY ','"; // +
																						// "
																						// LINES
																						// TERMINATED
																						// BY
																						// '\n'
																						// (txn_amount,
																						// card_number,
																						// terminal_id)
																						// ";
				System.out.println(loadQuery1);
				Statement stmt = connection.createStatement();
				stmt.execute(loadQuery1);
				new General().msg("Company Master Data  Uploaded Sucessfully" + FilePath + Comp);

				/// 2
				String Conf = "ConfigMaster.csv";
				String loadQuery2 = "LOAD DATA LOCAL INFILE '" + FilePath + Conf
						+ "' INTO TABLE  ms_Configuration_master  FIELDS TERMINATED BY ','"; // +
																								// "
																								// LINES
																								// TERMINATED
																								// BY
																								// '\n'
																								// (txn_amount,
																								// card_number,
																								// terminal_id)
																								// ";
				System.out.println(loadQuery2);
				Statement stmt2 = connection.createStatement();
				stmt2.execute(loadQuery2);
				new General().msg("Configuration  Master Data  Uploaded Sucessfully" + FilePath + Conf);
				/// 3
				String master = "MasterTable.csv";
				String loadQuery3 = "LOAD DATA LOCAL INFILE '" + FilePath + master
						+ "' INTO TABLE  Master_table  FIELDS TERMINATED BY ','"; // +
																					// "
																					// LINES
																					// TERMINATED
																					// BY
																					// '\n'
																					// (txn_amount,
																					// card_number,
																					// terminal_id)
																					// ";
				System.out.println(loadQuery3);
				Statement stmt3 = connection.createStatement();
				stmt3.execute(loadQuery3);
				new General().msg("Master Table Data  Uploaded Sucessfully" + FilePath + master);
				/// 4
				String customer = "CustomerMaster.csv";
				String loadQuery4 = "LOAD DATA LOCAL INFILE '" + FilePath + customer
						+ "' INTO TABLE  ms_Customer_Master  FIELDS TERMINATED BY ','"; // +
																						// "
																						// LINES
																						// TERMINATED
																						// BY
																						// '\n'
																						// (txn_amount,
																						// card_number,
																						// terminal_id)
																						// ";
				System.out.println(loadQuery4);
				Statement stmt4 = connection.createStatement();
				stmt4.execute(loadQuery4);
				new General().msg("Customer Master  Data  Uploaded Sucessfully" + FilePath + customer);
				/// 5
				String EAN = "EANMaster.csv";
				String loadQuery5 = "LOAD DATA LOCAL INFILE '" + FilePath + EAN
						+ "' INTO TABLE  ms_EAN_Master  FIELDS TERMINATED BY ','"; // +
																					// "
																					// LINES
																					// TERMINATED
																					// BY
																					// '\n'
																					// (txn_amount,
																					// card_number,
																					// terminal_id)
																					// ";
				System.out.println(loadQuery5);
				Statement stmt5 = connection.createStatement();
				stmt5.execute(loadQuery5);
				new General().msg("EAN Master   Uploaded Sucessfully" + FilePath + EAN);
				/// 6
				String Article = "ArticleMaster.csv";
				String loadQuery6 = "LOAD DATA LOCAL INFILE '" + FilePath + Article
						+ "' INTO TABLE  msArticle_master  FIELDS TERMINATED BY ','"; // +
																						// "
																						// LINES
																						// TERMINATED
																						// BY
																						// '\n'
																						// (txn_amount,
																						// card_number,
																						// terminal_id)
																						// ";
				System.out.println(loadQuery6);
				Statement stmt6 = connection.createStatement();
				stmt5.execute(loadQuery6);
				new General().msg("Article  Master   Uploaded Sucessfully" + FilePath + Article);
				/// 7
				String SEQ = "NumSEQ.csv";
				String loadQuery7 = "LOAD DATA LOCAL INFILE '" + FilePath + SEQ
						+ "' INTO TABLE  ms_Number_seq  FIELDS TERMINATED BY ','"; // +
																					// "
																					// LINES
																					// TERMINATED
																					// BY
																					// '\n'
																					// (txn_amount,
																					// card_number,
																					// terminal_id)
																					// ";
				System.out.println(loadQuery7);
				Statement stmt7 = connection.createStatement();
				stmt7.execute(loadQuery7);
				new General().msg("Number Seq   Master   Uploaded Sucessfully" + FilePath + SEQ);

				/// 8
				String role = "RoleMaster.csv";
				String loadQuery8 = "LOAD DATA LOCAL INFILE '" + FilePath + role
						+ "' INTO TABLE  ms_Role_Master  FIELDS TERMINATED BY ','"; // +
																					// "
																					// LINES
																					// TERMINATED
																					// BY
																					// '\n'
																					// (txn_amount,
																					// card_number,
																					// terminal_id)
																					// ";
				System.out.println(loadQuery8);
				Statement stmt8 = connection.createStatement();
				stmt8.execute(loadQuery8);
				new General().msg("Article  Master   Uploaded Sucessfully" + FilePath + role);
				/// 9
				String SalesPrice = "SalesPrice.csv";
				String loadQuery9 = "LOAD DATA LOCAL INFILE '" + FilePath + SalesPrice
						+ "' INTO TABLE  Article_sales_Price  FIELDS TERMINATED BY ','"; // +
																							// "
																							// LINES
																							// TERMINATED
																							// BY
																							// '\n'
																							// (txn_amount,
																							// card_number,
																							// terminal_id)
																							// ";
				System.out.println(loadQuery9);
				Statement stmt9 = connection.createStatement();
				stmt9.execute(loadQuery9);
				new General().msg("Sales Price  Master   Uploaded Sucessfully" + FilePath + SalesPrice);

				/// 10
				String site = "SiteMaster.csv";
				String loadQuery10 = "LOAD DATA LOCAL INFILE '" + FilePath + site
						+ "' INTO TABLE  ms_site_master FIELDS TERMINATED BY ','"; // +
																					// "
																					// LINES
																					// TERMINATED
																					// BY
																					// '\n'
																					// (txn_amount,
																					// card_number,
																					// terminal_id)
																					// ";
				System.out.println(loadQuery10);
				Statement stmt10 = connection.createStatement();
				stmt10.execute(loadQuery10);
				new General().msg("site  Master   Uploaded Sucessfully" + FilePath + site);
				/// 11
				String user = "userMaster.csv";
				String loadQuery11 = "LOAD DATA LOCAL INFILE '" + FilePath + user
						+ "' INTO TABLE  user_master FIELDS TERMINATED BY ','"; // +
																				// "
																				// LINES
																				// TERMINATED
																				// BY
																				// '\n'
																				// (txn_amount,
																				// card_number,
																				// terminal_id)
																				// ";
				System.out.println(loadQuery11);
				Statement stmt11 = connection.createStatement();
				stmt11.execute(loadQuery11);
				new General().msg("user  Master   Uploaded Sucessfully" + FilePath + user);
				/// 12
				String tax = "TaxMaster.csv";
				String loadQuery12 = "LOAD DATA LOCAL INFILE '" + FilePath + tax
						+ "' INTO TABLE  ms_tax_master FIELDS TERMINATED BY ','"; // +
																					// "
																					// LINES
																					// TERMINATED
																					// BY
																					// '\n'
																					// (txn_amount,
																					// card_number,
																					// terminal_id)
																					// ";
				System.out.println(loadQuery12);
				Statement stmt12 = connection.createStatement();
				stmt12.execute(loadQuery12);
				new General().msg("Tax  Master   Uploaded Sucessfully" + FilePath + tax);

				/// 13
				String opstk = "OpeningStock.csv";
				String loadQuery13 = "LOAD DATA LOCAL INFILE '" + FilePath + opstk
						+ "' INTO TABLE  Stock_in_hand  FIELDS TERMINATED BY ','"; // +
																					// "
																					// LINES
																					// TERMINATED
																					// BY
																					// '\n'
																					// (txn_amount,
																					// card_number,
																					// terminal_id)
																					// ";
				System.out.println(loadQuery13);
				Statement stmt13 = connection.createStatement();
				stmt13.execute(loadQuery13);
				new General().msg("Tax  Master   Uploaded Sucessfully" + FilePath + opstk);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
////
