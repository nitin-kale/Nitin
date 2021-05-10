package RetailProduct;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.lingala.zip4j.exception.ZipException;
import org.apache.poi.hslf.record.PPDrawing;
import com.sun.mail.handlers.image_gif;
import javax.swing.ImageIcon;
import java.awt.Font;

public class BackupDB extends gnPublicVariable {
	String filename;
	String status = "Fail";
	File file = null;
	String pw = null;
	String vstring = "datgru999";
	String vpath = null;
	JFrame frame = new JFrame("DB Backup ");

	public void TakeBackup(String path) throws Throwable {

		//new General().msg(path);
		frame = new JFrame("Database Backup ,,");
		frame.setBounds(350, 250, 455, 275);
		frame.setVisible(true);
		JLabel lbl = new JLabel();
		lbl.setBounds(0, 0, 437, 230);
		lbl.setIcon(new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/backup1.jpg")));
		frame.getContentPane().add(lbl);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  		
		new General().Quickmsg("Taking Backup Please Wait...");
		new gnDecorate().setBusyCursor(frame);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Backup Is In Progress.. wait..");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setBounds(10, 201, 232, 29);
		frame.getContentPane().add(lblNewLabel);
		try {

			String vdate = new General().getDate();
			String vpos1 = vdate.substring(0, 2);
			String vpos2 = vdate.substring(3, 5);
			String vpos3 = vdate.substring(6, 10);
			String vtime = new General().getTime();
			String vp1 = vtime.substring(0, 2);
			String vp2 = vtime.substring(3, 5);
			String vp3 = vtime.substring(6, 8);
			// show() ;

			    String vverticlecode = new gnHierarchy().getVerticleCode() ;
				String vvertname = "MeretooBackup_Vert".concat(vverticlecode).concat("-") ;
				String vfilegenerate =  vvertname.concat(vpos1).concat(vpos2).concat(vpos3).concat(vp1).concat(vp2)
						.concat(vp3);
				filename = vfilegenerate.concat(".sql");
 				
			if (ApplicationMenu.MenuSelection.equals("RunReposting")) {
				filename = "Reposting".concat(filename);
			}
  			vpath = path;
			pw = myString;  
			String dbname = new getResultSet().dbname;
			//new General().msg(vpath+" "+dbname+ " "+pw);
			
 			file = new File(filename);
			//String dbname = new getResultSet().dbname;
  			//new General().msg("File Name:" + file);
    			
 			if (file.exists()) {
				file.delete();
				file.createNewFile();
				file.listFiles();
			}
 
    		File mysqlrunfile =new File(DBpath+"mysqldump.exe");
    		if (mysqlrunfile.exists())
    		{
    			//new General().msg("Yes Runnable File Exist .. ");
    		}
    		
 			
    			String runCommand =   DBpath + "mysqldump.exe -u" +user + " -p" + pw
    					+ " --port=3306 --protocol=tcp --force --allow-keywords --compress --add-drop-table --routines "
    					+ dbname + " -r " + file + "";
    			
    			System.out.println("Command  :"+" "+runCommand );
  			
			Runtime backup = Runtime.getRuntime();
  			Process pr = backup.exec(runCommand);
   			int processComplete = pr.waitFor();
  			System.out.println("process Complete Status   :"+" "+processComplete );
        		if (processComplete == 0) {
				new gnImageSound().playSound();
				Thread.sleep(9000);
				status = "Sucess";
				zipTheFile();
			} 
        	if (processComplete != 0) {
				new General().Quickmsg("DB Backupt Status <File not created>---> Fail ..");
  				status = "Fail";
				frame.dispose();
  			}
 	 	} catch (Exception e) {
			 new General().msg(e.getMessage());
		} finally {
  		}
	}

	private void zipTheFile() throws ZipException {
		try {
			
			if (file.exists()) 
			{
 			new gnMyZipFiles(vstring).pack(file);
			new gnImageSound().playSound();
			new gnImageSound().playSound();
			new General().Quickmsg("Backup Status -->Succes");
			new gnDecorate().setDefaultCursor(frame);
			frame.dispose();
			new gnImageSound().playSound();
			file.delete();
			file = null;
			}
			else{
 				frame.dispose();
 				new  General().msg("File Not Created ...");
			}
		} catch (Exception w) {
			new General().Quickmsg(w.getMessage());
		}
	}

	private void show() {
		frame.setBounds(300, 250, 100, 200);
		JLabel label = new JLabel("Please Wait...");
		label.setBounds(1, 1, 50, 50);
		frame.getContentPane().add(label);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
	}

	public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
		try {
			// new BackupDB().TakeBackup(new gnPublicVariable().DbBackupPath());
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
