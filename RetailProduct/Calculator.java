package RetailProduct;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

class Calculator implements ActionListener {
	JFrame f;
	JTextField t;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bdiv, bmul, bsub, badd, bdec, beq, bdel, bclr;

	static double a = 0, b = 0, result = 0;
	static int operator = 0;
	private JTextField hold;

	public void Calc() throws Throwable {
		f = new JFrame("Calculator");
		f.setBounds(350, 175, 500, 750);
		new gnApp().setFrameTitel(f);
		f.setType(Type.POPUP);
		f.getContentPane().setBackground(new Color(204, 255, 255));
		f.setAlwaysOnTop(true);
		f.setBackground(Color.ORANGE);
		f.getContentPane().setForeground(Color.GRAY);
		t = new JTextField();
		t.setFont(new Font("Tahoma", Font.BOLD, 17));
		b1 = new JButton("1");
		b1.setFont(new Font("Tahoma", Font.BOLD, 13));
		b2 = new JButton("2");
		b2.setFont(new Font("Tahoma", Font.BOLD, 13));
		b3 = new JButton("3");
		b3.setFont(new Font("Tahoma", Font.BOLD, 13));
		b4 = new JButton("4");
		b4.setFont(new Font("Tahoma", Font.BOLD, 13));
		b5 = new JButton("5");
		b5.setFont(new Font("Tahoma", Font.BOLD, 13));
		b6 = new JButton("6");
		b6.setFont(new Font("Tahoma", Font.BOLD, 13));
		b7 = new JButton("7");
		b7.setFont(new Font("Tahoma", Font.BOLD, 13));
		b8 = new JButton("8");
		b8.setFont(new Font("Tahoma", Font.BOLD, 13));
		b9 = new JButton("9");
		b9.setFont(new Font("Tahoma", Font.BOLD, 13));
		b0 = new JButton("0");
		b0.setFont(new Font("Tahoma", Font.BOLD, 13));
		bdiv = new JButton("/");
		bdiv.setFont(new Font("Tahoma", Font.BOLD, 13));
		bmul = new JButton("*");
		bmul.setFont(new Font("Tahoma", Font.BOLD, 13));
		bsub = new JButton("-");
		bsub.setFont(new Font("Tahoma", Font.BOLD, 13));
		badd = new JButton("+");
		badd.setFont(new Font("Tahoma", Font.BOLD, 13));
		bdec = new JButton(".");
		bdec.setFont(new Font("Tahoma", Font.BOLD, 13));
		beq = new JButton("=");
		beq.setFont(new Font("Tahoma", Font.BOLD, 13));
		bdel = new JButton("Delete");
		bdel.setMnemonic('D');
		bclr = new JButton("Clear");
		bclr.setMnemonic('C');

		t.setBounds(33, 43, 280, 40);
		b7.setBounds(40, 100, 50, 40);
		b8.setBounds(110, 100, 50, 40);
		b9.setBounds(180, 100, 50, 40);
		bdiv.setBounds(250, 100, 50, 40);

		b4.setBounds(40, 153, 50, 40);
		b5.setBounds(110, 153, 50, 40);
		b6.setBounds(180, 153, 50, 40);
		bmul.setBounds(250, 153, 50, 40);

		b1.setBounds(40, 206, 50, 40);
		b2.setBounds(110, 206, 50, 40);
		b3.setBounds(180, 206, 50, 40);
		bsub.setBounds(250, 206, 50, 40);

		bdec.setBounds(40, 259, 50, 40);
		b0.setBounds(110, 259, 50, 40);
		beq.setBounds(180, 259, 50, 40);
		badd.setBounds(250, 259, 50, 40);

		bdel.setBounds(63, 312, 108, 40);
		bclr.setBounds(180, 312, 100, 40);

		f.getContentPane().add(t);
		f.getContentPane().add(b7);
		f.getContentPane().add(b8);
		f.getContentPane().add(b9);
		f.getContentPane().add(bdiv);
		f.getContentPane().add(b4);
		f.getContentPane().add(b5);
		f.getContentPane().add(b6);
		f.getContentPane().add(bmul);
		f.getContentPane().add(b1);
		f.getContentPane().add(b2);
		f.getContentPane().add(b3);
		f.getContentPane().add(bsub);
		f.getContentPane().add(bdec);
		f.getContentPane().add(b0);
		f.getContentPane().add(beq);
		f.getContentPane().add(badd);
		f.getContentPane().add(bdel);
		f.getContentPane().add(bclr);

		f.getContentPane().setLayout(null);

		hold = new JTextField();
		hold.setBackground(Color.WHITE);
		hold.setFont(new Font("Tahoma", Font.BOLD, 11));
		hold.setEnabled(false);
		hold.setEditable(false);
		hold.setBounds(33, 23, 280, 22);
		f.getContentPane().add(hold);
		hold.setColumns(10);
		f.setVisible(true);
		f.setSize(350, 393);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setResizable(false);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		badd.addActionListener(this);
		bdiv.addActionListener(this);
		bmul.addActionListener(this);
		bsub.addActionListener(this);
		bdec.addActionListener(this);
		beq.addActionListener(this);
		bdel.addActionListener(this);
		bclr.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1)
			t.setText(t.getText().concat("1"));

		if (e.getSource() == b2)
			t.setText(t.getText().concat("2"));

		if (e.getSource() == b3)
			t.setText(t.getText().concat("3"));

		if (e.getSource() == b4)
			t.setText(t.getText().concat("4"));

		if (e.getSource() == b5)
			t.setText(t.getText().concat("5"));

		if (e.getSource() == b6)
			t.setText(t.getText().concat("6"));

		if (e.getSource() == b7)
			t.setText(t.getText().concat("7"));

		if (e.getSource() == b8)
			t.setText(t.getText().concat("8"));

		if (e.getSource() == b9)
			t.setText(t.getText().concat("9"));

		if (e.getSource() == b0)
			t.setText(t.getText().concat("0"));

		if (e.getSource() == bdec)
			t.setText(t.getText().concat("."));

		if (e.getSource() == badd) {
			a = Double.parseDouble(t.getText());
			hold.setText(Double.toString(a));
			operator = 1;
			t.setText("");
		}

		if (e.getSource() == bsub) {
			a = Double.parseDouble(t.getText());
			operator = 2;
			t.setText("");
			hold.setText(Double.toString(a));

		}

		if (e.getSource() == bmul) {
			a = Double.parseDouble(t.getText());
			operator = 3;
			t.setText("");
			hold.setText(Double.toString(a));

		}

		if (e.getSource() == bdiv) {
			a = Double.parseDouble(t.getText());
			operator = 4;
			t.setText("");
			hold.setText(Double.toString(a));

		}

		if (e.getSource() == beq) {
			b = Double.parseDouble(t.getText());

			switch (operator) {
			case 1:
				result = a + b;
				hold.setText(" ");

				break;

			case 2:
				result = a - b;
				hold.setText(" ");
				break;

			case 3:
				result = a * b;
				hold.setText(" ");
				break;

			case 4:
				result = a / b;
				hold.setText(" ");
				break;

			default:
				result = 0;
			}

			t.setText("" + result);
		}

		if (e.getSource() == bclr)
			t.setText("");
		hold.setText(" ");

		if (e.getSource() == bdel) {
			String s = t.getText();
			t.setText("");
			for (int i = 0; i < s.length() - 1; i++)
				t.setText(t.getText() + s.charAt(i));
		}
	}

	public static void main(String... s) throws Throwable {
		Calculator abc = new Calculator();
		abc.Calc();
	}
}
