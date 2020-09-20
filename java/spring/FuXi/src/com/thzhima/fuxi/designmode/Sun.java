package com.thzhima.fuxi.designmode;

public class Sun {

	private Sun() {}
	
//	private static Sun o = new Sun();  // eager
	private static Sun o = null;
	
	public synchronized static Sun getInstance() {
		if(o==null) {
			o = new Sun();//¿¡∫∫lazy
		}
		return o;
	}
	
	
	
}
