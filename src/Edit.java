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
	JButton delete = new JButton("Edit");
	JLabel empty = new JLabel();
	
	public Edit(){
		ed.setSize(500, 100);
		ed.setResizable(false);
		ed.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		ed.setLayout(new GridLayout(2, 2));
		ed.add(items);
		ed.add(edList);
		ed.add(empty);
		ed.add(delete);
	}
}
