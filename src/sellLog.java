import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.TableColumn;

public class sellLog extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5847318933614455522L;
	/**
	 * 
	 */
	JFrame sl = new JFrame();
	private static String[] slcolumns = { "ID", "Name", "Quantity" ,"Type", "Date","Price"};
	private static Object[][] datasl = new Object[100][6];
	public static JTable selllog = new JTable(datasl, slcolumns);
	JScrollPane container = new JScrollPane(selllog);
	TableColumn column1 = null;
	TableColumn column2 = null;
	TableColumn column3 = null;
	TableColumn column4 = null;
	TableColumn column5 = null;
	TableColumn column6 = null;
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;

	public sellLog() {
		sl.setTitle("Warehouse - Sell Log");
		sl.setSize(700, 300);
		sl.setResizable(false);
		sl.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		sl.setLocation(screenWidth / 4, screenHeight / 4);
		sl.add(container);
		column1 = selllog.getColumnModel().getColumn(0);
		column1.setPreferredWidth(10);
		column2 = selllog.getColumnModel().getColumn(1);
		column2.setPreferredWidth(250);
		column3 = selllog.getColumnModel().getColumn(2);
		column3.setPreferredWidth(40);
		column4 = selllog.getColumnModel().getColumn(3);
		column4.setPreferredWidth(30);
		column5 = selllog.getColumnModel().getColumn(4);
		column5.setPreferredWidth(30);
		column6 = selllog.getColumnModel().getColumn(5);
		column6.setPreferredWidth(30);
		selllog.setEnabled(false);
		sl.setVisible(true);
	}// constructor

	public static void sldata() throws SQLException {
		supplies.rs = supplies.pst.executeQuery("select * from sell");
		int i = 0;
		while (supplies.rs.next()) {
			datasl[i][0] = supplies.rs.getString(1);
			datasl[i][1] = supplies.rs.getString(2);
			datasl[i][2] = supplies.rs.getString(3);
			datasl[i][3] = supplies.rs.getString(4);
			datasl[i][4] = supplies.rs.getString(5);
			datasl[i][5] = supplies.rs.getString(6);
			i++;
		}// while
	}
}
