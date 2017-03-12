package org.cmg.jresp.writerreader;

import org.cmg.jresp.knowledge2.ActualTemplateField;
import org.cmg.jresp.knowledge2.Knowledge;
import org.cmg.jresp.knowledge2.Template;

public class Writer2 implements Runnable{
	Knowledge ts;

	public Writer2 (Knowledge  ts){
		this.ts = ts;
	}
	public void run(){
		Template template = new Template(new ActualTemplateField("Libro"), new ActualTemplateField(10));
		try {
			ts.get(template);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
