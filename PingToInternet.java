package source;
import java.io.*; 
import java.net.*;
import javax.swing.JOptionPane;

/*
 * Esta clase hace de apoyo para la prueba de conexión y para poder escaner la red
 */

public class PingToInternet {
	private String ip ="";

	//Existe un constructor por clase que lo requiere
	public PingToInternet(String ip)throws  IllegalArgumentException, UnknownHostException, IOException {
		setIp(ip);
	}
	public PingToInternet()throws  IllegalArgumentException, UnknownHostException, IOException {
		}
	
	//Método para verificar las validez de la ip
	public void setIp(String ip)throws  IllegalArgumentException {
		 String octets[] = ip.split("\\.");
		 if(octets.length >= 5) {
			 throw new IllegalArgumentException(Integer.parseInt(octets[4]));
		 }else {
			 for(int i = 0; i<octets.length; i++) {
					if(Integer.parseInt(octets[i]) > 255){
						throw new IllegalArgumentException(Integer.parseInt(octets[i]));
					}
				}
				this.ip = ip;	 
		 }
		
	}
	
	
	//Método para la prueba de conexión
	public void ping() throws UnknownHostException, IOException, IllegalArgumentException { 
	  
		InetAddress host = InetAddress.getByName(ip); 
		JOptionPane.showMessageDialog(null, "Estableciendo conexión con: "+ip, "PingToInternet", JOptionPane.INFORMATION_MESSAGE);
		if (host.isReachable(5000)) { 
			JOptionPane.showMessageDialog(null, "Conexión exitosa!! con: "+ip, "PingToInternet", JOptionPane.DEFAULT_OPTION);
		}else {
			JOptionPane.showMessageDialog(null, "NO se pudo establecer conexión con: "+ip, "PingToInternet", JOptionPane.ERROR_MESSAGE );
		}
	}
	
	//Método para el escaneo de la red 
	public boolean ping(String ip) throws UnknownHostException, IOException, IllegalArgumentException { 
		InetAddress host = InetAddress.getByName(ip); 
		if (host.isReachable(65000)) { 
			return true;
		}else {
			return false;
		}
	}
	
	
	
}
