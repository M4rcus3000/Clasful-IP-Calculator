package source;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/*
 * Clase para escirbir información del cálculo de subredes y del escaneo de red
 */

public class CSVWriter {
	
	

	public CSVWriter(String []a, String []b, String []c, int lenght) {
		write(a,b,c, lenght);
	}
	public CSVWriter(ArrayList<String> a) {
		write(a);
	}
	
	public void write(ArrayList<String> a) {
		try {
			PrintWriter pw = new PrintWriter(new File("C:\\Users\\Public\\hosts.csv"));
			StringBuilder build = new StringBuilder();
			int lenght = a.size();
			for(int i = 0; i < lenght; i++) {
				build.append(a.get(i)+"\n");				
			}
			pw.write(build.toString());
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void write(String []a, String []b, String []c, int lenght) {
		try {
			PrintWriter pw = new PrintWriter(new File("C:\\Users\\Public\\Subnets.csv"));
			StringBuilder build = new StringBuilder();
			build.append("Net	Hosts	Bd\n");
			for(int i = 0; i < lenght; i++) {
				build.append(a[i]+" "+b[i]+" "+c[i]+"\n");				
			}
			pw.write(build.toString());
			pw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
