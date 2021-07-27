package source;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ScanNet extends PingToInternet{
	InetAddress host = InetAddress.getLocalHost();	
	ArrayList <String> nets = new ArrayList<>();	
	String ip =""; 
	
	public ScanNet()throws  IllegalArgumentException, UnknownHostException, IOException{
		ip = host.getHostAddress();

	}
	public ScanNet(String ip)throws  IllegalArgumentException, UnknownHostException, IOException{
		super(ip);										
	}
	
	//Método para inciar el escaneo ingresando la ip
	public void scanMyNet(String ip) throws UnknownHostException, IOException, IllegalArgumentException {
		JOptionPane.showMessageDialog(null, "Esto puede tardar varios minutos", null, JOptionPane.WARNING_MESSAGE);
		String parts[] = ip.split("\\.");
		if(parts.length >= 255 || parts.length < 2) {
			throw new IllegalArgumentException(0);
		}else {
			String provisional_ip;
			for(int i = 0; i < 254; i++ ) {
				provisional_ip = parts[0]+"."+parts[1]+"."+parts[2]+"."+i; 
				if(super.ping(provisional_ip) == true) {
					nets.add(provisional_ip+"\n");
				}
				else {
					provisional_ip ="";
					continue;
				}
			}
			CSVWriter ww = new CSVWriter(nets);
			JOptionPane.showMessageDialog(null, "Arhivo .csv creado", "ScanMyNet", JOptionPane.DEFAULT_OPTION);
			}
	}
	
	
	//Método para inciar el escaneo sin ingresar la ip
	public void scanMyNet() throws UnknownHostException, IOException, IllegalArgumentException {
		JOptionPane.showMessageDialog(null, "Esto puede tardar varios minutos", null, JOptionPane.WARNING_MESSAGE);
		String parts[] = ip.split("\\.");
		if(parts.length >= 5 || parts.length < 2) {
			throw new IllegalArgumentException(0);
		}else {
			String provisional_ip;
			for(int i = 0; i < 255; i++ ) {
				provisional_ip = parts[0]+"."+parts[1]+"."+parts[2]+"."+i;
				if(super.ping(provisional_ip) == true) {
					nets.add(provisional_ip+"\n");
				}
				else {
					provisional_ip ="";
					continue;
				}
			}
			JOptionPane.showMessageDialog(null, nets, "Tus hosts activos:", JOptionPane.DEFAULT_OPTION);
			}
	}
	
}
