import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class BuyLog extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6155099684574375762L;
	JFrame bl = new JFrame();
	private static String[] blcolumns = { "ID", "Name", "Quantity", "Date" };
	private static Object[][] databl = new Object[100][4];
	public static JTable buylog = new JTable(databl, blcolumns);
	JScrollPane container = new JScrollPane(buylog);
	TableColumn column1 = null;
	TableColumn column2 = null;
	TableColumn column3 = null;
	TableColumn column4 = null;
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;

	public BuyLog() {
		bl.setTitle("Warehouse - Buy Log");
		bl.setSize(700, 300);
		bl.setResizable(false);
		bl.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		bl.add(container);
		column1 = buylog.getColumnModel().getColumn(0);
		column1.setPreferredWidth(10);
		column2 = buylog.getColumnModel().getColumn(1);
		column2.setPreferredWidth(300);
		column3 = buylog.getColumnModel().getColumn(2);
		column3.setPreferredWidth(40);
		column4 = buylog.getColumnModel().getColumn(3);
		column4.setPreferredWidth(30);
		buylog.setEnabled(false);
		bl.setLocation(screenWidth / 4, screenHeight / 4);
		bl.setVisible(true);
	}// constructor

	public static void bldata() throws SQLException {
		supplies.rs = supplies.pst.executeQuery("select * from buy");
		int i = 0;
		while (supplies.rs.next()) {
			databl[i][0] = supplies.rs.getString(1);
			databl[i][1] = supplies.rs.getString(2);
			databl[i][2] = supplies.rs.getString(3);
			databl[i][3] = supplies.rs.getString(4);
			i++;
		}// while
	}
}