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
	JTextField empid = new JTextField();
	JTextField empname = new JTextField();
	JTextField empsalary = new JTextField();
	JLabel empnameL = new JLabel("Name");
	JLabel empidL = new JLabel("ID");
	JLabel empsalaryL = new JLabel("Salary");
	JButton buyI = new JButton("Buy");
	JLabel empty = new JLabel();
	//String[] list = { "ID", "Name", "Quantity" , "Date","Type","Price","FPA" };
	JComboBox itemList = new JComboBox();
	public buy() throws SQLException {
		j.setTitle("Buy");
		j.setSize(200, 150);
		j.setResizable(false);
		j.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		j.setLayout(new GridLayout(4, 2));
		j.add(empidL);
		j.add(empid);
		j.add(empnameL);
		j.add(itemList);
		j.add(empsalaryL);
		j.add(empsalary);
		j.add(empty);
		j.add(buyI);
		j.setVisible(true);
		
	}
}