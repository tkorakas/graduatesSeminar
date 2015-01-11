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

public class Add extends JFrame {

	private static final long serialVersionUID = -3444882383881509894L;
	JFrame ad = new JFrame("Add");
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;
	JLabel pname = new JLabel("Product");
	JLabel pprice = new JLabel("Price");
	JTextField name = new JTextField();
	JTextField price = new JTextField();
	JButton add = new JButton("Add");
	JLabel empty = new JLabel();

	public Add() {
		ad.setSize(500, 120);
		ad.setResizable(false);
		ad.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		ad.setLocation(screenWidth / 4, screenHeight / 4);
		ad.setLayout(new GridLayout(3, 2));
		ad.add(pname);
		ad.add(name);
		ad.add(pprice);
		ad.add(price);
		ad.add(empty);
		ad.add(add);
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String selpro = name.getText(); // new product name
				
				try {
					float selprice = Float.parseFloat(price.getText()); // price
					float fpa = (float) ((selprice * 0.23) + selprice); // fpa
						PreparedStatement pt = supplies.con
								.prepareStatement("insert into prods values(null,?,?,?,?,?)");
						pt.setString(1, selpro);
						pt.setInt(2, 0);
						SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
						Date date = new Date();
						pt.setString(3, ft.format(date));
						pt.setFloat(4, selprice);
						pt.setFloat(5, fpa);
						pt.executeUpdate();
						JOptionPane.showMessageDialog(null,
								"New Product Added", "New Product",
								JOptionPane.INFORMATION_MESSAGE);
						supplies.Tablequery();
						supplies.table.repaint();
						ad.dispose();
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Fill all boxes",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		ad.setVisible(true);
	}
}
