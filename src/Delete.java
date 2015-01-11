import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Delete extends JFrame {

	private static final long serialVersionUID = 7043894155749272166L;
	JFrame dlt = new JFrame("Delete");
	@SuppressWarnings({ "rawtypes", "unchecked" })
	JComboBox dltList = new JComboBox(buy.list);
	JLabel items = new JLabel("Products");
	JButton delete = new JButton("Delete");
	JLabel empty = new JLabel();
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;
	public Delete() {
		dlt.setSize(500, 100);
		dlt.setResizable(false);
		dlt.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		dlt.setLayout(new GridLayout(2, 2));
		dlt.add(items);
		dlt.add(dltList);
		dlt.add(empty);
		dlt.add(delete);
		dlt.setLocation(screenWidth / 4, screenHeight / 4);
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String product = dltList.getModel()
						.getElementAt(dltList.getSelectedIndex())
						.toString();
				
				try {
					PreparedStatement pt = supplies.con.prepareStatement("delete from prods where pname = ?");
					pt.setString(1,product);
					pt.executeUpdate();
					JOptionPane.showMessageDialog(null,product + " deleted.","Deleted",JOptionPane.INFORMATION_MESSAGE);
					//Empty array
					for(int j=0;j<supplies.counter;j++){
						for(int t=0;t<6;t++){
							supplies.data[j][t] = " ";
						}
					}
					for(int i =0;i<supplies.counter-1;i++){
						if(supplies.data[i][1].toString().equals(product)){
							for(int j=i;j<supplies.counter;j++){
								for(int t=0;t<6;t++){
									supplies.data[j][t] = supplies.data[j+1][t];
								}
							}
							for(int t=0;t<6;t++){
								supplies.data[supplies.counter-1][t] = null;
							}
							
						}
					}
					
					supplies.Tablequery();
					supplies.table.repaint();
					
					dlt.dispose();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		dlt.setVisible(true);
	}
}
