import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class supplies extends JFrame {
	/**
	 */
	public static Connection con;
	public static java.sql.Statement pst = null;
	public static java.sql.ResultSet rs;
	private String[] columnNames = { "ID", "Name", "Salary" };
	private static Object[][] data = new Object[100][3];
	JTable table = new JTable(data, columnNames);
	JScrollPane container = new JScrollPane(table);
	JButton but = new JButton("New Item");
	JButton but2 = new JButton("Buy");
	JButton but3 = new JButton("Sell");

	public supplies() throws SQLException {
		JFrame frame = new JFrame();
		frame.setTitle("Supplies");
		frame.setSize(700, 600);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.add(but);
		container.setBounds(0, 30, 695, 590);
		but.setBounds(0, 0, 150, 30);
		frame.add(but2);
		but2.setBounds(275, 0, 150, 30);
		frame.add(but3);
		but3.setBounds(550, 0, 150, 30);
		but.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				newItem ni = new newItem();
			}
		});
		but2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					buy b = new buy();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		but3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sell sl = new sell();
			}
		});
		frame.add(container);
		table.setEnabled(false);
		frame.setVisible(true);
	}// supplies

	public supplies(String dif) {

	}

	public static void connect() {
		// insert library
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// Open Connection with DB
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/testDB", "root", "");
			pst = con.createStatement();
			System.out.println("Connected to database");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}// Connect method

	public static void Tablequery() throws SQLException {
		rs = pst.executeQuery("select * from employee");
		int i = 0;
		while (rs.next()) {
			// { "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) }

			String input = "{ \"" + rs.getString(1) + "\", " + "\""
					+ rs.getString(2) + "\", " + "\"" + rs.getString(3) + "\" "
					+ "}";
			System.out.println(input);
			data[i][0] = rs.getString(1);
			data[i][1] = rs.getString(2);
			data[i][2] = rs.getString(3);
			i++;
		}
	}

}