package source;
import javax.swing.JOptionPane;

public class IllegalArgumentException extends Exception {   
	private int c;			
	private String cc;
	
	public IllegalArgumentException() {		
		super("RunTimeException");
	}
	public IllegalArgumentException(int x) {
		super("RunTimeException");
		c = x;
	}
	public IllegalArgumentException(String s) {
		super("RunTimeException");
		cc = s;
	}
	
	public String toString() {  
		JOptionPane.showMessageDialog(null, "Argumentos inválidos", "FATAL ERROR!!!!", JOptionPane.ERROR_MESSAGE);
		return getMessage()+ "\nArgumento inválido\n" +"Por Favor revisa tu entrada: '"+ c+"'";
	}
}