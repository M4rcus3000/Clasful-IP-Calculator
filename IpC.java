package source;

public class IpC extends Ip {
	private int number_of_subnets = (int) Math.pow(2, (n_mask-mask));	
	private String subnets [] = new String [number_of_subnets];			
	private String host_min_and_max [] = new String [number_of_subnets];	
	private String broadcast [] = new String [number_of_subnets];			
	
	private int hops = 256-hop;										
	
	
	public IpC(String ip, int mask, int n_mask) throws IllegalArgumentException {					
		super(ip,mask,n_mask);
	}
	
	public String [] makeSubnets() {
		int count = 0;					
		if(mask >= 24 && n_mask < 32) {
			for(int i = 0; i < number_of_subnets; i++) {
				if(i > 0) {
					count = count + hops;
				}
				subnets[i] = "Subnets "+octet[0]+"."+octet[1]+"."+octet[2]+"."+(count);		
			}
			return subnets;
		}else {
			return null;
		}
	}
		
		
	public String [] makeHost() {
		int count = 0;
		int min;
		int max = hops -2;
		
		for(int i = 0; i < number_of_subnets; i++) {
			if(i > 0) {
				count = count + hops;
			}
			min = count + 1;
			host_min_and_max[i] = "Min: ."+(min)+"  Max: ."+(max);		
			max = max + hops;
		}
		return host_min_and_max;
		
	}

	public String[] makeBd() {
		int count = hops -1;
		for(int i = 0; i < number_of_subnets; i++) {
			broadcast[i] = "Broadcast: "+count;						
			count = count + hops;									
		return broadcast;
	}

}

