package source;

/*
 * Esta clase obtiene los parámetros inciales para el cálculo
 */

public abstract class Ip {
	protected int mask = 0;   
	protected int n_mask = 0;	
	protected int octet [] = new int [4];	
	protected final int counter [] = {64,32,16,8,4,2,1};	
	protected int hop = 128;						
	protected int bits;								
	
	public Ip() {  
	}
	
	//Constructor principal de la clase
	public Ip(String ip_dic, int mask, int n_mask)throws IllegalArgumentException {	
		setMask(mask);
		setNMask(n_mask);
		setOctets(ip_dic);
		getSum();
	}
	
	//Setter de máscara incial, esta solo puede tomar el valor de 8,16 y 24 (classful)
	public void setMask(int mask)throws IllegalArgumentException{			
		if(mask == 8 || mask == 16 || mask == 24) {
			this.mask = mask;
		}else {
			throw new IllegalArgumentException (mask);
		}
	}
	
	//setter de la máscara final
	public void setNMask(int n_mask) throws IllegalArgumentException{		
		if(n_mask >= 8 && n_mask <= 30) {
			if(n_mask >= mask) {
				this.n_mask = n_mask;
				}
		}else {
			throw new IllegalArgumentException (n_mask);
		}
	}
	
	/*
	 * Método para verificar la dirección IP, verificando que ningún octeto sea menor a 0 y mayor a 255.
	 * Además busca que solo se ingresen cuatro octetos, no más ni menos.
	 */
	private int [] setOctets(String ip_dic) throws IllegalArgumentException {   
		String  parts [] = ip_dic.split("\\.");	
		if(parts.length == 4) {
			for(int i = 0; i < 4; i++) {
				if(Integer.parseInt(parts[0]) >= 1 && Integer.parseInt(parts[i]) <= 255 ) {
				octet [i] = Integer.parseInt(parts[i]); 
				}
				else {
					throw new IllegalArgumentException (Integer.parseInt(parts[i]));
				}
			}
			return octet;
		}else {
				throw new IllegalArgumentException(ip_dic);
		}	
	}
	
	//Este método obtiene el valor decimal del octeto más significativo para la nueva máscara
	public void getSum(){   
		bits = n_mask - mask;		
		if(bits > 0) {
			while(bits > 8) {		
				bits = bits - 8;	
			}
			for(int i = 0; i < bits-1; i++) {
				hop = hop + counter[i];		
			}
		}
		else {
			hop = 0;
		}
	}

	/*
	 * Este método se inicia antes de crear cualquier objeto.
	 * Este dicta cual de las subclases va a trabajar dependiendo de la máscara incial
	 */
	public static int selectType(int mask) { 
		if(mask >= 8 && mask <= 30) {		
			if(mask >= 8 && mask < 16) {
				return 1;
			}else if(mask >= 16 && mask < 24) {
				return 2;
			}else {
				return 3;
			}
		}else {
			return 0;
		}
	}
	
	//Métdos abstractos para las subclases
	public abstract String [] makeSubnets();	
	public abstract String [] makeHost();		
	public abstract String [] makeBd();			
	
	

}
