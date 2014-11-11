import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.TableColumn;

public class sellLog extends JFrame {
	JFrame sl = new JFrame();
	private static String[] slcolumns = { "ID", "Name", "Quantity", "Date" , "Type" };
	private static Object[][] datasl = new Object[100][5];
	public static JTable selllog = new JTable(datasl, slcolumns);
	JScrollPane container = new JScrollPane(selllog);
	TableColumn column1 = null;
	TableColumn column2 = null;
	TableColumn column3 = null;
	TableColumn column4 = null;
	TableColumn column5 = null;
	public sellLog() {
		sl.setTitle("Sell Log");
		sl.setSize(700, 600);
		sl.setResizable(false);
		sl.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		sl.add(container);
		column1 = selllog.getColumnModel().getColumn(0);
		column1.setPreferredWidth(10);
		column2 = selllog.getColumnModel().getColumn(1);
		column2.setPreferredWidth(300);
		column3 = selllog.getColumnModel().getColumn(2);
		column3.setPreferredWidth(40);
		column4 = selllog.getColumnModel().getColumn(3);
		column4.setPreferredWidth(30);
		column5 = selllog.getColumnModel().getColumn(4);
		column5.setPreferredWidth(30);
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
			i++;
		}// while
	}
}
