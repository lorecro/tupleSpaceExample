package org.cmg.jresp.examples;

import org.cmg.jresp.knowledge2.ActualTemplateField;
import org.cmg.jresp.knowledge2.Knowledge;
import org.cmg.jresp.knowledge2.Template;

public class TestQuery implements Runnable{
	Knowledge ts;
public TestQuery(Knowledge ts){
	this.ts = ts;
	
}
public void run() {
	Template template = new Template(new ActualTemplateField("prova"));
	try {
		ts.query(template);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
}
