import java.awt.GridLayout;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class buy extends JFrame {
	JFrame j = new JFrame();
	supplies sp = new supplies("test");
	JTextField empname = new JTextField();
	JTextField empsalary = new JTextField();
	JLabel empnameL = new JLabel("Product");
	JLabel empsalaryL = new JLabel("Quantity");
	JButton buyI = new JButton("Buy");
	JLabel empty = new JLabel();
	public static String[] list;
	// String[] list = { "ID", "Name", "Quantity" , "Date","Type","Price","FPA"
	// };
	@SuppressWarnings("unchecked")
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
				try{
					quant = Integer.parseInt(empsalary.getText());
				}catch(Exception e){
					e.printStackTrace();
				}
				if (quant > 0) {
					/*PreparedStatement  pst = con.prepareStatement("insert into employee values(?,?,?)");
                  //(1,?,?) antikathistoume to prwto erotimatiko
                  pst.setInt(1, empid);
                  //(?,2,?)*/
				
					try {
						String temp =  itemList.getModel().getElementAt(itemList.getSelectedIndex()).toString();
						PreparedStatement pt = supplies.con.prepareStatement("update prods set pquant = pquant + ? where pname = ?");
						pt.setInt(1, Integer.parseInt(empsalary.getText()));
						pt.setString(2, temp);
						System.out.println(pt.toString());
						pt.executeUpdate();
						j.dispose();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}else{
					System.out.println("fill quantity");
				}

			}
		});

	}// constructor

}