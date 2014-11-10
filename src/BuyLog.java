
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class BuyLog extends JFrame{
	JFrame bl = new JFrame();
	private static String[] blcolumns = { "ID", "Name", "Quantity", "Date" };
private static Object[][] databl = new Object[100][7];
	public static JTable buylog = new JTable(databl, blcolumns);
	JScrollPane container = new JScrollPane(buylog);
	public BuyLog(){
		bl.setTitle("BuyLog");
		bl.setSize(700,600);
		bl.setResizable(false);
		bl.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		bl.add(container);
		buylog.setEnabled(false);
		bl.setVisible(true);
	}//constructor
	public static void bldata() throws SQLException{
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