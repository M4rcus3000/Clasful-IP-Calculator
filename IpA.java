package source;

/*
 * Esta configuración es casi la misma para las clases IpB e IpC 
 */

public class IpA extends Ip {
	private int number_of_subnets = (int) Math.pow(2, (n_mask-mask));
	private String subnets [] = new String [number_of_subnets];	
	private String host_min_and_max [] = new String [number_of_subnets];
	private String broadcast [] = new String [number_of_subnets];
	
	private int hops = 256-hop;		
	private int cycle_jump = (255/hops) + 1; /*Variable que dicta cuando solo se va a recorrer en el último octeto
											  *De esta forma no se crean cantidades grandes de subredes
											  *Ejemplo:
											  *192.168.#.# ------> 192.168.0.#	
											  */
																				
	
	public IpA(String ip, int mask, int n_mask) throws IllegalArgumentException {
		super(ip, mask, n_mask);
	}
	
	//Método para obtener las subredes, cambiando el número de ellas según el caso
	public String[] makeSubnets() {
		int count = 0;
		if((mask >= 8 && mask < 16) && (n_mask <= 16)) {
			for(int i = 0; i < number_of_subnets; i++) {
				if(i > 0) {
					count = count + hops;
				}
				subnets[i] = "Subnets "+octet[0]+"."+count+"."+0+"."+0;
			}
			return subnets;
		}else if((mask >= 8 && mask < 16) && (n_mask <= 24 && n_mask > 16)) {
			subnets = new String [cycle_jump];
			for(int i = 0; i < cycle_jump; i++) {
				if( i > 0) {
					count = count + hops;
				}
				subnets[i] = "Subnets "+octet[0]+"."+0+"."+count+"."+0;
			}
			return subnets;
		}else if((mask >= 8 && mask < 16) && (n_mask <= 30 && n_mask > 24)) {
			subnets = new String [cycle_jump];
			for(int i = 0; i < cycle_jump; i++) {
				if(i > 0) {
					count = count + hops;
				}
				subnets[i] = "Subnets "+octet[0]+"."+0+"."+0+"."+count;
			}
			return subnets;
		}else {
			return null;
		}
	}

	
	//Método para obtener el primer y último host de cada subred
	public String[] makeHost() {
		int count = 0;
		int min = 0;
		int max = hops - 2;
		if((mask >= 8 && mask < 16) && (n_mask <= 16)) {
			for(int i = 0; i < number_of_subnets; i++) {
				if(i > 0) {
					count = count + hops;
				}
				min = count + 1;
				host_min_and_max[i] = "Min: ."+count+".0.1"+"  Max: ."+((count+hops)-1)+".255.254";
				max = max + hops;
			}
			return host_min_and_max;
			
		}else if((mask >= 8 && mask < 16) && (n_mask <= 24 && n_mask > 16)) {
			host_min_and_max = new String[cycle_jump];
			for(int i = 0; i < cycle_jump; i++) {
				if(i > 0) {
					count = count + hops;
				}
				min = count + 1;
				host_min_and_max[i] = "Min: ."+count+".1"+"  Max: ."+((count+hops)-1)+".254";
				max = max + hops;
			}
			return host_min_and_max;
			
		}else if((mask >= 8 && mask < 16) && (n_mask <= 30 && n_mask > 24)) {
			host_min_and_max = new String[cycle_jump];
			for(int i = 0; i < cycle_jump; i++) {
				if(i > 0) {
					count = count + hops;
				}
				min = count + 1;
				host_min_and_max[i] = "Min: ."+(count+1)+"  Max: ."+((count+hops)-2);
				max = max + hops;
			}
			return host_min_and_max;
		}else {
			return null;
		}
	}

	
	//Método para obtener el broadcast de cada subred
	public String[] makeBd() {
		if((mask >= 8 && mask < 16) && (n_mask <= 16)){
			int count = hops -1;
			for(int i = 0; i < number_of_subnets; i++) {
				broadcast[i] = "Broadcast: "+"."+count+".255.255";
				count = count + hops;
			}
			return broadcast;
		}else if((mask >= 8 && mask < 16) && (n_mask <= 24 && n_mask > 16)) {
			broadcast = new String[cycle_jump];
			int count = hops -1;
			for(int i = 0; i < broadcast.length; i++) {
				broadcast[i] = "Broadcast: "+"."+count+".255";
				count = count + hops;
			}
			return broadcast;
		}else if((mask >= 8 && mask < 16) && (n_mask <= 30 && n_mask > 24)) {
			broadcast = new String[cycle_jump];
			int count = hops -1;
			for(int i = 0; i < broadcast.length; i++) {
				broadcast[i] = "Broadcast: "+"."+count;
				count = count + hops;
			}
			return broadcast;
		}else {
			return null;
		}	
	}
}