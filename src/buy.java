import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class buy extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4518011660406369616L;
	/**
	 * 
	 */
	JFrame j = new JFrame();
	JTextField empname = new JTextField();
	JTextField empsalary = new JTextField();
	JLabel empnameL = new JLabel("Product");
	JLabel empsalaryL = new JLabel("Quantity");
	JButton buyI = new JButton("Buy");
	JLabel empty = new JLabel();
	public static String[] list;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox itemList = new JComboBox(list);
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;

	public buy() throws SQLException {
		j.setTitle("Buy");
		j.setSize(500, 120);
		j.setResizable(true);
		j.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		j.setLayout(new GridLayout(3, 2));
		j.add(empnameL);
		j.add(itemList);
		j.add(empsalaryL);
		j.add(empsalary);
		j.add(empty);
		j.add(buyI);
		j.setVisible(true);
		j.setLocation(screenWidth / 4, screenHeight / 4);
		buyI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int quant = 0;
				try {
					quant = Integer.parseInt(empsalary.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Fill quantity",
							"Empty Quantity", JOptionPane.INFORMATION_MESSAGE);
				}
				if (quant > 0) {
					try {
						String product = itemList.getModel()
								.getElementAt(itemList.getSelectedIndex())
								.toString();
						PreparedStatement pt = supplies.con
								.prepareStatement("update prods set pquant = pquant + ? where pname = ?");
						pt.setInt(1, Integer.parseInt(empsalary.getText()));
						pt.setString(2, product);
						pt.executeUpdate();
						pt = supplies.con
								.prepareStatement("insert into buy values(null,?,?,?)");
						pt.setString(1, product);
						pt.setInt(2, quant);
						SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
						Date date = new Date();
						pt.setString(3, ft.format(date));
						pt.executeUpdate();
						JOptionPane.showMessageDialog(null,
								"Purchase was Completed", "State",
								JOptionPane.INFORMATION_MESSAGE);
						supplies.Tablequery();
						supplies.table.repaint();
						j.dispose();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("fill quantity");
				}
			}
		});
	}// constructor
}