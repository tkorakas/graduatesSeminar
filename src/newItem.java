import javax.swing.JFrame;


public class newItem extends JFrame{
	JFrame j = new JFrame();
	public newItem(){
		j.setTitle("New Product");
		j.setSize(200, 250);
		j.setResizable(false);
		j.setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
		j.setVisible(true);
	}
}