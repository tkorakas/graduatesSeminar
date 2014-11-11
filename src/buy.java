import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class buy extends JFrame {
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
						System.out.println(pt.toString());
						pt.executeUpdate();
						pt = supplies.con
								.prepareStatement("insert into buy values(null,?,?,?)");
						pt.setString(1, product);
						pt.setInt(2, quant);
						SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
						Date date = new Date();
						pt.setString(3, ft.format(date));
						pt.executeUpdate();
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