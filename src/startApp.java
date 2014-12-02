import java.sql.SQLException;



public class startApp {
	public static void main(String args[]) throws SQLException {
		supplies.connect();
		supplies.Tablequery();
		@SuppressWarnings("unused")
		supplies s = new supplies();
		//@SuppressWarnings("unused")
		//GUI g = new GUI();
	}
}