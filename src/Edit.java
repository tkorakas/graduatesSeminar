import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Edit extends JFrame{

	private static final long serialVersionUID = 8029298750687019416L;
	JFrame ed = new JFrame("Edit");
	@SuppressWarnings({ "rawtypes", "unchecked" })
	JComboBox edList = new JComboBox(buy.list);
	JLabel items = new JLabel("Products");
	JButton delete = new JButton("Delete");
	JLabel empty = new JLabel();
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;
	public Edit(){
		ed.setSize(500, 100);
		ed.setResizable(false);
		ed.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		ed.setLayout(new GridLayout(2, 2));
		ed.add(items);
		ed.add(edList);
		ed.add(empty);
		ed.add(delete);
		ed.setLocation(screenWidth / 4, screenHeight / 4);
		ed.setVisible(true);
	}
}
