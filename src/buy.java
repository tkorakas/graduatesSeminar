import java.awt.GridLayout;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	public static String[] list ;
	//String[] list = { "ID", "Name", "Quantity" , "Date","Type","Price","FPA" };
	@SuppressWarnings("unchecked")
	JComboBox itemList = new JComboBox(list);
	public buy() throws SQLException {
		j.setTitle("Buy");
		j.setSize(500,120);
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
		
	}//constructor
	
}