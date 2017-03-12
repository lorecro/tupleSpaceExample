package org.cmg.jresp.philosophers;

import org.cmg.jresp.knowledge2.ActualTemplateField;
import org.cmg.jresp.knowledge2.Knowledge;
import org.cmg.jresp.knowledge2.RecursiveTupleNode;
import org.cmg.jresp.knowledge2.RecursiveTupleSpace;
import org.cmg.jresp.knowledge2.Template;
import org.cmg.jresp.knowledge2.Tuple;

public class TableSpace {
	private final int NF; //numero forchette/filosofi
	private Knowledge forks; //forchette disponibili per ogni filosofo. devo ottenere il lock dal tuple Space destro e sinistra per poter mangiare

	public TableSpace() throws InterruptedException{
		NF=5;
		forks = new RecursiveTupleSpace();
		for(int i=0; i<NF;i++){
			forks.put(new Tuple(i,2));
		}
//		forks.firstStamp();
	}
	public void getFork(int i) throws InterruptedException{
		forks.query(getTemplate(i,2));
		System.out.println("query fatta id:" +i);
		forks.get(getTemplate(left(i), 2));
		System.out.println("forchetta sinistra ottenuta id:" +i);
		forks.get(getTemplate(right(i), 2));
		System.out.println("forchetta sinistra ottenuta id:" +i);
	}
	private Template getTemplate(int i, int value){
		return new Template(new ActualTemplateField(i), new ActualTemplateField(value));
	}
	private int left(int i){
		int ret;
		ret=(i==0?NF-1:(i-1));
		return ret;
	}
	private int right(int i){
		int ret;
		ret=(i+1)%NF;
		return ret;
	}
	public void releaseForks(int i) throws InterruptedException{
			forks.put(getTuple(left(i), 2));
			forks.put(getTuple(right(i), 2));
		}
	
private Tuple getTuple(int i, int value){
	return new Tuple(i, value);
}
}
