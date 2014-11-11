import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.sql.SQLException;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3024781500307203319L;
	JFrame f = new JFrame();
	private JButton lab1 = new JButton("Supplies");
	private JButton lab2 = new JButton("BuyLog");
	private JButton lab3 = new JButton("SellLog");
	private JButton lab4 = new JButton("About");
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;

	public GUI() {
		System.out.println("Rendering...");
		f.setTitle("Database Managment System");
		f.setSize(500, 150);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setLayout(new GridLayout(0, 1));
		f.setLocation(screenWidth / 4, screenHeight / 4);
		f.add(lab1);
		f.add(lab2);
		f.add(lab3);
		f.add(lab4);
		f.setVisible(true);
		lab1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					supplies.Tablequery();
					@SuppressWarnings("unused")
					supplies s = new supplies();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		lab2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					BuyLog.bldata();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				@SuppressWarnings("unused")
				BuyLog bl = new BuyLog();
			}
		});
		lab3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					sellLog.sldata();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				@SuppressWarnings("unused")
				sellLog s = new sellLog();
			}
		});
		lab4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				about a = new about();
			}
		});

	}
}