package source;

public class IpB extends Ip{
	private int number_of_subnets = (int) Math.pow(2, (n_mask-mask));
	private String subnets [] = new String [number_of_subnets];
	private String host_min_and_max [] = new String [number_of_subnets];
	private String broadcast [] = new String [number_of_subnets];
	
	private int hops = 256-hop;
	private int cycle_jump = (255/hops) + 1; 
	
	public IpB(String ip, int mask, int n_mask) throws IllegalArgumentException {
		super(ip, mask, n_mask);
	}
	
	
	public String[] makeSubnets() {
		int count = 0;
		if(mask >= 16 && mask < 24 && n_mask <= 24) {
			for(int i = 0; i < number_of_subnets; i++) {
				if(i > 0) {
					count = count + hops;
				}
				subnets[i] = "Subnets "+octet[0]+"."+octet[1]+"."+count+"."+0;
			}
			return subnets;
		}else if((mask >= 16 && mask < 24) && (n_mask > 24 && n_mask <= 30 )) {
			subnets = new String[cycle_jump];
			for(int i = 0; i < cycle_jump; i++) {
				if(i > 0) {
					count = count + hops;
				}
				subnets[i] = "Subnets "+octet[0]+"."+octet[1]+"."+0+"."+count;
			}
			return subnets;
		}else {
			return null;
		}
	}

	public String[] makeHost() {
		int count = 0;
		int min = 0;
		int max = hops - 2;
		if(mask >= 16 && mask < 24 && n_mask <= 24) {
			for(int i = 0; i < number_of_subnets; i++) {
				if(i > 0) {
					count = count + hops;
				}
				min = count + 1;
				host_min_and_max[i] = "Min: ."+count+".0"+"  Max: ."+((count+hops)-1)+"."+254;
				max = max + hops;
			}
			return host_min_and_max;
		}else if((mask >= 16 && mask < 24) && (n_mask > 24 && n_mask <= 30 )) {
			host_min_and_max = new String[cycle_jump];
			for(int i = 0; i < cycle_jump; i++) {
				if(i > 0) {
					count = count + hops;
				}
				min = count + 1;
				host_min_and_max[i] = "Min: .0."+(count+1)+"  Max: .0."+((count+hops)-2);
				
				max = max + hops;
			
			}
			return host_min_and_max;
		}else {
			return null;
		}
	}

	public String[] makeBd() {	
		if(mask >= 16 && mask < 24 && n_mask <= 24){
			int count = hops -1;
			for(int i = 0; i < number_of_subnets; i++) {
				broadcast[i] = "Broadcast: "+"."+count+".255";
				count = count + hops;
			}
			return broadcast;
		}else if((mask >= 16 && mask < 24) && (n_mask > 24 && n_mask <= 30 )) {
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