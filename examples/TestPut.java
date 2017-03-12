package org.cmg.jresp.examples;

import org.cmg.jresp.knowledge2.Knowledge;
import org.cmg.jresp.knowledge2.Tuple;

public class TestPut implements Runnable{
	Knowledge ts;
public TestPut(Knowledge ts){
	this.ts = ts;
	
}
public void run() {
	Tuple t = new Tuple("prova");
	try {
		ts.put(t);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
}
