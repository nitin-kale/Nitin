package RetailProduct;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FilenameUtils;

public class GetFileName {

	private JFrame frame;
	private JTextField textField;
	public String Name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetFileName window = new GetFileName();
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
	public GetFileName() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 409, 148);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(46, 41, 279, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btn = new JButton("Click");
		btn.setBounds(328, 40, 31, 25);
		ActionListener ls1 = new lsnr();
		btn.addActionListener(ls1);
		frame.getContentPane().add(btn);

		JLabel lblFileSelected = new JLabel("File Selected ");
		lblFileSelected.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblFileSelected.setBounds(46, 13, 154, 16);
		frame.getContentPane().add(lblFileSelected);
	}

	public class lsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			int i = e.getID();
			String value = e.getActionCommand();
			// System.out.println("ID is : "+ i);
			// System.out.println("Value is : "+ value);
			getFile();
		}

	}

	public String getFile() {

		JFileChooser fln = new JFileChooser();
		fln.setCurrentDirectory(new java.io.File("."));
		fln.setDialogTitle("choosertitle");
		// fln.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fln.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		fln.setAcceptAllFileFilterUsed(false);
		fln.addChoosableFileFilter(null);
		String text = fln.getApproveButtonText();
		int returnVal = fln.showOpenDialog(frame);
		fln.getApproveButtonText();
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			java.io.File file = fln.getSelectedFile();
			String path = file.getPath();
			// textField.setText(file.getName());
			textField.setText(path);
			Name = path;
			return Name;
		}
		return Name;
	}

	public String getSQLFiles() {

		JFileChooser fln = new JFileChooser();
		FileFilter ext = new FileNameExtensionFilter("My SQL DB File", "SQL");
		fln.addChoosableFileFilter(ext);
		fln.setCurrentDirectory(new java.io.File("D://akn//script"));
		fln.setDialogTitle("Select Script File with *.SQL File");
		// fln.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fln.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		fln.setAcceptAllFileFilterUsed(false);
		fln.addChoosableFileFilter(null);
		String text = fln.getApproveButtonText();
		int returnVal = fln.showOpenDialog(frame);
		fln.getApproveButtonText();
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			java.io.File file = fln.getSelectedFile();
			String path = file.getPath();
			textField.setText(path);
			Name = path;
			return Name;
		}
		return Name;
	}

}
