import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.SQLException;

public class GUI extends JFrame {

	JFrame f = new JFrame();
	private JButton lab1 = new JButton("Supplies");
	private JButton lab2 = new JButton("BuyLog");
	private JButton lab3 = new JButton("SellLog");
	private JButton lab4 = new JButton("About");

	public GUI() {
		System.out.println("Rendering...");
		f.setTitle("Database Managment System");
		f.setSize(500, 150);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setLayout(new GridLayout(0, 1));
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
					supplies s = new supplies();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				BuyLog bl = new BuyLog();
			}
		});
		lab3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					sellLog.sldata();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sellLog s = new sellLog();
			}
		});

	}
}