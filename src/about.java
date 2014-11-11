import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class about extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5162974861326028390L;
	JFrame fr = new JFrame();
	JTextField ab = new JTextField(
			"Ergasia Seminariou apo tous foitites Korakas Athanasio Euthimi Tsimouro Xrhsto Xutiri ");
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;

	public about() {
		fr.setTitle("About");
		fr.setSize(300, 300);
		fr.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		fr.setResizable(false);
		fr.add(ab);
		ab.setEnabled(false);
		fr.setLocation(screenWidth / 4, screenHeight / 4);
		fr.setVisible(true);
	}
}
