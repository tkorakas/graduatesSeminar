import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class sell extends JFrame {
	JFrame j = new JFrame();
	public static String[] sellList;
	JLabel product = new JLabel("Product");
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox products = new JComboBox(sellList);
	JLabel quant = new JLabel("Quantity");
	JTextField quantity = new JTextField();
	JLabel typ = new JLabel("Receipt Type");
	String typeData[] = { "Apodeiksi", "Timologio" };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	JComboBox type = new JComboBox(typeData);
	JLabel empty = new JLabel();
	JButton sellb = new JButton("Sell");

	public sell() {
		j.setTitle("Sell");
		j.setSize(500, 120);
		j.setResizable(false);
		j.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		j.setLayout(new GridLayout(4, 2));
		j.add(product);
		j.add(products);
		j.add(quant);
		j.add(quantity);
		j.add(typ);
		j.add(type);
		j.add(empty);
		j.add(sellb);
		j.setVisible(true);
	}// Constructor

}