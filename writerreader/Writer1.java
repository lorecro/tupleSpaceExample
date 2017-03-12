package org.cmg.jresp.writerreader;

import org.cmg.jresp.knowledge2.Knowledge;
import org.cmg.jresp.knowledge2.Tuple;

public class Writer1 implements Runnable{
	Knowledge ts;

	public Writer1 (Knowledge  ts){
		this.ts = ts;
	}
	public void run(){
		Tuple t = new Tuple("Libro", 10); 
		try {
			ts.put(t);
			System.out.println();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
