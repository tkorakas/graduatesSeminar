import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
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
	/**
	 * 
	 */
	private static final long serialVersionUID = -7202503354390928155L;
	/**
	 * 
	 */
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
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;

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
		j.setLocation(screenWidth / 4, screenHeight / 4);
		sellb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				selectedItem = products.getModel()
						.getElementAt(products.getSelectedIndex()).toString();
				selectedType = type.getModel()
						.getElementAt(type.getSelectedIndex()).toString();
				if (selectedType.equals("Apodeiksi")) {
					selectedType = "a_l";
				} else {
					selectedType = "t_p";
				}
				try {
					// price
					@SuppressWarnings("unused")
					float sprice = 0;
					// final price
					if (selectedType.equals("a_l")) {
						// +fpa
						PreparedStatement pt = supplies.con
								.prepareStatement("select pfpa from prods where pname = ?");
						pt.setString(1, selectedItem);
						supplies.rs = pt.executeQuery();
						while (supplies.rs.next()) {
							sprice = supplies.rs.getFloat(1);
						}
					} else {
						// without fpa
						PreparedStatement pt = supplies.con
								.prepareStatement("select pprice from prods where pname = ?");
						pt.setString(1, selectedItem);
						supplies.rs = pt.executeQuery();
						while (supplies.rs.next()) {
							sprice = supplies.rs.getFloat(1);
						}
					}// if for payment type
					if (!quantity.getText().equals("")) {
						if (Integer.parseInt(quantity.getText()) > 0) {
							PreparedStatement pt = supplies.con
									.prepareStatement("select pquant from prods where pname = ?");
							pt.setString(1, selectedItem);
							supplies.rs = pt.executeQuery();
							while (supplies.rs.next()) {
								quantIn = supplies.rs.getInt(1);
							}
						}
						if (Integer.parseInt(quantity.getText()) <= quantIn) {
							PreparedStatement pt2 = supplies.con
									.prepareStatement("update prods set pquant = pquant - ? where pname = ?");
							pt2.setInt(1, Integer.parseInt(quantity.getText()));
							pt2.setString(2, selectedItem);
							pt2.executeUpdate();
							pt2 = supplies.con
									.prepareStatement("insert into sell values(null,?,?,?,?,?)");
							pt2.setString(1, selectedItem);
							pt2.setInt(2, Integer.parseInt(quantity.getText()));
							SimpleDateFormat ft = new SimpleDateFormat(
									"yyyy-MM-dd");
							Date date = new Date();
							pt2.setString(4, ft.format(date));
							pt2.setString(3, selectedType);
							sprice *= (float) Integer.parseInt(quantity
									.getText());
							pt2.setFloat(5, sprice);
							pt2.executeUpdate();
							JOptionPane.showMessageDialog(null, "Product Sold",
									"State", JOptionPane.INFORMATION_MESSAGE);
							supplies.Tablequery();
							supplies.table.repaint();
							j.dispose();
						} else {
							JOptionPane.showMessageDialog(null,
									"Not enough Product", "Product Quantity",
									JOptionPane.ERROR_MESSAGE);

						}
						} else {
							JOptionPane.showMessageDialog(null,
									"Fill Quantity", "Sell Quantity",
									JOptionPane.ERROR_MESSAGE);
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