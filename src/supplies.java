import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.TableColumn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class supplies extends JFrame {
	/**
	 */
	//Database Variables
	public static Connection con;
	public static java.sql.Statement pst = null;
	public static java.sql.ResultSet rs;
	//Table Data
	private String[] columnNames = { "ID", "Name", "Quantity" , "Date","Type","Price","FPA" };
	private static Object[][] data = new Object[100][7];
	//GUI Variables
	JTable table = new JTable(data, columnNames);
	JScrollPane container = new JScrollPane(table);
	JButton newIt = new JButton("New Item");
	JButton buyButton = new JButton("Buy");
	JButton sellButton = new JButton("Sell");
	//Resize table variabless
	TableColumn column1 = null;
	TableColumn column2 = null;
	TableColumn column3 = null;
	TableColumn column4 = null;
	TableColumn column5 = null;
	TableColumn column6 = null;
	TableColumn column7 = null;
	//constructor
	public supplies() throws SQLException {
		//Creating window
		JFrame frame = new JFrame();
		frame.setTitle("Supplies");
		frame.setSize(700, 600);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.add(newIt);
		//Set custom layout
		container.setBounds(0, 30, 695, 590);
		newIt.setBounds(0, 0, 150, 30);
		frame.add(buyButton);
		buyButton.setBounds(275, 0, 150, 30);
		frame.add(sellButton);
		sellButton.setBounds(550, 0, 150, 30);
		//Resizing columns
		column1 = table.getColumnModel().getColumn(0);
		column1.setPreferredWidth(10);
		column2 = table.getColumnModel().getColumn(1);
		column2.setPreferredWidth(300);
		column3 = table.getColumnModel().getColumn(2);
		column3.setPreferredWidth(40);
		column5 = table.getColumnModel().getColumn(4);
		column5.setPreferredWidth(30);
		column6 = table.getColumnModel().getColumn(5);
		column6.setPreferredWidth(30);
		column7 = table.getColumnModel().getColumn(6);
		column7.setPreferredWidth(30);
		newIt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				newItem ni = new newItem();
			}
		});
		buyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					buy b = new buy();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		sellButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sell sl = new sell();
			}
		});
		frame.add(container);
		table.setEnabled(false);
		frame.setVisible(true);
	}// supplies
	//constructor with parameter
	public supplies(String dif) {

	}
	//Connect to Database 
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
					"jdbc:mysql://localhost:3306/warehouse", "root", "");
			pst = con.createStatement();
			System.out.println("Connected to database");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}// Connect method
	
	
	//Take Data from Database
	public static void Tablequery() throws SQLException {
		rs = pst.executeQuery("select * from prods");
		int i = 0;
		while (rs.next()) {
			// { "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) }

			data[i][0] = rs.getString(1);
			data[i][1] = rs.getString(2);
			data[i][2] = rs.getString(3);
			data[i][3] = rs.getString(4);
			data[i][4] = rs.getString(5);
			data[i][5] = rs.getString(6);
			data[i][6] = rs.getString(7);
			i++;
		}//query
	}

}