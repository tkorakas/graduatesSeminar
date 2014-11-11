import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class newItem extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2042241976832368370L;
	JFrame j = new JFrame();
	JButton edit = new JButton("Edit");
	JButton delete = new JButton("Delete");
	JButton add = new JButton("Add");
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;
	public newItem() {
		j.setTitle("Products");
		j.setSize(200, 150);
		j.setResizable(false);
		j.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		j.setLayout(new GridLayout(0, 1));
		j.add(edit);
		j.setLocation(screenWidth / 4, screenHeight / 4);
		edit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					supplies.addData();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				@SuppressWarnings("unused")
				Edit ed = new Edit();
				j.dispose();
			}
		}); // EDIT button
		j.add(delete);
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					supplies.addData();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				@SuppressWarnings("unused")
				Delete dlt = new Delete();
				j.dispose();
			}
		});// delete button
		j.add(add);
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				Add ad = new Add();
				j.dispose();
			}
		});// Add button
		j.setVisible(true);
	}
}