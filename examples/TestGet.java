package org.cmg.jresp.examples;

import org.cmg.jresp.knowledge2.ActualTemplateField;
import org.cmg.jresp.knowledge2.Knowledge;
import org.cmg.jresp.knowledge2.Template;
import org.cmg.jresp.knowledge2.Tuple;

public class TestGet implements Runnable {
	Knowledge ts;

	public TestGet(Knowledge ts) {
		this.ts = ts;
	}

	public void run() {
		Template template = new Template(new ActualTemplateField("prova"));
		try {
			Tuple t = ts.get(template);
		} catch (InterruptedException e) {
			System.out.println("errore");
			e.printStackTrace();
		}
	}
}
