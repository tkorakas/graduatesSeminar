import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.TableColumn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class supplies extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3000272733344032327L;
	/**
	 */

	// Database Variables
	public static Connection con;
	public static java.sql.Statement pst = null;
	public static java.sql.ResultSet rs;

	// Product List DropDown menu
	String productslist[] = { "PRODUCTS", "Add", "Edit", "Delete" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox prodMenu = new JComboBox(productslist);

	// BUY Menu
	String buyList[] = { "BUY", "Buy", "Buy Log" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox buyMenu = new JComboBox(buyList);

	// SELL Menu
	String sellList[] = { "SELL", "Sell", "Sell Log" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox sellMenu = new JComboBox(sellList);

	// About Button
	JButton aboutB = new JButton("About");
	// Table Data
	private static String[] columnNames = { "ID", "Name", "Quantity", "Date",
			"Type", "Price", "FPA" }; // Column Name List
	public static Object[][] data = new Object[100][7];
	// Table Variables
	// Resize table variables
	TableColumn column1 = null;
	TableColumn column2 = null;
	TableColumn column3 = null;
	TableColumn column4 = null;
	TableColumn column5 = null;
	TableColumn column6 = null;
	TableColumn column7 = null;
	public static int counter = 0;
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;

	// End Table Variables

	// GUI Variables
	public static JTable table = new JTable(data, columnNames);
	JScrollPane container = new JScrollPane(table);

	// constructor
	public supplies() throws SQLException {

		// Creating and customize window
		final JFrame frame = new JFrame();
		frame.setTitle("Supplies");
		frame.setSize(700, 600);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocation(screenWidth / 4, screenHeight / 4);
		frame.add(prodMenu);
		frame.add(buyMenu);
		frame.add(sellMenu);
		frame.add(aboutB);

		// Set custom layout
		container.setBounds(0, 30, 695, 590);
		prodMenu.setBounds(0, 0, 175, 30);
		buyMenu.setBounds(175, 0, 175, 30);
		sellMenu.setBounds(350, 0, 175, 30);
		aboutB.setBounds(525, 0, 175, 30);

		prodsResize();// resize Table for prods

		frame.add(container);
		table.setEnabled(false);
		frame.setVisible(true); // Show Window

		// Products Menu Listener
		prodMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (prodMenu.getSelectedItem().toString().equals("Add")) { // Add
																			// new
																			// Item
					@SuppressWarnings("unused")
					Add ad = new Add();

					prodMenu.setSelectedIndex(0);
				} else if (prodMenu.getSelectedItem().toString().equals("Edit")) {
					try {
						supplies.addData();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					@SuppressWarnings("unused")
					Edit ed = new Edit();
					prodMenu.setSelectedIndex(0);
				} else if (prodMenu.getSelectedItem().toString()
						.equals("Delete")) { // Delete an existing item
					try {
						supplies.addData();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					@SuppressWarnings("unused")
					Delete dlt = new Delete();
					prodMenu.setSelectedIndex(0);
				} else {// Show Products
					try {
						Tablequery();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					table.repaint();
					System.out.println("repaint");
				}
			}
		});// Action Listener for PRODUCTS

		// Buy menu listener
		buyMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (buyMenu.getSelectedItem().toString().equals("Buy")) {

					try {
						addData();
						@SuppressWarnings("unused")
						buy b = new buy();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					buyMenu.setSelectedIndex(0);
				} else if (buyMenu.getSelectedItem().toString()
						.equals("Buy Log")) {
					try {
						BuyLog.bldata();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					@SuppressWarnings("unused")
					BuyLog bl = new BuyLog();
					try {
						sellLog.sldata();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					@SuppressWarnings("unused")
					sellLog s = new sellLog();
					buyMenu.setSelectedIndex(0);
				} else {

				}
			}
		});// Buy menu

		// Sell Menu
		sellMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (sellMenu.getSelectedItem().toString().equals("Sell Log")) {
					try {
						sellLog.sldata();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					@SuppressWarnings("unused")
					sellLog s = new sellLog();
					sellMenu.setSelectedIndex(0);
				} else if (sellMenu.getSelectedItem().toString().equals("Sell")) {
					try {
						addSellData();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					@SuppressWarnings("unused")
					sell Nsell = new sell();
					sellMenu.setSelectedIndex(0);
				}
			}
		});//Sell Menu
	}

	public void prodsResize() {
		// Resizing columns for products
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
	}

	/*
	 * Connect to Database Function no parameters Trying to import external
	 * library after importing successfully mysql connector creates connection
	 * between application and database on localhost on port 3306 in case of
	 * error shows error message and closes the application
	 */
	public static void connect() {
		// import library
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Cant Connect with Database",
					"Connection Problem", JOptionPane.INFORMATION_MESSAGE);
		}
		// Open Connection with DB
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/warehouse", "root", "");
			pst = con.createStatement();
			System.out.println("Connected to database");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Unable to Connect with Database", "Connection Problem",
					JOptionPane.ERROR_MESSAGE);
			// e.printStackTrace(); debug
		}

	}// Connect method

	// Retrieve Data from Database
	public static void Tablequery() throws SQLException {
		counter = 0;
		rs = pst.executeQuery("select * from prods");
		int i = 0;
		while (rs.next()) {

			data[i][0] = rs.getString(1);
			data[i][1] = rs.getString(2);
			data[i][2] = rs.getString(3);
			data[i][3] = rs.getString(4);
			data[i][4] = rs.getString(5);
			data[i][5] = rs.getString(6);
			data[i][6] = rs.getString(7);
			i++;
			counter++;
		}// while
	}// query
		// Find all product names

	public static void addData() throws SQLException {
		rs = pst.executeQuery("select pname from prods");
		buy.list = new String[counter];
		int i = 0;
		while (rs.next()) {
			buy.list[i] = rs.getString(1);
			i++;
		}// while

	}// addData

	public static void addSellData() throws SQLException {
		rs = pst.executeQuery("select pname from prods");
		int j = 0;
		while (rs.next()) {
			j++;
		}
		sell.sellList = new String[j];
		int i = 0;
		rs = pst.executeQuery("select pname from prods");
		while (rs.next()) {
			sell.sellList[i] = rs.getString(1);
			i++;
		}// while
	}
}