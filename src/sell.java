import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	String selectedItem;
	int quantIn;
	String selectedType;
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
		sellb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				selectedItem = products.getModel()
						.getElementAt(products.getSelectedIndex()).toString();
				selectedType = type.getModel()
						.getElementAt(type.getSelectedIndex()).toString();
				if(selectedType.equals("Apodeiksi")){
					selectedType = "a_l";
				}
				else{
					selectedType = "t_p";
				}
				try {
					if (Integer.parseInt(quantity.getText()) > 0) {
						PreparedStatement pt = supplies.con
								.prepareStatement("select pquant from prods where pname = ?");
						pt.setString(1, selectedItem);
						System.out.println(selectedItem);
						supplies.rs = pt.executeQuery();
						System.out.println("query done");
						while (supplies.rs.next()) {
							quantIn = supplies.rs.getInt(1);
							System.out.println(quantIn);
						}
						if (Integer.parseInt(quantity.getText()) <= quantIn) {
							PreparedStatement pt2 = supplies.con
									.prepareStatement("update prods set pquant = pquant - ? where pname = ?");
							pt2.setInt(1, Integer.parseInt(quantity.getText()));
							pt2.setString(2, selectedItem);
							pt2.executeUpdate();
							pt2 = supplies.con
									.prepareStatement("insert into sell values(null,?,?,?,?)");
							pt2.setString(1, selectedItem);
							pt2.setInt(2, Integer.parseInt(quantity.getText()));
							SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
							Date date = new Date();
							pt2.setString(3, ft.format(date));
							pt2.setString(4, selectedType);
							pt2.executeUpdate();
							JOptionPane.showMessageDialog(null,
									"Product Sold", "State",
									JOptionPane.INFORMATION_MESSAGE);
							j.dispose();
						} else {
							JOptionPane.showMessageDialog(null,
									"Not enough Product", "Product Quantity",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				} catch (Exception e) {
					// JOptionPane.showMessageDialog(null, "Fill quantity",
					// "Empty Quantity", JOptionPane.INFORMATION_MESSAGE);
					e.printStackTrace();
				}
			}
		});
		j.setVisible(true);
	}// Constructor

}